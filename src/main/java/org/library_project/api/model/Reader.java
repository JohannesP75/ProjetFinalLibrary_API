package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.library_project.api.config.ReaderRoleAuthority;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "readers")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Reader extends Person {
    @Override
    public String getUsername() {
        return givenName+"."+surname+"@READER."+id;
    }

    @OneToMany(mappedBy = "reader")
    private Set<Loan> loans = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "reader_role_id", nullable = false)
    private ReaderRole role;

    @Override
    public String[] getAllAuthorities() {
        ArrayList<String> list=new ArrayList<>();

        if (role.isBorrowItems())list.add(ReaderRoleAuthority.BORROW_ITEMS.toString());

        return list.toArray(new String[0]);
    }

    @PreAuthorize("hasAuthority('READERS_MANAGEMENT')")
    public void setRole(ReaderRole role) {
        this.role = role;
    }
}
