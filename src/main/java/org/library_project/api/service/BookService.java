package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Book;
import org.library_project.api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class BookService extends GeneralService<BookRepository, Book>{
}
