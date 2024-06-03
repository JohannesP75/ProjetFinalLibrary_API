package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference(value = "formatbook-itemsbook")
    private Set<ItemBook> itemsBook;
}
