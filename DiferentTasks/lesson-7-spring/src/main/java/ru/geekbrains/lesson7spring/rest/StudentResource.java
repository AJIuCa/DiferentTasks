package ru.geekbrains.lesson7spring.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7spring.service.StudentREST;
import ru.geekbrains.lesson7spring.service.StudentService;
import ru.geekbrains.lesson7spring.studentRepo.Student;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all" +
            "", produces = "application/json")
    public List<StudentREST> showAllRestStudents() {
        return studentService.showAllRestStudents();
    }

    @GetMapping(path = "/{id}")
    public StudentREST findByRestID(@PathVariable("id") Long id){
        return studentService.findRestStudentById(id).orElseThrow(NullPointerException::new);
    }

    @PostMapping(consumes = "application/json")
    public StudentREST addNewStudent(@RequestBody StudentREST studentREST){
        if (studentREST.getId() != null ){
            throw new NullPointerException();
        } else {
            studentService.saveRestStudent(studentREST);
            return studentREST;
        }
    }


    @PutMapping(consumes = "application/json")
    public void update(@RequestBody StudentREST studentREST){
        if (studentREST.getId() == null){
            throw new NullPointerException();
        }
        studentService.saveRestStudent(studentREST);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByRestId(@PathVariable("id") Long id){
        studentService.deleteRestStudentById(id);
    }

}
