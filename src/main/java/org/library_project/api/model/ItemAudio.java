package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "items_audio")
@DiscriminatorValue("2")
public class ItemAudio extends Item {
    /**
     * Length of the recording, in seconds
     */
    private int length;

    /**
     * International Standard Recording Code
     */
    private String isrc;

    /**
     * Audio document of which it is a sample
     */
    @ManyToOne
    @JoinColumn(name="audio_id", nullable=false)
    @JsonManagedReference(value = "audio-items")
    private Audio audio;

    /**
     * Audio format of the recording
     */
    @ManyToOne
    @JoinColumn(name="format_audio_id", nullable = false)
    @JsonManagedReference(value = "formataudio-itemsaudio")
    private FormatAudio formatAudio;
}
