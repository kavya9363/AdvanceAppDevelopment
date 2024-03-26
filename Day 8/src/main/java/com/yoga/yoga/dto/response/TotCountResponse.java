package com.yoga.yoga.dto.response;

import java.util.Map;

import lombok.Data;

@Data
public class TotCountResponse {
    private long totalUsers;
    private long adminUsers;
    private long customerUsers;
    private long totalCourses;
    private Map<Long, Long> courseCountForAcademy;
    private long totalAcademy;
    private Map<Long, Long> userCountForAcademy;
    
    public void setCourseCountForAcademy(Long academyId, long courseCount) {
        this.courseCountForAcademy.put(academyId, courseCount);
    }

    public void setUserCountForAcademy(Long academyId, Long userCount) {
        this.userCountForAcademy.put(academyId, userCount);
    }
}
