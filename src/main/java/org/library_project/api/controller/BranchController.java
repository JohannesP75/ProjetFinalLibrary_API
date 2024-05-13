package org.library_project.api.controller;

import org.library_project.api.model.Book;
import org.library_project.api.model.Branch;
import org.library_project.api.model.Grade;
import org.library_project.api.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("branches")
public class BranchController {
    @Autowired
    private BranchService service;


    @PostMapping("")
    public Branch create(@RequestBody Branch obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Branch get(@PathVariable("id") final Long id){
        Optional<Branch> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Branch> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Branch update(@PathVariable("id") final Long id, @RequestBody Branch body){
        Optional<Branch> o=service.get(id);
        Branch entity=null;

        if(o.isPresent()){
            entity=o.get();
        }

        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id){
        service.delete(id);
    }
}
