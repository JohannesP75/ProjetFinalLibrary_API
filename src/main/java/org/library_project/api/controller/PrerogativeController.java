package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Prerogative;
import org.library_project.api.model.UserRole;
import org.library_project.api.service.PrerogativeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rights")
public class PrerogativeController extends AbstractController<PrerogativeService, Prerogative> {
    @GetMapping("/{id}/roles")
    public ResponseEntity<Iterable<UserRole>> getUserRoles(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getUserRoles(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}