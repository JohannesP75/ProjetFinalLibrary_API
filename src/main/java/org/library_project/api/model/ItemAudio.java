package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "items_audio")
@DiscriminatorValue("2")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class ItemAudio extends Item {
    /**
     * Length of the recording, in seconds
     */
    private int length;

    /**
     * International Standard Recording Code
     * <a href="https://isrc.scpp.fr/files/Guide_ISRC_4eme_Edition.pdf">https://isrc.scpp.fr/files/Guide_ISRC_4eme_Edition.pdf</a>
     */
    @Pattern(regexp = "^[a-zA-Z]{2}-?\\w{3}-?\\d{2}-?\\d{5}$")
    private String isrc;

    /**
     * Audio document of which it is a sample
     */
    @ManyToOne
    @JoinColumn(name="audio_id", nullable=false)
    private Audio audio;

    /**
     * Audio format of the recording
     */
    @ManyToOne
    @JoinColumn(name="format_audio_id", nullable = false)
    private FormatAudio formatAudio;
}
