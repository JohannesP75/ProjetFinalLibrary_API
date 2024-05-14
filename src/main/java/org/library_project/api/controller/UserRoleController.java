package org.library_project.api.controller;

import org.library_project.api.model.UserRole;
import org.library_project.api.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("roles")
public class UserRoleController {
    @Autowired
    private UserRoleService service;

    @PostMapping("")
    public ResponseEntity<UserRole> create(@RequestBody UserRole obj){
        try {
            UserRole objResponse = service.save(obj);

            return ResponseEntity.ok(objResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> get(@PathVariable("id") final Long id){
        try {
            Optional<UserRole> response=service.get(id);
            HttpStatusCode code=response.isPresent()? HttpStatus.OK:HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(response.orElse(null), code);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<UserRole>> getAll(){
        try {
            List<UserRole> listResponses = (List<UserRole>) service.getAll();

            return ResponseEntity.ok(listResponses);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public UserRole update(@PathVariable("id") final Long id, @RequestBody UserRole body){
        // TODO
        Optional<UserRole> o=service.get(id);
        UserRole entity=o.isPresent()?o.get():null;

        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserRole> delete(@PathVariable("id") final Long id){
        try {
            service.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}