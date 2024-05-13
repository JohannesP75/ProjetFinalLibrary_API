package org.library_project.api.repository;

import org.library_project.api.model.Prerogative;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrerogativeRepository extends CrudRepository<Prerogative, Long> {
}
