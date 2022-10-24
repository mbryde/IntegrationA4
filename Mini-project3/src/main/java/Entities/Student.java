package Entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String email;
    public String education;
    @ManyToMany(fetch = FetchType.LAZY)
    public ArrayList<Book> boughtBooks;

    public Student(String name, String email, String education, ArrayList<Book> boughtBooks) {
        this.name = name;
        this.email = email;
        this.education = education;
        this.boughtBooks = boughtBooks;
    }

    public Student() {}
}
