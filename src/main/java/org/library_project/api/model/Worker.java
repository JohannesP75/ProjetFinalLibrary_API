package org.library_project.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.library_project.api.config.WorkerRoleAuthority;

import java.util.ArrayList;

@Entity
@Setter
@Getter
@Table(name = "workers")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Worker extends Person{
    @Override
    public String getUsername() {
        return givenName+"."+surname+"@WORKER."+id;
    }

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "worker_role_id", nullable = false)
    private WorkerRole role;

    @Override
    public String[] getAllAuthorities() {
        ArrayList<String> list=new ArrayList<>();

        if (role.isHrManagement())list.add(WorkerRoleAuthority.HR_MANAGEMENT.toString());
        if (role.isReadersManagement())list.add(WorkerRoleAuthority.READERS_MANAGEMENT.toString());
        if (role.isSystemManagement())list.add(WorkerRoleAuthority.SYSTEM_MANAGEMENT.toString());
        if (role.isInventoryManagement())list.add(WorkerRoleAuthority.INVENTORY_MANAGEMENT.toString());

        return list.toArray(new String[0]);
    }
}