package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class representing an author
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@DiscriminatorColumn(name="author_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Author {
    /**
     * ID of author
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Description of an author
     */
    private String description;

    /**
     * Name of an author
     */
    @NonNull
    private String name;

    /**
     * Name used in sorting authors
     */
    @Column(name = "sorted_name")
    private String sortedName;

    /**
     * Year of birth and creation
     */
    @Column(name = "year_birth")
    @NonNull
    private Integer yearBirth;

    /**
     * List of works created by the author
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Resource",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    private Set<Document> documents = new HashSet<>();

    /**
     * List of audio works interpreted by the author
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Audio",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "audio_id") }
    )
    private Set<Audio> audios = new HashSet<>();
}
