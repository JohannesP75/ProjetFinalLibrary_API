package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.ItemBook;
import org.library_project.api.repository.ItemBookRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ItemBookService extends GeneralService<ItemBookRepository, ItemBook> {
}
