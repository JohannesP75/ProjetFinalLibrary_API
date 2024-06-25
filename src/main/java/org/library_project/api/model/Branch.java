package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "branch")
    private Set<Item> items = new HashSet<>();

    @OneToMany(mappedBy = "branch")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Worker> workers = new HashSet<>();

    public Branch() {
    }

    public Branch(@NonNull String name) {
        this.name = name;
    }
}
