package org.library_project.api.controller;

import org.library_project.api.model.UserRole;
import org.library_project.api.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("roles")
public class UserRoleController {
    @Autowired
    private UserRoleService service;

    @PostMapping("")
    public UserRole create(@RequestBody UserRole obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public UserRole get(@PathVariable("id") final Long id){
        Optional<UserRole> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<UserRole> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public UserRole update(@PathVariable("id") final Long id, @RequestBody UserRole body){
        Optional<UserRole> o=service.get(id);
        UserRole entity=null;

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