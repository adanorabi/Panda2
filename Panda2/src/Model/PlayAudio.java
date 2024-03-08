package Model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayAudio {
	public static Clip hpClip ;
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
			hpClip = AudioSystem.getClip();
			hpClip.open(audioStream);
			hpClip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}