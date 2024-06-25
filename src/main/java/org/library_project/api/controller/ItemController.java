package org.library_project.api.controller;

import org.library_project.api.model.Item;
import org.library_project.api.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
public class ItemController extends AbstractController<ItemService, Item> {

}