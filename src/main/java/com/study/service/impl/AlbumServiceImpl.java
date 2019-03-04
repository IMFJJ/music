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
    public PageInfo<Album> selectByPage(Album album, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("status",0);
        //分页查询
        PageHelper.startPage(page, length);
        List<Album> albumList = selectByExample(example);
        return new PageInfo<>(albumList);
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
