package org.library_project.api.controller;

import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("readers")
public class ReaderController {
    @Autowired
    private ReaderService service;

    @PostMapping("")
    public ResponseEntity<Reader> create(@RequestBody Reader obj){
        try {
            Reader objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> get(@PathVariable("id") final Long id){
        try {
            Optional<Reader> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Reader>> getAll(){
        try {
            List<Reader> listResponses = (List<Reader>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Reader update(@PathVariable("id") final Long id, @RequestBody Reader body){
        // TODO
        Optional<Reader> o=service.get(id);
        Reader entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reader> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}