package com.hz.example.oldalmanac;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 程序员老黄历Java源码实现
 *
 * Created by hezhao on 2018/10/24 18:59
 */
public class ProgrammerCalendar {

    /** 当前日期 */
    private Integer iday = 0;
    /** 星期 */
    private String [] weeks = new String[]{"日", "一","二","三","四","五","六"};
    /** 方位 */
    private String [] directions = new String[]{"北方","东北方","东方","东南方","南方","西南方","西方","西北方"};
    /** 饮品 */
    private String [] drinks  =  new String[]{"水","茶","红茶","绿茶","咖啡","奶茶","可乐","鲜奶","豆奶","果汁","果味汽水","苏打水","运动饮料","酸奶","酒"};
    /** 开发工具 */
    private String [] tools =  new String[]{"Eclipse写程序", "MSOffice写文档", "记事本写程序", "Windows8", "Linux", "MacOS", "IE", "Android设备", "iOS设备"};
    /** 变量名称 */
    private String [] varNames  =  new String[]{"result", "activity", "pay", "expire", "bill", "every", "free", "i1", "a", "virtual", "ad", "spider", "password", "pass", "ui"};

    public Integer getIday() {
        return iday;
    }

    public String[] getDirections() {
        return directions;
    }

    /**
     * 注意：本程序中的“随机”都是伪随机概念，以当前的天为种子。
     */
    public Integer random(Integer daySeed, Integer indexSeed) {
        Integer n = daySeed % 11117;
        for (int i = 0; i < 100 + indexSeed; i++) {
            n = n * n;
            n = n % 11117;	//11117是个质数
        }
        return n;
    }

    public String getTodayString (){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return "今天是" + calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1)
                + "月" + calendar.get(Calendar.DAY_OF_MONTH)
                + "日 星期" + weeks[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public String star(Integer num) {
        String result = "";
        int i = 0;
        while (i < num) {
            result += "★";
            i++;
        }
        while(i < 5) {
            result += "☆";
            i++;
        }
        return result;
    }

    private Boolean isWeekend() {
        Locale.setDefault(Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7;
    }

    public List<ActivitiesEnum> filter() {
        List<ActivitiesEnum> thisEnum = new ArrayList<ActivitiesEnum>();

        // 周末的话，只留下 weekend = true 的事件
        if(isWeekend()) {
            for (ActivitiesEnum e : ActivitiesEnum.values()) {
                if(e.getWeekend()){
                    thisEnum.add(e);
                }
            }
            return thisEnum;
        }
        return new ArrayList<ActivitiesEnum>(Arrays.asList(ActivitiesEnum.values()));
    }

    /**
     * 宜 / 不宜
     */
    public String pickTodaysLuck() {
        List<ActivitiesEnum> _activities = filter();

        Integer numGood = random(iday, 98) % 3 + 2;
        Integer numBad = random(iday, 87) % 3 + 2;
        List<Map<String, String>> eventArr = pickRandomActivity(_activities, numGood + numBad);

        // Integer [] specialSize = pickSpecials();

        StringBuilder sb = new StringBuilder();

        sb.append("宜：");
        for (int i = 0; i < numGood; i++) {
            sb.append("\n    " + eventArr.get(i).get("name") + (StringUtils.isNotBlank(eventArr.get(i).get("good")) ? ":" + eventArr.get(i).get("good") : ""));
        }
        sb.append("\n不宜：");
        for (int i = 0; i < numBad; i++) {
            sb.append("\n    " + eventArr.get(numGood + i).get("name") + (StringUtils.isNotBlank(eventArr.get(numGood + i).get("bad")) ? ":" + eventArr.get(numGood + i).get("bad") : ""));
        }
        return sb.toString();
    }

    /**
     * 从数组中随机挑选 size 个
     * @param size
     * @return
     */
    private List<ActivitiesEnum> pickRandom(List<ActivitiesEnum> _activities, Integer size) {
        List<ActivitiesEnum> result = new ArrayList<ActivitiesEnum>();

        for (ActivitiesEnum ae : _activities) {
            result.add(ae);
        }

        for (int i = 0; i < _activities.size() - size; i++) {
            int index = random(iday, i) % result.size();
            result.remove(index);
        }
        return result;
    }

    /**
     * 从数组中随机挑选 size 个
     * @param size
     * @return
     */
    private List<String> pickRandomDrinks(Integer size) {
        List<String> result = new ArrayList<String>(Arrays.asList(drinks));

        for (int i = 0; i < drinks.length - size; i++) {
            int index = random(iday, i) % result.size();
            result.remove(index);
        }
        return result;
    }

    //  枚举 中随机挑选 size 个
    public List<Map<String, String>> pickRandomActivity(List<ActivitiesEnum> _activities, Integer size) {
        List<ActivitiesEnum> picked_events = pickRandom(_activities, size);
        List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
        for (int i = 0; i < picked_events.size(); i++) {
            mapList.add(parse(picked_events.get(i)));
        }
        return mapList;
    }

    /**
     * 解析占位符并替换成随机内容
     * @param ae
     * @return
     */
    public Map<String, String> parse(ActivitiesEnum ae) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", ae.getName());
        map.put("good", ae.getGood());
        map.put("bad", ae.getBad());

        if(map.get("name").indexOf("%v") != -1) {
            map.put("name", map.get("name").replaceAll("%v", varNames[random(iday, 12) % varNames.length]));
        }
        if(map.get("name").indexOf("%t") != -1) {
            map.put("name", map.get("name").replaceAll("%t", tools[random(iday, 11) % tools.length]));
        }
        if(map.get("name").indexOf("%l") != -1) {
            map.put("name", map.get("name").replaceAll("%l", (random(iday, 12) % 247 + 30) + ""));
        }
        return map;
    }

    public Integer [] pickSpecials () {
        Integer [] specialSize = new Integer[]{0, 0};
        for (SpecialsEnum se : SpecialsEnum.values()) {
            if(iday == se.getDate()){
                if(se.getType().equals("good")){
                    specialSize[0]++;
                }else{
                    specialSize[1]++;
                }
                System.out.println("name:" + se.getName() + " description:" + se.getDescription());
            }
        }
        return specialSize;
    }

    public ProgrammerCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            iday = Integer.parseInt(sdf.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace(); // 懒得引用log了
        }
    }

    public static void main(String[] args) {
        ProgrammerCalendar hl = new ProgrammerCalendar();
        System.out.println(hl.getTodayString());
        System.out.println("座位朝向：面向" + hl.directions[hl.random(hl.getIday(), 2) % hl.getDirections().length] + "写程序，BUG 最少。");
        System.out.println("今日宜饮：" + StringUtils.join(hl.pickRandomDrinks(2), ","));
        System.out.println("女神亲近指数：" + hl.star(hl.random(hl.getIday(), 6) % 5 + 1));
        System.out.println(hl.pickTodaysLuck());
    }

}
