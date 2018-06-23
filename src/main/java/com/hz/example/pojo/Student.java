package com.hz.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 使用lombok生成实体类
 *
 * @Getter / @Setter注释任何字段（当然也可以注释到类上的），让lombok自动生成默认的getter / setter方法。
 *
 * @ToString 生成toString()方法，默认情况下，它会按顺序（以逗号分隔）打印你的类名称以及每个字段
 *
 * @EqualsAndHashCode 生成hashCode()和equals()方法
 *
 * @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor 生成构造方法
 *
 * @Data 包含了 @ToString、@EqualsAndHashCode、@Getter / @Setter和@RequiredArgsConstructor的功能
 *
 * @Builder 注释为你的类生成复杂的构建器API。
 * 如：Person.builder().name("Adam Savage").city("San Francisco").job("Mythbusters").job("Unchained Reaction").build();
 *
 * @Author hezhao
 * @Time 2018-06-24 2:02
 * @Description 无
 * @Version V 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
}
