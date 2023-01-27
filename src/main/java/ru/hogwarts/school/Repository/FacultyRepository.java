package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByNameContainsIgnoreCase(String name);

    List<Faculty> findByColorContainsIgnoreCase(String color);
}

