package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.UserRole;
import org.library_project.api.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserRoleService extends GeneralService<UserRoleRepository, UserRole> {
}
