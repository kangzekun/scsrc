package com.kzk.scsrc.upload.util;

import java.text.NumberFormat;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * 文件进度监听器
 * */
public class FileProcessListener implements ProgressListener {

	/** 日志对象*/
	private Log logger = LogFactory.getLog(this.getClass());

	private HttpSession session;

	public FileProcessListener() {
		super();
	}

	public FileProcessListener(HttpSession session) {
		super();
        this.session=session;  
		this.session.removeAttribute("fileUploadProcess");
	}

	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		// TODO Auto-generated method stub
		double readByte = pBytesRead;
		double totalSize = pContentLength;
		if(pContentLength == -1) {
			logger.debug("item index[" + pItems + "] " + pBytesRead + " bytes have been read.");
		} else {
			logger.debug("item index[" + pItems + "] " + pBytesRead + " of " + pContentLength + " bytes have been read.");
			String p = NumberFormat.getPercentInstance().format(readByte / totalSize);
			session.setAttribute("fileUploadProcess", p);
		}
	}

}
