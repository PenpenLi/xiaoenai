package android.support.v4.speech.tts;

import android.speech.tts.UtteranceProgressListener;

final class TextToSpeechICSMR1$1
  extends UtteranceProgressListener
{
  TextToSpeechICSMR1$1(TextToSpeechICSMR1.UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1) {}
  
  public void onDone(String paramString)
  {
    this.val$listener.onDone(paramString);
  }
  
  public void onError(String paramString)
  {
    this.val$listener.onError(paramString);
  }
  
  public void onStart(String paramString)
  {
    this.val$listener.onStart(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\speech\tts\TextToSpeechICSMR1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */