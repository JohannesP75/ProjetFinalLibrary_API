package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Loan;
import org.library_project.api.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Data
@Service
public class LoanService extends AbstractService<LoanRepository, Loan> {
    @Override
    public Loan save(Loan entry) {
        entry.setDateStart(LocalDate.now());
        return super.save(entry);
    }
}
