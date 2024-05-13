package org.library_project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralService <TRepository extends CrudRepository<TEntity, Long>, TEntity> {
    @Autowired
    protected TRepository repository;

    public Optional<TEntity> get(final Long id){
        return repository.findById(id);
    }

    public Iterable<TEntity> getAll(){
        return repository.findAll();
    }

    public void delete(final Long id){
        repository.deleteById(id);
    }

    public TEntity save(TEntity entry){
        return repository.save(entry);
    }
}
