package org.library_project.api.controller;

import org.library_project.api.model.Author;
import org.library_project.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping("")
    public ResponseEntity<Author> create(@RequestBody Author obj){
        try {
            Author objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> get(@PathVariable("id") final Long id){
        try {
            Optional<Author> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> getAll(){
        try {
            List<Author> listResponses = (List<Author>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Author update(@PathVariable("id") final Long id, @RequestBody Author body){
        // TODO
        Optional<Author> o=service.get(id);
        Author entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}