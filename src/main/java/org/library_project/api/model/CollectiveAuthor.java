package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class CollectiveAuthor extends Author{
    /**
     * Geographical seat of the group
     */
    private String seat;
}
