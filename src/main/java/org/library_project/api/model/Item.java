package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
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
    private Branch branch;

    @OneToMany(mappedBy = "item")
    private Set<Loan> loans=new HashSet<>();

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable=false)
    private Publisher publisher;
}
