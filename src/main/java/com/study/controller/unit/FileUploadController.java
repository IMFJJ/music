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
import  com.study.util.DateUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/upload")
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
    @RequestMapping(value = "/audio", method = RequestMethod.POST)
    public @ResponseBody JSONObject audio(HttpServletRequest request, MultipartFile file) {
        return upload(file,audioFileDir,audioFileStr);
    }
	/*@RequestMapping(value = "/audio", method = RequestMethod.POST)
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
*/
    private JSONObject upload(MultipartFile file, String FileDir, String FileStr){
        JSONObject json = new JSONObject();
        try {
            String endFile = DateUtil.endFileDir(); // 图片的根目录后面的文件夹目录（XXXX/XX（年月）/X（日））
            String imgSavePath = FileDir + endFile; // 文件完整保存目录
            // 如果目录不存在，自动创建文件夹
            File dir = new File(imgSavePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 文件后缀名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            // 上传文件名
            String filename = UUID.randomUUID() + suffix;
            // 服务器端保存的文件对象
            File serverFile = new File(imgSavePath + filename);
            // 将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);
            // 访问路径
            String path = host + FileStr + endFile + filename;
            json.put("success", true);
            json.put("msg", "上传成功！");
            json.put("file_path", path);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success", false);
            json.put("msg", "上传失败！");
            json.put("file_path", "");
            return json;
        }
    }

}
