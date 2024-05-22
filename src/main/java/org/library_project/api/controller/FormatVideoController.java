package org.library_project.api.controller;

import org.library_project.api.model.FormatVideo;
import org.library_project.api.service.FormatVideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video_formats")
public class FormatVideoController extends GeneralController<FormatVideoService, FormatVideo> {

}