package com.aaa.mapper;

import com.aaa.entity.Branch;
import com.aaa.entity.Tmenu;
import com.aaa.entity.Tuser;
import com.aaa.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface BranchMapper extends MyMapper<Branch> {

    //根据权限查到自己的下级
    public List<Map> branchList(Map<String, Object> map);
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
