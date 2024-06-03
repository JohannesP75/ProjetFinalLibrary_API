package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.FormatVideo;
import org.library_project.api.model.ItemVideo;
import org.library_project.api.repository.FormatVideoRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class FormatVideoService extends GeneralService<FormatVideoRepository, FormatVideo> {
    public Iterable<ItemVideo> getItemVideos(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getItemsVideo();
    }
}