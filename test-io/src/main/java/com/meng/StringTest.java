package com.meng;

public class StringTest {
    public static void main(String[] args) {  
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        String s4 = new String("a");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s4));
        String s = "LEFT JOIN ( " +
                " SELECT " +
                "  T .user_id, " +
                "  SUM (T .HOURS), " +
                "  1, " +
                "  CASE " +
                " WHEN SUM (T .HOURS) = '0' THEN " +
                "  '0' " +
                " ELSE " +
                "  '100%' " +
                " END " +
                " FROM " +
                "  TB_WORK_HOURS_DONE T " +
                " WHERE " +
                "  -- T .USER_ID = '\"+userId+\"' " +
                "  T .HOUR_DATE = TO_DATE ('2021-01', 'yyyy-mm') " +
                " GROUP BY " +
                "  T .USER_ID " +
                ") t2 ON t2.user_id = t1.FLD_U_0001";
        
        String ss = "1234567";
    }
}  