# ev3dev-lang-java /examples

This repository store a set of examples ready to use with the
ev3dev-lang-java libraries.

## Checking it out

You can build the project and upload all programs with their dependencies with these commands:
```sh
./gradlew uploadGradleLibraries
./gradlew deploy
```

You can then run them from the ev3dev menu in the `examples` subdirectory.

Alternatively, you can also work only with one project at a time:
```sh
./gradlew :opencv:deploy    # only upload 'opencv' project
./gradlew :opencv:run       # only run already uploaded build of 'opencv' project
./gradlew :opencv:deployRun # only upload and run 'opencv' project
```

To remove all samples from the brick, just run:
```sh
./gradlew undeploy
```

## Contents

Take a look the following examples to discover some features included with this Java project.

**EV3Dev-lang-Java:**

- ev3dev.misc
- [BumperCar](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/misc/BumperCar.java)
- [BumperCar2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/misc/BumperCar2.java)
- ev3dev.robotics.tts
- [TTSDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/robotics/tts/TTSDemo.java)
- [TTSDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/robotics/tts/TTSDemo2.java)
- ev3dev.actuators
- [LCDDrawIconsTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDDrawIconsTest.java)
- [LCDDrawImagesTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDDrawImagesTest.java)
- [LCDDrawLinesTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDDrawLinesTest.java)
- [LCDDrawRectanglesTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDDrawRectanglesTest.java)
- [LCDFontTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDFontTest.java)
- [LCDTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDTest.java)
- [LCDWriteTextTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/LCDWriteTextTest.java)
- [SoundDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/SoundDemo.java)
- ev3dev.actuators.ev3
- [LEDExample](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/ev3/LEDExample.java)
- ev3dev.actuators.lego.motors
- [LargeMotorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/LargeMotorDemo.java)
- [LargeMotorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/LargeMotorDemo2.java)
- [MediumMotorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/MediumMotorDemo.java)
- [MotorEventTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/MotorEventTest.java)
- [MultipleMotorsDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/MultipleMotorsDemo.java)
- [MultipleMotorsStopDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/MultipleMotorsStopDemo.java)
- [RegulatedMotorRotateDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/RegulatedMotorRotateDemo.java)
- [RegulatedMotorRotateDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/RegulatedMotorRotateDemo.java)
- [RegulatedMotorRotateToDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/RegulatedMotorRotateToDemo.java)
- [UnregulatedMotorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/UnregulatedMotorDemo.java)
- [UnregulatedMotorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/UnregulatedMotorDemo2.java)
- [UnregulatedMutilpleMotorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/actuators/lego/motors/UnregulatedMutilpleMotorDemo.java)
- ev3dev.sensors
- [BatteryDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/BatteryDemo.java)
- [ButtonExample](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ButtonExample.java)
- ev3dev.sensors.ev3
- [ColorSensorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/ColorSensorDemo.java)
- [ColorSensorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/ColorSensorDemo2.java)
- [ColorSensorDemo3](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/ColorSensorDemo3.java)
- [ColorSensorMultipleDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/ColorSensorMultipleDemo.java)
- [GyroSensorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/GyroSensorDemo.java)
- [GyroSensorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/GyroSensorDemo2.java)
- [GyroSensorDemo3](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/GyroSensorDemo3.java)
- [IRSensorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/IRSensorDemo.java)
- [IRSensorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/IRSensorDemo2.java)
- [IRSensorDemo3](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/IRSensorDemo3.java)
- [TouchSensorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/TouchSensorDemo.java)
- [USSensorDemo](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/USSensorDemo.java)
- [USSensorDemo2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/sensors/ev3/USSensorDemo2.java)
- ev3dev.hardware
- [PlatformTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/ev3dev/hardware/PlatformTest.java)

**lejos-commons:**

- lejos.commons.subsumption
- [BumperCar](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/commons/subsumption/BumperCar.java)
- [DriveForward](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/commons/subsumption/DriveForward.java)
- [HitWall](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/commons/subsumption/HitWall.java)

**lejos-navigation:**

- lejos.robotics.navigation
- [PilotConfig](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/pilot/PilotConfig.java)
- [PilotConfig2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/pilot/PilotConfig2.java)
- [DifferentialPilotStopTest](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/pilot/DifferentialPilotStopTest.java)
- [DifferentialPilotTest1](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/pilot/DifferentialPilotTest1.java)
- [DifferentialPilotTest9](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/pilot/DifferentialPilotTest9.java)
- [MoveControllerTest1](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/MoveControllerTest1.java)
- [MoveControllerTest2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/MoveControllerTest2.java)
- [NavigatorTest1](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/NavigatorTest1.java)
- [NavigatorTest2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/NavigatorTest2.java)
- [NavigatorTest3](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/NavigatorTest3.java)
- [NavigatorTest4](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/navigator/NavigatorTest4.java)
- lejos.robotics.objectdetection
- [FeatureAvoider](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/feature/FeatureAvoider.java)
- [FeatureAvoider2](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/feature/FeatureAvoider2.java)
- [FeatureAvoider3](https://github.com/ev3dev-lang-java/examples/blob/develop/ev3dev-lang-java/src/main/java/lejos/navigation/feature/FeatureAvoider3.java)


