package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Video;
import org.library_project.api.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class VideoService extends GeneralService<VideoRepository, Video> {
}
