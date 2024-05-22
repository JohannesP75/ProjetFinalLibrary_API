package org.library_project.api.repository;

import org.library_project.api.model.FormatVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatVideoRepository extends CrudRepository<FormatVideo, Long> {
}
