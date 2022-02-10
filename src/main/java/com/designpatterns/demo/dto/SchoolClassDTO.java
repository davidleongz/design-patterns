package com.designpatterns.demo.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SchoolClassDTO {

    String schoolId;

    String typeSchool;
}
