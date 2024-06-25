package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Author;
import org.library_project.api.model.Video;
import org.library_project.api.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoController extends AbstractController<VideoService, Video> {
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
}