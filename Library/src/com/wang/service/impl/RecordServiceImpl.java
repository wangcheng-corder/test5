package com.wang.service.impl;

import com.wang.dao.BookDao;
import com.wang.dao.ReaderDao;
import com.wang.dao.RecordDao;
import com.wang.dao.impl.BookDaoImpl;
import com.wang.dao.impl.ReaderDaoImpl;
import com.wang.dao.impl.RecordDaoImpl;
import com.wang.pojo.Book;
import com.wang.pojo.Reader;
import com.wang.pojo.Record;
import com.wang.service.RecordService;

import java.util.Date;

public class RecordServiceImpl implements RecordService {
    @Override
    public void Borrow(long readerid,long bookid) {//还书
        BookDao bc = new BookDaoImpl();
        ReaderDao rd = new ReaderDaoImpl();
        Reader reader=rd.queryReaderById(readerid);
        Book book = bc.queryBookById(bookid);
        RecordDao rod= new RecordDaoImpl();
        if(reader.getAvailable()==1){//判断读者状态 1 可借 0 不可借
            if(book.getLended()==1){//判断书的状态
                Record record= new Record();//创建recor对象，并赋值
                record.setBid(bookid);
                record.setRid(readerid);
                Date date = new Date();
                record.setLenddate(date);
                rod.insertOne(record);//将record插入借阅表
                book.setLended(0);//改变书的状态
                book.setCounter(book.getCounter()+1);//书的次数+1
                bc.updateOne(book);//更新书的信息
                reader.setAvailable(0);//改变读者的状态
                rd.updateOne(reader);//更新读者
                System.out.println("借书成功");
            }
            else{//书的状态不可借
                System.out.println("该书已被借走");
            }
        }else {//读者状态不与允许借书
            System.out.println("该读者不可借书");
        }
    }

    @Override
    public void Baack(long readerid,long bookid) {//还书
        RecordDao rod= new RecordDaoImpl();
        BookDao bc = new BookDaoImpl();
        ReaderDao rd = new ReaderDaoImpl();
        Reader reader=rd.queryReaderById(readerid);
        Book book = bc.queryBookById(bookid);
        if(reader.getAvailable()==0){//判断读者状态 1 未借 0 已借
            if(book.getLended()==0){//判断书的状态
                book.setLended(1);//改变书的状态
                bc.updateOne(book);//更新书的信息
                reader.setAvailable(1);//改变读者的状态
                rd.updateOne(reader);//更新读者
                rod.updataRecordByBookAndReaderid(bookid,readerid);//更新还书时间
                System.out.println("还书成功");
            }
            else{//书的状态未被借
                System.out.println("该书未被该读者借走");
            }
        }else {//读者状态未借书
            System.out.println("该读者未借书");
        }
    }
}
