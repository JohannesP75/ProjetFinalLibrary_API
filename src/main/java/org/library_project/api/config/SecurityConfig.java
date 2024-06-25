package org.library_project.api.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.library_project.api.model.Reader;
import org.library_project.api.model.Worker;
import org.library_project.api.service.ReaderService;
import org.library_project.api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final RsaKeyProperties rsaKeys;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private ReaderService readerService;

    public enum Roles {
        READER,
        WORKER
    }

    public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    /**
     * Return an encoder to hash a password
     * @return
     */
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.headers(headers->
                        headers.xssProtection(
                                xss->xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
                        ).contentSecurityPolicy(
                                cps->cps.policyDirectives("script-src 'self'")
                        ))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->
                        auth
                                // General readers
                                .requestMatchers(HttpMethod.GET, "/anscr/*", "/anscr", "/audios/*", "/audios", "/authors/*", "/authors", "/books/*", "/books", "/branches/*", "/branches", "/dewey/*",  "/dewey", "/book-formats/*", "/book-items/*", "/book-formats", "/book-items", "/video-formats/*", "/video-items/*", "/video-formats", "/video-items", "/audio-formats/*", "/audio-items/*", "/audio-formats", "/audio-items","/publishers/*", "/publishers").permitAll()
                                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                                // Personal profiles
                                .requestMatchers(HttpMethod.GET, "/readers/profile").hasRole(Roles.READER.name())
                                .requestMatchers(HttpMethod.PATCH, "/readers/profile").hasRole(Roles.READER.name())
                                .requestMatchers(HttpMethod.DELETE, "/readers/profile").hasRole(Roles.READER.name())
                                .requestMatchers(HttpMethod.GET, "/workers/profile").hasRole(Roles.WORKER.name())
                                // Registered readers
                                .requestMatchers(HttpMethod.POST, "/loans").hasAnyAuthority(ReaderRoleAuthority.BORROW_ITEMS.name())
                                // Inventory management
                                .requestMatchers(HttpMethod.GET, "/authors/*", "/books/*", "/videos/*", "/audios/*", "/anscr/*", "/dewey/*", "/**-formats/*", "/**-items/*", "/publishers/*", "/authors", "/books", "/videos", "/audios", "/anscr", "/dewey", "/**-formats", "/**-items", "/publishers").hasAnyAuthority(WorkerRoleAuthority.INVENTORY_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.POST, "/authors", "/books", "/videos", "/audios", "/anscr", "/dewey", "/**-formats", "/**-items", "/publishers").hasAnyAuthority(WorkerRoleAuthority.INVENTORY_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.PATCH, "/authors/*", "/books/*", "/videos/*", "/audios/*", "/anscr/*", "/dewey/*", "/**-formats/*", "/**-items/*", "/publishers/*").hasAnyAuthority(WorkerRoleAuthority.INVENTORY_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.DELETE, "/authors/*", "/books/*", "/videos/*", "/audios/*", "/anscr/*", "/dewey/*", "/**-formats/*", "/**-items/*", "/publishers/*").hasAnyAuthority(WorkerRoleAuthority.INVENTORY_MANAGEMENT.name())
                                // Readers management
                                .requestMatchers(HttpMethod.GET, "/readers/*", "/loans/*", "/readers", "/loans").hasAnyAuthority(WorkerRoleAuthority.READERS_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.POST, "/readers", "/loans").hasAnyAuthority(WorkerRoleAuthority.READERS_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.PATCH, "/readers/*", "/loans/*").hasAnyAuthority(WorkerRoleAuthority.READERS_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.DELETE, "/readers/*", "/loans/*").hasAnyAuthority(WorkerRoleAuthority.READERS_MANAGEMENT.name())
                                // HR management
                                .requestMatchers(HttpMethod.GET, "/workers/*", "/workers").hasAnyAuthority(WorkerRoleAuthority.HR_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.POST, "/workers", "/branches").hasAnyAuthority(WorkerRoleAuthority.HR_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.PATCH, "/workers/*", "/branches/*").hasAnyAuthority(WorkerRoleAuthority.HR_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.DELETE, "/workers/*", "/branches/*").hasAnyAuthority(WorkerRoleAuthority.HR_MANAGEMENT.name())
                                // System management
                                .requestMatchers(HttpMethod.GET, "/grades/*", "/**-roles/*").hasAnyAuthority(WorkerRoleAuthority.SYSTEM_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.POST, "/grades", "/**-roles").hasAnyAuthority(WorkerRoleAuthority.SYSTEM_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.PATCH, "/grades/*", "/**-roles/*").hasAnyAuthority(WorkerRoleAuthority.SYSTEM_MANAGEMENT.name())
                                .requestMatchers(HttpMethod.DELETE, "/grades/*", "/**-roles/*").hasAnyAuthority(WorkerRoleAuthority.SYSTEM_MANAGEMENT.name())
                                // General
                                .anyRequest().denyAll() // To remove any possibility of backdoor
                )
                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /**
     * Return the manager of the users in memory
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager users(){
        List<UserDetails> listUsers=new ArrayList<>();
        listUsers.add(User.withUsername("worker")
                .roles("WORKER")
                .password("$2y$10$A8jPGq01.b5tQorPf5RVzeJN/lebab8gcu4zENAPmen5MrXNUnGei")
                .authorities(WorkerRoleAuthority.HR_MANAGEMENT.name())
                .build());
        listUsers.add(User.withUsername("reader")
                .roles("READER")
                .password("$2y$10$A8jPGq01.b5tQorPf5RVzeJN/lebab8gcu4zENAPmen5MrXNUnGei")
                .authorities(ReaderRoleAuthority.BORROW_ITEMS.name())
                .build());

        // List of the workers
        for(Worker worker: workerService.getAll()){
            listUsers.add(User.withUsername(worker.getUsername())
                    .roles(Roles.WORKER.name())
                    .password(String.format("{bcrypt}%s", worker.getPassword()))
                    .authorities(worker.getAllAuthorities())
                    .build());
        }

        // List of the readers
        for(Reader reader: readerService.getAll()){
            listUsers.add(User.withUsername(reader.getUsername())
                    .roles(Roles.READER.name())
                    .password(String.format("{bcrypt}%s", reader.getPassword()))
                    .authorities(reader.getAllAuthorities())
                    .build());
        }

        return new InMemoryUserDetailsManager(listUsers);
    }

    /**
     * Returns a JWT decoder
     * @return
     */
    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    /**
     * Returns a JWT encoder
     * @return
     */
    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();

        return new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
    }
}
