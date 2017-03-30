package com.kzk.scsrc.upload.controller;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kzk.scsrc.upload.entity.State;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.kzk.scsrc.upload.util.HdfsUtil;

@Controller
@RequestMapping(value = "/hdfs")
public class UploadController {

	private Log logger = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;

	//上传到HDFS的文件路径
	private String uploadFilePath;
	//上传文件大小
	private long uploadFileSize;
	//上传文件的类型
	private String uploadFileType;
	//保存到本地的文件名称
	private String uploadFileName;
	//服务器上的文件夹名称
	private String uploadFolderName = "uploadFiles";
	//HDFS URI
	private String hdfsURI = "hdfs://10.10.10.47:9000/home/chenyf/sjl/kzk";

    private InputStream in=null;
	

	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public  @ResponseBody Map<String,Object> fileUpload(@RequestParam("files") CommonsMultipartFile files[],
			HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//循环上传文件到HDFS
        for(int i=0;i<files.length;i++) {

            FileItem fileItem=files[i].getFileItem();
            uploadFileName=fileItem.getName();
            uploadFileSize=fileItem.getSize();
            uploadFileType=fileItem.getContentType();
            // 使用工具类上传
            HdfsUtil hdfsUtil = new HdfsUtil(hdfsURI);
            //获取文件流
            hdfsUtil.putFiles(files[i].getInputStream(),uploadFileName, hdfsURI);

        }
        return State.OK.toMap();
}
}
