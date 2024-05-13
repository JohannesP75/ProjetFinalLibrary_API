package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Dewey;
import org.library_project.api.repository.DeweyRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class DeweyService extends GeneralService<DeweyRepository, Dewey> {
}
