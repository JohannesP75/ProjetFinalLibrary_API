package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.BranchController;
import org.library_project.api.model.Branch;
import org.springframework.http.HttpStatus;

public class BranchControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new BranchController().create(new Branch("test_branch")).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new BranchController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new BranchController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new BranchController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new BranchController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
