package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.FormatAudio;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.repository.FormatAudioRepository;
import org.springframework.stereotype.Service;
@Data
@Service
public class FormatAudioService extends GeneralService<FormatAudioRepository, FormatAudio> {
    public Iterable<ItemAudio> getItemAudios(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getItemsAudio();
    }
}