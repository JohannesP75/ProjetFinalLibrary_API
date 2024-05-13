package org.library_project.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@DiscriminatorValue("2")
public class CollectiveAuthor extends Author{
    @NonNull
    private String name;
}
