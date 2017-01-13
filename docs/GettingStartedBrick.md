# Getting Started on your Brick.

## 1. Install EV3Dev on your brick

The first step is the creation of an image of EV3Dev with latest version 
of this project.

To complete this step, read the following tutorial: http://www.ev3dev.org/docs/getting-started/

### 1.1 Update distro

Check if your EV3Brick with EV3Dev need some upgrade:

``` bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get dist-upgrade
sudo reboot
```


## 2. Install Java 8 on your brick

### 2.1 Install Java 8 on EV3 Brick

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

### 2.2 Install Java 8 for BrickPi

```
sudo apt-get install software-properties-common
sudo apt-key adv --recv-key --keyserver keyserver.ubuntu.com EEA14886
sudo vi /etc/apt/sources.list
deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main 
deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main
sudo apt-get update
sudo apt-get install oracle-java8-installer
``

## 3 Install OpenCV for Java

``` 
sudo apt-get install libopencv2.4-java
```

To run an application with OpenCV has to indicate JVM some information about OpenCV native installation:

```
find / -name "libopencv_java249.so"
/usr/lib/jni/libopencv_java249.so
java -Djava.library.path=/usr/lib/jni/ -cp examples-all-0.1.0.jar:/usr/share/OpenCV/java/opencv-249.jarjava -Djava.library.path=/usr/lib/jni/ -cp examples-all-0.1.0.jar:/usr/share/OpenCV/java/opencv-249.jar opencv/HelloWorldCV
2017-01-07 19:22:54 [main] INFO  opencv.HelloWorldCV - Welcome to OpenCV 2.4.9.0
2017-01-07 19:22:55 [main] INFO  opencv.HelloWorldCV - /usr/lib/jni/
2017-01-07 19:23:02 [main] INFO  opencv.HelloWorldCV - m = [1, 0, 0;
  0, 1, 0;
  0, 0, 1]
``  
