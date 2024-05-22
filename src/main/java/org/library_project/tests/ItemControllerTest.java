package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ItemController;
import org.library_project.api.model.ItemAudio;
import org.library_project.api.model.ItemBook;
import org.library_project.api.model.ItemVideo;
import org.springframework.http.HttpStatus;

public class ItemControllerTest {
    @Test
    public void testCreateAudio(){
        Assertions.assertEquals(new ItemController().create(new ItemAudio()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testCreateBook(){
        Assertions.assertEquals(new ItemController().create(new ItemBook()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testCreateVideo(){
        Assertions.assertEquals(new ItemController().create(new ItemVideo()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ItemController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ItemController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ItemController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ItemController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
