package com.example.notetakingapi.service;

import com.example.notetakingapi.entity.Note;
import com.example.notetakingapi.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServiceInterface {

    public User addUser(User user);
    public String validateUser(String email,String password);
    public Note addNote(Note note, Long userId);
    public List<Note> getUserNoteList(Long id);
    public Note updateNote(Long id, Note note);
    public List<Note> searchNotes(Long id, String title);
    public  String deleteNote(Long id);
}
