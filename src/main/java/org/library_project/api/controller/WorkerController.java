package org.library_project.api.controller;

import org.library_project.api.model.Worker;
import org.library_project.api.service.WorkerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workers")
public class WorkerController extends GeneralController<WorkerService, Worker>{

}