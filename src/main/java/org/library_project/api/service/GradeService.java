package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Grade;
import org.library_project.api.repository.GradeRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class GradeService extends GeneralService<GradeRepository, Grade> {
}
