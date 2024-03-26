package com.yoga.yoga.service;

import java.util.List;

import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.CourseResponse;
import com.yoga.yoga.dto.response.TotCountResponse;

public interface CourseService {
    // void addCourse(CoursesRequest courseRequest);

    List<CourseResponse> getAllCourses();

CourseResponse getCourse(Long courseid);

CourseResponse updateCourse(CourseRequest request, Long courseid);

boolean deleteCourse(Long courseid);

  public TotCountResponse getTotCourseCount();

boolean AddCourse(CourseRequest request);

}
