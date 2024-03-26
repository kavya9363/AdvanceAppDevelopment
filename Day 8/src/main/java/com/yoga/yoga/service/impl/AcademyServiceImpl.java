package com.yoga.yoga.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.yoga.dto.request.AcademyRequest;
import com.yoga.yoga.dto.request.CourseRequest;
import com.yoga.yoga.dto.response.AcademyResponse;
import com.yoga.yoga.dto.response.CourseResponse;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.model.Academy;
import com.yoga.yoga.model.Course;
import com.yoga.yoga.repository.AcademyRepository;
import com.yoga.yoga.repository.CourseRepository;
import com.yoga.yoga.repository.UserRepository;
import com.yoga.yoga.service.AcademyService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AcademyServiceImpl implements AcademyService{

    private final AcademyRepository academyRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    //newly added
    @Override
    public void addCourseToAcademy(Long academyId, CourseRequest courseRequest) {
        Academy academy = academyRepository.findByAcademyId(academyId)
                .orElseThrow(() -> new EntityNotFoundException("Academy not found with ID: " + academyId));

        Course course = Course.builder()
                .courseName(courseRequest.getCourseName())
                // Set other course attributes as needed
                .build();

        academy.getCourses().add(course);
        academyRepository.save(academy);
    }

//     //newly added
//     @Override
//     public List<Course> getCoursesByAcademyId(Long academyId) {
//         Academy academy = academyRepository.findByAcademyId(academyId)
//                 .orElseThrow(() -> new EntityNotFoundException("Academy not found with ID: " + academyId));

//         // Convert the set of courses to a list
//         return academy.getCourses()
//                 .stream()
//                 .collect(Collectors.toList());
//     }

// private CourseResponse mapCourseToCourseResponse(Course course) {
//     return CourseResponse.builder()
//             .courseName(course.getCourseName())
//             // .courseDescription(course.getCourseDescription())
//             .courseDuration(course.getCourseDuration())
//             .instructorName(course.getInstructorName())
//             .courseAmount(course.getCourseAmount())
//             .courseImage(course.getCourseImage())
//             .build();
// }


    @Override
    public List<AcademyResponse> getAllAcademy() {
        List<Academy> academyList = academyRepository.findAll();
        return academyList.stream()
                .map(this::mapAcademyToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AcademyResponse getAcademy(Long academyId) {
        Academy academy = academyRepository.findByAcademyId(academyId).orElse(null);
        return mapAcademyToResponse(academy);
    }

    @Override
    public AcademyResponse updateAcademy(AcademyRequest request, Long academyId) {
        Academy academy = academyRepository.findByAcademyId(academyId).orElse(null);
        if (academy != null) {
            academy.setAcademyName(request.getAcademyName());
            academy.setAcademyDescription(request.getAcademyDescription());
            academy.setAcademyLocation(request.getAcademyLocation());
            academy.setEmail(request.getEmail());

            academyRepository.save(academy);

            return mapAcademyToResponse(academy);
        } else {
            throw new EntityNotFoundException("Academy with id " + academyId + " not found");
        }
    }

    @Override
    public boolean deleteAcademy(Long academyId) {
        if (academyRepository.existsByAcademyId(academyId)) {
            academyRepository.deleteByAcademyId(academyId);
            return true;
        } else {
            return false;
        }
    }

    private AcademyResponse mapAcademyToResponse(Academy academy) {
        if (academy != null) {
            return AcademyResponse.builder()
                    .academyid(academy.getAcademyId())
                    .academyName(academy.getAcademyName())
                    .academyDescription(academy.getAcademyDescription())
                    .academyLocation(academy.getAcademyLocation())
                    .email(academy.getEmail())
                    .build();
        } else {
            return null;
        }
    }

    // @Override
    // public TotCountResponse getTotAcademyCount() {
    //     TotCountResponse totCountsResponse = new TotCountResponse();
    //     long totalAcademyCount = academyRepository.count();
    //     totCountsResponse.setTotalAcademy(totalAcademyCount);

    //     // You may add additional logic here to count anything related to academies
        
    //     return totCountsResponse;
    // }

    @Override
public TotCountResponse getTotAcademyCount() {
    TotCountResponse totCountsResponse = new TotCountResponse();
    long totalAcademyCount = academyRepository.count();
    totCountsResponse.setTotalAcademy(totalAcademyCount);

    // Get number of users for each academy
    List<Academy> allAcademy = academyRepository.findAll();
    for (Academy academy : allAcademy) {
        Long academyId = academy.getAcademyId();
        long userCount = userRepository.countByAcademy_AcademyId(academyId); // Assuming you have a method like this in your UserRepository
        totCountsResponse.setUserCountForAcademy(academyId, userCount);
    }

    return totCountsResponse;
}

@Override
public boolean AddAcademy(AcademyRequest request) {
    // Check if the academy already exists
    if (academyRepository.findByAcademyName(request.getAcademyName()).isPresent()) {
        return false;
    }
// Create a new Academy entity from the request
    Academy academy = Academy.builder()
            .academyName(request.getAcademyName())
            .academyDescription(request.getAcademyDescription())
            .academyLocation(request.getAcademyLocation())
            .email(request.getEmail())
            .build();

    academyRepository.save(academy);
    return true;
}

}
