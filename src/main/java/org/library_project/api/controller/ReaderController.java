package org.library_project.api.controller;

import com.github.fge.jsonpatch.JsonPatch;
import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Loan;
import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("readers")
public class ReaderController extends AbstractController<ReaderService, Reader> {
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
    public ResponseEntity<Reader> getProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) Jwt jwt){
        try {
            return super.get(extractIdFromJWT(jwt));
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @PatchMapping(value = "profile", consumes = "application/json-patch+json")
    public ResponseEntity<Reader> updateProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) Jwt jwt, @RequestBody JsonPatch body){
        try {
            return super.update(extractIdFromJWT(jwt), body);
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "profile")
    public ResponseEntity<Reader> deleteProfile(@RequestHeader(HttpHeaders.AUTHORIZATION) Jwt jwt){
        try {
            Long id=extractIdFromJWT(jwt);

            if(!service.get(id).getLoans().stream().filter(loan -> !loan.isReturned()).collect(Collectors.toSet()).isEmpty())
                throw new IllegalAccessException("Loans have to be returned before profiles are able to be deleted !");

            return super.delete(extractIdFromJWT(jwt));
        }catch(EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (IllegalAccessException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}