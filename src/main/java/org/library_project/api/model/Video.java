package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Table(name = "videos")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Video extends Document {
    /**
     * IMDB identifiant for the work
     * <a href="https://developer.imdb.com/documentation/key-concepts">https://developer.imdb.com/documentation/key-concepts</a>
     */
    @Pattern(regexp = "^tt\\d+$")
    private String imdb;

    /**
     * CNC certificate for a movie
     * <a href="https://www.cnc.fr/professionnels/visas-et-classification/activite-de-la-commission-de-classification">https://www.cnc.fr/professionnels/visas-et-classification/activite-de-la-commission-de-classification</a>
     */
    @Column(unique = true)
    private Long certificateCNC;
}
