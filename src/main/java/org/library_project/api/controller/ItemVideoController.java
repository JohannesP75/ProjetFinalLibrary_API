package org.library_project.api.controller;

import org.library_project.api.model.ItemVideo;
import org.library_project.api.service.ItemVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items_video")
public class ItemVideoController {
    @Autowired
    private ItemVideoService service;

    @PostMapping("")
    public ResponseEntity<ItemVideo> create(@RequestBody ItemVideo obj){
        try {
            ItemVideo objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemVideo> get(@PathVariable("id") final Long id){
        try {
            Optional<ItemVideo> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ItemVideo>> getAll(){
        try {
            List<ItemVideo> listResponses = (List<ItemVideo>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ItemVideo update(@PathVariable("id") final Long id, @RequestBody ItemVideo body){
        // TODO
        Optional<ItemVideo> o=service.get(id);
        ItemVideo entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemVideo> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}