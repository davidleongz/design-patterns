package com.designpatterns.demo.dto;

import lombok.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private List<SchoolClassDTO> classes;
    private Map<Integer, TeacherDTO> teacherMap;

    public StudentDTO(Long id, String name, List<SchoolClassDTO> classes, Map<Integer, TeacherDTO> teacherMap) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.name = Objects.requireNonNullElse(name, "hayley");
        this.classes = Objects.requireNonNullElseGet(classes, ArrayList::new);
        this.teacherMap = Objects.requireNonNullElseGet(teacherMap, HashMap::new);
    }

}
