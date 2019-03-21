package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sun.swing.BakedArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Author author=new Author();
        author.setFirstName("Shivam");
        author.setLastName("Saxena");
        author.setAge(21);
        author.setDob(new Date());
        Address address=new Address();
        address.setStreetNumber("C-339");
        address.setLocation("Alpha 1");
        address.setState("Uttar Pradesh");
        author.setAddress(address);

        Set<String> subjects=new HashSet<>();
        subjects.add("Maths");
        subjects.add("physics");
        subjects.add("Chemistry");

        author.setSubjects(subjects);

        List<Author> authorList1=new ArrayList<>();
        authorList1.add(author);

        List<Book> bookList=new ArrayList<>();
        Book book=new Book();
        book.setBookName("DAA");
        book.setAuthorList(authorList1);
        bookList.add(book);
        author.setBookList(bookList);
        //author.setBook(book);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.save(book);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}