package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.w;

final class b$1
  extends FileObserver
{
  b$1(b paramb, String paramString, int paramInt)
  {
    super(paramString, 8);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = "/data/anr/" + paramString;
    if (!paramString.contains("trace"))
    {
      w.d("not anr file %s", new Object[] { paramString });
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */