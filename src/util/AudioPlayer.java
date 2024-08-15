package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private static Clip clip;
    private static AudioInputStream audioInputStream;
    public static void playAudio(String path){
        File sonfFile = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(sonfFile);
            // here we got audio clip
            clip  = AudioSystem.getClip();
            // open clip
            clip.open(audioInputStream);
            // play
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }
}
