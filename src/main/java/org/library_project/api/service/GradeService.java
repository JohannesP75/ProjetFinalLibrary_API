package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Grade;
import org.library_project.api.model.Worker;
import org.library_project.api.repository.GradeRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class GradeService extends GeneralService<GradeRepository, Grade> {
    public Iterable<Worker> getWorkers(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getWorkers();
    }
}
