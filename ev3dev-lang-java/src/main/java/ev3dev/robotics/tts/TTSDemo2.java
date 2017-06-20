package ev3dev.robotics.tts;

public class TTSDemo2 {

	public static void main(String[] args) {

		System.out.println("Testing Espeak on EV3Brick");

		Espeak TTS = new Espeak();
		TTS.setVolume(100);

		//English example
		TTS.setMessage("I am a LEGO robot");
		TTS.say();
	}

}
