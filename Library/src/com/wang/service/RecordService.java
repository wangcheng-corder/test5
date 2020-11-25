package com.wang.service;

public interface RecordService {
    void Borrow(long readerid,long bookid);//借书
    void Baack(long readerid,long bookid);//还书
}
