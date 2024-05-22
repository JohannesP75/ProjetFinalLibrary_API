package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.FormatBookController;
import org.library_project.api.model.FormatBook;
import org.springframework.http.HttpStatus;

public class FormatBookControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new FormatBookController().create(new FormatBook()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new FormatBookController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new FormatBookController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new FormatBookController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new FormatBookController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
