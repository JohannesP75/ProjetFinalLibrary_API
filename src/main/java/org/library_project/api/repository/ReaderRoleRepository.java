package org.library_project.api.repository;

import org.library_project.api.model.ReaderRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRoleRepository extends CrudRepository<ReaderRole, Long> {
}
