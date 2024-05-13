package org.library_project.api.controller;

import org.library_project.api.model.Loan;
import org.library_project.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items_book")
public class LoanController {
    @Autowired
    private LoanService service;

    @PostMapping("")
    public Loan create(@RequestBody Loan obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Loan get(@PathVariable("id") final Long id){
        Optional<Loan> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Loan> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Loan update(@PathVariable("id") final Long id, @RequestBody Loan body){
        Optional<Loan> o=service.get(id);
        Loan entity=null;

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