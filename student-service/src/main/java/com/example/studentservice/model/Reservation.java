package com.example.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Calendar reservationDate;
    private Calendar returnDate;


    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    Book book;
}
