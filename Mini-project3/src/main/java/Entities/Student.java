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
}
