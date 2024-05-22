package org.library_project.api.service;

import lombok.Data;
import org.library_project.api.model.FormatVideo;
import org.library_project.api.repository.FormatVideoRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class FormatVideoService extends GeneralService<FormatVideoRepository, FormatVideo> {
}