package com.aaa.service;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.Express;

import java.util.List;
import java.util.Map;

public interface ExpressService {
    public List<Map> expressList(BaseQuery baseQuery,Express express);
    //查询总条数
    public int selectCount(Express express);
    //修改查询
    public List<Express> updateSelect(Express express);
    //修改
    public int update(Express express);
}
