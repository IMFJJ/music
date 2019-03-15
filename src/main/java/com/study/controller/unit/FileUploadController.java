package com.study.controller.unit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import com.study.consts.EnumConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value = "/api/upload")
public class FileUploadController {
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
	// 专辑音频的目录
	@Value("${album.audio.fileDir}")
	private String audioFileDir;
	// 专辑音频的访问目录
	@Value("${album.audio.fileStr}")
	private String audioFileStr;
	// 当前域名
	@Value("${MUSIC.INDEX_CHILD}")
	private String host;
	/**
	 * yidian bug收集传图
	 *
	 * @author lidz
	 * @time 2018年7月3日 上午12:01:59
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/upload/audio", method = RequestMethod.POST)
	public @ResponseBody JSONObject collectBugImg(String imgdata,String suffix) {
		JSONObject json = new JSONObject();
		if (imgdata == null) {
			return json;
		}
		log.info("[文件上传（fileUploadPicture）][params:imgdata=" + log + "]");
		// 创建输出流
		FileOutputStream outputStream = null;
		try {
			// 如果目录不存在，自动创建文件夹
			File dir = new File(audioFileDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if(suffix==null || "".equals(suffix)){
				return json;
			}
			// 上传文件名+后缀名
			String filename = UUID.randomUUID() + suffix;
			// 完整路径
			String imgPath = audioFileStr + filename ;
			// new一个文件对象用来保存图片
			File imageFile = new File(imgPath);
			// 创建输出流
			outputStream = new FileOutputStream(imageFile);
			// 获得一个图片文件流，我这里是从flex中传过来的
			byte[] result=Base64.getDecoder().decode(imgdata.split(",")[1]);// 解码
			for (int i = 0; i < result.length; ++i) {
				if (result[i] < 0) {// 调整异常数据
					result[i] += 256;
				}
			}
			outputStream.write(result);
			json.put("code", EnumConst.RetCode.SUCCESS.getCode());
			json.put("path",host+audioFileStr+filename);
			return json;
		} catch (Exception e) {
			log.error("[文件上传（fileUpload）][errors:" + e + "]");
			return json;
		} finally {
			try {
				outputStream.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
