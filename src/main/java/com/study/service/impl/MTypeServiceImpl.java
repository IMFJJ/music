package com.study.service.impl;

import com.study.mapper.MTypeMapper;
import com.study.model.MLanguages;
import com.study.model.MType;
import com.study.service.MTypeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MTypeServiceImpl implements MTypeService {
    @Resource
    MTypeMapper mTypeMapper;
    @Override
    public List<MType> findList() {
        Example example = new Example(MType.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("id","name");
        example.orderBy("createTime");
        criteria.andEqualTo("status",1);
        return mTypeMapper.selectByExample(example);
    }
}
