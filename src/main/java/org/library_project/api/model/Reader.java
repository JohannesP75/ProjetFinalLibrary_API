package org.library_project.api.model;

import jakarta.persistence.*;
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
    private Set<Loan> loans = new HashSet<>();
}
