package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String author;
    public String description;
    public String ISBN;
    public int price;

    @ElementCollection
    public ArrayList<String> recommendedFor;

    public Book(String name, String author, String description, String ISBN, int price, ArrayList<String> recommendedFor) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.ISBN = ISBN;
        this.price = price;
        this.recommendedFor = recommendedFor;
    }
}
