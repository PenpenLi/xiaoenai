package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public abstract interface AuthorizeListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Bundle paramBundle);
  
  public abstract void onError(Throwable paramThrowable);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\authorize\AuthorizeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */