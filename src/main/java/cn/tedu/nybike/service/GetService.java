package cn.tedu.nybike.service;


import cn.tedu.nybike.po.vo.GenderCountVo;

import java.sql.SQLException;
import java.util.List;

public interface GetService {
    public GenderCountVo getGenderCount() throws SQLException;

}
