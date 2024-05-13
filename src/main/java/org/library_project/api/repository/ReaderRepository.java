package org.library_project.api.repository;

import org.library_project.api.model.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
}
