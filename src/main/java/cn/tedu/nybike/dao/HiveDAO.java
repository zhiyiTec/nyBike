package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import cn.tedu.nybike.pojo.*;
import cn.tedu.utils.HiveDBUtil;

public class HiveDAO {

    // 添加一方法，从hive中查询tb_gender-count表的全部数据，并输出在控制台
    public List<GenderCountDO> listGenderCount() {
        List<GenderCountDO> list = new ArrayList<>();
        String sql = "select * from tb_gender_count";
        try (Connection conn = HiveDBUtil.getHiveConn(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GenderCountDO gc = new GenderCountDO();
                gc.setStartDate(rs.getDate("start_date"));
                gc.setGender(rs.getInt("gender"));
                gc.setNum(rs.getInt("num"));
                list.add(gc);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    // 添加一方法，从hive中查询tb_ageStage_count表的全部数据，并输出在控制台
    public List<AgeStageCountDo> listAgeStageCount() {
        List<AgeStageCountDo> list = new ArrayList<>();
        String sql = "select * from tb_agestage_count";
        try (Connection conn = HiveDBUtil.getHiveConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AgeStageCountDo ac = new AgeStageCountDo();
                ac.setBirthYear(rs.getInt("birth_year"));
                ac.setCount(rs.getInt("num"));
                ac.setStarttime(rs.getDate("starttime"));

                list.add(ac);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将年龄段以及对应的数量获取
     */
    public List<AgeStageNumDo> getAgeStageNum (){
        HiveDAO hiveDAO = new HiveDAO();
        List<AgeStageCountDo> ageStageCountDoList = hiveDAO.listAgeStageCount();

        Calendar cale = Calendar.getInstance();
        ;
        int year = cale.get(Calendar.YEAR);
        int data[] = new int[4];


        for (AgeStageCountDo a : ageStageCountDoList) {
            Integer number = a.getCount();
            Integer birthYear = a.getBirthYear();
            Integer age = year - birthYear;
            GCItem gcItem = new GCItem();
            if (age > 12 && age <= 18) {data[0]+=a.getCount();}
            if (age > 18 && age <= 30) {data[1]+=a.getCount();}
            if (age > 30 && age <= 50) {data[2]+=a.getCount();}
            if (age > 50) {data[3]+=a.getCount();data[3]++;}
        }

        List<AgeStageNumDo> ageStageNumDos = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            AgeStageNumDo ageStageNumDo = new AgeStageNumDo();
            ageStageNumDo.setAge(i);
            ageStageNumDo.setNum(data[i]);
            ageStageNumDos.add(ageStageNumDo);
        }

        return ageStageNumDos;
    }

    /**
     * 获取不同的用户类型骑行情况
     * @return
     */
    public List<UserTypeCountDo> getUserTypeCount() {
        List<UserTypeCountDo> list = new ArrayList<>();
        String sql = "select * from  tb_usertype_count";
        try (Connection conn = HiveDBUtil.getHiveConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserTypeCountDo ac = new UserTypeCountDo();
                ac.setNum(rs.getInt("num"));
                ac.setType(rs.getString("type"));

                list.add(ac);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取骑行者的骑行时长及其数量
     * @return
     */
    public List<DurationCountDo> getDurationCount() {
        List<DurationCountDo> list = new ArrayList<>();
        String sql = "select * from  tb_duration_count";
        try (Connection conn = HiveDBUtil.getHiveConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DurationCountDo ac = new DurationCountDo();
                ac.setStartime(rs.getDate("startime"));
                ac.setTime(rs.getInt("time"));
                ac.setNum(rs.getInt("num"));
                list.add(ac);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取不同时间段对应的数量
     * @return
     */
    public List<DurationNumDo> getDurationNumDo (){
        HiveDAO hiveDAO = new HiveDAO();
        List<DurationCountDo> durationCountDos = hiveDAO.getDurationCount();

        int data[] = new int[4];

        for (DurationCountDo a : durationCountDos) {
            Double minte=Double.valueOf(a.getTime()/60);
            if (minte<=15) {data[0]+=a.getNum();}
            if (minte>15&&minte<=60) {data[1]+=a.getNum();}
            if (minte>60) {data[2]+=a.getNum();}

        }

        List<DurationNumDo> durationNumDos = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            DurationNumDo durationNumDo = new DurationNumDo();
            durationNumDo.setType(i);
            durationNumDo.setNumber(data[i]);
            durationNumDos.add(durationNumDo);
        }

        return durationNumDos;
    }






//    made by 陈辉

    // ?????????????hive?в??tb_gender-count???????????
    public List<BrokenBikeDO> listBrokenBike() {
        List<BrokenBikeDO> list = new ArrayList<>();
        String sql = "select * from tb_broken_bike";
        try (Connection conn = HiveDBUtil.getHiveConn(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BrokenBikeDO bb = new BrokenBikeDO();
                bb.setData(rs.getDate("data"));
                bb.setBikeid(rs.getInt("bikeid"));
                bb.setStation_name(rs.getString("station_name"));
                list.add(bb);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    // ?????????????hive?в??tb_genderavg_time???????????
    public List<GenderAvgTimeDO> listGenderAvgTime() {
        List<GenderAvgTimeDO> list = new ArrayList<>();
        String sql = "select * from tb_genderavg_time";
        try (Connection conn = HiveDBUtil.getHiveConn(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GenderAvgTimeDO gat = new GenderAvgTimeDO();
                gat.setData(rs.getDate("data"));
                gat.setGender(rs.getInt("gender"));
                gat.setAvg_time(rs.getDouble("avg_time"));
                list.add(gat);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }
}
