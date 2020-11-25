package com.wang.dao;

import com.wang.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> queryAll(); //获取全部HqUser数据
    boolean insertOne(Book book); //增加一个HqUser数据
    boolean deleteOne(Book book); //删除一个HqUser数据
    boolean updateOne(Book book);// 更新一个HqUser的数据
    boolean deleteById(long id); //通过id来删除一个HqUser的数据
    Book queryBookById(long bookid);
}
