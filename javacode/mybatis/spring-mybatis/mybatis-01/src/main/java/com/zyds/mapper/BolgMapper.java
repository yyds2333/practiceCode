package com.zyds.mapper;

import com.zyds.pojo.Bolg;

import java.util.List;
import java.util.Map;

public interface BolgMapper {
    //添加Bolg
    int addBolg(Map map);
    //查询Bolg
    List<Bolg> getBolgIf(Map map);

}
