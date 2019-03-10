package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.Album;
import com.study.model.User;
import com.study.service.AlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    @RequestMapping
    public Map<String,Object> getAll(Album album, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        JSONObject jsonObject = new JSONObject();
        PageInfo<Album> pageInfo = albumService.selectByPage(album, start, length);
        jsonObject.put("count", pageInfo.getTotal());
        jsonObject.put("data", pageInfo.getList());
        jsonObject.put("code", 0);
        jsonObject.put("msg", "success");
        return jsonObject;
    }
}
