package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.FormatAudioController;
import org.library_project.api.model.FormatAudio;
import org.springframework.http.HttpStatus;

public class FormatAudioControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new FormatAudioController().create(new FormatAudio()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new FormatAudioController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new FormatAudioController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new FormatAudioController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new FormatAudioController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
