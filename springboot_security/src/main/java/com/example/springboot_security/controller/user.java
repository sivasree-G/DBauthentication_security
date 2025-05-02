package com.example.springboot_security.controller;

import com.example.springboot_security.entity.userentity;
import com.example.springboot_security.repository.studentrepository;
import com.example.springboot_security.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class user {
    @Autowired
    private studentrepository repo;
    @Autowired
    public Userservice service;

//    public user(studentrepository repo) {
//        this.repo = repo;
//    }

    @PostMapping("/adduser")
    public userentity addstudent(@RequestBody userentity u){
        return service.register(u);
        //return repo.save(u);
    }
    @GetMapping("/users")
    public List<userentity> getAllUsers() {
        return repo.findAll();
    }
   // @PostMapping("/login")
//    @PostMapping("/userlogin")
//
//    public String login(@RequestBody userentity u){
//       var user= repo.findByName(u.getName());
//       if(!Objects.isNull(user))
//        return "hi success";
//       return "hi failure";
//    }
}
