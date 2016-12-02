package com.gizwits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gizwits.dao.UserRepository;
import com.gizwits.domain.User;

/**
 * @author Marvel
 */
@Service
public class UserManagement {

    @Autowired
    private UserRepository userRepository;

    public User login(String phoneNumber, String password) {
        User user = findByPhoneNumber(phoneNumber);
        if (user == null || password == null || !password.equals(user.getPassword())) {
            return null;
        }
        return user;
    }
    
    public User register(String phoneNumber, String password) {
        if (findByPhoneNumber(phoneNumber) != null || password == null) {
            return null;
        }
        User user = new User();
        user.setName(phoneNumber); // 默认与手机号相同
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        return userRepository.save(user);
    }
    
//    public User create(User user) {
//        // 检查是否存在相同的phoneNumber
//        if (user == null || findByPhoneNumber(user.getPhoneNumber()) != null) {
//            return null;
//        }
//        return userRepository.save(user);
//    }
    
    public Page<User> findAll(Integer page, Integer size) {
        return userRepository.findAll(new PageRequest(page, size));
    }
    
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }

    public User update(User user, String name) {
        if (user == null) {
            return null;
        }
        // 非必填项，不为null时才修改
        if (name != null) {
            user.setName(name);
        }
        return userRepository.save(user);
    }
    
    public User updatePassword(User user, String password) {
        if (user == null || password == null) {
            return null;
        }
        user.setPassword(password);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User findById(Long id) {
        if (id == null) {
            return null;
        }
        return userRepository.findOne(id);
    }

    public User findByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return userRepository.findByPhoneNumber(phoneNumber);
    }
    
    public Boolean exists(Long id) {
        if (id == null) {
            return null;
        }
        return userRepository.exists(id);
    }

    // TODO 短信验证
    public Boolean validateCode(String code) {
        if (code.isEmpty()) {
            return false;
        }
        return true;
    }
    
}
