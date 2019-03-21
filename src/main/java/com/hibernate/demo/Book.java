package com.hibernate.demo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    @ManyToMany(mappedBy = "bookList")
    List<Author> AuthorList=new ArrayList<>();

    public List<Author> getAuthorList() {
        return AuthorList;
    }

    public void setAuthorList(List<Author> authorList) {
        AuthorList = authorList;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", AuthorList=" + AuthorList +
                '}';
    }
}