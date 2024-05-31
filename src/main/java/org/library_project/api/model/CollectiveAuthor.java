package org.library_project.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Collective authors
 */
@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("1")
public class CollectiveAuthor extends Author{
    /**
     * Geographical seat of the group
     */
    private String seat;
}
