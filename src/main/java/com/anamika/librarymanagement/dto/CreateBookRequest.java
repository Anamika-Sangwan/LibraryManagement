package com.anamika.librarymanagement.dto;

import lombok.Data;

@Data
public class CreateBookRequest{
    private String author;
    private String title;

    public String getTitle(){return this.author;}
    public String getAuthor(){return this.title;}
}