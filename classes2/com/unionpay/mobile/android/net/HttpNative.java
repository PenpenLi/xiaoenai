package com.unionpay.mobile.android.net;

public class HttpNative
{
  private static HttpNative a = null;
  
  public static HttpNative a()
  {
    if (a == null) {
      a = new HttpNative();
    }
    return a;
  }
  
  public native String getIssuer(int paramInt);
  
  public native String getSubject(int paramInt);
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\net\HttpNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */