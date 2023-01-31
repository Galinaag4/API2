package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.SQL.AgeStudent;
import ru.hogwarts.school.SQL.CountStudent;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.SQL.LastStudent;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value="SELECT count(id) FROM student",nativeQuery=true)
    List<CountStudent>getCountStudent();
    @Query(value="SELECT AVG(age) FROM student",nativeQuery=true)
    List<AgeStudent>getAverageAge();
    @Query(value="SELECT*FROM student ORDER BY id DESC LIMIT 5",nativeQuery=true)
    List<LastStudent> getLastStudent();


    List<Student> findByAge(int student);
    Collection<Student> findByAgeBetween(Integer min, Integer max);


}
