package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.WorkerController;
import org.library_project.api.model.Worker;
import org.springframework.http.HttpStatus;

public class WorkerControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new WorkerController().create(new Worker()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new WorkerController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new WorkerController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new WorkerController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new WorkerController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
