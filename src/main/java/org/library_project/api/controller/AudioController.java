package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Audio;
import org.library_project.api.model.Author;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.service.AudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("audios")
public class AudioController extends AbstractController<AudioService, Audio> {
    @GetMapping("/{id}/items")
    public ResponseEntity<Iterable<ItemAudio>> getItems(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getItems(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/authors")
    public ResponseEntity<Iterable<Author>> getAuthors(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getAuthors(id));
        }catch(EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/interpreters")
    public ResponseEntity<Iterable<Author>> getInterpreters(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getInterpreters(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
