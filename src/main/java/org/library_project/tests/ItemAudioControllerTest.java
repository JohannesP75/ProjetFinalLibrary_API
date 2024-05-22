package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ItemAudioController;
import org.library_project.api.model.ItemAudio;
import org.springframework.http.HttpStatus;

public class ItemAudioControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new ItemAudioController().create(new ItemAudio()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ItemAudioController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ItemAudioController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ItemAudioController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ItemAudioController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
