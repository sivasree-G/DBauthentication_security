package com.example.springboot_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class student {
    private record StudentDetails(Integer id, String name, String address) {}

    private final List<StudentDetails> stu = new ArrayList<>(List.of(
            new StudentDetails(1, "siva", "pattukkotai"),
            new StudentDetails(2, "sri", "thanjavur")
    ));

    @GetMapping("/stu")
    public List<StudentDetails> getStudents() {
        return stu;
    }

    @PostMapping("/add")
    public StudentDetails addStudent(@RequestBody StudentDetails stud) {
        stu.add(stud);  // now works correctly
        return stud;
    }
    @GetMapping("/csrf")
    public CsrfToken gettoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }
}
