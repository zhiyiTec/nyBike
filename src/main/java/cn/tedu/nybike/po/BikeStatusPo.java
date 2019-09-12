package cn.tedu.nybike.po;

import java.io.Serializable;

public class BikeStatusPo implements Serializable {

    private Integer id;
    private Integer sid;
    private Integer nba;
    private Integer nbd ;
    private Integer nda;
    private Integer ndd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNba() {
        return nba;
    }

    public void setNba(Integer nba) {
        this.nba = nba;
    }

    public Integer getNbd() {
        return nbd;
    }

    public void setNbd(Integer nbd) {
        this.nbd = nbd;
    }

    public Integer getNda() {
        return nda;
    }

    public void setNda(Integer nda) {
        this.nda = nda;
    }

    public Integer getNdd() {
        return ndd;
    }

    public void setNdd(Integer ndd) {
        this.ndd = ndd;
    }
}
