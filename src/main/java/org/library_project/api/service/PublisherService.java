package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Item;
import org.library_project.api.model.Publisher;
import org.library_project.api.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class PublisherService extends AbstractService<PublisherRepository, Publisher> {
    public Iterable<Item> getItems(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getItems();
    }
}
