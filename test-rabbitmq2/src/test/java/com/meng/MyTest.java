package com.meng;

import org.junit.Test;

public class MyTest {
    @Test
    public void test1() {
        String s = "truncate table TB_WORK_HOURS_DONE;\n" +
                "insert into TB_WORK_HOURS_DONE(project_id,user_id,hours,HOUR_DATE,hour_rate)\n" +
                "select aaa.\"ID\",AAA.CREATORID,aaa.prjEFFORT,AAA.HOUR_DATE,\n" +
                "case BBB.EFFORT when 0 then 0 else round(AAA.prjEFFORT/BBB.EFFORT,2) end\n" +
                " HOUR_DATE from (select b.id,ab.creatorid,sum(ab.EFFORT) prjEFFORT,TRUNC(AB.REPORTDAY,'mm') HOUR_DATE  from T_TSK_DAYRPT ab ,T_TSK_TSK c,\n" +
                "t_psm_pjt b where ab.taskid=c.id and c.OBJECTID=b.ID\n" +
                "and (b.PHASEID not in('6335791c-a043-4840-8299-af92baa04de6','a0890195-e424-40ad-9217-aba32d093948') \n" +
                "or b.PHASEID is null) group by b.id,ab.creatorid,TRUNC(AB.REPORTDAY,'mm') ) aaa,\n" +
                "(select ab.creatorid,sum(ab.EFFORT) EFFORT,TRUNC(AB.REPORTDAY,'mm') HOUR_DATE from T_TSK_DAYRPT ab ,T_TSK_TSK c,\n" +
                "t_psm_pjt b where ab.taskid=c.id and c.OBJECTID=b.ID\n" +
                "and (b.PHASEID not in('6335791c-a043-4840-8299-af92baa04de6','a0890195-e424-40ad-9217-aba32d093948') \n" +
                "or b.PHASEID is null) group by ab.creatorid,TRUNC(AB.REPORTDAY,'mm')) bbb\n" +
                "where\n" +
                "aaa.creatorid=bbb.creatorid and aaa.HOUR_DATE=bbb.HOUR_DATE;";

        byte[] bytes = s.getBytes();
        System.out.println(s.getBytes());
    }

}
