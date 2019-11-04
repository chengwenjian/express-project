package com.aaa.service.impl;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.Express;
import com.aaa.entity.Expressdetails;
import com.aaa.mapper.ExpressdetailsMapper;
import com.aaa.service.ExpressService;
import com.aaa.service.ExpressdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ExpressdetailsServiceImpl implements ExpressdetailsService {

    @Autowired
    private ExpressdetailsMapper expressdetailsMapper;
    @Override
    public List<Map> expressdetailsList(BaseQuery baseQuery, Expressdetails expressdetails) {
        int begin=baseQuery.getLimit()*(baseQuery.getPage()-1);
        int end=baseQuery.getLimit()*baseQuery.getPage();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("begin", begin);
        map.put("end", end);
        map.put("expnum", expressdetails.getExpnum());
        map.put("expoper", expressdetails.getExpoper());
        map.put("expoperipone", expressdetails.getExpoperipone());
        return expressdetailsMapper.expressdetailsList(map);
    }

    @Override
    public int selectCount(Expressdetails expressdetails) {
        return expressdetailsMapper.selectCount(expressdetails);
    }

    @Override
    public List<Expressdetails> updateList(Expressdetails expressdetails) {
        return expressdetailsMapper.updateList(expressdetails);
    }
}
