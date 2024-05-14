package org.library_project.api.controller;

import org.library_project.api.model.ANSCR;
import org.library_project.api.service.ANSCRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("anscr")
public class ANSCRController {
    @Autowired
    private ANSCRService service;

    @PostMapping("")
    public ResponseEntity<ANSCR> create(@RequestBody ANSCR obj){
        try {
            ANSCR objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ANSCR> get(@PathVariable("id") final Long id){
        try {
            Optional<ANSCR> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ANSCR>> getAll(){
        try {
            List<ANSCR> listResponses = (List<ANSCR>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ANSCR update(@PathVariable("id") final Long id, @RequestBody ANSCR body){
        // TODO
        Optional<ANSCR> o=service.get(id);
        ANSCR entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ANSCR> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
