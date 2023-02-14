package ru.hogwarts.school.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/GetPort")
    public String getPort(){
        return serverPort ;
    }
}
