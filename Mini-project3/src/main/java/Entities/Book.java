package Entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String author;
    public String description;
    public String ISIN;
    public int price;

    @ElementCollection
    public ArrayList<String> recommendedFor;

    public Book(String name, String author, String description, String ISIN, int price, ArrayList<String> recommendedFor) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.ISIN = ISIN;
        this.price = price;
        this.recommendedFor = recommendedFor;
    }

    public Book() {}
}
