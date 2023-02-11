package ru.hogwarts.school.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Метод createStudent ");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("Метод findStudent ");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("Метод editStudent ");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Метод deleteStudent ");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        logger.info("Метод findByAge ");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("Метод findByAgeBetween ");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findFacultyByStudent(long id) {
        logger.info("Метод findFacultyByStudent ");
        return studentRepository.findById(id)
                .map(student -> student.getFaculty())
                .orElse(null);
    }
    public int getCountStudent(){
        logger.info("Метод getCountStudent ");
        return studentRepository.getCountStudent();
    }
    public double getAverageAge(){
        logger.info("Метод getAverageAge ");
        return studentRepository.getAverageAge();
    }
    public Collection<Student> getLastStudent(){
        logger.info("Метод getLastStudent ");
        return studentRepository.getLastStudent();
    }
}