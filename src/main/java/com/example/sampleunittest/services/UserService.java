package com.example.sampleunittest.services;

import com.example.sampleunittest.exception.InvalidUserException;
import com.example.sampleunittest.exception.UserNotFoundException;
import com.example.sampleunittest.models.User;
import com.example.sampleunittest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author absatyap
 **/
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) throws UserNotFoundException, InvalidUserException {
        if (user == null || user.getUserId() == null) {
            throw new InvalidUserException();
        }
        Long existingUserId = user.getUserId();
        User existingUser = userRepository.findById(existingUserId).orElseThrow(() -> new UserNotFoundException(existingUserId));

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setBio(user.getBio());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.deleteById(userId);
    }
}
