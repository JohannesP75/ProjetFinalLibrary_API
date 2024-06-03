package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference(value = "formataudio-itemsaudio")
    private Set<ItemAudio> itemsAudio;
}
