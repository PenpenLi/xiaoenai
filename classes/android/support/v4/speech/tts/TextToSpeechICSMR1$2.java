package android.support.v4.speech.tts;

import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;

final class TextToSpeechICSMR1$2
  implements TextToSpeech.OnUtteranceCompletedListener
{
  TextToSpeechICSMR1$2(TextToSpeechICSMR1.UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1) {}
  
  public void onUtteranceCompleted(String paramString)
  {
    this.val$listener.onStart(paramString);
    this.val$listener.onDone(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\speech\tts\TextToSpeechICSMR1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */