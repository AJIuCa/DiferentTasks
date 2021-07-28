package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.studentDB.Student;
import ru.geekbrains.studentDB.StudentRepository;

import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        startApp();

    }

    public static void startApp(){
        System.out.println("### DO DEFAULT DB ###\n");
        defaultInitRepo();
        System.out.println("### INSERT NEW STUDENT ###\n");
        insertInStudentsDB();
        System.out.println("### SHOW ALL STUDENTS ###\n");
        showAllStudents();
        System.out.println("### UPDATE DB ###\n");
        updateStudentsDB();
        System.out.println("### FIND BY ID ###\n");
        findStudentByID();
        System.out.println("### REMOVE FROM DB ###\n");
        removeFromStudentDB();
        System.out.println("### SHOW ALL STUDENTS ###\n");
        showAllStudents();
    }

    public static void defaultInitRepo(){

        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);
        studentRepository.initRepoWithDefaultData();

    }

    public static void showAllStudents(){
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);
        System.out.println(studentRepository.showAll());


    }

    public static void findStudentByID(){
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);
        System.out.println(studentRepository.findById(1002));
        System.out.println(studentRepository.findById(1));
        System.out.println(studentRepository.findById(2));
        System.out.println(studentRepository.findById(4));

    }

    public static void updateStudentsDB(){
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);
        studentRepository.updateName(1, "Boris");
        studentRepository.updateName(2, "Nikolai");
        studentRepository.updateMark(1, 4);
        studentRepository.updateAllInfo(4, "Alice",5);


    }

    public static void removeFromStudentDB(){
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);
        studentRepository.deleteById(2);

    }
    public static void insertInStudentsDB(){

        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        StudentRepository studentRepository = new StudentRepository(entityManagerFactory);

        Student student = new Student("Kate",5);
        studentRepository.insertObj(student);
        studentRepository.insert("Pavel",3);
    }
}
