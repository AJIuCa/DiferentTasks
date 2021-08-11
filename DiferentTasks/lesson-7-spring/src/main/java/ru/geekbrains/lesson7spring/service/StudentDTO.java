package ru.geekbrains.lesson7spring.service;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.lesson7spring.studentRepo.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentDTO {

    private long id;

    @NotEmpty
    private String name;

    @NotNull
    private int age;

    public StudentDTO() {
    }

    public StudentDTO(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }


}
