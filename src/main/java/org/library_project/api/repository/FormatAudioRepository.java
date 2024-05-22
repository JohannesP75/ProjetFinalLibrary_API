package org.library_project.api.repository;

import org.library_project.api.model.FormatAudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatAudioRepository extends CrudRepository<FormatAudio, Long> {
}