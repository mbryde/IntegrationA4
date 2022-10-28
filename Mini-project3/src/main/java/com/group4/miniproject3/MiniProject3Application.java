package com.group4.miniproject3;

import com.group4.miniproject3.Server.BookServer;
import com.group4.miniproject3.Service.BookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class MiniProject3Application {
    public static void main(String[] args) {
        SpringApplication.run(BookServer.class, args);
    }
    @EventListener(org.springframework.context.event.ContextStartedEvent.class)
    public void start() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new BookService())
                .build();
        try
        {
            server.start();
            // Keep the server running in the foreground blocking the prompt
            server.awaitTermination();
        }
        catch (IOException e)
        {}
        catch (InterruptedException e)
        {}
    }
}