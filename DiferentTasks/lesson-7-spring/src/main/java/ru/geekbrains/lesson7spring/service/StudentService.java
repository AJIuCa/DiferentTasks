package ru.geekbrains.lesson7spring.service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> showAllStudents();
    List<StudentREST> showAllRestStudents();

    Optional<StudentDTO> findStudentById (long id);
    Optional<StudentREST> findRestStudentById (long id);

    void saveStudent (StudentDTO studentDTO);
    void saveRestStudent (StudentREST studentREST);

    void deleteStudentById (long id);
    void deleteRestStudentById (long id);

}
