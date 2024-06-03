package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Audio entry present in the library
 */
@Data
@Setter
@Getter
@Entity
@Table(name = "audios")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Audio extends Document {
    /**
     * List of interpreters
     */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "interpretations",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "resource_id") }
    )
    private Set<Author> interpreters = new HashSet<>();

    /**
     * List of samples of this audio entry
     */
    @OneToMany(mappedBy = "audio")
    @JsonBackReference(value = "audio-items")
    private Set<ItemAudio> items=new HashSet<>();

    /**
     * ANSCR number call
     */
    @ManyToOne
    @JoinColumn(name = "anscr_id", nullable = false)
    @JsonManagedReference(value = "anscr-audios")
    private ANSCR anscr;
}
