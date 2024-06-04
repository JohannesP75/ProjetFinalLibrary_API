package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.WorkerRoleController;
import org.library_project.api.model.WorkerRole;
import org.springframework.http.HttpStatus;

public class WorkerRoleControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new WorkerRoleController().create(new WorkerRole()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new WorkerRoleController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new WorkerRoleController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new WorkerRoleController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new WorkerRoleController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
