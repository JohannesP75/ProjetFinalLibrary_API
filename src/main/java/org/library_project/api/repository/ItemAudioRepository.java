package org.library_project.api.repository;

import org.library_project.api.model.ItemAudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAudioRepository extends CrudRepository<ItemAudio, Long> {
}
