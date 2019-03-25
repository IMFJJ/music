package com.study.service.impl;

import com.study.mapper.MMusicMapper;
import com.study.model.MMusic;
import com.study.service.MMusicService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MMusicServiceImpl implements MMusicService {
    @Resource
    MMusicMapper mMusicMapper;
    @Override
    public List<MMusic> findList(Integer ablumId) {
        Example example = new Example(MMusic.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("id","name","singer","author","Composer","type","status","public_time");
        example.orderBy("updateTime");
        criteria.andEqualTo("status",1);
        criteria.andEqualTo("albumId",ablumId);
        return mMusicMapper.selectByExample(example);
    }
}
