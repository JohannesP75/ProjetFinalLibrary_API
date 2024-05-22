package org.library_project.api.controller;

import org.library_project.api.model.Author;
import org.library_project.api.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController extends GeneralController<AuthorService, Author>{
    
}