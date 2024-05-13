package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "documents")
    private Set<Author> authors = new HashSet<>();
}
