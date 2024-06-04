package org.library_project.api.controller;

import org.library_project.api.model.WorkerRole;
import org.library_project.api.service.WorkerRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("worker-roles")
public class WorkerRoleController extends GeneralController<WorkerRoleService, WorkerRole>{

}