package android.support.v4.hardware.fingerprint;

final class FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1
  extends FingerprintManagerCompatApi23.AuthenticationCallback
{
  FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1(FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback) {}
  
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
  
  public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal paramAuthenticationResultInternal)
  {
    this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.access$000(paramAuthenticationResultInternal.getCryptoObject())));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\hardware\fingerprint\FingerprintManagerCompat$Api23FingerprintManagerCompatImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */