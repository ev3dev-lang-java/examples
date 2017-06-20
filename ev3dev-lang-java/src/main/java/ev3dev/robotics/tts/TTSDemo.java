package ev3dev.robotics.tts;

public class TTSDemo {

	public static void main(String[] args) {

		System.out.println("Testing Espeak on EV3Brick");

		Espeak TTS = new Espeak();
		TTS.setVolume(100);

		//Spanish example
		TTS.setVoice("es");
		TTS.setSpeedReading(200);
		TTS.setPitch(50);
		TTS.setMessage("Soy un robot LEGO");
		TTS.say();
		
		//English example
		TTS.setVoice("en");
		TTS.setSpeedReading(105);
		TTS.setPitch(60);
		TTS.setMessage("I am a LEGO robot");
		TTS.say();
	}

}
