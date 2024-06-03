package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"password"})
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public abstract class Person {
    /**
     * ID of Person
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     * Surname of Person
     */
    @NonNull
    private String surname;

    /**
     * Given name of Person
     */
    private String givenName;

    /**
     * Password of Person
     */
    @NonNull
    private String password;

    /**
     * E-Mail address of Person
     */
    @Email
    private String emailAddress;

    /**
     * Phone number of Person
     */
    private String phone;

    /**
     * Birthdate of Person
     */
    @Past
    private LocalDate birthDate;

    /**
     * Role of the Person inside the application
     */
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    /**
     * Get the age of the Person in years
     * @return The age of Person
     */
    public Long calculateAge(){
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
