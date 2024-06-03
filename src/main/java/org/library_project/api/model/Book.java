package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Book extends Document {
    @OneToMany(mappedBy = "book")
    @JsonBackReference(value = "book-items")
    private Set<ItemBook> items=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "dewey_id", nullable = false)
    private Dewey dewey;
}
