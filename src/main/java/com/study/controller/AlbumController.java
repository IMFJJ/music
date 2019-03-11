package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.Album;
import com.study.service.AlbumService;
import javafx.beans.DefaultProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    @RequestMapping
    public Map<String,Object> getAll(Album album,  Integer size, Integer limit){
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(size==null?1:size, limit == null ?10: limit);
        List<Album> albumList = albumService.findByPage();
        jsonObject.put("count", albumService.findAllCount());
        jsonObject.put("data", albumList);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "success");
        return jsonObject;
    }
}
