package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Author;
import org.library_project.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AuthorService extends GeneralService<AuthorRepository, Author> {

}
