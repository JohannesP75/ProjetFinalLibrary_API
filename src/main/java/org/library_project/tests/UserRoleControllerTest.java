package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.UserRoleController;
import org.library_project.api.model.UserRole;
import org.springframework.http.HttpStatus;

public class UserRoleControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new UserRoleController().create(new UserRole()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new UserRoleController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new UserRoleController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new UserRoleController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new UserRoleController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
