package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "items_book")
@DiscriminatorValue("1")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class ItemBook extends Item{
    /**
     * Number of pages
     */
    private int numberPages;

    /**
     *International Standard Book Number
     * <a href="https://www.isbn-international.org/sites/default/files/Manuel%20d%27utilisation%20de%20l%27ISBN.pdf">https://www.isbn-international.org/sites/default/files/Manuel%20d%27utilisation%20de%20l%27ISBN.pdf</a>
     */
    @Pattern(regexp = "^(\\d{3}-)?\\d{1,5}-\\d{1,7}-\\d{1,6}-[0-9X]$")
    private String isbn;

    /**
     * Book of which this item is a sample
     */
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    /**
     * Format of the book
     */
    @ManyToOne
    @JoinColumn(name="format_book_id", nullable = false)
    private FormatBook formatBook;
}
