package com.meng.redis.lock.a;

public class TaskThread extends Thread {
    private Service1 service;
    
    public TaskThread(Service1 service) {
        this.service = service;
    }
    
    @Override
    public void run() {
        try {    
            synchronized (this) {
                service.seckill();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Service1 service = new Service1();
        for (int i = 0; i < 20; i++) {
            TaskThread thread = new TaskThread(service);
            thread.start();
        }
    }

}