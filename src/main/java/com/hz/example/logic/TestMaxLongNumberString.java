package com.hz.example.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，输出字符串中最长的数字串，并把这个数字串的长度输出。
 *
 * 请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串；
 *
 * 注意：数字串只需要是数字组成的就可以，并不要求顺序，比如数字串“1234”的长度就小于数字串“1359055”，如果没有数字，则返回空字符串（“”）而不是NULL！
 *
 * 输入描述:
 * 一个字符串
 * 输出描述:
 * 输出最长的数字串,输出最长数字串个数；
 * 中间以逗号(,)隔开；
 *
 * 示例1
 * 输入
 * abcd12345ed125ss123058789
 * 输出
 * 123058789,9
 *
 * Created by hezhao on 2018/9/19 10:19
 */
public class TestMaxLongNumberString {

    public static void main(String[] args) {
//        String str = "abcd12345ed125ss123058789";
        String str = "abcd111111111ed222222222ss123058789";
        System.out.println(filterNumber1(str));
        System.out.println(filterNumber2(str));
    }

    // 集合存储法，循环一次,代码较长较繁琐
    public static String filterNumber1(String str) {
        char[] chars = str.toCharArray();
        Pattern pattern = Pattern.compile("^[\\d]*$");

        List<String> nums = new ArrayList<>();
        String num = "";
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (pattern.matcher(String.valueOf(chars[i])).matches()) {
                num += String.valueOf(chars[i]);
                flag = true;
                // 最后一个字符
                if (i == chars.length-1) {
                    nums.add(num);
                    break;
                }
                continue;
            }
            if (flag) {
                nums.add(num);
                num = "";
            }
            flag = false;
        }

//        System.out.println(nums);

        if (nums.size() == 0) {
            return "";
        } else {
//            int compare(Object a, Object b) 返回一个基本类型的整型
//            如果要按照升序排序，
//                则a小于b，返回-1（负数），相等返回0，a大于b返回1（正数）
//            如果要按照降序排序
//                则a小于b，返回1（正数），相等返回0，a大于b返回-1（负数）
            List<String> newNums = nums.stream().sorted((a, b) -> {
                if (a.length() > b.length()) {
                    return -1;
                } else if (a.length() == b.length()) {
                    // 如果存在长度相同的连续数字串，返回最后一个连续数字串；
                    return -1;
                } else {
                    return 1;
                }
            }).collect(Collectors.toList());

//            System.out.println(newNums);
            return newNums.get(0) + "," + newNums.get(0).length();
        }
    }

    // 遍历字符串，遇到数字时开启内层循环直到到达数字结尾，更新最长字符及其长度。
    public static String filterNumber2(String str) {
        char[] chars = str.toCharArray();
        Pattern pattern = Pattern.compile("^[\\d]*$");
        int maxLen = 0;
        String temp = "", output = "";

        for (int i = 0; i < chars.length; i++) {
            if (pattern.matcher(String.valueOf(chars[i])).matches()) {
                temp += chars[i];
                while (i < chars.length-1 && pattern.matcher(String.valueOf(chars[i+1])).matches()) {
                    i++; // 下次进入for循环时候直接从该数字末尾开始，提升效率
                    temp += chars[i];
                }

                if (temp.length() > maxLen) {
                    maxLen = temp.length();
                    output = temp;
                } else {
                    output = temp;
                }
            }
            temp = "";
        }
        return output + "," + output.length();
    }

}
