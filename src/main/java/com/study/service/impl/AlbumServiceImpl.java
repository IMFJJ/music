package com.study.service.impl;

import com.study.mapper.AlbumMapper;
import com.study.model.Album;
import com.study.service.AlbumService;
import org.springframework.stereotype.Service;

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
    public Album findDetailById(Integer id) {
        return albumMapper.selectDetailById(id) ;
    }

    @Override
    public Album findById(Integer id) {
        return albumMapper.selectById( id);
    }

    @Override
    public Integer  saveOrUpdate(Album album) {
        if(album.getId()==null){
           return albumMapper.insert(album);
        }else {
           return albumMapper.updateByPrimaryKey(album);
        }
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
