package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.mapper.AlbumMapper;
import com.study.model.Album;
import com.study.service.AlbumService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AlbumServiceImpl extends BaseService<Album> implements AlbumService {
    @Resource
    AlbumMapper albumMapper;

    @Override
    public List<Album> findByPage() {
        return albumMapper.selectByPage();
    }

    @Override
    public Integer findAllCount() {
        return albumMapper.selectAllCount();
    }

    @Override
    public int save(Album entity) {
        return 0;
    }

    @Override
    public int updateAll(Album entity) {
        return 0;
    }

    @Override
    public int updateNotNull(Album entity) {
        return 0;
    }
}
