package ru.hogwarts.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.SQL.LastStudent;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value="SELECT count(id) FROM student",nativeQuery=true)
    public int getCountStudent();
    @Query(value="SELECT AVG(age) FROM student",nativeQuery=true)
    public double getAverageAge();
    @Query(value="SELECT*FROM student ORDER BY id DESC LIMIT 5",nativeQuery=true)
    public Collection<Student> getLastStudent();


    List<Student> findByAge(int student);
    Collection<Student> findByAgeBetween(Integer min, Integer max);


    Object findAllByAge(int eq);
}
