package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.NonNull;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @NonNull
    private String surname;

    @Column(name = "given_name")
    private String givenName;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;
}
