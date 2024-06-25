package org.library_project.api.controller;

import org.library_project.api.model.Loan;
import org.library_project.api.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loans")
public class LoanController extends AbstractController<LoanService, Loan> {
}