package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Album;

public interface AlbumService extends IService<Album> {
    PageInfo<Album> selectByPage(Album album, int start, int length);
}
