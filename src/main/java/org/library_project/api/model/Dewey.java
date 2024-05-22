package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "dewey")
public class Dewey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Pattern("^\\d{3}$")
    private String code;

    @NonNull
    private String name;

    @OneToMany(mappedBy="dewey")
    private Set<Book> books = new HashSet<>();
}
