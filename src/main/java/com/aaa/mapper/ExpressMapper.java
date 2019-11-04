package com.aaa.mapper;

import com.aaa.entity.Express;
import com.aaa.entity.Offer;
import com.aaa.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExpressMapper extends MyMapper<Express> {
    public List<Map> expressList(Map<String, Object> map);
    //查询总条数
    public int selectCount(Express express);
    //修改查询
    public List<Express> updateSelect(Express express);
    //修改
    public int update(Express express);
}
