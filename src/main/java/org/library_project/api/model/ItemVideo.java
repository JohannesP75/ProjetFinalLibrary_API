package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "items_video")
@DiscriminatorValue("3")
public class ItemVideo extends Item{
    /**
     * Length, in minutes, of the video document
     */
    private int length;

    /**
     * International Standard Audiovisual Number
     */
    private String isan;

    /**
     * Video
     */
    @ManyToOne
    @JoinColumn(name="video_id", nullable=false)
    private Video video;

    @ManyToOne
    @JoinColumn(name="format_video_id", nullable = false)
    private FormatVideo formatVideo;
}
