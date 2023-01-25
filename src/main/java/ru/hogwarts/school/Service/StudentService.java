package ru.hogwarts.school.Service;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;

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
    public Collection<Student> findByAgeBetween(int min,int max) {
        return studentRepository.findByAgeBetween(min, max);
    }
    public Collection<Student> ById(long id) {
      return studentRepository.getByFaculty_Id(id);

    }





}
