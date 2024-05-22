package org.library_project.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("0")
public class IndividualAuthor extends Author{
    @Column(name = "given_name")
    private String givenName;

    @Column(name = "year_death")
    private int yearDeath;
}
