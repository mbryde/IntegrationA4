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
@Table(name = "Book")
public class Book {
    @Id
    private Long id;
    public String name;
    public String author;
    public String description;
    public String ISBN;
    public int price;
    public String recommendedFor;

    public Book(String name, String author, String description, String ISBN, int price, String recommendedFor) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.ISBN = ISBN;
        this.price = price;
        this.recommendedFor = recommendedFor;
    }
}
