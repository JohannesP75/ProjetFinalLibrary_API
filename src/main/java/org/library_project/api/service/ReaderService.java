package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Reader;
import org.library_project.api.repository.ReaderRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ReaderService extends GeneralService<ReaderRepository, Reader> {
}
