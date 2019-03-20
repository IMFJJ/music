package com.study.mapper;

import com.study.model.Album;
import com.study.util.MyMapper;

import java.util.List;

public interface AlbumMapper extends MyMapper<Album> {
    public List<Album> selectByPage();
    public Integer selectAllCount();
    public Album selectDetailById(Integer id);

    public Album selectById(Integer id);

}