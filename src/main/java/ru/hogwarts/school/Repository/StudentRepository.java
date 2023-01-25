package ru.hogwarts.school.Repository;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.Model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByAge(int student);
    Collection<Student> findByAgeBetween(Integer min, Integer max);
    Collection<Student> getByFaculty_Id(long id);

}
