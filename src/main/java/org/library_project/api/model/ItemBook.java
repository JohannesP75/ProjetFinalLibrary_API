package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "items_book")
@DiscriminatorValue("1")
public class ItemBook extends Item{
    /**
     * Number of pages
     */
    private int numberPages;

    /**
     *International Standard Book Number
     */
    private String isbn;

    /**
     * Book of which this item is a sample
     */
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    @JsonManagedReference(value = "book-items")
    private Book book;

    /**
     * Format of the book
     */
    @ManyToOne
    @JoinColumn(name="format_book_id", nullable = false)
    @JsonManagedReference(value = "formatbook-itemsbook")
    private FormatBook formatBook;
}
