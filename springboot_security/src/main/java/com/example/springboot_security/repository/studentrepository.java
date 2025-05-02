package com.example.springboot_security.repository;

import com.example.springboot_security.entity.userentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepository extends JpaRepository<userentity, Integer> {
    userentity findByName(String name);
}
