package com.yoga.yoga.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademyResponse {
    private long academyid;
    private String academyName;
    private String academyDescription;
    private String academyLocation;
    private String email;
}
