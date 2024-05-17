package org.library_project.api.controller;

import org.library_project.api.model.Branch;
import org.library_project.api.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("branches")
public class BranchController {
    @Autowired
    private BranchService service;

    @PostMapping("")
    public ResponseEntity<Branch> create(@RequestBody Branch obj){
        try {
            Branch objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> get(@PathVariable("id") final Long id){
        try {
            Optional<Branch> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Branch>> getAll(){
        try {
            List<Branch> listResponses = (List<Branch>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Branch update(@PathVariable("id") final Long id, @RequestBody Branch body){
        // TODO
        Optional<Branch> o=service.get(id);
        Branch entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Branch> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
