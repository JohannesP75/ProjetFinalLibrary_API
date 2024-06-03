package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.Branch;
import org.library_project.api.model.Item;
import org.library_project.api.model.Worker;
import org.library_project.api.repository.BranchRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class BranchService extends GeneralService<BranchRepository, Branch> {
    public Iterable<Worker> getWorkers(final Long id){
        Branch branch=repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return branch.getWorkers();
    }

    public Iterable<Item> getItems(final Long id){
        Branch branch=repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return branch.getItems();
    }
}
