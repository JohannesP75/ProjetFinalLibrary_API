package org.library_project.api.repository;

import org.library_project.api.model.ItemBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemBookRepository extends CrudRepository<ItemBook, Long> {
}
