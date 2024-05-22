package org.library_project.api.controller;

import org.library_project.api.model.Prerogative;
import org.library_project.api.service.PrerogativeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rights")
public class PrerogativeController extends GeneralController<PrerogativeService, Prerogative>{

}