package com.anamika.librarymanagement.dto;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class BookResponse {
    private int id;

    @NotBlank(message="Title cannot be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message="Author cannot be empty")
    @Size(min = 2, max = 100, message = "Author must be between 2 and 100 characters")
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