package Service;

import Entities.Book;
import Repository.BookRepository;
import com.group4.miniproject3.stubs.book.BookRequest;
import com.group4.miniproject3.stubs.book.BookResponse;
import com.group4.miniproject3.stubs.book.BookServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService extends BookServiceGrpc.BookServiceImplBase {
    @Autowired
    private BookRepository repository;

    public void getBookById(BookRequest request, StreamObserver<BookResponse> responseStreamObserver) {
        try{
            Long id = Long.parseLong(request.getId());

            Optional<Book> book = repository.findById(id);

            if(book.isPresent()) {
                BookResponse bookResponse = BookResponse.newBuilder()
                        .setId(id.toString())
                        .setName(book.get().getName())
                        .setAuthor(book.get().getAuthor())
                        .setDescription(book.get().getDescription())
                        .setISBN(book.get().getISBN())
                        .setPrice(String.valueOf(book.get().getPrice()))
                        .build();
            /*BookResponse bookResponse = BookResponse.newBuilder()
                    .setId("1234567")
                    .setName("Bob")
                    .setAuthor("The Builder")
                    .setDescription("Awesome")
                    .setISBN("1234")
                    .setPrice("1234")
                    .build();*/

                responseStreamObserver.onNext(bookResponse);
            }

            responseStreamObserver.onCompleted();
        } catch (Exception ex) {
            System.out.println(ex);
            responseStreamObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }
    }
}