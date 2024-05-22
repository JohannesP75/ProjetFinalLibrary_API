package org.library_project.api.controller;

import org.library_project.api.model.Video;
import org.library_project.api.service.VideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoController extends GeneralController<VideoService, Video>{

}