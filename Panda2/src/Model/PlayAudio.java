package Model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class PlayAudio {
	public static Clip hpClip ;
	public static Clip diceClip; 
	public static Clip victoryClip;
	public static Clip playingBackGround;
	public static Clip steps;
	public static void playHPSound() {
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
	public static void playDiceSound() {
		try {
			File audioFile = new File("src/Model/Audio/rollDice.wav"); // Adjust the file path accordingly
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			diceClip = AudioSystem.getClip();
			diceClip.open(audioStream);
			diceClip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public static void playVictorySound() {
  try {
      File audioFile = new File("src/Model/Audio/winner.wav"); // Adjust the file path accordingly
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      victoryClip = AudioSystem.getClip();
      victoryClip.open(audioStream);
      victoryClip.start();
  } catch (Exception e) {
      e.printStackTrace();
  }
}
public static void playSnakeSound() { // function that play sound when movin down throgh a sasake -Yara
	  try {
	    //  File audioFile = new File("src/Model/Audio/snake.wav") snake.wav // Adjust the file path accordingly
	      File audioFile = new File("src/Model/Audio/down.wav");  // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	     Clip snakeClip = AudioSystem.getClip();
	     snakeClip.open(audioStream);
	      snakeClip.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
public static void playLadderSound() { // function that play sound when movin down throgh a sasake -Yara
	  try {
	      File audioFile = new File("src/Model/Audio/ladder.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	     Clip ladderClip = AudioSystem.getClip();
	     ladderClip.open(audioStream);
	     ladderClip.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
public static void playMenuSound() { // function that play sound when choosing button in menu -Yara
	  try {
	      File audioFile = new File("src/Model/Audio/menuButton.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	     Clip menuBT = AudioSystem.getClip();
	     menuBT.open(audioStream);
	     menuBT.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
public static void playRadioSound() { // -Yara
	  try {
	      File audioFile = new File("src/Model/Audio/pickRadio.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	     Clip radioBT = AudioSystem.getClip();
	    radioBT.open(audioStream);
	     radioBT.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
public static void playBoxSound() { // -Yara
	  try {
	      File audioFile = new File("src/Model/Audio/playersNum.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	     Clip box = AudioSystem.getClip();
	    box.open(audioStream);
	     box.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	}
//public static void playGameSound() {
//	 try {
//	      File audioFile = new File("src/Model/Audio/playing.wav"); // Adjust the file path accordingly
//	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//	      
//	    playingBackGround = AudioSystem.getClip();
//	    playingBackGround.open(audioStream);
//	    playingBackGround.start();
//	  } catch (Exception e) {
//	      e.printStackTrace();
//	  }
//}
public static void playGameSound() {
    try {
        File audioFile = new File("src/Model/Audio/playing.wav"); // Adjust the file path accordingly
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        
        playingBackGround = AudioSystem.getClip();
        playingBackGround.open(audioStream);
        
        // Loop the background music continuously
        playingBackGround.loop(Clip.LOOP_CONTINUOUSLY);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void PlayStepsSound() {
	 try {
	      File audioFile = new File("src/Model/Audio/steps.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	  steps = AudioSystem.getClip();
	  steps.open(audioStream);
	   steps.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	
}
public static void PlayBackSound() {
	 try {
	      File audioFile = new File("src/Model/Audio/menuButton.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	  Clip back = AudioSystem.getClip();
	  back.open(audioStream);
	  back.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	
}
public static void PlayGameStartSound() {
	 try {
	      File audioFile = new File("src/Model/Audio/gameStart.wav"); // Adjust the file path accordingly
	      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	      
	  Clip back = AudioSystem.getClip();
	  back.open(audioStream);
	  back.start();
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	
}
//	 public static void playVictorySound() {
//	        try {
//	            File audioFile = new File("src/Model/Audio/winner.wav"); // Adjust the file path accordingly
//	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//	            victoryClip = AudioSystem.getClip();
//	            victoryClip.open(audioStream);
//	            
//	            // Add listener to restart clip when it ends
//	            victoryClip.addLineListener(new LineListener() {
//	                public void update(LineEvent event) {
//	                    if (event.getType() == LineEvent.Type.STOP) {
//	                        victoryClip.setMicrosecondPosition(0);
//	                        victoryClip.start();
//	                    }
//	                }
//	            });
//
//	            victoryClip.start();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }


}