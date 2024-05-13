package org.library_project.api.repository;

import org.library_project.api.model.ItemVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVideoRepository extends CrudRepository<ItemVideo, Long> {
}
