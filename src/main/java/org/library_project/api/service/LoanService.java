package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.Loan;
import org.library_project.api.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoanService extends GeneralService<LoanRepository, Loan> {
}
