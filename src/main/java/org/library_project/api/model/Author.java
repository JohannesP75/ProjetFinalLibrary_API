package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "author_type")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = IndividualAuthor.class, name = "0"),
                @JsonSubTypes.Type(value = CollectiveAuthor.class, name = "1")
        }
)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public abstract class Author {
    /**
     * ID of author
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Description of an author
     */
    protected String description;

    /**
     * Name of an author
     */
    @NonNull
    protected String name;

    /**
     * Name used in sorting authors
     */
    @Column(name = "sorted_name")
    protected String sortedName;

    /**
     * Year of birth and creation
     */
    @Column(name = "year_birth")
    @NonNull
    protected Integer yearBirth;

    /**
     * List of works created by the author
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Resource",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    protected Set<Document> documents = new HashSet<>();

    /**
     * List of audio works interpreted by the author
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Author_Audio",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "audio_id") }
    )
    protected Set<Audio> audios = new HashSet<>();
}
