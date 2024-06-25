package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.ItemVideo;
import org.library_project.api.repository.ItemVideoRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ItemVideoService extends AbstractService<ItemVideoRepository, ItemVideo> {
}
