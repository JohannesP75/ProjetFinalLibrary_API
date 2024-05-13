package org.library_project.api.controller;

import org.library_project.api.model.ItemBook;
import org.library_project.api.service.ItemBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items_book")
public class ItemBookController {
    @Autowired
    private ItemBookService service;

    @PostMapping("")
    public ItemBook create(@RequestBody ItemBook obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public ItemBook get(@PathVariable("id") final Long id){
        Optional<ItemBook> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<ItemBook> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public ItemBook update(@PathVariable("id") final Long id, @RequestBody ItemBook body){
        Optional<ItemBook> o=service.get(id);
        ItemBook entity=null;

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