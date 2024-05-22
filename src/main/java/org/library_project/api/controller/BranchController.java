package org.library_project.api.controller;

import org.library_project.api.model.Branch;
import org.library_project.api.service.BranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("branches")
public class BranchController extends GeneralController<BranchService, Branch>{

}