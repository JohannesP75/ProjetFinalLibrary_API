package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Setter
@Getter
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "branch")
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "branch")
    private Set<Worker> workers = new HashSet<>();
}
