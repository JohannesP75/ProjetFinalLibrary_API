package org.library_project.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

/**
 * Format of a video item
 */
@Data
@Entity
public class FormatVideo extends Format {
    @OneToMany(mappedBy="formatVideo")
    private Set<ItemVideo> items_video;
}
