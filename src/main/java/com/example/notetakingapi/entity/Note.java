package com.example.notetakingapi.entity;


import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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

    @CreationTimestamp
    private LocalDate dateOfEdition;
    @Column(length=100)
    private String title;
    @Column(length=550)
    private String noteBody;
    private String noteBackgroundColor;



}
