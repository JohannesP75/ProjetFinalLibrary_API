package org.library_project.api.controller;

import org.library_project.api.model.Loan;
import org.library_project.api.service.LoanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items_book")
public class LoanController extends GeneralController<LoanService, Loan>{

}