package org.library_project.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
abstract public class GeneralService <TRepository extends CrudRepository<TEntity, Long>, TEntity> {
    @Autowired
    protected TRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    public TEntity save(TEntity entry){
        return repository.save(entry);
    }

    public Optional<TEntity> get(final Long id){
        return (Optional<TEntity>) repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Iterable<TEntity> getAll(){
        return repository.findAll();
    }

    public TEntity update(Long id, @NotNull JsonPatch patch) throws JsonProcessingException, JsonPatchException {
        // TODO: Trouver un moyen d'améliorer cette méthode, si possible
        TEntity entity=repository.findById(id).orElseThrow(EntityNotFoundException::new);
        JsonNode patched=patch.apply(objectMapper.convertValue(entity, JsonNode.class));

        return repository.save(objectMapper.treeToValue(patched, (Class<TEntity>) null));
    }

    public void delete(final Long id){
        repository.deleteById(id);
    }
}
