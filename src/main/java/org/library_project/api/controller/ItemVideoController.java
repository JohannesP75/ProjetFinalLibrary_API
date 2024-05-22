package org.library_project.api.controller;

import org.library_project.api.model.ItemVideo;
import org.library_project.api.service.ItemVideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video_items")
public class ItemVideoController extends GeneralController<ItemVideoService, ItemVideo>{

}