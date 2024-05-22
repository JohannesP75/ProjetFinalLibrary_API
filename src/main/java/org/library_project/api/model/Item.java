package org.library_project.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@DiscriminatorColumn(name="item_type", discriminatorType = DiscriminatorType.INTEGER)
abstract public class Item {
    @Id
    private Long id;

    @Column(name = "is_loanable")
    private Boolean isLoanable;

    @Column(name = "is_available")
    private Boolean isAvailable;

    private String description;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "item")
    private Set<Loan> loans=new HashSet<>();
}
