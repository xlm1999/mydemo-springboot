package com.meng.offline;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class OffLineTest {
    String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<response><status>1</status><info>OK</info><infocode>10000</infocode><regeocode><formatted_address>江西省南昌市青山湖区冠山管理处</formatted_address><addressComponent><country>中国</country><province>江西省</province><city>南昌市</city><citycode>0791</citycode><district>青山湖区</district><adcode>360111</adcode><township>冠山管理处</township><towncode>360111482000</towncode><neighborhood><name></name><type></type></neighborhood><building><name></name><type></type></building><streetNumber><street></street><number></number><direction></direction><distance></distance></streetNumber><businessAreas type=\"list\"><businessArea/></businessAreas></addressComponent><pois type=\"list\"/><roads type=\"list\"/><roadinters type=\"list\"/><aois type=\"list\"/></regeocode></response>";


    @Test
    public void test1(){
        String str = "abcdefg" ;
        try {
            String s = getSite(XML);
            System.out.println(s.length());
            System.out.println(s.substring(0,6));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public String getSite(String str) throws DocumentException {
        Document doc = DocumentHelper.parseText(str) ;//从字符串中读取xml
        Element rootElt = doc.getRootElement(); // 获取根节点
        List first = rootElt.elements();
        for (Iterator<?> its = first.iterator(); its.hasNext();) {
            Element e = (Element) its.next();
            List   second = e.elements();
            for (Iterator<?> it = second.iterator(); it.hasNext();) {
                Element t = (Element) it.next();
                return t.getText() ;
            }
        }
        return null ;
    }
    public static void main(String[] args) throws DocumentException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response><status>1</status><info>OK</info><infocode>10000</infocode><regeocode><formatted_address>江西省南昌市青山湖区冠山管理处</formatted_address><addressComponent><country>中国</country><province>江西省</province><city>南昌市</city><citycode>0791</citycode><district>青山湖区</district><adcode>360111</adcode><township>冠山管理处</township><towncode>360111482000</towncode><neighborhood><name></name><type></type></neighborhood><building><name></name><type></type></building><streetNumber><street></street><number></number><direction></direction><distance></distance></streetNumber><businessAreas type=\"list\"><businessArea/></businessAreas></addressComponent><pois type=\"list\"/><roads type=\"list\"/><roadinters type=\"list\"/><aois type=\"list\"/></regeocode></response>";
        Document doc = DocumentHelper.parseText(str) ;//从字符串中读取xml
        Element rootElt = doc.getRootElement(); // 获取根节点
        String city  = "";
        List first = rootElt.elements();
       /* for (Iterator<?> its = first.iterator(); its.hasNext();) {
            Element e = (Element) its.next();
//            System.out.println(e);
             *//*--------------regeocode---------------------*//*
            List   second = e.elements();
            for (Iterator<?> it = second.iterator(); it.hasNext();) {
                Element t = (Element) it.next();
                System.out.println(t.getText());
                city =t.getText() ;
            }
        }*/
        System.out.println(city.substring(0,6));

    }
     /*  for (Iterator<?> temp = list.iterator(); it.hasNext();) {
            Element t = (Element) temp.next();
            System.out.println(t);
        }*/


//        System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称


        /*Iterator iter = rootElt.elementIterator("regeocode"); // 获取根节点下的子节点head

        while (iter.hasNext()){
            Element recordEle = (Element) iter.next();
            System.out.println(recordEle.toString());
        }*/
}
