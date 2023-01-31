package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.SQL.AgeStudent;
import ru.hogwarts.school.SQL.CountStudent;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.StudentRepository;
import ru.hogwarts.school.SQL.LastStudent;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findFacultyByStudent(long id) {
        return studentRepository.findById(id)
                .map(student -> student.getFaculty())
                .orElse(null);
    }
    public List<CountStudent> getCountStudent(){
        return studentRepository.getCountStudent();
    }
    public List<AgeStudent> getAverageAge(){
        return studentRepository.getAverageAge();
    }
    public List<LastStudent> getLastStudent(){
        return studentRepository.getLastStudent();
    }
}