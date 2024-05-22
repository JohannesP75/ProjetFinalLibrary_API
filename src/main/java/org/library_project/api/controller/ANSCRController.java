package org.library_project.api.controller;

import org.library_project.api.model.ANSCR;
import org.library_project.api.service.ANSCRService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anscr")
public class ANSCRController extends GeneralController<ANSCRService, ANSCR> {

}
