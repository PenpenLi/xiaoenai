package android.support.v4.app;

import android.os.Bundle;

final class RemoteInput$1
  implements RemoteInputCompatBase.RemoteInput.Factory
{
  public RemoteInput build(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    return new RemoteInput(paramString, paramCharSequence, paramArrayOfCharSequence, paramBoolean, paramBundle, null);
  }
  
  public RemoteInput[] newArray(int paramInt)
  {
    return new RemoteInput[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\RemoteInput$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */