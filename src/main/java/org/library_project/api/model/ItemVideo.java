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
    private int length;

    private String isan;

    @ManyToOne
    @JoinColumn(name="video_id", nullable=false)
    private Video video;
}
