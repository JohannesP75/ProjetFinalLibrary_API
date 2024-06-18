package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role_type")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = WorkerRole.class, name = "WORK"),
                @JsonSubTypes.Type(value = ReaderRole.class, name = "READ")
        }
)
abstract public class UserRole implements IRole {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     * Name of the role
     */
    @NonNull
    protected String name;

    /**
     * Description of the role
     */
    protected String description;

    /*@ManyToMany(mappedBy = "userRoles")
    private Set<Prerogative> prerogatives;*/

    public UserRole() {
    }

    public UserRole(@NonNull String name) {
        this.name = name;
    }

    @Override
    public String getFullName() {
        return null;
    }
}
