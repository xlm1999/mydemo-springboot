package com.meng;

import java.util.Calendar;
import java.util.*;

public class CalendarUtil {

    public static void main(String[] args) {
        Map<String, Integer> map = getMonthInfo(Calendar.getInstance());
        System.err.println("------------" + map.get("year") + "年" + map.get("month") + "月-------------");
        System.err.println("总天数：" + map.get("daysAmount"));
        System.err.println("工作日天数：" + map.get("workDaysAmount"));
        System.err.println("周数：" + map.get("weeksAmount"));
    }


    /**
     * 计算当前月有多少自然日、有多少工作日、有几周
     */
    private static Map getMonthInfo(Calendar calendar) {
        calendar.add(Calendar.MONTH, -1);
        Map<Object, Integer> map = new HashMap();
        int workDays = 0;
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        try {
            calendar.set(Calendar.DATE, 1);//从每月1号开始
            for (int i = 0; i < days; i++) {
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
                    workDays++;
                }
                calendar.add(Calendar.DATE, 1);
            }
            map.put("workDaysAmount", workDays);//工作日
            map.put("year", calendar.get(Calendar.YEAR));//实时年份
            map.put("month", calendar.get(Calendar.MONTH));//实时月份
            map.put("daysAmount", days);//自然日
            map.put("weeksAmount", calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));//周
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}