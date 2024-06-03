package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
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
