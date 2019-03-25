package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.study.model.MMusic;
import com.study.service.MMusicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/music")
public class MusicController extends BasicController{
    @Resource
    MMusicService mMusicService;
    @RequestMapping("/getAllByAblumId")
    @ResponseBody
    public Map<String,Object> getAllByAblumId(Integer ablumId, Integer size, Integer limit){
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(size==null?1:size, limit == null ?10: limit);
        List<MMusic> albumList = mMusicService.findList(ablumId);
        jsonObject.put("count", mMusicService.findList(ablumId).size());
        jsonObject.put("data", albumList);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "success");
        return jsonObject;
    }
}
