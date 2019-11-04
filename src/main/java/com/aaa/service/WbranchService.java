package com.aaa.service;



import com.aaa.entity.Branch;
import com.aaa.entity.TuserTwo;

import java.util.List;

public interface WbranchService extends IService<Branch>{
    public List<Branch> findBranch();
}
