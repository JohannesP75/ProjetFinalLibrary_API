package org.library_project.api.model;

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
    private Set<ItemAudio> items=new HashSet<>();

    /**
     * ANSCR number call
     */
    @ManyToOne
    @JoinColumn(name = "anscr_id", nullable = false)
    private ANSCR anscr;
}
