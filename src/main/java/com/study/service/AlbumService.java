package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.model.Album;

import java.util.List;

public interface AlbumService extends IService<Album> {
    //获取合辑分页列表
    List<Album> findByPage();
    //获取合辑总数
   Integer findAllCount();
   /**
    * @Description: 根据id获取专辑以及歌曲详细信息
    * @author JJ
    * @date 2019/3/13 8:43
   */
   Album findDetailById(Integer id);
}
