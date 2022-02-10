package com.designpatterns.demo;

import com.designpatterns.demo.dto.SchoolClassDTO;
import com.designpatterns.demo.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class StudentConstructorDemo {

    public static void main(String[] args) {

        constructorWithRequireNonNull();

        // no usage of requiredNonNullElse
        final var students1 = getAllStudents_returnsNull();
        System.out.println("Students 1: " + students1);

        // requireNonNullElse used on the result of another method call
        final var students2 = Objects.requireNonNullElse(getAllStudents_returnsNull(), List.<StudentDTO>of());
        System.out.println("Students 2: " + students2);

        // requireNonNullElse used on the result of another method call
        final var students3 = Objects.requireNonNullElse(getAllStudents_1(), List.<StudentDTO>of());
        System.out.println("Students 3: " + students3);

        // requireNonNullElse used inside invoked method
        final var students4 = getAllStudents_2();
        System.out.println("Students 4: " + students4);

        final var studentName = Objects.requireNonNullElse(getStudentName_returnsNull(), "hayley");
        System.out.println("Default student name: " + studentName);

        final var studentList = prepareStudentList();
        final var studentNames = getAllNames(studentList);
        System.out.println("All names:" + studentNames);

        //throws NPE
        //final var studentNames2 = getAllNames_NPE(null);

    }


    private static void constructorWithRequireNonNull() {

        // throws NPE with message "id is required"
        //final var student = new StudentDTO(null, null, null, null);
        //log.info("Student: {}", student);

        // throws NPE with message "id is required"
        //final var studentA = StudentDTO.builder().build();
        //log.info("StudentA: {}", studentA);

        final var student1 = new StudentDTO(1L, null, null, null);
        log.info("Sets a default name as \"hayley\" -> Student: {} ", student1);

        final var student2 = new StudentDTO(1L, "ege", null, null);
        log.info("Initializes classes as empty list and teacherMap as empty map -> Student 2: {} ", student2);

        final var student3 = new StudentDTO();
        log.info("Using noArgsConstructor, so does not set a default value -> Student 3: {} ", student3);

        final var student4 = StudentDTO.builder().id(1L).name("ege").build();
        log.info("Student 4: {}", student4);

        final var schoolClasses = List.of(new SchoolClassDTO());
        final var student5 = StudentDTO.builder().id(1L).name("ege").classes(schoolClasses).build();
        log.info("Student 5: {}", student5);

    }


    private static List<StudentDTO> getAllStudents_returnsNull() {
        // here, there could be a real code getting students from db or somewhere else
        // and it could return null
        return null;
    }

    private static List<StudentDTO> getAllStudents_1() {
        final var student1 = StudentDTO.builder().id(1L).name("Ege").build();
        final var student2 = StudentDTO.builder().id(2L).name("Itir").build();

        return List.of(student1, student2);
    }

    private static List<StudentDTO> getAllStudents_2() {
        final var student1 = StudentDTO.builder().id(1L).name("Itir").build();
        final var student2 = StudentDTO.builder().id(2L).name("Ege").build();

        final var students = List.of(student1, student2);
        //  return Objects.requireNonNullElse(students, List.of()); // this will work as well
        return Objects.requireNonNullElseGet(students, ArrayList::new);
    }

    private static List<String> getAllNames(List<StudentDTO> students) {

        return Objects.requireNonNullElse(students, List.<StudentDTO>of())
                .stream()
                .filter(Objects::nonNull)
                .map(StudentDTO::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getAllNames_NPE(List<StudentDTO> students) {

        return students  // cannot call .stream() on null
                .stream()
                .filter(Objects::nonNull)
                .map(StudentDTO::getName)
                .collect(Collectors.toList());
    }

    private static List<StudentDTO> prepareStudentList() {
        final var student1 = StudentDTO.builder().id(1L).name("Itir").build();
        final var student2 = StudentDTO.builder().id(2L).name("Ege").build();

        return Arrays.asList(student1, student2, null);
    }

    private static String getStudentName_returnsNull() {
        return null;
    }
    
}
