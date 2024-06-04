package org.library_project.api.repository;

import org.library_project.api.model.WorkerRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRoleRepository extends CrudRepository<WorkerRole, Long> {
}
