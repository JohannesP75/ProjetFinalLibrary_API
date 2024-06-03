package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class FormatBook extends Format{
    @OneToMany(mappedBy = "formatBook")
    private Set<ItemBook> itemsBook;
}
