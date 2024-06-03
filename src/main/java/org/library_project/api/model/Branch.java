package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference(value = "branch-items")
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "branch")
    @JsonBackReference(value = "workers")
    private Set<Worker> workers = new HashSet<>();

    public Branch() {
    }

    public Branch(@NonNull String name) {
        this.name = name;
    }
}
