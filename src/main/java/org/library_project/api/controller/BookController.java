package org.library_project.api.controller;

import org.library_project.api.model.Book;
import org.library_project.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("")
    public ResponseEntity<Book> create(@RequestBody Book obj){
        try {
            Book objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") final Long id){
        try {
            Optional<Book> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAll(){
        try {
            List<Book> listResponses = (List<Book>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Book update(@PathVariable("id") final Long id, @RequestBody Book body){
        // TODO
        Optional<Book> o=service.get(id);
        Book entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
