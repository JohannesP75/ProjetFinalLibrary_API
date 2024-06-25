package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.config.SecurityConfig;
import org.library_project.api.model.Loan;
import org.library_project.api.model.Reader;
import org.library_project.api.repository.ReaderRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ReaderService extends AbstractService<ReaderRepository, Reader> {
    @Override
    public Reader save(Reader entry) {
        entry.setPassword(SecurityConfig.passwordEncoder().encode(entry.getPassword()));

        return super.save(entry);
    }

    public Iterable<Loan> getLoans(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new).getLoans();
    }
}
