package org.library_project.api.controller;

import org.library_project.api.model.ItemBook;
import org.library_project.api.service.ItemBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items_book")
public class ItemBookController {
    @Autowired
    private ItemBookService service;

    @PostMapping("")
    public ResponseEntity<ItemBook> create(@RequestBody ItemBook obj){
        try {
            ItemBook objResponse = service.save(obj);

            return new ResponseEntity<>(objResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemBook> get(@PathVariable("id") final Long id){
        try {
            Optional<ItemBook> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ItemBook>> getAll(){
        try {
            List<ItemBook> listResponses = (List<ItemBook>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ItemBook update(@PathVariable("id") final Long id, @RequestBody ItemBook body){
        // TODO
        Optional<ItemBook> o=service.get(id);
        ItemBook entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemBook> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}