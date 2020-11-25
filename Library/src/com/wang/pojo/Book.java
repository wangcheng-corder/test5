package com.wang.pojo;

import java.util.Date;

public class Book {
    private long bookid;
    private String bname;
    private double price;
    private String author;
    private String publisher;
    private Date pubdate;
    private int lended;
    private int counter;

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubdate=" + pubdate +
                ", lended=" + lended +
                ", counter=" + counter +
                '}';
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Book(long bookid, String bname, double price, String author, String publisher, Date pubdate, int lended, int counter) {
        this.bookid = bookid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.lended = lended;
        this.counter = counter;
    }

    public Book() {
    }
}
