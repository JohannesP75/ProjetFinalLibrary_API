package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Item;
import org.library_project.api.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ItemService extends AbstractService<ItemRepository, Item> {
}
