package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

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
}
