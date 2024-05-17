package org.library_project.api.controller;

import org.library_project.api.model.ItemAudio;
import org.library_project.api.service.ItemAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items_audio")
public class ItemAudioController {
    @Autowired
    private ItemAudioService service;

    @PostMapping("")
    public ResponseEntity<ItemAudio> create(@RequestBody ItemAudio obj){
        try {
            ItemAudio objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemAudio> get(@PathVariable("id") final Long id){
        try {
            Optional<ItemAudio> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ItemAudio>> getAll(){
        try {
            List<ItemAudio> listResponses = (List<ItemAudio>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ItemAudio update(@PathVariable("id") final Long id, @RequestBody ItemAudio body){
        // TODO
        Optional<ItemAudio> o=service.get(id);
        ItemAudio entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemAudio> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
