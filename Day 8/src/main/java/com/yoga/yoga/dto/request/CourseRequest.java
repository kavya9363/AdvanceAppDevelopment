package com.yoga.yoga.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    
    private String courseName;
    private String courseDescription;
    private int courseDuration;
    private String instructorName;
    private float courseAmount;
    private String courseImage;
}
