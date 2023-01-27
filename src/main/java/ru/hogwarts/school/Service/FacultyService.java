package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }


    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColorContainsIgnoreCase(color);
    }
    public Collection<Faculty> findByName(String name) {
        return facultyRepository.findByNameContainsIgnoreCase(name);
    }
    public Student findStudentByFaculty(long id){
        return (Student) facultyRepository.findById(id)
                .map(faculty -> faculty.getStudents())
                .orElse(null);
    }

}

