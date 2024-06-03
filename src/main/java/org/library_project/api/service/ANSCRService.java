package org.library_project.api.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.library_project.api.model.ANSCR;
import org.library_project.api.model.Audio;
import org.library_project.api.repository.ANSCRRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class ANSCRService extends GeneralService<ANSCRRepository, ANSCR> {
    public Iterable<Audio> getAudios(final Long id){
        ANSCR anscr=repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return anscr.getAudios();
    }
}
