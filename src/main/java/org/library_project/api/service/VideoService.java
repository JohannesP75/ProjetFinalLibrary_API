package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Author;
import org.library_project.api.model.Video;
import org.library_project.api.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class VideoService extends AbstractService<VideoRepository, Video> {
    public Iterable<Author> getAuthors(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getAuthors();
    }
}
