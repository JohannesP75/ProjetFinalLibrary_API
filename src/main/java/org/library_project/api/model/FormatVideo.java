package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

/**
 * Format of a video item
 */
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class FormatVideo extends Format {
    @OneToMany(mappedBy="formatVideo")
    private Set<ItemVideo> itemsVideo;
}
