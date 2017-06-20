package ev3dev.hardware;

public class PlatformTest extends EV3DevDevice {

	public static void main(String[] args) {
		final PlatformTest platform = new PlatformTest();
		final EV3DevPlatform value = platform.getPlatform();
		System.out.println("Using the platform: " + value);
	}

}
