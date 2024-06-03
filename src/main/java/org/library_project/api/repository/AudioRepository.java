package org.library_project.api.repository;

import org.library_project.api.model.Audio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends CrudRepository<Audio, Long> {
}
