package org.library_project.api.controller;

import org.library_project.api.model.ANSCR;
import org.library_project.api.service.ANSCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("anscr")
public class ANSCRController {
    @Autowired
    private ANSCRService service;

    @PostMapping("")
    public ANSCR create(@RequestBody ANSCR obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public ANSCR get(@PathVariable("id") final Long id){
        Optional<ANSCR> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<ANSCR> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public ANSCR update(@PathVariable("id") final Long id, @RequestBody ANSCR body){
        Optional<ANSCR> o=service.get(id);
        ANSCR entity=null;

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
