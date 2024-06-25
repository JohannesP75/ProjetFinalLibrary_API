package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Book;
import org.library_project.api.model.Dewey;
import org.library_project.api.repository.DeweyRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class DeweyService extends AbstractService<DeweyRepository, Dewey> {

    public Iterable<Book> getBooks(final Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getBooks();
    }
}
