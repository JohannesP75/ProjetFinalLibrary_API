package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.AuthorController;
import org.library_project.api.model.CollectiveAuthor;
import org.library_project.api.model.IndividualAuthor;
import org.springframework.http.HttpStatus;

public class AuthorControllerTest {
    @Test
    public void testCreateCollective(){
        Assertions.assertEquals(new AuthorController().create(new CollectiveAuthor()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testCreateIndividual(){
        Assertions.assertEquals(new AuthorController().create(new IndividualAuthor()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new AuthorController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new AuthorController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new AuthorController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new AuthorController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
