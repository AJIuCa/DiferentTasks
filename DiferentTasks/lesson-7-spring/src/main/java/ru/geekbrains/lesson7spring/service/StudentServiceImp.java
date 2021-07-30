package ru.geekbrains.lesson7spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson7spring.studentRepo.Student;
import ru.geekbrains.lesson7spring.studentRepo.StudentRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDTO> showAllStudents() {
        return studentRepo.findAll().stream().map(student -> new StudentDTO(student)).collect(Collectors.toList());
    }
    @Override
    public List<StudentREST> showAllRestStudents() {
        return studentRepo.findAll().stream().map(student -> new StudentREST(student)).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentById(long id) {
        return studentRepo.findById(id).map(student -> new StudentDTO(student));
    }
    @Override
    public Optional<StudentREST> findRestStudentById(long id) {
        return studentRepo.findById(id).map(student -> new StudentREST(student));
    }

    @Override
    @Transactional
    public void saveStudent(StudentDTO studentDTO) {
        studentRepo.save(new Student(studentDTO));
    }
    @Override
    @Transactional
    public void saveRestStudent(StudentREST studentREST) {
        Student studentToSave = new Student(studentREST);
        studentRepo.save(studentToSave);
    }

    @Override
    @Transactional
    public void deleteStudentById(long id) {
        studentRepo.deleteById(id);
    }
    @Override
    @Transactional
    public void deleteRestStudentById(long id) {
        studentRepo.deleteById(id);
    }
}
