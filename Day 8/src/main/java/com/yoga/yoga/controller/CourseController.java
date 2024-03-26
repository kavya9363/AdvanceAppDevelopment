package com.yoga.yoga.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.yoga.constant.Api;
import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.CourseResponse;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.service.CourseService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping(Api.COURSES)
@RequiredArgsConstructor
@Tag(name="Course")
public class CourseController {
    
   private final CourseService courseService;
    
@PostMapping("/addcourse")
// @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<String> AddCourse(@RequestBody CourseRequest request) {
    boolean isCreated = courseService.AddCourse(request);
    return isCreated ? ResponseEntity.status(201).body("Course created successfully!")
            : ResponseEntity.badRequest().build();
}

   @GetMapping("/get")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courseList = courseService.getAllCourses();
        return !courseList.isEmpty() ? ResponseEntity.ok().body(courseList) : ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{courseId}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long courseId) {
        CourseResponse courseResponse = courseService.getCourse(courseId);
        return courseResponse != null ? ResponseEntity.ok().body(courseResponse) : ResponseEntity.notFound().build();
    }

    @PutMapping("/edit/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody CourseRequest request, @PathVariable Long courseId) {
        CourseResponse courseResponse = courseService.updateCourse(request, courseId);
        return courseResponse != null ? ResponseEntity.ok().body(courseResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{courseId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId) {
        boolean isDeleted = courseService.deleteCourse(courseId);
        return isDeleted ? ResponseEntity.ok().body("Course deleted successfully!")
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/getCount")
    public ResponseEntity<TotCountResponse> getTotCourseCount() {
        TotCountResponse countResponse = courseService.getTotCourseCount();
        return ResponseEntity.ok(countResponse);
    }
}
