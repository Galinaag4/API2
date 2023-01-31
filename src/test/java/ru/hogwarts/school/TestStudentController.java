package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.Controller.StudentController;
import ru.hogwarts.school.Model.Student;

import static jdk.dynalink.linker.support.Guards.isNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStudentController {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception{
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void testGetStudent() throws Exception{
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "id", String.class))
                .isNotNull();
    }
    @Test
    public void testPostStudent() throws Exception{
        Student student = new Student();
        student.setName("AAA");
        student.setAge(20);
        Assertions.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student",student, String.class))
                .isNotNull();
    }
    @Test
    public void testPutStudent() throws Exception{
        Student student = new Student("CCC",25);

    }
    @Test
    public void testDeleteStudent() throws Exception{
        Student student = new Student("CCC",25);
        student.setName("FFF");
        Assertions.assertThat(this.restTemplate.put("http://localhost:" + port + "/student",student, String.class))
                .isNotNull();

    }
}
