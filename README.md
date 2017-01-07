# ev3dev-lang-java /examples

This repository store a set of examples ready to use with the 
ev3dev-lang-java libraries.
 
# [1. Getting Started on your computer](./docs/GettingStartedLaptop.md)

# [2. Getting Started on your Brick](./docs/GettingStartedBrick.md)

# 3. Using the project to learn the API by examples

## 3.1 Update the manifest a specify the example to run on your brick.

This repository has a Manifest.mf file with details about how to 
execute the examples in the brick:

```
Manifest-Version: 1.0
Implementation-Title: EV3Dev-lang-java / examples
Implementation-Version: 0.3.0
Implementation-Vendor: Juan Antonio Breña Moral
Main-Class: hardware.sensors.ev3.TouchSensorDemo
```

Change the name of the class that you want to test on your brick. Idea 
has a good integration with Manifest files.

## 3.2 Review that your Brick has a Wifi connection and update gradle
settings

Review that your Brick has a Wifi Connection and update the settings 
on your Gradle file:

```
remotes {
    ev3dev {
        host = '192.168.1.2'
        user = 'robot'
        password = 'maker'
    }
}
```

## 3.3 Execute one example.

Using the project, execute the task "deployAndRun" to generate a 
FatJar about the project and send remotely to your brick. With Idea 
is easy to launch a Gradle task or using a Terminal type:

```
./gradlew deployAndRun
```

Console output from Idea:

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
:deployAndRun
``` 

# 4 Advanced topics

### 4.1 Update logback.xml to show/hide log messages

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








