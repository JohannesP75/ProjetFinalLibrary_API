package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.NonNull;
import org.intellij.lang.annotations.Pattern;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @NonNull
    private String surname;

    @Column(name = "given_name")
    private String givenName;

    @Column
    @NonNull
    private String password;

    @Pattern("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String emailAddress;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    protected Person() {
    }
}
