package org.library_project.api.controller;

import org.library_project.api.model.Grade;
import org.library_project.api.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("grades")
public class GradeController {
    @Autowired
    private GradeService service;

    @PostMapping("")
    public Grade create(@RequestBody Grade obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Grade get(@PathVariable("id") final Long id){
        Optional<Grade> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Grade> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Grade update(@PathVariable("id") final Long id, @RequestBody Grade body){
        Optional<Grade> o=service.get(id);
        Grade entity=null;

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
