package org.ev3dev;
 
import java.lang.management.*;
import javax.management.*; 
 
public class Main { 
 
    public static void main(String[] args) 
        throws Exception { 
     
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        ObjectName name = new ObjectName("org.ev3dev:type=Brick");
        Brick mbean = new Brick();
        mbs.registerMBean(mbean, name);
     
        System.out.println("Waiting forever..."); 
        Thread.sleep(Long.MAX_VALUE); 
    } 
} 