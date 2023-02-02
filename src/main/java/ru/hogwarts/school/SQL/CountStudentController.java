package ru.hogwarts.school.SQL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
public class CountStudentController {
    private final StudentService studentService;

    public CountStudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/count-student")
    public int getCountStudent(){
        return studentService.getCountStudent();
    }
    @GetMapping("/age-student")
    public double getAverageAge(){
        return studentService.getAverageAge();
    }
    @GetMapping("/last-student")
    public Collection<Student> getLastStudent(){
        return studentService.getLastStudent();
    }

}
