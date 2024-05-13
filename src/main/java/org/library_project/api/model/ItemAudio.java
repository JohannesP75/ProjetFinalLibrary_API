package org.library_project.api.model;

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
    private int length;

    private String isrc;

    @ManyToOne
    @JoinColumn(name="audio_id", nullable=false)
    private Audio audio;
}
