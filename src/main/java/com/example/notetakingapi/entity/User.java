package com.example.notetakingapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "note_sequence", sequenceName = "note_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence")
    private Long id;
    private String emailAddress;
    private String password;

    @OneToMany
    @JoinTable(
            name="Join_user_note",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="note_id")
    )
    private List<Note> noteList;
}
