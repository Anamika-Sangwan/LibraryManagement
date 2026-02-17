package com.anamika.librarymanagement.Exceptions;

public class BookAlreadyBorrowedException extends RuntimeException{
    public BookAlreadyBorrowedException(String message){
        super(message);
    }
}