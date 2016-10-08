package android.support.v4.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;

final class FingerprintManagerCompatApi23$1
  extends FingerprintManager.AuthenticationCallback
{
  FingerprintManagerCompatApi23$1(FingerprintManagerCompatApi23.AuthenticationCallback paramAuthenticationCallback) {}
  
  public void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationFailed()
  {
    this.val$callback.onAuthenticationFailed();
  }
  
  public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompatApi23.AuthenticationResultInternal(FingerprintManagerCompatApi23.access$000(paramAuthenticationResult.getCryptoObject())));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\hardware\fingerprint\FingerprintManagerCompatApi23$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */