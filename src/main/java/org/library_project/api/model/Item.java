package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@DiscriminatorColumn(name="item_type", discriminatorType = DiscriminatorType.INTEGER)
abstract public class Item {
    @Id
    private Long id;

    @Column
    private Boolean isLoanable;

    @Column
    private Boolean isAvailable;

    private String description;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @JsonManagedReference(value = "branch-items")
    private Branch branch;

    @OneToMany(mappedBy = "item")
    @JsonBackReference(value = "loan-item")
    private Set<Loan> loans=new HashSet<>();

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable=false)
    @JsonManagedReference(value = "item-publisher")
    private Publisher publisher;
}
