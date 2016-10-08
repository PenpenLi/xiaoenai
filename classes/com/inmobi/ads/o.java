package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.InMobiAdActivity;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import java.util.HashMap;
import java.util.Map;

class o
  extends AdUnit
{
  private static final String a = o.class.getSimpleName();
  private int b = 0;
  private boolean c = false;
  private int d = -1;
  private long e = 0L;
  
  public o(Context paramContext, long paramLong, AdUnit.a parama)
  {
    super(paramContext, paramLong, parama);
  }
  
  void A()
  {
    this.c = true;
    if (n() != null) {
      n().n();
    }
  }
  
  protected String a()
  {
    return "int";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      f().getResources().getAnimation(paramInt1);
      f().getResources().getAnimation(paramInt2);
      this.d = paramInt1;
      n().setFullScreenExitAnimation(paramInt2);
      x();
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.ERROR, a, "The supplied resource id with show for animations is invalid", localNotFoundException);
      }
    }
  }
  
  public void a(a parama)
  {
    super.a(parama);
    if (g() == AdUnit.AdState.STATE_AVAILABLE) {
      b(h());
    }
  }
  
  public void a(RenderView paramRenderView)
  {
    super.a(paramRenderView);
    if (g() == AdUnit.AdState.STATE_LOADED)
    {
      u();
      a(AdUnit.AdState.STATE_READY);
      w();
      m().a();
      r();
    }
  }
  
  public void b(RenderView paramRenderView)
  {
    super.b(paramRenderView);
    if (g() == AdUnit.AdState.STATE_LOADED)
    {
      u();
      a(AdUnit.AdState.STATE_FAILED);
      m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
    }
  }
  
  protected String c()
  {
    return null;
  }
  
  public void c(RenderView paramRenderView)
  {
    super.c(paramRenderView);
    if (g() == AdUnit.AdState.STATE_AVAILABLE) {
      a(AdUnit.AdState.STATE_LOADED);
    }
  }
  
  protected RenderingProperties.PlacementType d()
  {
    return RenderingProperties.PlacementType.FULL_SCREEN;
  }
  
  protected Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    if (p()) {}
    for (String str = String.valueOf(1);; str = String.valueOf(0))
    {
      localHashMap.put("preload-request", str);
      return localHashMap;
    }
  }
  
  public void e(RenderView paramRenderView)
  {
    for (;;)
    {
      try
      {
        super.e(paramRenderView);
        if (g() == AdUnit.AdState.STATE_RENDERED)
        {
          this.b += 1;
          if (this.b == 1)
          {
            m().b();
            return;
          }
          a(AdUnit.AdState.STATE_ACTIVE);
          continue;
        }
        if (g() != AdUnit.AdState.STATE_ACTIVE) {
          continue;
        }
      }
      finally {}
      this.b += 1;
    }
  }
  
  /* Error */
  public void f(RenderView paramRenderView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 198	com/inmobi/ads/AdUnit:f	(Lcom/inmobi/rendering/RenderView;)V
    //   7: aload_0
    //   8: invokevirtual 94	com/inmobi/ads/o:g	()Lcom/inmobi/ads/AdUnit$AdState;
    //   11: getstatic 196	com/inmobi/ads/AdUnit$AdState:STATE_ACTIVE	Lcom/inmobi/ads/AdUnit$AdState;
    //   14: if_acmpne +31 -> 45
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 30	com/inmobi/ads/o:b	I
    //   22: iconst_1
    //   23: isub
    //   24: putfield 30	com/inmobi/ads/o:b	I
    //   27: aload_0
    //   28: getfield 30	com/inmobi/ads/o:b	I
    //   31: iconst_1
    //   32: if_icmpne +10 -> 42
    //   35: aload_0
    //   36: getstatic 191	com/inmobi/ads/AdUnit$AdState:STATE_RENDERED	Lcom/inmobi/ads/AdUnit$AdState;
    //   39: invokevirtual 121	com/inmobi/ads/o:a	(Lcom/inmobi/ads/AdUnit$AdState;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: invokevirtual 94	com/inmobi/ads/o:g	()Lcom/inmobi/ads/AdUnit$AdState;
    //   49: getstatic 191	com/inmobi/ads/AdUnit$AdState:STATE_RENDERED	Lcom/inmobi/ads/AdUnit$AdState;
    //   52: if_acmpne -10 -> 42
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 30	com/inmobi/ads/o:b	I
    //   60: iconst_1
    //   61: isub
    //   62: putfield 30	com/inmobi/ads/o:b	I
    //   65: aload_0
    //   66: getstatic 201	com/inmobi/ads/AdUnit$AdState:STATE_CREATED	Lcom/inmobi/ads/AdUnit$AdState;
    //   69: invokevirtual 121	com/inmobi/ads/o:a	(Lcom/inmobi/ads/AdUnit$AdState;)V
    //   72: new 166	java/util/HashMap
    //   75: dup
    //   76: invokespecial 168	java/util/HashMap:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: ldc -53
    //   83: aload_0
    //   84: invokevirtual 206	com/inmobi/ads/o:j	()Ljava/lang/String;
    //   87: invokeinterface 209 3 0
    //   92: pop
    //   93: invokestatic 214	com/inmobi/commons/core/c/a:a	()Lcom/inmobi/commons/core/c/a;
    //   96: ldc -40
    //   98: ldc -38
    //   100: aload_1
    //   101: invokevirtual 221	com/inmobi/commons/core/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   104: aload_0
    //   105: invokevirtual 128	com/inmobi/ads/o:m	()Lcom/inmobi/ads/AdUnit$a;
    //   108: invokeinterface 223 1 0
    //   113: aload_0
    //   114: invokevirtual 226	com/inmobi/ads/o:t	()V
    //   117: goto -75 -> 42
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	o
    //   0	125	1	paramRenderView	RenderView
    // Exception table:
    //   from	to	target	type
    //   2	42	120	finally
    //   45	117	120	finally
  }
  
  public void o()
  {
    if (this.e != 0L)
    {
      int i = l().f();
      if (SystemClock.elapsedRealtime() - this.e < i * 1000)
      {
        a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + i + " seconds"), false);
        Logger.a(Logger.InternalLogLevel.ERROR, a, "Ad cannot be refreshed before " + i + " seconds");
        return;
      }
    }
    if (g() == AdUnit.AdState.STATE_RENDERED)
    {
      a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false);
      Logger.a(Logger.InternalLogLevel.ERROR, a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
      return;
    }
    this.e = SystemClock.elapsedRealtime();
    super.o();
  }
  
  protected void q()
  {
    super.q();
    if (this.c) {
      n().n();
    }
  }
  
  protected void t()
  {
    super.t();
    this.d = -1;
  }
  
  protected void v()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Renderview timed out.");
    c("RenderTimeOut");
    if (g() == AdUnit.AdState.STATE_LOADED)
    {
      a(AdUnit.AdState.STATE_FAILED);
      m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
    }
  }
  
  public void x()
  {
    new Handler(Looper.getMainLooper()).post(new o.1(this));
  }
  
  void y()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, ">>> Starting " + InMobiAdActivity.class.getSimpleName() + " to display interstitial ad ...");
    int i = InMobiAdActivity.a(n());
    Intent localIntent = new Intent(f(), InMobiAdActivity.class);
    localIntent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_RENDERVIEW_INDEX", i);
    localIntent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
    localIntent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
    com.inmobi.commons.a.a.a(f(), localIntent);
    if (((f() instanceof Activity)) && (this.d != -1)) {
      ((Activity)f()).overridePendingTransition(this.d, 0);
    }
  }
  
  public boolean z()
  {
    return g() == AdUnit.AdState.STATE_READY;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */