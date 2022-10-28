package com.group4.miniproject3.DAO;
import com.group4.miniproject3.Entities.Book;
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

    public List<Book> getAllRecommended()
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
}
