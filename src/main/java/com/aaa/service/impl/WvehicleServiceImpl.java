package com.aaa.service.impl;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.WstaffdetailsVO;
import com.aaa.entity.WvehicleVO;
import com.aaa.mapper.WvehicleMapper;
import com.aaa.service.WvehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class WvehicleServiceImpl extends BaseService<WvehicleVO> implements WvehicleService {
    @Resource
    private WvehicleMapper wvehicleMapper;


    @Override
    public List<Map> findCar(BaseQuery baseQuery, WvehicleVO wvehicleVO) {
        int begin=baseQuery.getLimit()*(baseQuery.getPage()-1);
        int end=baseQuery.getLimit()*baseQuery.getPage();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("begin", begin);
        map.put("end", end);

        map.put("vehdirver",wvehicleVO.getVehdirver());
        return wvehicleMapper.findCar(map);
    }

    @Override
    public int selectCount(WvehicleVO wvehicleVO) {
        return wvehicleMapper.selectCount(wvehicleVO);
    }

    @Override
    public String selTruename(WstaffdetailsVO wstaffdetailsVO) {
        return wvehicleMapper.selTruename(wstaffdetailsVO);
    }

    @Override
    public String selBraname(WstaffdetailsVO wstaffdetailsVO) {
        return wvehicleMapper.selBraname(wstaffdetailsVO);
    }

    @Override
    public List<WstaffdetailsVO> selBranameTwo(WstaffdetailsVO wstaffdetailsVO) {
        return wvehicleMapper.selBranameTwo(wstaffdetailsVO);
    }

    @Override
    public int selBraid(WvehicleVO wvehicleVO) {
        return wvehicleMapper.selBraid(wvehicleVO);
    }

    @Override
    public int insertCar(WvehicleVO wvehicleVO) {
        return wvehicleMapper.insertCar(wvehicleVO);
    }

    @Override
    public int delCar(WvehicleVO wvehicleVO) {
        return wvehicleMapper.delCar(wvehicleVO);
    }

    @Override
    public List<WvehicleVO> selCar(WvehicleVO wvehicleVO) {
        return wvehicleMapper.selCar(wvehicleVO);
    }

    @Override
    public int updateCar(WvehicleVO wvehicleVO) {
        return wvehicleMapper.updateCar(wvehicleVO);
    }

    @Override
    public List<WvehicleVO> selType() {
        return wvehicleMapper.selType();
    }
}
