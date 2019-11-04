package com.aaa.mapper;

import com.aaa.entity.Branch;

import com.aaa.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WbranchMapper extends MyMapper<Branch> {
    public List<Branch> findBranch();


}
