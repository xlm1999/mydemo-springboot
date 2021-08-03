package com.meng.demo;

import java.util.*;

public class MyTest {
    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        // task1_test start
        Row task1_row1 = new Row(1000, 20);
        Row task1_row2 = new Row(1000, 23);
        Row task1_row3 = new Row(2000, 16);
        Row task1_row4 = new Row(4000, 16);
        Row task1_row5 = new Row(2000, 80);
        Row[] rows1 = new Row[]{task1_row1, task1_row2, task1_row3, task1_row4, task1_row5};
        //System.out.println(myTest.task1(rows1, 5));
        // task1_test end

        // task2_test start
        Row task2_row1 = new Row(1000, 31);
        Row task2_row2 = new Row(1000, 72);
        Row task2_row3 = new Row(1500, 12);
        Row task2_row4 = new Row(1500, 34);
        Row task2_row5 = new Row(2000, 22);
        Row task2_row6 = new Row(2000, 33);
        Row[] rows2 = new Row[]{task2_row1, task2_row2, task2_row3, task2_row4, task2_row5, task2_row6};
        //System.out.println(myTest.task2(rows2, 6));
        // task2_test end

        // task3_test start
        Row task3_row1 = new Row(1000, 31);
        Row task3_row2 = new Row(2000, 22);
        Row task3_row3 = new Row(2000, 33);
        Row[] rows3 = new Row[]{task3_row1, task3_row2, task3_row3};
        System.out.println(myTest.task3(rows3, 3));
        // task3_test end




    }


    /**
     * @param rows
     * @param nrows
     * @return
     */
    public String task1(Row[] rows, int nrows) {
        // rows 和 nrows应该是有关联的吧？我的理解是rows.length == nrows。
        // 所以感觉在这里只有rows这一个形参就够了
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            int a = row.getA();
            if (a == 1000 || a == 2000 || a == 3000) {
                int b = row.getB();
                if (b >= 10 && b < 50) {
                    // 如果都符合a，b的范围，就将此行数据保留并输出。
                    sb.append(a).append(",").append(b).append("\n").toString();
                }
            }
        }

        return sb.toString();
    }

    /**
     * @param rows
     * @param nrows
     * @return
     */
    public String task2(Row[] rows, int nrows) {
        // 已经按照a,b进行过排序。rows的范围进一步缩小。
        // 对于a的范围，a > 3000的rows,可以直接舍弃，避免了task1 的全表扫描

        // 定义一个list，存放符合条件的rows
        List<Row> list = new ArrayList<Row>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            int a = row.getA();
            if (a <= 3000) {
                // 把符合条件的rows加入到list，后期只循环遍历这个list中的数据即可。
                list.add(row);
            } else {
                // 如果a > 3000，则结束for循环
                continue;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Row row = list.get(i);
            int a = row.getA();
            if (a == 1000 || a == 2000 || a == 3000) {
                int b = row.getB();
                if (b >= 10 && b < 50) {
                    // 如果都符合a，b的范围，就将此行数据保留并输出。
                    sb.append(a).append(",").append(b).append("\n").toString();
                }
            }
        }

        return sb.toString();
    }

    /**
     * @param rows
     * @param nrows
     * @return
     */
    public String task3(Row[] rows, int nrows) {
        // 按照b进行排序
        StringBuilder sb = new StringBuilder("");
        // 定义map，把b放入map的key中
        Map<Integer, Row> map = new HashMap();
        // 定义数组bs，以便对b进行排序
        int[] bs = new int[rows.length];

        for (int i = 0; i < rows.length; i++) {
            Row row = rows[i];
            int b = row.getB();
            // 把rows放入map，b作为key。
            map.put(b, row);
            bs[i] = b;
        }

        // 接下来对b进行排序,这里采用冒泡排序
        int temp = 0;
        for (int i = 0; i < bs.length - 1; i++) {
            for (int j = 0; j < bs.length - i - 1; j++) {
                if (bs[j] > bs[j + 1]) {
                    temp = bs[j];
                    bs[j] = bs[j + 1];
                    bs[j + 1] = temp;
                }
            }
        }

        // 打印输出
        for (int i = 0; i < bs.length; i++) {
            sb.append(map.get(bs[i]).getA()
            ).append(",").append(map.get(bs[i]).getB()).append("\n").toString();
        }

        return sb.toString();
    }

    /**
     * @param rows
     * @param nrows
     * @return
     */
    public String task4(Row[] rows, int nrows) {
        // 在task3的基础上，判断rows.getA()是否能被1000整除
        boolean flag = true;
        String a = rows[0].getA() / 1000 + "";
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(a.charAt(i))) {
                flag = false;
                break;
            }
        }

        if (flag) {
           // 说明能被1000整除
        }

        return  null;
    }
}

/**
 * 定义row对象，包含a和b两个属性。
 */
class Row {
    private int a;
    private int b;

    public Row(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
