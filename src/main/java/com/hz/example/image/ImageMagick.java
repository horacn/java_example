package com.hz.example.image;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

/**
 * @author hegh E-mail: heguanhua@tjhq.com
 * @version 创建时间：Mar 13, 2012 10:43:12 AM 类说明
 */
public class ImageMagick {

 /** * ImageMagick的路径 */
  public static String imageMagickPath = "D:\\Program Files\\GraphicsMagick-1.3.21-Q8"; 
  static{ /**获取ImageMagick的路径 */ 
   //Properties prop = new PropertiesFile().getPropertiesFile(); 
   //linux下不要设置此值，不然会报错
   //imageMagickPath = prop.getProperty("imageMagickPath"); 
  } 
  
  /** * 根据坐标裁剪图片
  * @param srcPath 要裁剪图片的路径 
  * @param newPath 裁剪图片后的路径 
  * @param x 起始横坐标 
  * @param y 起始挫坐标 
  * @param x1 结束横坐标 
  * @param y1 结束挫坐标 
  */ 
  public static void cutImage(String srcPath, String newPath, int x, int y, int x1, int y1)
   throws Exception { 
   int width = x1 - x; int height = y1 - y; 
   IMOperation op = new IMOperation(); 
   op.addImage(srcPath); 
   /**
    * width：裁剪的宽度 
    * height：裁剪的高度 
    * x：裁剪的横坐标 
    * y：裁剪的挫坐标 
    */ 
   op.crop(width, height, x, y);
   op.addImage(newPath); 
   ConvertCmd convert = new ConvertCmd(true);
   //linux下不要设置此值，不然会报错 
   convert.setSearchPath(imageMagickPath);
   convert.run(op); 
 } 
  
  /** 
   * 根据尺寸缩放图片 
   * @param width 缩放后的图片宽度 
   * @param height 缩放后的图片高度 
   * @param srcPath 源图片路径 
   * @param newPath 缩放后图片的路径 
   * @param type 1为比例处理，2为大小处理，如（比例：1024x1024,大小：50%x50%）
   */ 
  public static String cutImage(int width, int height, String srcPath, String newPath,int type,String quality) throws Exception { 
   IMOperation op = new IMOperation();       
   ConvertCmd cmd = new ConvertCmd(true); 
   op.addImage(); 
   String raw = "";
   if(type == 1){
    //按像素
    raw = width+"x"+height+"^";
   }else{
    //按像素百分比
    raw = width+"%x"+height+"%";
   }  
   op.addRawArgs("-sample" ,  raw );   
   if((quality !=null && quality.equals(""))){
    op.addRawArgs("-quality" ,  quality ); 
   }
   op.addImage();   
   
   String osName = System.getProperty("os.name").toLowerCase();
   if(osName.indexOf("win") != -1) {
   //linux下不要设置此值，不然会报错
   cmd.setSearchPath(imageMagickPath);
   }

   try{
    cmd.run(op, srcPath, newPath);        
   }catch(Exception e){
    e.printStackTrace();
   }
   return newPath;
 } 
 
  
 /** 
  * 给图片加水印
  * @param srcPath 源图片路径 
  */ 
  public static void addImgText(String srcPath) throws Exception { 
   IMOperation op = new IMOperation();   
//   op.font("宋体").gravity("southeast").pointsize(18).fill("#BCBFC8").draw("text 100,100 co188.com");  
   op.gravity("southeast").pointsize(18).fill("#BCBFC8").draw("text 100,100 co188.com");  
   op.addImage(); 
   op.addImage();    
   
   String osName = System.getProperty("os.name").toLowerCase();    
   ConvertCmd cmd = new ConvertCmd(true); 
   if(osName.indexOf("win") != -1) {
   //linux下不要设置此值，不然会报错
   cmd.setSearchPath(imageMagickPath);
   }

   try{
    cmd.run(op, srcPath, srcPath);        
   }catch(Exception e){
    e.printStackTrace();
   }
  } 
  
  public static void main(String[] args) throws Exception{ 
	  Long start = System.currentTimeMillis();
	  //裁剪
//   cutImage("C:\\Users\\Administrator\\Pictures\\快速保存图片\\aaa.jpg","C:\\Users\\Administrator\\Pictures\\快速保存图片\\sf\\suofang_"+new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(new Date())+".jpg",98, 48, 870, 820); 
	  //缩放
//   cutImage(710,710, "C:\\Users\\Administrator\\Pictures\\快速保存图片\\aaa.jpg","C:\\Users\\Administrator\\Pictures\\快速保存图片\\sf\\suofang_"+new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(new Date())+".jpg",2,"1"); 
	  //水印
//   addImgText("C:\\Users\\Administrator\\Pictures\\快速保存图片\\sf\\suofang_2016-07-12-11-03-59-184.jpg"); 
   
   Long end = System.currentTimeMillis();
   System.out.println("time:"+(end-start)/3600);
  }
}