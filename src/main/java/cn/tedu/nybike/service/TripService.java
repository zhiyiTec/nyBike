package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.dao.HiveDAO;
import cn.tedu.nybike.pojo.*;

public class TripService {

    private HiveDAO dao = new HiveDAO();

    public GenderCountVO findGenderCount() {
        List<GenderCountDO> list = dao.listGenderCount();
        GenderCountVO vo = new GenderCountVO();
        List<GCItem> data = new ArrayList<GCItem>(list.size());
        for (GenderCountDO gc : list) {
            GCItem item = new GCItem();
            item.setValue(gc.getNum());
            String name = gc.getGender() == 0 ? "未知" : gc.getGender() == 1 ? "男" : "女";
            item.setName(name);
            data.add(item);
        }
        vo.setData(data);
        return vo;
    }

    public AgeStageCountVO getAgeStage() {

        List<AgeStageNumDo> ageStageNumDos = dao.getAgeStageNum();
        List<GCItem> gcil = new LinkedList<>();
        AgeStageCountVO ageStageCountVO = new AgeStageCountVO();

        for (AgeStageNumDo a : ageStageNumDos) {

            Integer number = a.getNum();
            Integer age = a.getAge();

            GCItem gcItem = new GCItem();
            if (age == 0) gcItem.setName("少年");
            if (age == 1) gcItem.setName("青年");
            if (age == 2) gcItem.setName("壮年");
            if (age == 3) gcItem.setName("中老年");
            gcItem.setValue(a.getNum());
            gcil.add(gcItem);
        }
        ageStageCountVO.setData(gcil);
        return ageStageCountVO;
    }

    /**
     * 获取不同类型骑行者数量统计
     *
     * @return
     */
    public UserTypeCountVo getUserTypeCount() {

        List<UserTypeCountDo> userTypeCountDos = dao.getUserTypeCount();
        List<GCItem> gcil = new LinkedList<>();
        UserTypeCountVo userTypeCountVo = new UserTypeCountVo();

        for (UserTypeCountDo a : userTypeCountDos) {

            GCItem gcItem = new GCItem();
            gcItem.setName(a.getType());
            gcItem.setValue(a.getNum());
            gcil.add(gcItem);
        }
        userTypeCountVo.setData(gcil);
        return userTypeCountVo;
    }

	/**
	 * 获取不同骑行时长的统计
	 * @return
	 */
    public DurationCountVo getDurationCountVo() {
        List<DurationNumDo> durationNumDos = dao.getDurationNumDo();
        List<GCItem> gcil = new LinkedList<>();
        DurationCountVo durationCountVo = new DurationCountVo();

        for (DurationNumDo a : durationNumDos) {

            GCItem gcItem = new GCItem();
            if (a.getType() == 0) {
                gcItem.setName("骑行时长小于15分钟");
            }
            if (a.getType() == 1) {
                gcItem.setName("骑行时长在15分钟和60分钟之间");
            }
            if (a.getType() == 2) {
                gcItem.setName("骑行时长60分钟以上");
            }

            gcItem.setValue(a.getNumber());
            gcil.add(gcItem);
        }
        durationCountVo.setData(gcil);
        return durationCountVo;
    }





    public BrokenBikeVO findBrokenBike() {
        List<BrokenBikeDO> list = dao.listBrokenBike();
        BrokenBikeVO vo = new BrokenBikeVO();
        List<BBItem> data = new ArrayList<BBItem>(list.size());
        for (BrokenBikeDO bb : list) {
            BBItem item = new BBItem();
            item.setData(bb.getData());;
            item.setBikeid(bb.getBikeid());
            item.setStation_name(bb.getStation_name());
            data.add(item);
        }
        vo.setData(data);
        return vo;
    }

    public GenderAvgTimeVO findGenderAvgTime() {
        List<GenderAvgTimeDO> list = dao.listGenderAvgTime();
        GenderAvgTimeVO vo = new GenderAvgTimeVO();
        List<GATItem> data = new ArrayList<GATItem>(list.size());
        for (GenderAvgTimeDO gat : list) {
            GATItem item = new GATItem();
            item.setData(gat.getData());
            String sex = gat.getGender() == 0 ? "未知" : gat.getGender() == 1 ? "男" : "女";
            item.setGender(sex);;
            item.setAvg_time(gat.getAvg_time());
            data.add(item);
        }
        vo.setData(data);
        return vo;
    }
}
