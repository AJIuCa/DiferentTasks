package ru.geekbrains.studentDB;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(length = 128, nullable = false)
    private String  name;


    @Column(length = 32)
    private int mark;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "\nStudent {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", mark = " + mark +
                '}';
    }
}
