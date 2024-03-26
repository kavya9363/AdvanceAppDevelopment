package com.yoga.yoga.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    private String InstructorName;
    private int courseDuration;
    private float CourseAmount;
    private String CourseImage;

    @ManyToOne
    private Academy academy;

    @ManyToMany
    private Set<User> users;

    public Long getAcademyId() {
        return this.academy != null ? this.academy.getAcademyId() : null;
    }
}
