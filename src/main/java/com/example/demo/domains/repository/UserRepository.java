package com.example.demo.domains.repository;

import com.example.demo.domains.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.Text;


public interface UserRepository extends JpaRepository<User, String> {
}
