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
