package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.FormatVideo;
import org.library_project.api.model.ItemVideo;
import org.library_project.api.service.FormatVideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video_formats")
public class FormatVideoController extends GeneralController<FormatVideoService, FormatVideo> {
    @GetMapping("/{id}/items")
    public ResponseEntity<Iterable<ItemVideo>> getItemVideos(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getItemVideos(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}