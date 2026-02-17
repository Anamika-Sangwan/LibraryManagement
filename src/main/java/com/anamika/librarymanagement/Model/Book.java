package com.anamika.librarymanagement.Model;


public class Book {
    private int id;
    private String title;
    private String author;
    private boolean borrowed;

    public Book(){}

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }
    //Setters and getters
    //For Id
    public void setId(int id){this.id = id;}
    public int getId(){return this.id;}

    //For Author
    public String getAuthor(){return this.author;}
    public void setAuthor(String author){this.author = author;}

    //For title
    public void setTitle(String title) {this.title = title;}
    public String getTitle(){return this.title;}

    //For Borrowed
    public boolean isBorrowed(){return this.borrowed;}
    public void setBorrowed(boolean borrowed){this.borrowed = borrowed;}
}