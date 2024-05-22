package org.library_project.api.controller;

import org.library_project.api.model.Book;
import org.library_project.api.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController extends GeneralController<BookService, Book>{

}