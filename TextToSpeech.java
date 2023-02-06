import javax.speech.*;
import javax.speech.synthesis.*;
import java.util.Locale;

public class TextToSpeech {
  public static void main(String[] args) {
    try {
      // Set the synthesizer to use the default locale
      Synthesizer synthesizer = Central.createSynthesizer(null);
      synthesizer.allocate();

      // Get the voice to use for speaking
      Voice voice = synthesizer.getVoices()[0];
      synthesizer.getSynthesizerProperties().setVoice(voice);

      // Convert the input text to speech
      System.out.println("Enter the text to convert to speech:");
      String input = System.console().readLine();
      synthesizer.speakPlainText(input, null);
      synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
      
      // Deallocate the synthesizer
      synthesizer.deallocate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
