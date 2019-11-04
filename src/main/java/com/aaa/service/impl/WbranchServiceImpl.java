package com.aaa.service.impl;


import com.aaa.entity.Branch;
import com.aaa.entity.TuserTwo;
import com.aaa.entity.Wbranch;
import com.aaa.mapper.TuserTwoMapper;
import com.aaa.mapper.WbranchMapper;
import com.aaa.service.TuserTwoService;
import com.aaa.service.WbranchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class WbranchServiceImpl extends BaseService<Wbranch> implements WbranchService {
    @Resource
    private WbranchMapper wbranchMapper;
    @Override
    public List<Wbranch> findBranch() {
        return wbranchMapper.findBranch();
    }
}
