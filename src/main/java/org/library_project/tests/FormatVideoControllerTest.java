package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.FormatVideoController;
import org.library_project.api.model.FormatVideo;
import org.springframework.http.HttpStatus;

public class FormatVideoControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new FormatVideoController().create(new FormatVideo()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new FormatVideoController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new FormatVideoController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new FormatVideoController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new FormatVideoController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
