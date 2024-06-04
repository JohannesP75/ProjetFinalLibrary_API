package org.library_project.api.controller;

import org.library_project.api.model.ReaderRole;
import org.library_project.api.service.ReaderRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reader-roles")
public class ReaderRoleController extends GeneralController<ReaderRoleService, ReaderRole> {
}
