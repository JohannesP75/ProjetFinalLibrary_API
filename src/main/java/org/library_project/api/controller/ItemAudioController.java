package org.library_project.api.controller;

import org.library_project.api.model.ItemAudio;
import org.library_project.api.service.ItemAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items_audio")
public class ItemAudioController {
    @Autowired
    private ItemAudioService service;

    @PostMapping("")
    public ItemAudio create(@RequestBody ItemAudio obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public ItemAudio get(@PathVariable("id") final Long id){
        Optional<ItemAudio> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<ItemAudio> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public ItemAudio update(@PathVariable("id") final Long id, @RequestBody ItemAudio body){
        Optional<ItemAudio> o=service.get(id);
        ItemAudio entity=null;

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
