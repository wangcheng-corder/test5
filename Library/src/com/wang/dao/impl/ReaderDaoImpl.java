package com.wang.dao.impl;

import com.wang.dao.ReaderDao;
import com.wang.pojo.Book;
import com.wang.pojo.Reader;
import com.wang.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    @Override
    public List<Reader> queryAll() {
        List<Reader> readerList = new ArrayList<>();

        String sql = "select * from tb_reader";
        try(
                Connection connection = JdbcUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                long readerid = resultSet.getLong("readerid");
                String rname = resultSet.getString("rname");
                String gender = resultSet.getString("gender");
                String tel = resultSet.getString("tel");
                Date regdate  = resultSet.getDate("regdate");
                Integer available=resultSet.getInt("available");
                Reader item = new Reader(readerid, rname, gender, tel,regdate, available);
                readerList.add(item);
            }
            System.out.println(readerList);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return readerList;
    }

    @Override
    public boolean insertOne(Reader reader) {
        String sql =
                "insert into tb_reader (readerid,rname,gender,tel,regdate,available) values (0, ?,?,?,?,?)";
        try(
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, reader.getRname());
            ps.setString(2, reader.getGender());
            ps.setString(3,reader.getTel());
            java.sql.Date regdate = new java.sql.Date(reader.getRegdate().getTime());
            ps.setDate(4, regdate);
            ps.setInt(5,reader.getAvailable());
            int result = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.first()){
                long id = generatedKeys.getLong(1);
                reader.setReaderid(id);
            }
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOne(Reader reader) {
        return deleteById(reader.getReaderid());
    }

    @Override
    public boolean updateOne(Reader reader) {
        String sql =
                "update tb_reader set rname=?,gender=?,tel=?,regdate=?,available=? where readerid=?";
        try(
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, reader.getRname());
            ps.setString(2, reader.getGender());
            ps.setString(3,reader.getTel());
            java.sql.Date regdate = new java.sql.Date(reader.getRegdate().getTime());
            ps.setDate(4, regdate);
            ps.setInt(5,reader.getAvailable());
            ps.setLong(6,reader.getReaderid());
            int result = ps.executeUpdate();
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        String sql = "delete from tb_reader where readerid = ?";
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
    public Reader queryReaderById(long readerid) {
        Reader reader = new Reader();
        String sql = "select * from tb_reader where readerid = ?";
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, readerid);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                reader.setReaderid(resultSet.getLong("readerid"));
                reader.setRname(resultSet.getString("rname"));
                reader.setGender(resultSet.getString("gender"));
                reader.setTel(resultSet.getString("tel"));
                reader.setRegdate(resultSet.getDate("regdate"));
                reader.setAvailable(resultSet.getInt("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reader;
    }
}
