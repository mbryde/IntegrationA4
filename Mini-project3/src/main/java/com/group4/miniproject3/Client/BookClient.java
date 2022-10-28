package com.group4.miniproject3.Client;

import com.group4.miniproject3.stubs.book.BookRequest;
import com.group4.miniproject3.stubs.book.BookResponse;
import com.group4.miniproject3.stubs.book.BookServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BookClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090").usePlaintext().build();

        BookServiceGrpc.BookServiceBlockingStub bookServiceBlockingStub = BookServiceGrpc.newBlockingStub(channel);

        BookRequest bookRequest = BookRequest.newBuilder().build();

    }
}
