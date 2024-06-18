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
 * Role held by a reader
 */
@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("1")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class ReaderRole extends UserRole {
    @Override
    public String getFullName() {
        return "ROLE_READER_"+name;
    }

    @OneToMany(mappedBy="role")
    private Set<Reader> readers;

    /**
     * Indicates whether this role can borrow items
     */
    private boolean borrowItems;
}
