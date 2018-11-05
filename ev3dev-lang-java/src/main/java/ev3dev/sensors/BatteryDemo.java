package examples.sensors;

import ev3dev.sensors.Battery;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatteryDemo {

	public static void main(String[] args) {

		BatteryDemo example = new BatteryDemo();

        final Battery battery = Battery.getInstance();

		for(int x = 0; x < 20; x++){
			LOGGER.info("Battery Voltage: " + battery.getVoltage());

			Delay.msDelay(1000);
		}
	}

}
