package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Alpha Numeric System for Collections of Recordings
 * See also:
 * - <a href="https://sscltech.com/2014/08/06/what-on-earth-is-anscr/">...</a>
 * - <a href="https://library.csustan.edu/music/anscr">...</a>
 */
@Entity
@Data
@Getter
@Setter
public class ANSCR {
    /**
     * ID of the ANSCR code
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ANSCR code
     */
    @Pattern(regexp = "^[A-Z]{1,2}$", message = "ANSCR call number should be a string of uppercase letters of a length between 1 and 2")
    private String code;

    /**
     * Description of the call number
     */
    private String name;

    /**
     * List of video documents with this number call
     */
    @OneToMany(mappedBy="anscr")
    @JsonBackReference(value = "anscr-audios")
    private Set<Audio> audios = new HashSet<>();
}
