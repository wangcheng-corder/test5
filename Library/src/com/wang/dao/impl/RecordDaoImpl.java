package com.wang.dao.impl;

import com.wang.dao.RecordDao;
import com.wang.pojo.Record;
import com.wang.utils.JdbcUtils;

import java.sql.*;

public class RecordDaoImpl implements RecordDao {
    @Override
    public boolean insertOne(Record record) {
        String sql =
                "insert into tb_record (recordid,bid,rid,lenddate) values (0, ?,?,?)";
        try(
                //2.通过DriverManager获取数据库连接对象
                Connection connection = JdbcUtils.getConnection();
                //3.通过数据库连接对象创建PreparedStatement
                //Statement.RETURN_GENERATED_KEYS表示我需要在插入成功以后获取自增id
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            //给各个?占位符的地方进行赋值
            ps.setLong(1, record.getBid());
            ps.setLong(2, record.getRid());
            java.sql.Date lenddate = new java.sql.Date(record.getLenddate().getTime());
            ps.setDate(3,lenddate);
            //4.使用statement对象执行数据更新操作
            int result = ps.executeUpdate();
            //通过PreparedStatement获取产生出来的自增id值
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.first()){
                long id = generatedKeys.getLong(1);
                record.setRecordid(id);
            }
            //定义插入一行数据为成功
            return result > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int updataRecordByBookAndReaderid(long bookid, long readerid) {
        String sql =
                "update tb_record set backdate=? where bid=?&&rid=? and backdate=null";
        try(
                //2.通过DriverManager获取数据库连接对象
                Connection connection = JdbcUtils.getConnection();
                //3.通过数据库连接对象创建PreparedStatement
                //Statement.RETURN_GENERATED_KEYS表示我需要在插入成功以后获取自增id
                PreparedStatement ps = connection.prepareStatement(sql/*, Statement.RETURN_GENERATED_KEYS*/);
        ){
            //给各个?占位符的地方进行赋值
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
//            java.sql.Date backdate = new java.sql.Date();
            ps.setDate(1,date);
            ps.setLong(2,bookid);
            ps.setLong(3,readerid);
            int result = ps.executeUpdate();
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
