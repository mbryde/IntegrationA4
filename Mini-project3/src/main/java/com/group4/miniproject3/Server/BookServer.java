package com.group4.miniproject3.Server;

import com.group4.miniproject3.Service.BookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class BookServer {
    private static final Logger logger = Logger.getLogger(BookServer.class.getName());

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(9090)
                .addService(new BookService())
                .build();
        try
        {
            server.start();
            logger.log(Level.INFO, "STUDENT SERVER STARTED ON PORT 9090");
            // Keep the server running in the foreground blocking the prompt
            server.awaitTermination();
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "STUDENT SERVER DID NOT START");
        }
        catch (InterruptedException e)
        {
            logger.log(Level.SEVERE, "SERVER SHUT DOWN ON INTERRUPTED");
        }
    }

}
