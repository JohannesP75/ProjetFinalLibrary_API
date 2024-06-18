package org.library_project.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.library_project.api.model.Worker;
import org.library_project.api.service.WorkerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkerController extends GeneralController<WorkerService, Worker>{
    @GetMapping("profile")
    public ResponseEntity<Worker> profile(@RequestHeader(HttpHeaders.AUTHORIZATION) Jwt jwt){
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