package ru.hogwarts.school.SQL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.SQL.CountStudent;
import ru.hogwarts.school.Service.StudentService;

import java.util.List;

@RestController
public class CountStudentController {
    private final StudentService studentService;

    public CountStudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/count-student")
    public List<CountStudent>getCountStudent(){
        return studentService.getCountStudent();
    }
    @GetMapping("/age-student")
    public List<AgeStudent>getAverageAge(){
        return studentService.getAverageAge();
    }
    @GetMapping("/last-student")
    public List<LastStudent>getLastStudent(){
        return studentService.getLastStudent();
    }

}
