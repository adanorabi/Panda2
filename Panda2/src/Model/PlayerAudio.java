package Model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayerAudio {
	public static void playVictorySound() {
        try {
            File audioFile = new File("/Audio/victory.wav"); // Adjust the file path accordingly
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void playHPSound(String response) {
		try {
			File audioFile = new File("src/Model/Audio/MainPage.wav"); // Adjust the file path accordingly
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);


			while(!response.equals("Q")) {
			

				switch(response) {
				case ("P"): clip.start();
				break;
				case ("S"): clip.stop();
				break;
				case ("R"): clip.setMicrosecondPosition(0);
				break;
				case ("Q"): clip.close();
				break;
				default: System.out.println("Not a valid response");
				}
			}
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}