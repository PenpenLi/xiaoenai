package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import com.taobao.wireless.security.adapter.JNICLibrary;
import com.taobao.wireless.security.adapter.common.SPUtility2;

public final class a
{
  private static final Object b = new Object();
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    DeviceInfoCapturer.initialize(this.a, this);
  }
  
  public static String a()
  {
    synchronized (b)
    {
      String str = SPUtility2.readFromSPUnified("DataCollectionData", "key_nick", "");
      return str;
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = b;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      paramString = a();
      if ((!str.equals(paramString)) && (SPUtility2.saveToSPUnified("DataCollectionData", "key_nick", str, true)))
      {
        if ((paramString != null) && (paramString.length() != 0)) {
          JNICLibrary.a().doCommandNative(902, null, null, null, null);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */