package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.FormatAudio;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.service.FormatAudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("audio_formats")
public class FormatAudioController extends GeneralController<FormatAudioService, FormatAudio> {
    @GetMapping("/{id}/items")
    public ResponseEntity<Iterable<ItemAudio>> getItemAudios(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getItemAudios(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
