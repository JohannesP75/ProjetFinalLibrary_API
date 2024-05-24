package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@Setter
@Getter
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String description;

    @ManyToMany(mappedBy = "userRoles")
    private Set<Prerogative> prerogatives;

    public UserRole() {
    }

    public UserRole(@NonNull String name) {
        this.name = name;
    }
}
