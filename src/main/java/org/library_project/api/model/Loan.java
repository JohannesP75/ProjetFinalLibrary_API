package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_returned")
    private boolean isReturned;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_due")
    private LocalDate dateDue;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    @JsonBackReference(value = "reader-loans")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    @JsonManagedReference(value = "loan-item")
    private Item item;
}
