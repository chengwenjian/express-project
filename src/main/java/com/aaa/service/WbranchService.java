package com.aaa.service;



import com.aaa.entity.Branch;
import com.aaa.entity.TuserTwo;
import com.aaa.entity.Wbranch;

import java.util.List;

public interface WbranchService extends IService<Wbranch>{
    public List<Wbranch> findBranch();
}
