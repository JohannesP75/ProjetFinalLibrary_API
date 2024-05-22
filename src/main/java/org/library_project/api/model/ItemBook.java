package org.library_project.api.model;

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
    private int numberPages;

    private String isbn;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="format_book_id", nullable = false)
    private FormatBook formatBook;
}
