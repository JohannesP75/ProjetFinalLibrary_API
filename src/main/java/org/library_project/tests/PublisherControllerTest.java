package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.PublisherController;
import org.library_project.api.model.Publisher;
import org.springframework.http.HttpStatus;

public class PublisherControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new PublisherController().create(new Publisher()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new PublisherController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new PublisherController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new PublisherController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new PublisherController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
