package com.alibaba.nb.android.trade.callback;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class AliTradeCallbackContext
{
  private static final String a = AliTradeCallbackContext.class.getSimpleName();
  public static volatile WeakReference<Activity> activity;
  public static volatile Object loginCallback;
  public static volatile Object paymentProcessCallback;
  public static volatile AliTradeProcessCallback tradeProcessCallback;
  
  public static void setActivity(Activity paramActivity)
  {
    activity = new WeakReference(paramActivity);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\callback\AliTradeCallbackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */