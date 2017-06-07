package com.example;

import ev3dev.sensors.Battery;

public class Hello implements HelloMBean {

    public void sayHello() { 
        System.out.println("hello, world"); 
    } 
     
    public int add(int x, int y) { 
        return x + y; 
    } 
     
    public String getName() { 
        return this.name; 
    }  
     
    public int getCacheSize() { 
        return this.cacheSize; 
    } 
     
    public synchronized void setCacheSize(int size) {

    
        this.cacheSize = size; 
        System.out.println("Cache size now " + this.cacheSize); 
    }

    @Override
    public float getBatteryVoltage() {
        return Battery.getInstance().getVoltage();
    }


    private final String name = "Reginald"; 
    private int cacheSize = DEFAULT_CACHE_SIZE; 
    private static final int 
        DEFAULT_CACHE_SIZE = 200; 
}