package net.javaguides.springoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docker")
public class DockerController {
    @GetMapping
    public String DockerDemo() {
        return "Dockerizing Spripng Boot Web Application.";
    }
}
