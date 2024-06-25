package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Audio;
import org.library_project.api.model.Author;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.repository.AudioRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class AudioService extends AbstractService<AudioRepository, Audio> {
    public Iterable<ItemAudio> getItems(final Long id){
        Audio audio=repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return audio.getItems();
    }

    public Iterable<Author> getAuthors(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getAuthors();
    }

    public Iterable<Author> getInterpreters(final Long id){
        Audio audio=repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return audio.getInterpreters();
    }
}
