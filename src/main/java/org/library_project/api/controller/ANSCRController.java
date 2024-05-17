package org.library_project.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.ANSCR;
import org.library_project.api.service.ANSCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("anscr")
public class ANSCRController {
    @Autowired
    private ANSCRService service;

    @PostMapping("")
    public ResponseEntity<ANSCR> create(@RequestBody ANSCR obj){
        try {
            ANSCR objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ANSCR> get(@PathVariable("id") final Long id){
        try {
            Optional<ANSCR> response=service.get(id);

            return new ResponseEntity<>(response.orElse(null), HttpStatus.OK);
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ANSCR>> getAll(){
        try {
            return ResponseEntity.ok((List<ANSCR>) service.getAll());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ANSCR> update(@PathVariable("id") final Long id, @RequestBody JsonPatch body){
        try {
            return ResponseEntity.ok(service.update(id, body));
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch(JsonPatchException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch(JsonProcessingException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ANSCR> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
