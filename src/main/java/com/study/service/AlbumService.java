package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Album;

import java.util.List;

public interface AlbumService extends IService<Album> {
    PageInfo<Album> selectByPage(Album album, int start, int length);
    List<Album> selectByPage(int start, int length);
}
