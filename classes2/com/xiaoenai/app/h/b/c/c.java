package com.xiaoenai.app.h.b.c;

import android.content.Context;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.LogLevel;

public final class c
{
  public static void a(Context paramContext, String paramString)
  {
    InMobiSdk.setLogLevel(InMobiSdk.LogLevel.NONE);
    InMobiSdk.init(paramContext, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */