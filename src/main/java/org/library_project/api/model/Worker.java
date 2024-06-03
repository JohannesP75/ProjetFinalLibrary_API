package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "workers")
public class Worker extends Person{
    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @JsonManagedReference(value = "worker-branch")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    @JsonManagedReference(value = "grade-workers")
    private Grade grade;
}
