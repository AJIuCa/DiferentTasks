package ru.geekbrains.lesson7spring.studentRepo;
import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.lesson7spring.service.StudentDTO;
import ru.geekbrains.lesson7spring.service.StudentREST;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int age;

    public Student() {
    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public Student(StudentDTO studentDTO){
        this.id = studentDTO.getId();
        this.name = studentDTO.getName();
        this.age = studentDTO.getAge();
    }

    public Student(StudentREST studentREST){
        this.id = studentREST.getId();
        this.name = studentREST.getName();
        this.age = studentREST.getAge();
    }
}
