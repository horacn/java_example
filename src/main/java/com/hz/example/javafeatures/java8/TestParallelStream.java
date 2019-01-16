package com.hz.example.javafeatures.java8;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.hz.example.util.StopWatch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream 和 parallelStream
 *
 * Created by hezhao on 2019/1/16 19:33
 */
public class TestParallelStream {

    @Test
    public void test1(){
        // 初始化2千万个元素
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20000000; i++) {
            list.add(RandomUtil.randomInt());
        }

        StopWatch watch = new StopWatch("Stream效率测试");

        watch.start("stream start");
        Integer x = list.stream().filter(e -> e % 2 == 0).reduce((a, b) -> a + b).get();
        System.out.println(x);
        watch.stop();

        watch.start("parallelStream start");
        Integer y = list.parallelStream().filter(e -> e % 2 == 0).reduce((a, b) -> a + b).get();
        System.out.println(y);
        watch.stop();

        System.out.println();
        System.out.println(watch.prettyPrint());

        /*
        输出结果:
        -1709247080
        -1709247080

        StopWatch 'Stream效率测试': running time (millis) = 4949
        -----------------------------------------
        ms     %     Task name
        -----------------------------------------
        04816  097%  stream start
        00133  003%  parallelStream start
         */
    }

    @Test
    public void test2(){
        ArrayList<String> list = Lists.newArrayList("dd", "bb", "c", "aa", "e");

        // 原始顺序
        list.stream().forEach(System.out::println);
        System.out.println("---------------");
        // 打乱了顺序
        list.parallelStream().forEach(System.out::println);

        // 原始顺序
        System.out.println("---------------");
        List<String> list0 = list.parallelStream().collect(Collectors.toList());
        System.out.println(list0);

        // 有序
        System.out.println("---------------");
        list.stream().filter(e -> e.length() > 1).sorted().forEach(System.out::println);
        System.out.println("---------------");
        // 无序
        list.parallelStream().filter(e -> e.length() > 1).sorted().forEach(System.out::println);
        System.out.println("---------------");
        // 有序
        list.parallelStream().filter(e -> e.length() > 1).sorted().forEachOrdered(System.out::println);

        // 排序，两个都正常 >>> [aa, bb, dd]
        System.out.println("---------------");
        List<String> list1 = list.stream().filter(e -> e.length() > 1).sorted().collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("---------------");
        List<String> list2 = list.parallelStream().filter(e -> e.length() > 1).sorted().collect(Collectors.toList());
        System.out.println(list2);

        // 找出最小的 >>> aa
        System.out.println("---------------");
        System.out.println(list.stream().filter(e -> e.length() > 1).min(String::compareTo).get());
        System.out.println("---------------");
        System.out.println(list.parallelStream().filter(e -> e.length() > 1).min(String::compareTo).get());

        // 找出最小的 >>> aa
        System.out.println("---------------");
        System.out.println(list.stream().filter(e -> e.length() > 1).sorted().findFirst().get());
        System.out.println("---------------");
        System.out.println(list.parallelStream().filter(e -> e.length() > 1).sorted().findFirst().get());
    }

}
