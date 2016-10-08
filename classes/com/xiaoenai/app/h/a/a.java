package com.xiaoenai.app.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;

public final class a
{
  private static a b = null;
  private Context a = null;
  private a c = null;
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString)
  {
    if ((this.c == null) || (!this.c.a()))
    {
      Context localContext = paramContext;
      if (paramContext == null) {
        localContext = this.a;
      }
      AdhocTracker.incrementStat(localContext, paramString, 1);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean, String paramString, int paramInt, long paramLong, a parama)
  {
    if (this.a == null)
    {
      paramContext = paramContext.getApplicationContext();
      this.a = paramContext;
      this.c = parama;
      AdhocTracker.setGapTimeGetFlag(paramContext, paramInt);
      AdhocTracker.setGapTimeSendCacheData(paramLong);
      AdhocTracker.reportCrashEnable(true);
      if (TextUtils.isEmpty(paramString)) {
        AdhocTracker.init(paramContext, "ADHOC_e4dff3eb-ffb3-42f6-988e-e13f4de61085");
      }
    }
    else
    {
      return;
    }
    AdhocTracker.initWithClientId(paramContext, "ADHOC_e4dff3eb-ffb3-42f6-988e-e13f4de61085", paramString);
  }
  
  public boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (this.c == null) {
      bool = false;
    }
    do
    {
      return bool;
      if (("mzd_https_enable".equals(paramString)) && (!this.c.b())) {
        return false;
      }
      if (this.c == null) {
        break;
      }
      bool = paramBoolean;
    } while (this.c.a());
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = this.a;
    }
    return AdhocTracker.getExperimentFlags(localContext).getBooleanFlag(paramString, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract boolean a();
    
    public abstract boolean b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */