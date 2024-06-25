package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Audio;
import org.library_project.api.model.Author;
import org.library_project.api.model.Document;
import org.library_project.api.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController extends AbstractController<AuthorService, Author> {
    @GetMapping("/{id}/works")
    public ResponseEntity<Iterable<Document>> getDocuments(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getDocuments(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/interpretations")
    public ResponseEntity<Iterable<Audio>> getAudios(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getAudios(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}