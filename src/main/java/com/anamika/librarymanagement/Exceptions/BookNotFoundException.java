package com.anamika.librarymanagement.Exceptions;

import com.anamika.librarymanagement.Constants.CustomMessage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class BookNotFoundException extends RuntimeException{
    private static final Logger LOG = LoggerFactory.getLogger(BookNotFoundException.class);
    public BookNotFoundException(String message){
        super(message);
        LOG.error(CustomMessage.INSIDE_METHOD,"BookNotFoundException");
    }
}