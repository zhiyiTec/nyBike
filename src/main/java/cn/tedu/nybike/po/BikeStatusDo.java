package cn.tedu.nybike.po;

import java.io.Serializable;

public class BikeStatusDo implements Serializable {

    private Integer id;
    private Integer station_id;
    private Integer num_bikes_available;
    private Integer num_bikes_disabled ;
    private Integer num_docks_available;
    private Integer num_docks_disabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public Integer getNum_bikes_available() {
        return num_bikes_available;
    }

    public void setNum_bikes_available(Integer num_bikes_available) {
        this.num_bikes_available = num_bikes_available;
    }

    public Integer getNum_bikes_disabled() {
        return num_bikes_disabled;
    }

    public void setNum_bikes_disabled(Integer num_bikes_disabled) {
        this.num_bikes_disabled = num_bikes_disabled;
    }

    public Integer getNum_docks_available() {
        return num_docks_available;
    }

    public void setNum_docks_available(Integer num_docks_available) {
        this.num_docks_available = num_docks_available;
    }

    public Integer getNum_docks_disabled() {
        return num_docks_disabled;
    }

    public void setNum_docks_disabled(Integer num_docks_disabled) {
        this.num_docks_disabled = num_docks_disabled;
    }

    @Override
    public String toString() {
        return "BikeStatusDo{" +
                "id=" + id +
                ", station_id=" + station_id +
                ", num_bikes_available=" + num_bikes_available +
                ", num_bikes_disabled=" + num_bikes_disabled +
                ", num_docks_available=" + num_docks_available +
                ", num_docks_disabled=" + num_docks_disabled +
                '}';
    }
}
