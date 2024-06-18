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
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"password"})
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public abstract class Person implements IPerson {
    /**
     * ID of Person
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    /**
     * Surname of Person
     */
    @NonNull
    protected String surname;

    /**
     * Given name of Person
     */
    protected String givenName;

    /**
     * Password of Person
     */
    @NonNull
    @Length(max = 80, min = 50)
    protected String password;

    /**
     * E-Mail address of Person
     */
    @Email
    protected String emailAddress;

    /**
     * Phone number of Person
     */
    protected String phone;

    /**
     * Birthdate of Person
     */
    @Past
    protected LocalDate birthDate;

    @Override
    public Long calculateAge(){
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    @Override
    public String getUsername() {
        return null;
    }
}
