package com.example.notetakingapi.service;

import com.example.notetakingapi.entity.Note;
import com.example.notetakingapi.entity.User;
import com.example.notetakingapi.repository.NoteRepository;
import com.example.notetakingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String validateUser(String email, String password) {
        String idStr = "null";
        User user = userRepository.loginUser(email, password);

        if (user != null) {
            idStr = String.valueOf(user.getId());
        }

        return idStr;
    }

    @Override
    public Note addNote(Note note, Long userId) {


        noteRepository.save(note);

        User user = userRepository.findById(userId).get();

        List<Note> noteList = user.getNoteList();

        noteList.add(note);

        user.setNoteList(noteList);

        // update user
        userRepository.save(user);

        List<Note> newNoteList = user.getNoteList();

        return newNoteList.get(newNoteList.size() - 1);

    }

    @Override
    public List<Note> getUserNoteList(Long id) {

        User user = userRepository.findById(id).get();
        return user.getNoteList();
    }

    @Override
    public Note updateNote(Long id, Note note) {

        Note dbNote = noteRepository.findById(id).get();

        if (note.getTitle() != null && !note.getTitle().equals("")) {
            dbNote.setTitle(note.getTitle());
        }
        if (note.getNoteBody() != null && !note.getNoteBody().equals("")) {
            dbNote.setNoteBody(note.getNoteBody());
        }
        if(note.getNoteBackgroundColor()!= null && !note.getNoteBody().equals("")){
            dbNote.setNoteBackgroundColor(note.getNoteBackgroundColor());
        }



        return noteRepository.save(dbNote);
    }

    @Override
    public List<Note> searchNotes(Long id, String title) {

        List<Note>noteList=new ArrayList<>();
        User user = userRepository.findById(id).get();

        for(int i=0; i< user.getNoteList().size();i++){

            String noteTitle=user.getNoteList().get(i).getTitle().toLowerCase();
            if(noteTitle.contains(title.toLowerCase())){
                noteList.add(user.getNoteList().get(i));
            }

        }

        return noteList;
    }

    @Override
    public String deleteNote(Long id) {
        noteRepository.deleteById(id);

        return "note deleted";
    }
}
