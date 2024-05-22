package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Format of the item present in the library
 */
@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Format {
    /**
     * ID of the format
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the format
     */
    private String name;
}
