package com.aaa.service;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.Expressdetails;

import java.util.List;
import java.util.Map;

public interface ExpressdetailsService {
    //根据订单编号或者姓名或者电话查询所有结果
    public List<Map> expressdetailsList(BaseQuery baseQuery,Expressdetails expressdetails);
    //查询总条数
    public int selectCount(Expressdetails expressdetails);

    //根据订单编号
    public List<Expressdetails> updateList(Expressdetails expressdetails);
}
