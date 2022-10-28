package com.group4.miniproject3.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String email;
    public String education;
    public Integer amount;


    public Student(String name, String email, String education, Integer amount) {
        this.name = name;
        this.email = email;
        this.education = education;
        this.amount = amount;
    }
}
