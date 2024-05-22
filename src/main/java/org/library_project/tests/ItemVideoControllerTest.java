package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ItemVideoController;
import org.library_project.api.model.ItemVideo;
import org.springframework.http.HttpStatus;

public class ItemVideoControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new ItemVideoController().create(new ItemVideo()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ItemVideoController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ItemVideoController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ItemVideoController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ItemVideoController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
