package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Branch;
import org.library_project.api.repository.BranchRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class BranchService extends GeneralService<BranchRepository, Branch> {
}
