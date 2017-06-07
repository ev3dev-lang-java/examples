package com.example;

import java.lang.management.*;
import javax.management.*; 
 
public class Main { 
 
    public static void main(String[] args) 
        throws Exception { 
     
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        ObjectName name = new ObjectName("com.example:type=Hello"); 
        Hello mbean = new Hello(); 
        mbs.registerMBean(mbean, name);
     
        System.out.println("Waiting forever..."); 
        Thread.sleep(Long.MAX_VALUE); 
    } 
} 