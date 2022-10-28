package com.group4.miniproject3.Repository;

import com.group4.miniproject3.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getAll();
    List<Book> getAllByName(String name);
    List<Book> getAllByRecommendedForContains(String recommendation);
    Book getByISBN(String ISIN);
}