package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@Table(name="publishers")
public class Publisher {
    /**
     * ID of publisher
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "publisher")
    @JsonBackReference(value = "item-publisher")
    private Set<Item> items=new HashSet<>();

    public Publisher(@NonNull String name) {
        this.name = name;
    }

    public Publisher() {
    }
}
