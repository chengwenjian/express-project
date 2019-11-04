package com.aaa.mapper;

import com.aaa.entity.Branch;
import com.aaa.entity.Expressdetails;
import com.aaa.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ExpressdetailsMapper extends MyMapper<Expressdetails> {

    //根据订单编号或者姓名或者电话查询所有结果
    public List<Map> expressdetailsList(Map<String, Object> map);
    //查询总条数
    public int selectCount(Expressdetails expressdetails);

    //根据订单编号
    public List<Expressdetails> updateList(Expressdetails expressdetails);
}
