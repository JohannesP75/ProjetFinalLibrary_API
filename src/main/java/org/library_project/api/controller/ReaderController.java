package org.library_project.api.controller;

import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("readers")
public class ReaderController extends GeneralController<ReaderService, Reader>{

}