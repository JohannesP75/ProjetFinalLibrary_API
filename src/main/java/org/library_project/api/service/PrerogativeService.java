package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Prerogative;
import org.library_project.api.model.UserRole;
import org.library_project.api.repository.PrerogativeRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class PrerogativeService extends AbstractService<PrerogativeRepository, Prerogative> {
    public Iterable<UserRole> getUserRoles(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getUserRoles();
    }
}
