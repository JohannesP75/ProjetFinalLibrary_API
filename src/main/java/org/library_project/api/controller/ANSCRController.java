package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.ANSCR;
import org.library_project.api.model.Audio;
import org.library_project.api.service.ANSCRService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anscr")
public class ANSCRController extends GeneralController<ANSCRService, ANSCR> {
    @GetMapping("/{id}/audios")
    public ResponseEntity<Iterable<Audio>> getAudios(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getAudios(id));
        }catch(EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
