package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.DeweyController;
import org.library_project.api.model.Dewey;
import org.springframework.http.HttpStatus;

public class DeweyControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new DeweyController().create(new Dewey("000", "test_Dewey")).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new DeweyController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new DeweyController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new DeweyController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new DeweyController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
