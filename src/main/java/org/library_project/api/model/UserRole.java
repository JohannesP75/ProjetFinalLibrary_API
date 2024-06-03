package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String description;

    @ManyToMany(mappedBy = "userRoles")
    private Set<Prerogative> prerogatives;

    @OneToMany(mappedBy="userRole")
    private Set<Person> persons;

    public UserRole() {
    }

    public UserRole(@NonNull String name) {
        this.name = name;
    }
}
