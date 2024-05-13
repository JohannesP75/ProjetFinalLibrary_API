package org.library_project.api.controller;

import org.library_project.api.model.Item;
import org.library_project.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("")
    public Item create(@RequestBody Item obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable("id") final Long id){
        Optional<Item> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Item> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Item update(@PathVariable("id") final Long id, @RequestBody Item body){
        Optional<Item> o=service.get(id);
        Item entity=null;

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
