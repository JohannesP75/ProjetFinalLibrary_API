package org.library_project.api.repository;

import org.library_project.api.model.Dewey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeweyRepository extends CrudRepository<Dewey, Long> {
}
