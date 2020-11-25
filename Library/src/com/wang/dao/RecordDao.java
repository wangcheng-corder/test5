package com.wang.dao;

import com.wang.pojo.Record;

public interface RecordDao {
    boolean insertOne(Record record);

    int updataRecordByBookAndReaderid(long bookid, long readerid);
}
