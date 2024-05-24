package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.PrerogativeController;
import org.library_project.api.model.Prerogative;
import org.springframework.http.HttpStatus;

public class PrerogativeControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new PrerogativeController().create(new Prerogative("test_Prerogative")).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new PrerogativeController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new PrerogativeController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new PrerogativeController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new PrerogativeController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
