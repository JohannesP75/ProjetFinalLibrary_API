package org.library_project.api.controller;

import org.library_project.api.model.Video;
import org.library_project.api.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("videos")
public class VideoController {
    @Autowired
    private VideoService service;

    @PostMapping("")
    public ResponseEntity<Video> create(@RequestBody Video obj){
        try {
            Video objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> get(@PathVariable("id") final Long id){
        try {
            Optional<Video> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Video>> getAll(){
        try {
            List<Video> listResponses = (List<Video>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public Video update(@PathVariable("id") final Long id, @RequestBody Video body){
        // TODO
        Optional<Video> o=service.get(id);
        Video entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}