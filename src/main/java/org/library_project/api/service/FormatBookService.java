package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.FormatBook;
import org.library_project.api.model.ItemBook;
import org.library_project.api.repository.FormatBookRepository;
import org.springframework.stereotype.Service;
@Data
@Service
public class FormatBookService extends GeneralService<FormatBookRepository, FormatBook> {
    public Iterable<ItemBook> getItemBooks(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getItemsBook();
    }
}