package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "readers")
public class Reader extends Person {
    @OneToMany(mappedBy = "reader")
    @JsonManagedReference(value = "reader-loans")
    private Set<Loan> loans = new HashSet<>();
}
