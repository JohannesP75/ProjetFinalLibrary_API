package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.config.SecurityConfig;
import org.library_project.api.model.Worker;
import org.library_project.api.repository.WorkerRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class WorkerService extends GeneralService<WorkerRepository, Worker> {
    @Override
    public Worker save(Worker entry) {
        entry.setPassword(SecurityConfig.encoder().encode(entry.getPassword()));

        return super.save(entry);
    }
}
