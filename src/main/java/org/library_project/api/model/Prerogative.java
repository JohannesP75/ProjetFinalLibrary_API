package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.Set;

@Data
@Entity
@Getter
@Setter
@Table(name = "prerogatives")
public class Prerogative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Prerogative_Role",
            joinColumns = { @JoinColumn(name = "prerogatives_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<UserRole> userRoles;

    public Prerogative(@NonNull String name) {
        this.name = name;
    }

    public Prerogative() {
    }
}
