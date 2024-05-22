package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ItemBookController;
import org.library_project.api.model.ItemBook;
import org.springframework.http.HttpStatus;

public class ItemBookControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new ItemBookController().create(new ItemBook()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ItemBookController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ItemBookController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ItemBookController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ItemBookController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
