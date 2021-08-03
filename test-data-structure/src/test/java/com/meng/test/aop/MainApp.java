package com.meng.test.aop;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class MainApp {
    /**
     * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
     */
    public static void main(String[] args) {
        Dao dao = new DaoImpl();

        Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(), new Class<?>[]{Dao.class}, new LogInvocationHandler(dao));

        proxyDao.insert();
        System.out.println("----------分割线----------");
        proxyDao.delete();
        System.out.println("----------分割线----------");
        proxyDao.update();
    }

    @Test
    public void test2() {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DaoImpl.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (DaoImpl)enhancer.create();
        dao.insert();
        System.out.println("----------分割线----------");
        dao.delete();
        System.out.println("----------分割线----------");
        dao.update();
    }
}
