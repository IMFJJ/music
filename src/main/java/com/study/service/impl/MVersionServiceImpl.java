package com.study.service.impl;

import com.study.mapper.MVersionMapper;
import com.study.model.MType;
import com.study.model.MVersion;
import com.study.service.MVersionService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MVersionServiceImpl implements MVersionService {
    @Resource
    MVersionMapper mVersionMapper;
    @Override
    public List<MVersion> findList() {
        Example example = new Example(MVersion.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("id","name");
        example.orderBy("createTime");
        criteria.andEqualTo("status",1);
        return mVersionMapper.selectByExample(example);
    }
}
