package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * A book is a medium for recording information in the form of writing
 */
@Data
@Entity
@Getter
@Setter
@Table(name="books")
public class Book extends Document {
    @OneToMany(mappedBy = "book")
    @JsonBackReference(value = "book-items")
    private Set<ItemBook> items=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "dewey_id", nullable = false)
    @JsonManagedReference(value = "book-dewey")
    private Dewey dewey;
}
