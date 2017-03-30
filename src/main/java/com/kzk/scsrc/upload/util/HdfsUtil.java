package com.kzk.scsrc.upload.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;


public class HdfsUtil {

	private String hdfsURI;
	private Configuration con;
	private String hdfsPath;

	public HdfsUtil(String hdfsURI) {
		super();
		this.hdfsURI = hdfsURI;
		this.con=con;
	}

	public HdfsUtil() {
		super();
	}
	

    public void putFiles(InputStream in,String filename, String dst) throws IOException, URISyntaxException {
//        File file = new File(localSrc);
        dst = dst +"/"+ filename;
//        InputStream in=new BufferedInputStream(new FileInputStream(localSrc));
        con=new Configuration();
        FileSystem fs=FileSystem.get(URI.create(dst), con);
        OutputStream out=fs.create(new Path(dst));
        IOUtils.copyBytes(in, out, 4096, true);
        in.close();
    }

    public void catFiles() throws IOException, URISyntaxException {
		con=new Configuration();
		FileSystem fs=FileSystem.get(URI.create(hdfsURI), con);
		InputStream in=null;
		try{
			in=fs.open(new Path(hdfsURI));
			IOUtils.copyBytes(in, System.out, 4096, false);
		}finally {
			IOUtils.closeStream(in);
		}
	}
	
}
