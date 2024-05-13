package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.ANSCR;
import org.library_project.api.repository.ANSCRRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ANSCRService extends GeneralService<ANSCRRepository, ANSCR> {
}
