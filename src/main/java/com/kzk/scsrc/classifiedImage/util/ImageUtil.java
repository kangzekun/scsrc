package com.kzk.scsrc.classifiedImage.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import  com.kzk.scsrc.classifiedImage.entity.RGBvalue;

public class ImageUtil {
	static int rows = 145;
	static int cols = 145;

	public static String imgUtil() throws IOException {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String addString0 = path.substring(0, path.length() - 29) + "src/main/webapp/imgs/";
		String addString1 = path.substring(0, path.length() - 29) + "src/main/webapp/tools/";
		String filePath = addString1 + "label/labels.txt";
		int[][] data = new int[rows][cols];
		readTxt(filePath, data);
		String result = generateImage(data, addString0);
		return result;
	}


	public static String generateImage(int[][] data, String imagepath) throws IOException {
		int multiple = 3;
		String result = null;
		String outpath = imagepath + "classifiedImage.jpg";
		BufferedImage bi = new BufferedImage(rows * multiple, cols * multiple, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				switch (data[i][j]) {
				case 0:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.BLACK);
						}
					break;
				case 1:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.BRICK);
						}
					break;
				case 2:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.BROWN);
						}
					break;
				case 3:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.BLUE);
						}
					break;
				case 4:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.CARDINAL);
						}
					break;
				case 5:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.CELESTE);
						}
					break;
				case 6:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.FORESTGREEN);
						}
					break;
				case 7:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.GRAY);
						}
					break;
				case 8:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.GREEN);
						}
					break;
				case 9:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.INDIGO);
						}
					break;
				case 10:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.MANDARIN_BLUE);
						}
					break;
				case 11:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.ORANGE);
						}
					break;
				case 12:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.PINK);
						}
					break;
				case 13:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.PURPLE);
						}
					break;
				case 14:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.RED);
						}
					break;
				case 15:
					for (int m = i * multiple; m < (i * multiple + multiple); m++)
						for (int n = j * multiple; n < (j * multiple + multiple); n++) {
							bi.setRGB(n, m, RGBvalue.YELLOW);
						}
					break;
				}
			}
		}
		try {
			File imgFile = new File(outpath);
			if (imgFile.exists()) {
				imgFile.delete();
			}
			ImageIO.write(bi, "jpg", imgFile);
			result = "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "error";
		}
		return result;
	}

	public static void readTxt(String filePath, int[][] data) {

		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				int i = 0;
				while ((lineTxt = br.readLine()) != null) {
					// 处理文件的行
					if (i < rows) {
						String[] tempDatas = lineTxt.split(",");

						for (int j = 0; j < cols; j++) {
							data[i][j] = Integer.parseInt(tempDatas[j]);
						}
					}
					i++;
				}
				br.close();
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}

	}
}
