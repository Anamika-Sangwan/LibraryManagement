package com.anamika.librarymanagement.Exceptions;

import com.anamika.librarymanagement.Constants.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookAlreadyBorrowedException extends RuntimeException{
    private static final Logger LOG = LoggerFactory.getLogger(BookAlreadyBorrowedException.class);
    public BookAlreadyBorrowedException(String message){
        super(message);
        LOG.error(CustomMessage.INSIDE_METHOD,"BookAlreadyBorrowedException");
    }
}