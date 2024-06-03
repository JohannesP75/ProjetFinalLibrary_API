package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Grade;
import org.library_project.api.model.Worker;
import org.library_project.api.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("grades")
public class GradeController extends GeneralController<GradeService, Grade>{
    @GetMapping("/{id}/workers")
    public ResponseEntity<Iterable<Worker>> getWorkers(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getWorkers(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}