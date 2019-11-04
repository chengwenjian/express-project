package com.aaa.service;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.Branch;
import com.aaa.entity.Tuser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BranchService {
    List<Map> branchList(BaseQuery baseQuery, Branch branch);
    //查询总条数
    public int selectCount(Branch branch);
    //提交添加网点
    public int insertBranch(Branch branch);
    //根据网点编号
    public List<Branch> updateList(Branch branch);
    //修改网点信息
    public int update(Branch branch);
    //点击删除
    public int del(Branch branch);
}
