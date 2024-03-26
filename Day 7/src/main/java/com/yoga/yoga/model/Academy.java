package com.yoga.yoga.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_academy")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long academyId;
    private String academyName;
    private String academyDescription;
    private String academyLocation;
    private String email;

    @OneToMany(mappedBy = "academy")
    private Set<Course> courses;

    @ManyToMany
    private Set<User> users;
}
