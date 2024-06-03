package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.FormatBook;
import org.library_project.api.model.ItemBook;
import org.library_project.api.service.FormatBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book_formats")
public class FormatBookController extends GeneralController<FormatBookService, FormatBook> {
    @GetMapping("/{id}/items")
    public ResponseEntity<Iterable<ItemBook>> getItemBooks(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getItemBooks(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}