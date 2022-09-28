package com.example.sampleunittest.repository;

import com.example.sampleunittest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author absatyap
 **/
public interface UserRepository extends JpaRepository<User, Long> {
}
