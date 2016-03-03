package com.gizwits.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.User;

/**
 * @author Marvel
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    
    User findByPhoneNumber(String phoneNumber);
}
