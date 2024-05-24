package org.library_project.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
public class GeneralController<TService extends GeneralService, TEntity> {
    @Autowired
    private TService service;

    @PostMapping("")
    public ResponseEntity<TEntity> create(@RequestBody TEntity obj){
        try {
            return new ResponseEntity<>((TEntity) service.save(obj), HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TEntity> get(@PathVariable("id") final Long id){
        try {
            return new ResponseEntity<TEntity>((TEntity) service.get(id).orElse(null), HttpStatus.OK);
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<TEntity>> getAll(){
        try {
            return ResponseEntity.ok((List<TEntity>) service.getAll());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TEntity> update(@PathVariable("id") final Long id, @RequestBody JsonPatch body){
        try {
            return (ResponseEntity<TEntity>) ResponseEntity.ok(service.update(id, body));
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(IllegalArgumentException | JsonProcessingException | JsonPatchException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TEntity> delete(@PathVariable("id") final Long id){
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
