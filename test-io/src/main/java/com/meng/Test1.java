package com.meng;

import org.junit.Test;

public class Test1 {
    @Test
    public void test1() {
        Thread thread = new Thread() {
    @Override
    public void run() {
        System.out.println("my Thread");
    }
        };
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("my Thread 2");
    }
        });

        thread1.run();
        String s = "SELECT " +
        "   DISTINCT y1.userid " +
        "  FROM " +
        "   TB_WORK_HOURS_TEMP A " +
        "  LEFT JOIN T_PSM_EXT t3 ON t3.objectid = A .FLD_P_0003 " +
        "  LEFT JOIN T_SEC_USERROL y1 ON y1.objectid = t3.objectid " +
        "  LEFT JOIN t_sec_rol y2 ON y2. ID = y1.roleid " +
        "  WHERE " +
        "   1 = 1 " +
        "  AND y2. NAME = '项目经理' " +
        "  AND y1.userid = '33ba99dc-dc20-4b4b-b398-9c5e78e5735f' " +
        "  AND t3.Fld_S_00015 IN ( " +
        "   '07d8fc57-ba54-4b9a-bf90-cd78ac0278cf', " +
        "   'e4fa6627-26e7-4f65-a2de-35f63c036f71' " +
        "  ) " +
        "  AND FLD_Y_N = 'Y'";
    }
}
