package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Audio;
import org.library_project.api.model.Author;
import org.library_project.api.model.Document;
import org.library_project.api.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class AuthorService extends GeneralService<AuthorRepository, Author> {
    public Iterable<Document> getDocuments(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getDocuments();
    }

    public Iterable<Audio> getAudios(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getAudios();
    }
}
