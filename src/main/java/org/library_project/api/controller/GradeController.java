package org.library_project.api.controller;

import org.library_project.api.model.Grade;
import org.library_project.api.service.GradeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("grades")
public class GradeController extends GeneralController<GradeService, Grade>{

}