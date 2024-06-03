package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Loan;
import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("readers")
public class ReaderController extends GeneralController<ReaderService, Reader>{
    public ResponseEntity<Iterable<Loan>> getLoans(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getLoans(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}