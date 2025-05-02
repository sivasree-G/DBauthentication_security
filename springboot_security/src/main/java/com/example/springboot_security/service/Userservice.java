package com.example.springboot_security.service;

import com.example.springboot_security.entity.userentity;
import com.example.springboot_security.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    @Autowired
    private studentrepository sturepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public userentity register(userentity u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return sturepo.save(u);
    }
}
