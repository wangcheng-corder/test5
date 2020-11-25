package com.wang.test;

import com.wang.dao.BookDao;
import com.wang.dao.ReaderDao;
import com.wang.dao.impl.BookDaoImpl;
import com.wang.dao.impl.ReaderDaoImpl;
import com.wang.pojo.Book;
import com.wang.pojo.Reader;
import com.wang.service.RecordService;
import com.wang.service.impl.RecordServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    //long bookid, String bname, double price, String author, String publisher, Date pubdate, int lended, int counter
    public static void main(String[] args) {
        //测试书的增，删，该，查。
        /*BookDao bc = new BookDaoImpl();
        ReaderDao rd=new ReaderDaoImpl();
        Book book = new Book(3,"三国演义",120.00,"罗贯中","中华人民出版社",date,1,0);
        bc.insertOne(book);
        //bc.deleteById(4);
        //bc.queryAll();
       Date date = new Date(1997-02-12);
        Book book = new Book(3,"三国",120.00,"罗贯中","中华人民出版社",date,1,0);
        bc.updateOne(book);*/


       //测试读者的增，删，该，查。
        /*Date date = new Date(2020-10-10);
        Reader reader= new Reader(3,"孔明","男","753759542",date,1);
        //rd.updateOne(reader);
        //rd.insertOne(reader);
        //rd.deleteById(4);
        //rd.queryAll();*/


        //根据id查书与读者
        /*BookDao bc = new BookDaoImpl();
        //bc.queryBookById(2);
        /*ReaderDao rd = new ReaderDaoImpl();
        rd.queryReaderById(2);*/

        //借书
        System.out.println("。。。。。借书。。。。。");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入读者id");
        long readerid=sc.nextLong();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入书籍id");
        long bookid=sc2.nextLong();
        RecordService rod= new RecordServiceImpl();
        rod.Borrow(readerid,bookid);

        //还书
        /*System.out.println("。。。。。还书。。。。。");
        Scanner sc3 = new Scanner(System.in);
        System.out.println("请输入读者id");
        long readerid1=sc3.nextLong();
        Scanner sc4 = new Scanner(System.in);
        System.out.println("请输入书籍id");
        long bookid1=sc4.nextLong();
        RecordService rod1= new RecordServiceImpl();
        rod1.Baack(readerid1,bookid1);*/
    }
}
