package com.hz.example.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Chinese {

	private HanyuPinyinOutputFormat format = null;

    private String[] pinyin;

    public Chinese() {
        format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        pinyin = null;
    }

    //转换单个中文字符
    public String getCharacterPinYin(char c) {
        try {
            pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
        } catch(BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        // 如果c不是汉字，返回null
        if(null == pinyin)
            return null;

        // 多音字取第一个值
        return pinyin[0];
    }

    //转换一个字符串
    public String getStringPinYin(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); ++i) {
            String tmp = getCharacterPinYin(str.charAt(i));
            if(null == tmp) {
                // 如果str.charAt(i)不是汉字，则保持原样
                sb.append(str.charAt(i));
            } else {
                sb.append(tmp);
                //分词
                if ( i < str.length() - 1 && null != getCharacterPinYin(str.charAt(i + 1))) {
                    sb.append("\'");
                }
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        String str = "哈哈，我爱 Coding";
        String pinYin = chinese.getStringPinYin(str);
        System.out.println(pinYin);
    }
}