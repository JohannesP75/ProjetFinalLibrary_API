package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ReaderController;
import org.library_project.api.model.Reader;
import org.springframework.http.HttpStatus;

public class ReaderControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new ReaderController().create(new Reader()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ReaderController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ReaderController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ReaderController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ReaderController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
