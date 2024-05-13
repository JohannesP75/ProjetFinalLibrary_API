package org.library_project.api.repository;

import org.library_project.api.model.ANSCR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ANSCRRepository extends CrudRepository<ANSCR, Long> {
}
