package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.Album;
import com.study.model.User;
import com.study.service.AlbumService;
import javafx.beans.DefaultProperty;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    @RequestMapping
    @ResponseBody
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


    @RequestMapping(value = "/edit")
    public String edit( Integer id, Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (null == user) {
            return "error";
        }
        if (null == id || id == 0) {
            return "error";
        }
        // 查询专辑以及歌曲信息
       // Album album = albumService.findDetailById(id);
       // model.addAttribute("album", album);
        return "album/edit";
    }
}
