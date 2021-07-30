package ru.geekbrains.lesson7spring.service;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.lesson7spring.studentRepo.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentREST {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private int age;

    public StudentREST() {
    }

    public StudentREST(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentREST(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }

    public StudentREST(StudentDTO studentDTO) {
        this.id = studentDTO.getId();
        this.name = studentDTO.getName();
        this.age = studentDTO.getAge();
    }
}
