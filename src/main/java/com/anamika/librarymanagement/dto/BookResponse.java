package com.anamika.librarymanagement.dto;
import lombok.Data;

@Data
public class BookResponse {
    private int id;
    private String title;
    private String author;
    private boolean borrowed;

    public void setId(int id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setAuthor(String author){this.author = author;}
    public void setBorrowed(boolean borrowed){this.borrowed = borrowed;}

    public int getId(){return this.id;}
    public String getAuthor(){return this.author;}
    public String getTitle(){return this.title;}
    public boolean getBorrowed(){return this.borrowed;}
}