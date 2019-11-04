package com.aaa.mapper;

import com.aaa.entity.Branch;
import com.aaa.entity.Tuser;
import com.aaa.entity.TuserTwo;
import com.aaa.util.MyMapper;

import java.util.List;

public interface TuserMapper extends MyMapper<Tuser> {
    Tuser selectall();

}