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

@Service
abstract public class GeneralService <TRepository extends CrudRepository<TEntity, Long>, TEntity> {
    @Autowired
    protected TRepository repository;

    @Autowired
    protected ObjectMapper objectMapper;

    public Long count(){
        return repository.count();
    }

    /**
     * Creates an instance and saves it on the database
     * @param entry The instance to create
     * @return Saved instance
     */

    public TEntity save(TEntity entry){
        return repository.save(entry);
    }

    /**
     * Retrieves an instance of TEntity from the database
     * @param id ID of the instance to retrieve
     * @return The retrieved instance
     */
    public TEntity get(final Long id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Retrieves all the instances of TEntity from the database
     * @return The list of all the instances
     */
    public Iterable<TEntity> getAll(){
        return repository.findAll();
    }

    /**
     * Update an instance of TEntity
     * @param id ID of the instance to be updated
     * @param patch Modifications to the instance
     * @return An updated instance
     * @throws JsonProcessingException Issues during the serialisation of the patched instance
     * @throws JsonPatchException Issues during the patching of the instance
     */
    public TEntity update(Long id, @NotNull JsonPatch patch) throws JsonProcessingException, JsonPatchException {
        // TODO: Trouver un moyen d'améliorer cette méthode, si possible
        // Le moyen, ce serait de faire en sorte que le 2d argument de objectMapper.treeToValue
        // soit la classe TEntity pour éviter les erreurs d epointeur nul

        System.out.println(patch.toString());
        TEntity entity=repository.findById(id).orElseThrow(EntityNotFoundException::new);
        JsonNode patched=patch.apply(objectMapper.convertValue(entity, JsonNode.class));

        System.out.println(patched.toString());

        return repository.save(objectMapper.treeToValue(patched, (Class<TEntity>)(null) ));
    }

    /**
     * Delete an instance of TEntity
     * @param id ID of the instance to delete from the database
     */
    public void delete(final Long id){
        repository.deleteById(id);
    }
}
