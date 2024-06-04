package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.WorkerRole;
import org.library_project.api.repository.WorkerRoleRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class WorkerRoleService extends GeneralService<WorkerRoleRepository, WorkerRole> {
}
