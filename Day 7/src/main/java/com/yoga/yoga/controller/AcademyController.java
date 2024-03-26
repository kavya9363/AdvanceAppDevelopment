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

import com.yoga.yoga.dto.request.AcademyRequest;
import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.AcademyResponse;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.service.AcademyService;
import com.yoga.yoga.constant.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping(Api.ACADEMIES)
@RequiredArgsConstructor
@Tag(name="Academy")
public class AcademyController {
    
    private final AcademyService academyService;

   @PostMapping("/addacademy")
// @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<String> AddAcademy(@RequestBody AcademyRequest request) {
    boolean isCreated = academyService.AddAcademy(request);
    return isCreated ? ResponseEntity.status(201).body("Academy created successfully!")
            : ResponseEntity.badRequest().build();
}
    //newly added
    @PostMapping("/{academyId}/courses")
    public ResponseEntity<String> addCourseToAcademy(@PathVariable Long academyId, @RequestBody CourseRequest courseRequest) {
        academyService.addCourseToAcademy(academyId, courseRequest);
        return ResponseEntity.ok("Course added to academy successfully");
    }
    
//     //newly added
//     @GetMapping("/{academyId}/courses")
//     public ResponseEntity<List<CourseResponse>> getCoursesByAcademyId(@PathVariable Long academyId) {
//     List<CourseResponse> courses = academyService.getCoursesByAcademyId(academyId);
//     return ResponseEntity.ok().body(courses);
// }

   @GetMapping("/get")
    public ResponseEntity<List<AcademyResponse>> getAllAcademy() {
        List<AcademyResponse> academyList = academyService.getAllAcademy();
        return !academyList.isEmpty() ? ResponseEntity.ok().body(academyList) : ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{academyId}")
    public ResponseEntity<AcademyResponse> getAcademy(@PathVariable Long academyId) {
        AcademyResponse academyResponse = academyService.getAcademy(academyId);
        return academyResponse != null ? ResponseEntity.ok().body(academyResponse) : ResponseEntity.notFound().build();
    }

    @PutMapping("/edit/{academyId}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AcademyResponse> updateAcademy(@RequestBody AcademyRequest request, @PathVariable Long academyId) {
        AcademyResponse academyResponse = academyService.updateAcademy(request, academyId);
        return academyResponse != null ? ResponseEntity.ok().body(academyResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{academyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAcademy(@PathVariable Long academyId) {
        boolean isDeleted = academyService.deleteAcademy(academyId);
        return isDeleted ? ResponseEntity.ok().body("Academy deleted successfully!")
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/getCount")
    public ResponseEntity<TotCountResponse> getTotAcademyCount() {
        TotCountResponse countResponse = academyService.getTotAcademyCount();
        return ResponseEntity.ok(countResponse);
    }
}
