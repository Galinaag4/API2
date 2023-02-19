package ru.hogwarts.school.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
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
    public OptionalDouble getAverageAge(){
        logger.info("Метод getAverageAge ");
        return studentRepository.findAll().stream().mapToDouble(s->s.getAge()).average();
    }
    public Collection<Student> getLastStudent(){
        logger.info("Метод getLastStudent ");
        return studentRepository.getLastStudent();
    }
    public Collection<Student> getNameA(){
        logger.info("Метод getNameA ");
        return studentRepository.findAll().stream().filter(s -> s.getName().toLowerCase().toUpperCase().startsWith("А"))
                .collect(Collectors.toList());
    }
    public void printAllStudentsNames() {
        List<String> studentsNames = studentRepository.findAll()
                .stream()
                .map(Student::getName).toList();
        for (int i = 0; i < 2; i++) {
            System.out.println(studentsNames.get(i));
        }
        new Thread(() ->
        {
            for (int i = 2; i < 4; i++) {
                System.out.println(studentsNames.get(i));
            }
        }
        ).start();
        new Thread(() ->
        {
            for (int i = 4; i < 6; i++) {
                System.out.println(studentsNames.get(i));
            }
        }
        ).start();
        new Thread(() ->
        {
            for (int i = 6; i < 8; i++) {
                System.out.println(studentsNames.get(i));
            }
        }
        ).start();
    }

    public void printAllStudentsNamesInSynchronizedStream() throws InterruptedException {
        print(0);
        print(1);
        Thread thread_1 = new Thread(() ->
        {
            print(2);
            print(3);
        }
        );
        thread_1.start();
        thread_1.join();
        Thread thread_2 =   new Thread(() ->
        {
            print(4);
            print(5);
        }
        );
        thread_2.start();
        thread_2.join();
        Thread thread_3 = new Thread(() ->
        {
            print(6);
            print(7);
        }
        );
        thread_3.start();
        thread_3.join();
    }

    private void print(int index) {
        List<String> studentsNames = studentRepository.findAll()
                .stream()
                .map(Student::getName).toList();
        System.out.println(studentsNames.get(index));
    }
}