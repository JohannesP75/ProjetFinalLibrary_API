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

/**
 * Interacts with the final user
 * @param <TService> Service used to interact with the database
 * @param <TEntity>
 */
@RequestMapping("")
public class GeneralController<TService extends GeneralService, TEntity> {
    @Autowired
    private TService service;

    /**
     * Returns the number of instances of TENtity
     * @return Number of instances
     */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    /**
     * Creates a new instance of TEntity
     * @param obj The new instance to create
     * @return The created instance
     */
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

    /**
     * Reads an instance of TEntity from the database
     * @param id ID of the instance to read
     * @return The requested instance
     */
    @GetMapping("/{id}")
    public ResponseEntity<TEntity> get(@PathVariable("id") final Long id){
        try {
            return new ResponseEntity<>((TEntity)service.get(id), HttpStatus.OK);
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Requests all the instances of TEntity from the database
     * @return The list of all the instances of TEntity
     */
    @GetMapping("")
    public ResponseEntity<List<TEntity>> getAll(){
        try {
            return ResponseEntity.ok((List<TEntity>) service.getAll());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates an instance of TEntity
     * @param id ID of the instance to update
     * @param body Modifications to the instance
     * @return The updated instance
     */
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

    /**
     * Deletes an instance of TEntity
     * @param id ID of the instance to delete
     * @return The HTTP status
     */
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
