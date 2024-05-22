package org.library_project.api.controller;

import org.library_project.api.model.UserRole;
import org.library_project.api.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class UserRoleController extends GeneralController<UserRoleService, UserRole>{

}