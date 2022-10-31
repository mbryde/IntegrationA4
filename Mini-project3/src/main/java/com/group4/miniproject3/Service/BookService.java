package com.group4.miniproject3.Service;

import com.group4.miniproject3.DAO.BookDAO;
import com.group4.miniproject3.Entities.Book;
import com.group4.miniproject3.stubs.book.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    @Override
    public void getAllRecommended(BookRecommendedRequest request, StreamObserver<BooksResponse> responseStreamObserver) {
        try{
            BookDAO bookDAO = new BookDAO();
            ArrayList<Book> booksResponse= (ArrayList<Book>) bookDAO.getAllRecommended(request.getPrice(),request.getRecommendedFor());
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

    @Override
    public Book buyBook(buyRequest request, StreamObserver<BookResponse> responseStreamObserver) {
        try{
            BookDAO bookDAO = new BookDAO();

            Book book = bookDAO.buyBook(Integer.parseInt(request.getBookId()),Integer.parseInt(request.getStudentId()));
            responseStreamObserver.onNext(BookResponse.newBuilder()
                    .setId(String.valueOf(book.getId()))
                    .setName(book.getName())
                    .setAuthor(book.getAuthor())
                    .setDescription(book.getDescription())
                    .setISBN(book.getISBN())
                    .setPrice(String.valueOf(book.getPrice()))
                    .setRecommendedFor(book.getRecommendedFor())
                    .build());
            responseStreamObserver.onCompleted();
            return book;
        } catch (Exception ex) {
            System.out.println(ex);
            responseStreamObserver.onError(Status.NOT_FOUND.asRuntimeException());
            return null;
        }
    }
}