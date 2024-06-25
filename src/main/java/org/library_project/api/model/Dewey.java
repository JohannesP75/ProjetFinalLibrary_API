package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.intellij.lang.annotations.Pattern;
import org.intellij.lang.annotations.Subst;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "dewey")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Dewey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Pattern("^\\d{3}$")
    @Column(unique = true)
    private String code;

    @NonNull
    private String name;

    @OneToMany(mappedBy="dewey")
    private Set<Book> books = new HashSet<>();

    public Dewey(@Subst("") @NonNull String code, @NonNull String name) {
        this.code = code;
        this.name = name;
    }

    public Dewey() {
    }
}
