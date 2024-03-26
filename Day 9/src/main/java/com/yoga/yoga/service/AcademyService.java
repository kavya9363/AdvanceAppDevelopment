package com.yoga.yoga.service;

import java.util.List;

import com.yoga.yoga.dto.request.AcademyRequest;
import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.AcademyResponse;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.model.Course;

public interface AcademyService {
    
    List<AcademyResponse> getAllAcademy();

    AcademyResponse getAcademy(Long academyId);

    AcademyResponse updateAcademy(AcademyRequest request, Long academyId);

    boolean deleteAcademy(Long academyId);

    public TotCountResponse getTotAcademyCount();

    boolean AddAcademy(AcademyRequest request);
    // List<Course> getCoursesByAcademyId(Long academyId);
    void addCourseToAcademy(Long academyId, CourseRequest courseRequest);

}
