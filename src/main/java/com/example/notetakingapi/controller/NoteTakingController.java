package com.example.notetakingapi.controller;

import com.example.notetakingapi.entity.Note;
import com.example.notetakingapi.entity.User;
import com.example.notetakingapi.loginbody.LoginBody;
import com.example.notetakingapi.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteTakingController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        return userServiceInterface.addUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginBody loginBody) {

        String emailAddress = loginBody.getEmailAddress();
        String password = loginBody.getPassword();
        return userServiceInterface.validateUser(emailAddress, password);
    }

    @PostMapping("/note/{userid}")
    public Note createNote(@RequestBody Note note, @PathVariable("userid") String id) {

        Long userId = Long.parseLong(id);
        return userServiceInterface.addNote(note, userId);
    }

    @GetMapping("/notes/{userId}")
    public List<Note> getAllNotes(@PathVariable("userId") String id) {

        Long userId = Long.parseLong(id);

        return userServiceInterface.getUserNoteList(userId);
    }

    @PutMapping("/edit/{noteId}")
    public Note updateNote(@PathVariable("noteId") String id, @RequestBody Note note) {
        Long noteId = Long.parseLong(id);


        return userServiceInterface.updateNote(noteId, note);
    }


}
