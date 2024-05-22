package org.library_project.api.controller;

import org.library_project.api.model.ItemBook;
import org.library_project.api.service.ItemBookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book_items")
public class ItemBookController extends GeneralController<ItemBookService, ItemBook>{

}