package org.library_project.api.controller;

import org.library_project.api.model.Publisher;
import org.library_project.api.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publishers")
public class PublisherController extends GeneralController<PublisherService, Publisher>{
}
