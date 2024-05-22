package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.LoanController;
import org.library_project.api.model.Loan;
import org.springframework.http.HttpStatus;

public class LoanControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new LoanController().create(new Loan()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new LoanController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new LoanController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new LoanController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new LoanController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
