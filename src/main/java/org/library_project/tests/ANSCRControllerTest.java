package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.ANSCRController;
import org.library_project.api.model.ANSCR;
import org.springframework.http.HttpStatus;

public class ANSCRControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new ANSCRController().create(new ANSCR()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new ANSCRController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new ANSCRController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new ANSCRController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new ANSCRController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
