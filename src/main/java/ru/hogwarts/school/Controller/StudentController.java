package ru.hogwarts.school.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("/findByAgeBetween")
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int min,@RequestParam int max) {

        return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
    }
   @GetMapping("{id}/faculty")
    public ResponseEntity<Faculty> findFacultyByStudent(@PathVariable("id") long id){
        return ResponseEntity.ok(studentService.findFacultyByStudent(id));
    }
    @GetMapping("/getNameA")
    public ResponseEntity<Collection<Student>> getNameA(){
        return ResponseEntity.ok(studentService.getNameA());
    }
    @GetMapping("/printAllStudentsNames")
    public void printAllStudentsNames() {
        studentService.printAllStudentsNames();
    }

    @GetMapping("/printAllStudentsNamesInSynchronizedStream")
    public void printAllStudentsNamesInSynchronizedStream() throws InterruptedException {
        studentService.printAllStudentsNamesInSynchronizedStream();
    }




}
