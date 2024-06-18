package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Loan;
import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("readers")
public class ReaderController extends GeneralController<ReaderService, Reader>{
    @GetMapping("/{id}/loans")
    public ResponseEntity<Iterable<Loan>> getLoans(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(service.getLoans(id));
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("profile")
    public ResponseEntity<Reader> profile(@RequestHeader(HttpHeaders.AUTHORIZATION) Jwt jwt){
        try {
            String username=jwt.getSubject();
            List<String> tokens = List.of(username.split("@"));
            tokens=List.of(tokens.get(1).split("\\."));

            return ResponseEntity.ok(service.get(Long.parseLong(tokens.get(1))));
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}