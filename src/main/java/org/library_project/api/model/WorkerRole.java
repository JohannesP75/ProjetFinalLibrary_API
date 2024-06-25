package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Role held by a worker
 */
@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("0")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class WorkerRole extends UserRole{
    @Override
    public String getFullName() {
        return "ROLE_WORKER_"+name;
    }

    @OneToMany(mappedBy="role")
    private Set<Worker> workers;

    /**
     * Indicates whether this role is tasked with managing the inveotory of the library (resources, authors, items)
     */
    private boolean inventoryManagement;

    /**
     * Indicates whether this role is tasked with managing the human resources (hiring, modifying and deleting workers) and the architecture (branches) of the library
     */
    private boolean hrManagement;

    /**
     * Indicates whether this role is tasked with managing the readers and their loans
     */
    private boolean readersManagement;

    /**
     * Indicates whether this role is tasked with managing the database system (adding and modifying roles)
     */
    private boolean systemManagement;
}
