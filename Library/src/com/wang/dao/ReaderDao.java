package com.wang.dao;

import com.wang.pojo.Reader;

import java.util.List;

public interface ReaderDao {
    List<Reader> queryAll(); //获取全部HqUser数据
    boolean insertOne(Reader reader); //增加一个HqUser数据
    boolean deleteOne(Reader reader); //删除一个HqUser数据
    boolean updateOne(Reader reader);// 更新一个HqUser的数据
    boolean deleteById(long id); //通过id来删除一个HqUser的数据
    Reader queryReaderById(long readerid);
}
