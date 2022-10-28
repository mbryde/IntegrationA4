package com.group4.miniproject3.Service;

import com.group4.miniproject3.DAO.BookDAO;
import com.group4.miniproject3.Entities.Book;
import com.group4.miniproject3.Repository.BookRepository;
import com.group4.miniproject3.stubs.book.BookRequest;
import com.group4.miniproject3.stubs.book.BookResponse;
import com.group4.miniproject3.stubs.book.BookServiceGrpc;
import com.group4.miniproject3.stubs.book.BooksResponse;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService extends BookServiceGrpc.BookServiceImplBase {
    @Override
    public void getAllBooks(BookRequest request, StreamObserver<BooksResponse> responseStreamObserver) {
        try{

            BookDAO bookDAO = new BookDAO();
            ArrayList<Book> booksResponse= (ArrayList<Book>) bookDAO.getAllBooks();
            BooksResponse.Builder booksResponseBuilder = BooksResponse.newBuilder();
            for (Book book: booksResponse) {
                booksResponseBuilder.addBooks(BookResponse.newBuilder()
                        .setId(String.valueOf(book.getId()))
                        .setName(book.getName())
                        .setAuthor(book.getAuthor())
                        .setDescription(book.getDescription())
                        .setISBN(book.getISBN())
                        .setPrice(String.valueOf(book.getPrice()))
                        .setRecommendedFor(book.getRecommendedFor())
                        .build());
            };
            responseStreamObserver.onNext(booksResponseBuilder.build());

            responseStreamObserver.onCompleted();
        } catch (Exception ex) {
            System.out.println(ex);
            responseStreamObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }
}