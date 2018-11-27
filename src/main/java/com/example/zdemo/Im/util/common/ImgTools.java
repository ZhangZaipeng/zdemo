package com.example.zdemo.Im.util.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImgTools {

	/**
	 * 获取原图片 宽高
	 */
	public static Map<String,Integer> getImgSize(String imgUrl) throws IOException{
		HashMap<String, Integer> size = new HashMap<>();

		InputStream in = new URL(imgUrl).openStream();
		BufferedImage sourceImg = ImageIO.read(in);
		size.put("width", sourceImg.getWidth());
		size.put("height", sourceImg.getHeight());

		return size;
	}
	
	/** 
	 * 按照宽度还是高度进行压缩 
	 * @param w int 最大宽度 
	 * @param h int 最大高度 
	 */
	public static byte[] resizeFix(InputStream in, String fileName,int w, int h) throws IOException { 
		//构造Image对象 
		Image  img = ImageIO.read(in); 
		//得到源图宽 
		int width = img.getWidth(null);
		//得到源图长 
		int height = img.getHeight(null);
			  
		if (width / height > w / h) { 
			return resizeByWidth(in,fileName,w); 
		} else { 
			return resizeByHeight(in,fileName,h); 
		} 
	} 
	/** 
	 * 以宽度为基准，等比例放缩图片   
	 * @param w int 新宽度 
	 */
	public static byte[] resizeByWidth(InputStream in, String fileName,int w) throws IOException { 
		//构造Image对象 
		Image  img = ImageIO.read(in); 
		//得到源图宽 
		int width = img.getWidth(null);
		//得到源图长 
		int height = img.getHeight(null);
			  
		int h = (int) (height * w / width);
		
		//文件格式
		String imageFormat = fileName.substring(fileName.lastIndexOf(".")+1);
			 
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );  
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, imageFormat, baos);
		
		return baos.toByteArray();
	} 
	
	/** 
	 * 以高度为基准，等比例缩放图片 
	 * @param h int 新高度 
	 */
	public static byte[] resizeByHeight(InputStream in , String fileName, int h) throws IOException {
		//构造Image对象 
		Image  img = ImageIO.read(in); 
		//得到源图宽 
		int width = img.getWidth(null);
		//得到源图长 
		int height = img.getHeight(null);
			  
		int w = (int) (width * h / height); 
		return resize(in,fileName,w, h); 
	}
	
	/** 
	 * 强制压缩/放大图片到固定的大小 
	 * @param w int 新宽度 
	 * @param h int 新高度 
	 */
	public static byte[] resize(InputStream in, String fileName, int w, int h) throws IOException { 
		//构造Image对象 
		Image  img1 = ImageIO.read(in); 
		//文件格式
		String imageFormat = fileName.substring(fileName.lastIndexOf(".")+1);
			 
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );  
		image.getGraphics().drawImage(img1, 0, 0, w, h, null); // 绘制缩小后的图 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, imageFormat, baos);
		
		return baos.toByteArray();
	} 

}
