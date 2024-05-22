package org.library_project.api.controller;

import org.library_project.api.model.FormatAudio;
import org.library_project.api.service.FormatAudioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("audio_formats")
public class FormatAudioController extends GeneralController<FormatAudioService, FormatAudio> {

}
