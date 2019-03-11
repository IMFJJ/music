package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Album;

import java.util.List;

public interface AlbumService extends IService<Album> {
    //获取合辑分页列表
    List<Album> findByPage();
    //获取合辑总数
   Integer findAllCount();
}
