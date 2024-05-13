package org.library_project.api.controller;

import org.library_project.api.model.Prerogative;
import org.library_project.api.service.PrerogativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rights")
public class PrerogativeController {
    @Autowired
    private PrerogativeService service;

    @PostMapping("")
    public Prerogative create(@RequestBody Prerogative obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Prerogative get(@PathVariable("id") final Long id){
        Optional<Prerogative> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Prerogative> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Prerogative update(@PathVariable("id") final Long id, @RequestBody Prerogative body){
        Optional<Prerogative> o=service.get(id);
        Prerogative entity=null;

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