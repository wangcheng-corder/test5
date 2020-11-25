package com.wang.pojo;

import java.util.Date;

public class Record {
    private long recordid;
    private long bid;
    private long rid;
    private Date lenddate;
    private Date backdate;
    public Record() {
    }

    public Record(long recordid, long bid, long rid, Date lenddate, Date backdate) {
        this.recordid = recordid;
        this.bid = bid;
        this.rid = rid;
        this.lenddate = lenddate;
        this.backdate = backdate;
    }

    public long getRecordid() {
        return recordid;
    }

    public void setRecordid(long recordid) {
        this.recordid = recordid;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public Date getLenddate() {
        return lenddate;
    }

    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordid=" + recordid +
                ", bid=" + bid +
                ", rid=" + rid +
                ", lenddate=" + lenddate +
                ", backdate=" + backdate +
                '}';
    }
/*    public Record(int recordid, long bid, long rid, Date lenddate, Date backdate) {
        this.recordid = recordid;
        this.bid = bid;
        this.rid = rid;
        this.lenddate = lenddate;
        this.backdate = backdate;
    }*/

/*    public int getRecordid() {
        return recordid;
    }

    public void setRecordid(int recordid) {
        this.recordid = recordid;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public Date getLenddate() {
        return lenddate;
    }

    public void setLenddate(Date lenddate) {
        this.lenddate = lenddate;
    }

    public Date getBackdate() {
        return backdate;
    }

    public void setBackdate(Date backdate) {
        this.backdate = backdate;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordid=" + recordid +
                ", bid=" + bid +
                ", rid=" + rid +
                ", lenddate=" + lenddate +
                ", backdate=" + backdate +
                '}';
    }*/
}
