package ru.hogwarts.school.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty) {
        logger.info("Метод createFaculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Метод findFaculty");
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Метод editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Метод deleteFaculty");
        facultyRepository.deleteById(id);
    }


    public Collection<Faculty> findByColor(String color) {
        logger.info("Метод findByColor");
        return facultyRepository.findByColorContainsIgnoreCase(color);
    }
    public Collection<Faculty> findByName(String name) {
        logger.info("Метод findByName");
        return facultyRepository.findByNameContainsIgnoreCase(name);
    }
    public Collection<Student> findStudentByFaculty(long id){
        logger.info("Метод findStudentByFaculty");
        return  facultyRepository.findById(id)
                .map(faculty -> faculty.getStudents())
                .orElse(null);
    }

}

