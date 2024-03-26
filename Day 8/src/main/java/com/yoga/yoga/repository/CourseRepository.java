package com.yoga.yoga.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoga.yoga.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
    Optional<Course> findByCourseId(Long courseId);

    void deleteByCourseId(Long courseId);

    List<Course> findByAcademy_AcademyId(Long academyId);

    boolean existsByCourseId(Long courseId);
    // List<Course> findByAcademyId(Long academyId);
    Optional<Course> findByCourseName(String courseName);
}
