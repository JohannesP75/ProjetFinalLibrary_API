package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.GradeController;
import org.library_project.api.model.Grade;
import org.springframework.http.HttpStatus;

public class GradeControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new GradeController().create(new Grade()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new GradeController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new GradeController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new GradeController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new GradeController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
