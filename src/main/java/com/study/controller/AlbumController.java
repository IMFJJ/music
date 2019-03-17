package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.study.model.*;
import com.study.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    @Resource
    MLanguagesService mLanguagesService;
    @Resource
    MTypeService mTypeService;
    @Resource
    MStyleService mStyleService;
    @Resource
    MVersionService mVersionService;
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

        //语言
        List<MLanguages> languagesList=mLanguagesService.findList();
        //类型
        List<MType> typeList=mTypeService.findList();
        //风格
        List<MStyle> styleList=mStyleService.findList();
        //版本
        List<MVersion> versionList=mVersionService.findList();

       // Album album = albumService.findDetailById(id);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("styleList", styleList);
        model.addAttribute("versionList", versionList);
        return "album/edit";
    }
}
