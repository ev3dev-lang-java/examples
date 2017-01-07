# ev3dev-lang-java /examples

This repository store a set of examples ready to use with the ev3dev-lang-java libraries.
 
# Getting Started

## 1. Install EV3Dev on your brick (1 hour)

The first step is the creation of an image of EV3Dev with latest version 
of this project.

To complete this step, read the following tutorial: http://www.ev3dev.org/docs/getting-started/

## 2. Install Java 8 on your brick (30m.)

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



