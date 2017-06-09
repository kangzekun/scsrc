package com.kzk.scsrc.algorithm.util;

import com.kzk.scsrc.algorithm.controller.SparkController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellUtil {

//	public static void main(String[] args) {
//		String result=submitSCSRC();
//		System.out.println(result);
//	}

	public static String submitSCSRC(ExtractDataUtil extr, IterUtil iu) {


		String[] args = new String[]{
				"--class","SCSRC.examples.SCSRC_feature2",
    		"--master","spark://10.10.10.46:7077",
    		"--driver-memory","3g",
    		"--executor-memory","4g",
    		"--conf","spark.akka.frameSize=100",
    		"/home/hadoop/shen/SCSRC_V1.jar",
    		"/home/hadoop/shen/",
    	 };
    	 int partitions=16;
    	 int iterations=40;
    	 StringBuilder shell=new StringBuilder("spark-submit").append(" ");
    	 for(int i=0;i<args.length;i++) {
    		 shell.append(args[i]).append(" ");
    	 }
    	 shell.append(Integer.toString(partitions)).append(" ").append(Integer.toString(iterations));
		String result = execShell(shell.toString(), extr, iu);
		return result;
	}

	public static String execShell(String shell, ExtractDataUtil extr, IterUtil iu) {
		String result = "";
		try {
             Process process = Runtime.getRuntime().exec(shell);
			 //normal
//			 InputStreamReader isr = new InputStreamReader(process.getInputStream());
//			 BufferedReader br = new BufferedReader(isr);
			 //error
//			 InputStreamReader isr1 = new InputStreamReader(process.getErrorStream());
//			 BufferedReader br1 = new BufferedReader(isr1);
//			 String errline;
//			 String lineConsole = null;
			 //readLine只能读取连续的文件，不能判断是不是空行
			 //所以必须得加上一句代码让整个逻辑更加清楚
//			 while ((lineConsole = br.readLine()) != null) {
//				 if (lineConsole.isEmpty()) continue;
//				 System.out.println(lineConsole);
//				 extr.readProcessBuf(lineConsole);
//				 iu.setIteration(extr.getIteration());
//			 }
			 //get scsrcMap

//			 while ((errline = br1.readLine()) != null) {
//				 if (errline.indexOf("Exception") != -1) {
//					 result = "error";
//                 }
//             }
             process.waitFor();
         } catch (Exception e) {
             e.printStackTrace();
         }
		return result == "" ? "success" : result;
	}

}
