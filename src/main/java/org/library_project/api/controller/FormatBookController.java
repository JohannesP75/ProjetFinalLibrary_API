package org.library_project.api.controller;

import org.library_project.api.model.FormatBook;
import org.library_project.api.service.FormatBookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book_formats")
public class FormatBookController extends GeneralController<FormatBookService, FormatBook> {

}