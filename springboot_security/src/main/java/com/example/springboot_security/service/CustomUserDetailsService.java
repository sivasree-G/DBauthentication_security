package com.example.springboot_security.service;

import com.example.springboot_security.customuserdetails;
import com.example.springboot_security.entity.userentity;
import com.example.springboot_security.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    public  studentrepository userrepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       userentity u=userrepo.findByName(username);
       if(u==null){
           System.out.println("user not avilable");
           throw new UsernameNotFoundException("user not found");
       }
       return new customuserdetails(u);
    }
}
