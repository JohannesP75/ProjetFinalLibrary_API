package org.library_project.api.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.library_project.api.model.Reader;
import org.library_project.api.model.ReaderRole;
import org.library_project.api.model.Worker;
import org.library_project.api.model.WorkerRole;
import org.library_project.api.service.ReaderRoleService;
import org.library_project.api.service.ReaderService;
import org.library_project.api.service.WorkerRoleService;
import org.library_project.api.service.WorkerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    private WorkerRoleService workerRoleService;

    private WorkerService workerService;

    private ReaderRoleService readerRoleService;

    private ReaderService readerService;

    /*public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }*/

    public SecurityConfig(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    /**
     * Return an encoder to hash a password
     * @return
     */
    @Bean
    public static PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Get list of roles
        ArrayList<String> listHRRoles = new ArrayList<>();
        ArrayList<String> inventoryRoles = new ArrayList<>();
        ArrayList<String> readerManagementRoles = new ArrayList<>();
        ArrayList<String> systemRoles = new ArrayList<>();
        ArrayList<String> borrowItemRoles = new ArrayList<>();

        for(WorkerRole role: workerRoleService.getAll()){
            String name= role.getFullName();

            if(role.isHrManagement())listHRRoles.add(name);
            if(role.isReadersManagement())readerManagementRoles.add(name);
            if(role.isInventoryManagement())inventoryRoles.add(name);
            if(role.isSystemManagement())systemRoles.add(name);
        }

        for(ReaderRole role: readerRoleService.getAll()){
            String name=role.getFullName();

            if(role.isBorrowItems())borrowItemRoles.add(name);
        }

        return http.headers(headers->
                        headers.xssProtection(
                                xss->xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
                        ).contentSecurityPolicy(
                                cps->cps.policyDirectives("script-src 'self'")
                        ))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
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
        listUsers.add(User.withUsername("admin")
                .password("{noop}password")
                .authorities("ADMIN")
                .build());

        // List of the workers
        for(Worker worker: workerService.getAll()){
            listUsers.add(User.withUsername(worker.getUsername())
                    .password("{bcrypt}"+worker.getPassword())
                    .authorities(worker.getRole().getFullName())
                    .build());
        }

        // List of the readers
        for(Reader reader: readerService.getAll()){
            listUsers.add(User.withUsername(reader.getUsername())
                    .password(reader.getPassword())
                    .authorities(reader.getRole().getFullName())
                    .build());
        }

        return new InMemoryUserDetailsManager(listUsers);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();

        return new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
    }
}
