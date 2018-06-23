package com.hz.example.lib;

import com.hz.example.pojo.Student;

/** 使用lombok生成实体类
 * @Author hezhao
 * @Time 2018-06-24 2:14
 * @Description 无
 * @Version V 1.0
 */
public class TestLombok {
    public static void main(String[] args) {
        Student student = new Student("张三",18);
        student.setName("李四");
        student.setAge(28);
        System.out.println(student.toString());

        Student student2 = new Student();
        student2.setName("张三");
        student2.setAge(33);
        System.out.println(student2.getName());

        Student student3 = Student.builder().name("王五").age(44).build();
        System.out.println(student3);
    }
}
