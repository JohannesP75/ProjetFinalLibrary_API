package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.VideoController;
import org.library_project.api.model.Video;
import org.springframework.http.HttpStatus;

public class VideoControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new VideoController().create(new Video()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new VideoController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new VideoController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new VideoController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new VideoController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
