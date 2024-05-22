package org.library_project.api.controller;

import org.library_project.api.model.ItemAudio;
import org.library_project.api.service.ItemAudioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("audio_items")
public class ItemAudioController extends GeneralController<ItemAudioService, ItemAudio>{

}