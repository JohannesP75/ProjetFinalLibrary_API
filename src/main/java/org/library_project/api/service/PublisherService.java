package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Publisher;
import org.library_project.api.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class PublisherService extends GeneralService<PublisherRepository, Publisher>{
}
