package org.library_project.api.controller;

import org.library_project.api.model.Video;
import org.library_project.api.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("videos")
public class VideoController {
    @Autowired
    private VideoService service;

    @PostMapping("")
    public Video create(@RequestBody Video obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Video get(@PathVariable("id") final Long id){
        Optional<Video> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Video> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Video update(@PathVariable("id") final Long id, @RequestBody Video body){
        Optional<Video> o=service.get(id);
        Video entity=null;

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