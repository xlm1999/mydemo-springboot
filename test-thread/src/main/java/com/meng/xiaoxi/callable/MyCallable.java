package com.meng.xiaoxi.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        return "hello callable";
    }
}
