package ru.geekbrains.lesson7spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7spring.service.StudentDTO;
import ru.geekbrains.lesson7spring.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String indexPage(Model model) {
        logger.info("List page requested");

        List<StudentDTO> students = studentService.showAllStudents();
        model.addAttribute("student", students);
        return "student";
    }

    @GetMapping("student/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        logger.info("Edit page for Student id {} requested", id);

        model.addAttribute("student", studentService.findStudentById(id).orElseThrow(NullPointerException::new));
        return "student_form";
    }

    @GetMapping("/addStudent")
    public String addStudent (Model model){
        logger.info("Add new Student");

        model.addAttribute("student", new StudentDTO());
        return "student_form";
    }


    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        logger.info("Delete Student with id = {}", id);

        studentService.deleteStudentById(id);
        return "redirect:/student";
    }


    @PostMapping("student/update")
    public String updateProduct(@Valid StudentDTO studentDTO, BindingResult result) {
        logger.info("Update endpoint requested");

        if (result.hasErrors()) {
            return "student_form";
        }
        logger.info("Product update");
        studentService.saveStudent(studentDTO);

        return "redirect:/student";
    }


}
