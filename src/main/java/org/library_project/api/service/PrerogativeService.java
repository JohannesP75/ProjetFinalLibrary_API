package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Prerogative;
import org.library_project.api.repository.PrerogativeRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class PrerogativeService extends GeneralService<PrerogativeRepository, Prerogative>{
}
