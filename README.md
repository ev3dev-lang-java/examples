# ev3dev-lang-java /examples

This repository store a set of examples ready to use with the ev3dev-lang-java libraries.
 
# Getting Started

## 1. Install EV3Dev on your brick

The first step is the creation of an image of EV3Dev with latest version 
of this project.

To complete this step, read the following tutorial: http://www.ev3dev.org/docs/getting-started/

## 2. Install Java 8 on your brick

To install Java 8 on a EV3 Brick with EV3Dev, follow the steps.

**Download Java 8 jre from Oracle:**

[http://www.oracle.com/technetwork/java/embedded/downloads/javase/javaseemeddedev3-1982511.html](http://www.oracle.com/technetwork/java/embedded/downloads/javase/javaseemeddedev3-1982511.html)

**Copy the zip from your laptop to your brick:**

```
scp ejdk-8-fcs-b132-linux-arm-sflt-03_mar_2014.gz robot@EV3_IP:/home/robot/
sudo tar zxvf ejdk-8-fcs-b132-linux-arm-sflt-03_mar_2014.gz -C /opt
sudo update-alternatives --install /usr/bin/java java /opt/ejdk1.8.0/linux_arm_sflt/jre/bin/java 1
java -version
``

After the installation, you should have the following result:

``
robot@ev3dev:~$ java -version
java version "1.8.0"
Java(TM) SE Embedded Runtime Environment (build 1.8.0-b132, headless)
Java HotSpot(TM) Embedded Client VM (build 25.0-b70, mixed mode)
```

### 2.1 Install OpenCV for Java

``` 
sudo apt-get install libopencv2.4-java
```

## 3. Create your first project with ev3dev-lang-java

### 3.1 Adding ev3dev-lang-java as a dependency

Modern Java software use a build file. In the market the 
most popular build system for Java are Maven & Gradle. 

This repository store all examples in a Java project using a Gradle 
file.

ev3dev-lang-java is possible to be used in Maven/Gradle adding as a
 dependency:

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
 	
dependencies {
    compile 'com.github.ev3dev-lang-java:ev3dev-lang-java:v0.3.0'
}
 	
```

Further information to import the library here:  
https://jitpack.io/#ev3dev-lang-java/ev3dev-lang-java/v0.3.0 

### 3.2 Define a Manifest to launch a jar file with a specific Main 
class

This repository has a Manifest.mf file with details about how to 
execute the examples in the brick:

```
Manifest-Version: 1.0
Implementation-Title: EV3Dev-lang-java / examples
Implementation-Version: 0.3.0
Implementation-Vendor: Juan Antonio Breña Moral
Main-Class: hardware.sensors.ev3.TouchSensorDemo
```

### 3.3 Update logback.xml to show/hide log messages

ev3dev-lang-java has log support to help the developer to debug 
the software and the interaction with EV3Dev.

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>
                %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
            </Pattern>
        </encoder>
    </appender>

    <logger name="ch.qos.logback.core" level="OFF" />
    <logger name="ev3dev.hardware" level="DEBUG" />

    <root level="DEBUG">
        <appender-ref ref="STDOUT" />
    </root>

</configuration>
``` 

Edit the file to change log levels.
 
### Execute one example.

Using the project, execute the task "deployAndRun" to generate a 
FatJar about the project and send remotely to your brick.

```
18:05:34: Executing external task 'deployAndRun'...
:clean
:compileJava
:processResources
:classes
:fatJar
:deploy
:remoteRun
java -jar /home/robot/examples-all-0.1.0.jar
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG ev3dev.hardware.EV3DevDevice - Detecting motors with port: in1
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG ev3dev.utils.Sysfs - ls /sys/class/lego-sensor
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/address
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG ev3dev.hardware.EV3DevDevice - Detected port on path: /sys/class/lego-sensor/sensor6/address
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:19 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 0
ev3dev#131|2017-01-07 17:06:19 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:19 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:20 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:20 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 1
ev3dev#131|2017-01-07 17:06:20 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:20 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:21 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:21 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 2
ev3dev#131|2017-01-07 17:06:21 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:21 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:21 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:21 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 3
ev3dev#131|2017-01-07 17:06:21 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 1
ev3dev#131|2017-01-07 17:06:21 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:22 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:22 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 4
ev3dev#131|2017-01-07 17:06:22 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 1
ev3dev#131|2017-01-07 17:06:22 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:22 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:22 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 5
ev3dev#131|2017-01-07 17:06:22 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:22 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:23 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:23 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 6
ev3dev#131|2017-01-07 17:06:23 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:23 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:23 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:23 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 7
ev3dev#131|2017-01-07 17:06:23 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:23 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:24 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:24 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 8
ev3dev#131|2017-01-07 17:06:24 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:24 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:24 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:24 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 9
ev3dev#131|2017-01-07 17:06:24 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:24 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:25 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:25 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 10
ev3dev#131|2017-01-07 17:06:25 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:25 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:25 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:25 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 11
ev3dev#131|2017-01-07 17:06:26 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:26 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:26 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:26 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 12
ev3dev#131|2017-01-07 17:06:26 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:26 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:27 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:27 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 13
ev3dev#131|2017-01-07 17:06:27 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:27 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:27 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:27 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 14
ev3dev#131|2017-01-07 17:06:27 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:27 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:28 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:28 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 15
ev3dev#131|2017-01-07 17:06:28 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:28 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:28 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:28 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 16
ev3dev#131|2017-01-07 17:06:28 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:28 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:29 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:29 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 17
ev3dev#131|2017-01-07 17:06:29 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:29 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:29 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:29 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 18
ev3dev#131|2017-01-07 17:06:29 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:29 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:30 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:30 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 19
ev3dev#131|2017-01-07 17:06:30 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:30 [main] DEBUG lejos.utility.Delay - Delay: 500
ev3dev#131|2017-01-07 17:06:30 [main] DEBUG ev3dev.utils.Sysfs - cat /sys/class/lego-sensor/sensor6/value0
ev3dev#131|2017-01-07 17:06:30 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Iteration: 20
ev3dev#131|2017-01-07 17:06:30 [main] INFO  hardware.sensors.ev3.TouchSensorDemo - Touch: 0
ev3dev#131|2017-01-07 17:06:30 [main] DEBUG lejos.utility.Delay - Delay: 500
:deployAndRun
``` 







