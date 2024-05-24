package org.library_project.api.repository;

import org.library_project.api.model.FormatBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatBookRepository extends CrudRepository<FormatBook, Long> {
}