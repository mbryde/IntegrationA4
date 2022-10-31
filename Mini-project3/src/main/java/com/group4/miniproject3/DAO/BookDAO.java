package com.group4.miniproject3.DAO;
import com.group4.miniproject3.Entities.Book;
import com.group4.miniproject3.Entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.NoSuchElementException;

public class BookDAO
{
    public List<Book> getAllBooks()
    {
        // We use entity managers to search in the database
        // The persistenceUnitName will  be referred in the persistence.xml file in META-INF folder
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book");
        EntityManager em = emf.createEntityManager();

        // We search database for a record with the given  id using the predefined find() method
        List<Book> result = em.createQuery("SELECT b FROM Book b",Book.class).getResultList();

        // If there is no record found with the provided student id, then we throw a NoSuchElement exception.
        if(result == null)
        {
            throw new NoSuchElementException("NO DATA FOUND");
        }

        return result;
    }

    public List<Book> getAllRecommended(int price, String recommendedFor)
    {
        // We use entity managers to search in the database
        // The persistenceUnitName will  be referred in the persistence.xml file in META-INF folder
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book");
        EntityManager em = emf.createEntityManager();

        // We search database for a record with the given  id using the predefined find() method
        List<Book> result = em.createQuery("SELECT b FROM Book b WHERE b.price < :price AND b.recommendedFor = :recommendedFor",Book.class)
                .setParameter("price", price)
                .setParameter("recommendedFor", recommendedFor)
                .getResultList();

        // If there is no record found with the provided student id, then we throw a NoSuchElement exception.
        if(result == null)
        {
            throw new NoSuchElementException("NO DATA FOUND");
        }

        return result;
    }

    public Book buyBook(int id, int student)
    {
        // We use entity managers to search in the database
        // The persistenceUnitName will  be referred in the persistence.xml file in META-INF folder
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book");
        EntityManager em = emf.createEntityManager();

        // We search database for a record with the given  id using the predefined find() method
        Book result = em.find(Book.class, id);
        Student result2 = em.find(Student.class, student);
        if(result2.getAmount() < result.getPrice())
        {
            throw new NoSuchElementException("NOT ENOUGH MONEY");
        }else{
            //Microservice which send the book to the student
            //Microservice which sends confirmation email to the student

            // If there is no record found with the provided student id, then we throw a NoSuchElement exception.
        }

        if(result == null)
        {
            throw new NoSuchElementException("NO DATA FOUND");
        }

        return result;
    }
}
