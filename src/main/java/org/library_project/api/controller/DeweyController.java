package org.library_project.api.controller;

import org.library_project.api.model.Dewey;
import org.library_project.api.service.DeweyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dewey")
public class DeweyController extends GeneralController<DeweyService, Dewey>{

}