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
            String name = gc.getGender() == 0 ? "δ֪" : gc.getGender() == 1 ? "��" : "Ů";
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
            if (age == 0) gcItem.setName("����");
            if (age == 1) gcItem.setName("����");
            if (age == 2) gcItem.setName("׳��");
            if (age == 3) gcItem.setName("������");
            gcItem.setValue(a.getNum());
            gcil.add(gcItem);
        }
        ageStageCountVO.setData(gcil);
        return ageStageCountVO;
    }

    /**
     * ��ȡ��ͬ��������������ͳ��
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
	 * ��ȡ��ͬ����ʱ����ͳ��
	 * @return
	 */
    public DurationCountVo getDurationCountVo() {
        List<DurationNumDo> durationNumDos = dao.getDurationNumDo();
        List<GCItem> gcil = new LinkedList<>();
        DurationCountVo durationCountVo = new DurationCountVo();

        for (DurationNumDo a : durationNumDos) {

            GCItem gcItem = new GCItem();
            if (a.getType() == 0) {
                gcItem.setName("����ʱ��С��15����");
            }
            if (a.getType() == 1) {
                gcItem.setName("����ʱ����15���Ӻ�60����֮��");
            }
            if (a.getType() == 2) {
                gcItem.setName("����ʱ��60��������");
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
            String sex = gat.getGender() == 0 ? "δ֪" : gat.getGender() == 1 ? "��" : "Ů";
            item.setGender(sex);;
            item.setAvg_time(gat.getAvg_time());
            data.add(item);
        }
        vo.setData(data);
        return vo;
    }
}
