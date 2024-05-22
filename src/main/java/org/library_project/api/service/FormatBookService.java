package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.FormatBook;
import org.library_project.api.repository.FormatBookRepository;
import org.springframework.stereotype.Service;
@Data
@Service
public class FormatBookService extends GeneralService<FormatBookRepository, FormatBook> {
}