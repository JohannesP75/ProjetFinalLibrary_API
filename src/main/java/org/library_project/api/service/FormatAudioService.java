package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.FormatAudio;
import org.library_project.api.repository.FormatAudioRepository;
import org.springframework.stereotype.Service;
@Data
@Service
public class FormatAudioService extends GeneralService<FormatAudioRepository, FormatAudio> {
}