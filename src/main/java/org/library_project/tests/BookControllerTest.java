package org.library_project.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.library_project.api.controller.BookController;
import org.library_project.api.model.Book;
import org.springframework.http.HttpStatus;

public class BookControllerTest {
    @Test
    public void testCreate(){
        Assertions.assertEquals(new BookController().create(new Book()).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetOne(){
        Assertions.assertEquals(new BookController().get(0L).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetAll(){
        Assertions.assertEquals(new BookController().getAll().getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdate(){
        Assertions.assertEquals(new BookController().update(0L, null).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDelete(){
        Assertions.assertEquals(new BookController().delete(0L).getStatusCode(), HttpStatus.OK);
    }
}
