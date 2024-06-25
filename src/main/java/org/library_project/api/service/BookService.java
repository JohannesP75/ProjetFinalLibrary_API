package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Author;
import org.library_project.api.model.Book;
import org.library_project.api.model.ItemBook;
import org.library_project.api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class BookService extends AbstractService<BookRepository, Book> {
    public Iterable<ItemBook> getItems(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getItems();
    }

    public Iterable<Author> getAuthors(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getAuthors();
    }
}
