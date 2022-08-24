package com.example.notetakingapi.service;

import com.example.notetakingapi.entity.Note;
import com.example.notetakingapi.entity.User;
import com.example.notetakingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String validateUser(String email, String password) {
        return null;
    }

    @Override
    public List<Note> getUserNoteList(Long id) {
        return null;
    }
}
