package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

/**
 * Format of an audio item
 */
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class FormatAudio extends Format {
    @OneToMany(mappedBy = "formatAudio")
    private Set<ItemAudio> itemsAudio;
}
