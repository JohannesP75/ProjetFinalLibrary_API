package org.library_project.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

/**
 * Format of a written document
 */
@Data
@Entity
@Table(name="formats_book")
public class FormatBook extends Format{
    @OneToMany(mappedBy = "formatBook")
    private Set<ItemBook> items_book;
}
