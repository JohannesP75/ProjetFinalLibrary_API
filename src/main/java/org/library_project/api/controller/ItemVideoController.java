package org.library_project.api.controller;

import org.library_project.api.model.ItemVideo;
import org.library_project.api.service.ItemVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items_video")
public class ItemVideoController {
    @Autowired
    private ItemVideoService service;

    @PostMapping("")
    public ItemVideo create(@RequestBody ItemVideo obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public ItemVideo get(@PathVariable("id") final Long id){
        Optional<ItemVideo> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<ItemVideo> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public ItemVideo update(@PathVariable("id") final Long id, @RequestBody ItemVideo body){
        Optional<ItemVideo> o=service.get(id);
        ItemVideo entity=null;

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