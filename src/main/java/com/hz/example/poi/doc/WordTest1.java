package com.hz.example.poi.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.xmlbeans.XmlException;
  
public class WordTest1 {  
  
    public void wordWithOld() {  
        // word 2003： 图片不会被读取  
        try {  
            FileInputStream is = new FileInputStream(new File("C://a.doc"));  
            WordExtractor ex = new WordExtractor(is);  
            String[] graph = ex.getParagraphText();  
            System.out.println("该Word共有" + graph.length + "段");  
            for (int i = 0; i < graph.length; i++) {  
                System.out.println("第" + (i + 1) + "段有这样的内容:" + graph[i]);  
            }  
            String text2003 = ex.getText();  
            System.out.println("总的内容:" + text2003);  
  
            is.close();  
            ex.close();  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    public void wordWithNew() {  
        // word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后  
        try {  
            OPCPackage opcPackage = POIXMLDocument.openPackage("C://a.doc");  
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);  
            String text2007 = extractor.getText();  
            System.out.println(text2007);  
  
            opcPackage.close();  
            extractor.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (XmlException e) {  
            e.printStackTrace();  
        } catch (OpenXML4JException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    public void wordPictureRead() {  
        // 得到Word中的所有图片及内容  
  
        File file = new File("C://a.doc");  
        FileInputStream inputStream;  
        try {  
            inputStream = new FileInputStream(file);  
            XWPFDocument xwpfDocument = new XWPFDocument(inputStream);  
            XWPFWordExtractor extractor = new XWPFWordExtractor(xwpfDocument);  
            String text = extractor.getText();  
            System.out.println(text+"\n");  
              
            List<XWPFPictureData> list = xwpfDocument.getAllPictures();  
            for (XWPFPictureData picture : list) {  
                System.out.println(picture.getPictureType() + File.separator  
                        + picture.suggestFileExtension() + File.separator  
                        + picture.getFileName());  
                byte[] by = picture.getData();  
                FileOutputStream stream1 = new FileOutputStream("F:\\"  
                        + picture.getFileName());  
                stream1.write(by);  
            }  
  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    public static void main(String[] args) {  
        WordTest1 test1 = new WordTest1();  
//        test1.wordPictureRead();  
        test1.wordWithOld();  
//        test1.wordWithNew();  
           
    }  
}  
