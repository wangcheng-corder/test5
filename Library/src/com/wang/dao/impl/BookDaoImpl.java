package com.wang.dao.impl;

import com.wang.dao.BookDao;
import com.wang.pojo.Book;
import com.wang.utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> queryAll() {
        List<Book> bookList = new ArrayList<>();

        String sql = "select * from tb_book";
        try(
                Connection connection = JdbcUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                long bookid = resultSet.getLong("bookid");
                String bname = resultSet.getString("bname");
                double  price = resultSet.getDouble("price");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                Date pubdate  = resultSet.getDate("pubdate");
                Integer lended=resultSet.getInt("lended");
                Integer counter=resultSet.getInt("counter");
                Book item = new Book(bookid, bname, price, author,publisher, pubdate,lended,counter);
                bookList.add(item);
            }
            System.out.println(bookList);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public boolean insertOne(Book book) {
        String sql =
                "insert into tb_book (bookid,bname,price,author,publisher,pubdate,lended,counter) values (0, ?,?,?,?,?,?,?)";
        try(
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, book.getBname());
            ps.setDouble(2, book.getPrice());
            ps.setString(3, book.getAuthor());
            ps.setString(4,book.getPublisher());
            java.sql.Date pubdate = new java.sql.Date(book.getPubdate().getTime());
            ps.setDate(5, pubdate);
            ps.setInt(6,book.getLended());
            ps.setInt(7,book.getCounter());
            int result = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.first()){
                long id = generatedKeys.getLong(1);
                book.setBookid(id);
            }
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOne(Book book) {
        return deleteById(book.getBookid());
    }

    @Override
    public boolean updateOne(Book book) {
        String sql = "update tb_book set bname=?,price=?,author=?,publisher=?,pubdate=?,lended=?,counter=? where bookid=?";
        try(
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ){
            ps.setString(1, book.getBname());
            ps.setDouble(2,book.getPrice());
            ps.setString(3, book.getAuthor());
            ps.setString(4,book.getPublisher());
            java.sql.Date pubdate = new java.sql.Date(book.getPubdate().getTime());
            ps.setDate(5, pubdate);
            ps.setInt(6,book.getLended());
            ps.setInt(7,book.getCounter());
            ps.setLong(8, book.getBookid());
            int result = ps.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        String sql = "delete from tb_book where bookid = ?";
        try(
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);

        ){
            ps.setLong(1,id);
            int result = ps.executeUpdate();
            return result >0 ;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Book queryBookById(long bookid) {
        Book book = new Book();
        String sql = "select * from tb_book where bookid = ?";
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, bookid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book.setBookid(resultSet.getLong("bookid"));
                book.setBname(resultSet.getString("bname"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                book.setPubdate(resultSet.getDate("pubdate"));
                book.setLended(resultSet.getInt("lended"));
                book.setCounter(resultSet.getInt("counter"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
