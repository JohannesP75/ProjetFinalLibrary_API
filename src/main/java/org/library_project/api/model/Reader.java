package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "readers")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Reader extends Person {
    @Override
    public String getUsername() {
        return givenName+"."+surname+"@READER."+id;
    }

    @OneToMany(mappedBy = "reader")
    private Set<Loan> loans = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "reader_role_id", nullable = false)
    private ReaderRole role;
}
