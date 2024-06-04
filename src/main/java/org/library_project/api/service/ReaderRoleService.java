package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.ReaderRole;
import org.library_project.api.repository.ReaderRoleRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ReaderRoleService extends GeneralService<ReaderRoleRepository, ReaderRole> {
}
