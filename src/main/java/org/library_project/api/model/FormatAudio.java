package org.library_project.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

/**
 * Format of an audio item
 */
@Data
@Entity
public class FormatAudio extends Format {
    @OneToMany(mappedBy = "formatAudio")
    private Set<ItemAudio> items_audio;
}
