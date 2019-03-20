package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.consts.EnumConst;
import org.springframework.stereotype.Controller;

@Controller
public class BasicController {
    public Object success(String msg){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",EnumConst.RetCode.SUCCESS.getCode());
        jsonObject.put("msg",msg==null?"成功":msg);
        return jsonObject;
    }

    public Object fail(String msg){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",EnumConst.RetCode.ERROR.getCode());
        jsonObject.put("msg",msg==null?"失败":msg);
        return jsonObject;
    }
}
