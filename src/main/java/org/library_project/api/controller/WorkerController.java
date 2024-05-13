package org.library_project.api.controller;

import org.library_project.api.model.Worker;
import org.library_project.api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("workers")
public class WorkerController {
    @Autowired
    private WorkerService service;

    @PostMapping("")
    public Worker create(@RequestBody Worker obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Worker get(@PathVariable("id") final Long id){
        Optional<Worker> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Worker> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Worker update(@PathVariable("id") final Long id, @RequestBody Worker body){
        Optional<Worker> o=service.get(id);
        Worker entity=null;

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