package com.yoga.yoga.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.CourseResponse;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.model.Course;
import com.yoga.yoga.repository.CourseRepository;
import com.yoga.yoga.service.CourseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseList.stream()
                .map(this::mapCourseToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getCourse(Long courseId) {
        Course course = courseRepository.findByCourseId(courseId).orElse(null);
        return mapCourseToResponse(course);
    }
    
    @Override
    public CourseResponse updateCourse(CourseRequest request, Long courseId) {
        Course course = courseRepository.findByCourseId(courseId).orElse(null);
        if (course != null) {
            course.setCourseName(request.getCourseName());
            // course.setCourseDescription(request.getCourseDescription());
            course.setCourseDuration(request.getCourseDuration());
            course.setInstructorName(request.getInstructorName());
            course.setCourseAmount(request.getCourseAmount());
            course.setCourseImage(request.getCourseImage());


            courseRepository.save(course);

            return mapCourseToResponse(course);
        } else {
            throw new EntityNotFoundException("Course with id " + courseId + " not found");
        }
    }

    @Override
    public boolean deleteCourse(Long courseId) {
        if (courseRepository.existsByCourseId(courseId)) {
            courseRepository.deleteByCourseId(courseId);
            return true;
        } else {
            return false;
        }
    }
    
    private CourseResponse mapCourseToResponse(Course course) {
        return CourseResponse.builder()
                .courseid(course.getCourseId())
                .courseName(course.getCourseName())
                // .courseDescription(course.getCourseDescription())
                .courseDuration(course.getCourseDuration())
                .instructorName(course.getInstructorName())
                .courseAmount(course.getCourseAmount())
                .courseImage(course.getCourseImage())
                .build();
    }

    @Override
    public TotCountResponse getTotCourseCount() {
        // long count = courseRepository.count();
        // return TotCountResponse.builder().count(count).build();
        TotCountResponse totCountsResponse = new TotCountResponse();
        long totalCourseCount = courseRepository.count();
        totCountsResponse.setTotalCourses(totalCourseCount);

        // Get number of courses for each academy
        List<Course> allCourses = courseRepository.findAll();
        for (Course course : allCourses) {
            Long academyId = course.getAcademyId();
            long courseCount = courseRepository.findByAcademy_AcademyId(academyId).size();
            totCountsResponse.setCourseCountForAcademy(academyId, courseCount);
        }

        return totCountsResponse;
    }

    @Override
public boolean AddCourse(CourseRequest request) {
    // Check if the course already exists
    if (courseRepository.findByCourseName(request.getCourseName()).isPresent()) {
        return false;
    }

    // Create a new Course entity from the request
    Course course = Course.builder()
            .courseName(request.getCourseName())
            .InstructorName(request.getInstructorName())
            .courseDuration(request.getCourseDuration())
            .CourseAmount(request.getCourseAmount())
            .CourseImage(request.getCourseImage())
            .build();

    courseRepository.save(course);
    return true;
}
}
