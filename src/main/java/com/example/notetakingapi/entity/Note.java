package com.example.notetakingapi.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @SequenceGenerator(name = "note_sequence", sequenceName = "note_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_sequence")
    private Long id;

    @DateTimeFormat
    @CreatedDate
    private Date dateOfEdition;
    @Column(length=100)
    private String title;
    @Column(length=550)
    private String noteBody;



}
