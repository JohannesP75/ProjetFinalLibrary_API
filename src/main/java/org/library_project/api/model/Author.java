package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Table(name = "authors")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="author_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @NonNull
    private String name;

    @Column(name = "sorted_name")
    private String sortedName;

    @Column(name = "year_birth")
    @NonNull
    private int yearBirth;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Resource",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    private Set<Document> documents = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Audio",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "audio_id") }
    )
    private Set<Audio> audios = new HashSet<>();
}
