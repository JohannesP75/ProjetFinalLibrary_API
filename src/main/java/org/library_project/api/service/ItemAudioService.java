package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.repository.ItemAudioRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ItemAudioService extends GeneralService<ItemAudioRepository, ItemAudio> {
}
