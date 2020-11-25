package com.wang.pojo;

import java.util.Date;

public class Reader {
    private  long readerid;
    private String rname;
    private  String gender;
    private  String tel;
    private Date regdate;
    private int available;

    public Reader() {
    }

    public Reader(long readerid, String rname, String gender, String tel, Date regdate, int available) {
        this.readerid = readerid;
        this.rname = rname;
        this.gender = gender;
        this.tel = tel;
        this.regdate = regdate;
        this.available = available;
    }

    public long getReaderid() {
        return readerid;
    }

    public void setReaderid(long readerid) {
        this.readerid = readerid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerid=" + readerid +
                ", rname='" + rname + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", regdate=" + regdate +
                ", available=" + available +
                '}';
    }
}
