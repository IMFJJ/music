package com.study.service.impl;

import com.study.mapper.MLanguagesMapper;
import com.study.model.MLanguages;
import com.study.service.MLanguagesService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;

@Service
public class MLanguagesServiceImpl implements MLanguagesService {
    @Resource
    MLanguagesMapper mLanguagesMapper;
    @Override
    public List<MLanguages> findList() {
        Example example = new Example(MLanguages.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("id","name");
        example.orderBy("createTime");
        criteria.andEqualTo("status",1);
        return mLanguagesMapper.selectByExample(example);
    }
}
