package com.study.service.impl;

import com.study.mapper.MStyleMapper;
import com.study.model.MStyle;
import com.study.model.MType;
import com.study.service.MStyleService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MStyleServiceImpl implements MStyleService {
    @Resource
    MStyleMapper mStyleMapper;
    @Override
    public List<MStyle> findList() {
        Example example = new Example(MStyle.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("id","name");
        example.orderBy("createTime");
        criteria.andEqualTo("status",1);
        return mStyleMapper.selectByExample(example);
    }
}
