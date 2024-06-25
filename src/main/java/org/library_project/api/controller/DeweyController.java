package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Book;
import org.library_project.api.model.Dewey;
import org.library_project.api.service.DeweyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dewey")
public class DeweyController extends AbstractController<DeweyService, Dewey> {

    @GetMapping("/{id}/books")
    public ResponseEntity<Iterable<Book>> getBooks(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getBooks(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}