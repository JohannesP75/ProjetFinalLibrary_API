package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("1")
public class IndividualAuthor extends Author{
    @Column(name = "given_name")
    private String givenName;

    @Column(name = "year_death")
    private int yearDeath;
}
