package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultys = new HashMap<>();
    private long lastId = 0;
    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultys.put(lastId, faculty);
        return faculty;
    }
    public Faculty findFaculty(long id){
        return facultys.get(id);
    }
    public Faculty editFaculty(Faculty faculty){
        facultys.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty deleteFaculty(long id){
        return facultys.remove(id);
    }
    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultys.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }

}

