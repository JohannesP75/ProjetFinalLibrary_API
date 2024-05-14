package org.library_project.api.controller;

import org.library_project.api.model.Dewey;
import org.library_project.api.service.DeweyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dewey")
public class DeweyController {
    @Autowired
    private DeweyService service;

    @PostMapping("")
    public ResponseEntity<Dewey> create(@RequestBody Dewey obj){
        try {
            Dewey objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dewey> get(@PathVariable("id") final Long id){
        try {
            Optional<Dewey> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Dewey>> getAll(){
        try {
            List<Dewey> listResponses = (List<Dewey>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Dewey update(@PathVariable("id") final Long id, @RequestBody Dewey body){
        // TODO
        Optional<Dewey> o=service.get(id);
        Dewey entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dewey> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}