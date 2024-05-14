package org.library_project.api.controller;

import org.library_project.api.model.Prerogative;
import org.library_project.api.service.PrerogativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rights")
public class PrerogativeController {
    @Autowired
    private PrerogativeService service;

    @PostMapping("")
    public ResponseEntity<Prerogative> create(@RequestBody Prerogative obj){
        try {
            Prerogative objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prerogative> get(@PathVariable("id") final Long id){
        try {
            Optional<Prerogative> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Prerogative>> getAll(){
        try {
            List<Prerogative> listResponses = (List<Prerogative>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Prerogative update(@PathVariable("id") final Long id, @RequestBody Prerogative body){
        // TODO
        Optional<Prerogative> o=service.get(id);
        Prerogative entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prerogative> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}