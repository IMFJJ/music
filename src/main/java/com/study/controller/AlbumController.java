package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.study.model.*;
import com.study.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController extends BasicController {
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
        // 查询专辑以及歌曲信息

        //语言
        List<MLanguages> languagesList=mLanguagesService.findList();
        //类型
        List<MType> typeList=mTypeService.findList();
        //风格
        List<MStyle> styleList=mStyleService.findList();
        //版本
        List<MVersion> versionList=mVersionService.findList();

        //专辑信息
        Album album = albumService.findById(id);
        //
        if (album!=null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(album.getPublicTime());
            album.setDateString(dateString);
        }
        model.addAttribute("album", album);
        model.addAttribute("languagesList", languagesList);
        model.addAttribute("typeList", typeList);
        model.addAttribute("styleList", styleList);
        model.addAttribute("versionList", versionList);
        if(album==null){
            return "album/add";
        }else {
            return "album/edit";
        }

    }
    @PostMapping(value = "/sureSave")
    @ResponseBody
    public Object sureSave(Album album) throws ParseException {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user==null){
            return  fail("未登录");
        }
        Album oldAlbum;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (album.getId()==null){
            //添加
            oldAlbum=album;
            oldAlbum.setUserId(user.getId());
            album.setStatus(1);
            album.setCreateTime(new Date());
            album.setUpdateTime(new Date());
            album.setPublicTime(sdf.parse(album.getDateString()));
        }else {
             oldAlbum=albumService.findById(album.getId());
            if(oldAlbum==null){
                return success(null);
            }

            oldAlbum.setPublicTime(sdf.parse(album.getDateString()));
            oldAlbum.setCoverImage(album.getCoverImage());
            oldAlbum.setLanguages(album.getLanguages());
            oldAlbum.setName(album.getName());
            oldAlbum.setStatement(album.getStatement());
            oldAlbum.setStyle(album.getStyle());
            oldAlbum.setType(album.getType());
            oldAlbum.setVersion(album.getVersion());
        }
        Integer res= albumService.saveOrUpdate(oldAlbum);
        if (res>0){
            return  success(null);
        }else {
            return fail("保存失败");
        }
    }


    @RequestMapping(value = "/del")
    @ResponseBody
    public Object del( Integer id) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (null == user) {
            return "error";
        }
        Album oldAlbum=albumService.findById(id);
        if(oldAlbum==null){
            return fail("删除失败");
        }else {
            oldAlbum.setStatus(0);
        }
        if( albumService.saveOrUpdate(oldAlbum)>0){
            return success("删除成功");
        }else {
            return fail("删除失败");
        }
    }
}
