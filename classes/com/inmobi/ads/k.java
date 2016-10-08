package com.inmobi.ads;

import android.content.Context;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import java.util.HashMap;
import java.util.Map;

class k
  extends AdUnit
{
  private static final String a = k.class.getSimpleName();
  private InMobiBanner b;
  private boolean c = true;
  private boolean d = false;
  private int e = 0;
  
  public k(InMobiBanner paramInMobiBanner, Context paramContext, long paramLong, AdUnit.a parama)
  {
    super(paramContext, paramLong, parama);
    this.b = paramInMobiBanner;
  }
  
  protected String a()
  {
    return "banner";
  }
  
  public void a(a parama)
  {
    super.a(parama);
    if (g() == AdUnit.AdState.STATE_AVAILABLE) {
      b(h());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    super.o();
  }
  
  protected String c()
  {
    return this.b.getFrameSizeString();
  }
  
  public void c(RenderView paramRenderView)
  {
    super.c(paramRenderView);
    if (g() == AdUnit.AdState.STATE_AVAILABLE)
    {
      u();
      a(AdUnit.AdState.STATE_LOADED);
      w();
      m().a();
      r();
    }
  }
  
  protected RenderingProperties.PlacementType d()
  {
    return RenderingProperties.PlacementType.INLINE;
  }
  
  public void d(RenderView paramRenderView)
  {
    super.d(paramRenderView);
    if (g() == AdUnit.AdState.STATE_LOADED)
    {
      a(AdUnit.AdState.STATE_RENDERED);
      paramRenderView = new HashMap();
      paramRenderView.put("type", a());
      paramRenderView.put("impId", j());
      com.inmobi.commons.core.c.a.a().a("ads", "AdRendered", paramRenderView);
    }
  }
  
  protected Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    if (this.c) {}
    for (String str = String.valueOf(1);; str = String.valueOf(0))
    {
      localHashMap.put("u-rt", str);
      localHashMap.put("mk-ad-slot", this.b.getFrameSizeString());
      return localHashMap;
    }
  }
  
  /* Error */
  public void e(RenderView paramRenderView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 152	com/inmobi/ads/AdUnit:e	(Lcom/inmobi/rendering/RenderView;)V
    //   7: aload_0
    //   8: invokevirtual 46	com/inmobi/ads/k:g	()Lcom/inmobi/ads/AdUnit$AdState;
    //   11: getstatic 105	com/inmobi/ads/AdUnit$AdState:STATE_RENDERED	Lcom/inmobi/ads/AdUnit$AdState;
    //   14: if_acmpne +32 -> 46
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 35	com/inmobi/ads/k:e	I
    //   22: iconst_1
    //   23: iadd
    //   24: putfield 35	com/inmobi/ads/k:e	I
    //   27: aload_0
    //   28: getstatic 155	com/inmobi/ads/AdUnit$AdState:STATE_ACTIVE	Lcom/inmobi/ads/AdUnit$AdState;
    //   31: invokevirtual 79	com/inmobi/ads/k:a	(Lcom/inmobi/ads/AdUnit$AdState;)V
    //   34: aload_0
    //   35: invokevirtual 86	com/inmobi/ads/k:m	()Lcom/inmobi/ads/AdUnit$a;
    //   38: invokeinterface 157 1 0
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: invokevirtual 46	com/inmobi/ads/k:g	()Lcom/inmobi/ads/AdUnit$AdState;
    //   50: getstatic 155	com/inmobi/ads/AdUnit$AdState:STATE_ACTIVE	Lcom/inmobi/ads/AdUnit$AdState;
    //   53: if_acmpne -10 -> 43
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 35	com/inmobi/ads/k:e	I
    //   61: iconst_1
    //   62: iadd
    //   63: putfield 35	com/inmobi/ads/k:e	I
    //   66: goto -23 -> 43
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	k
    //   0	74	1	paramRenderView	RenderView
    // Exception table:
    //   from	to	target	type
    //   2	43	69	finally
    //   46	66	69	finally
  }
  
  public void f(RenderView paramRenderView)
  {
    try
    {
      super.f(paramRenderView);
      if (g() == AdUnit.AdState.STATE_ACTIVE)
      {
        this.e -= 1;
        if (this.e == 0)
        {
          a(AdUnit.AdState.STATE_RENDERED);
          m().c();
        }
      }
      return;
    }
    finally
    {
      paramRenderView = finally;
      throw paramRenderView;
    }
  }
  
  protected void q()
  {
    super.q();
    if (this.d) {
      n().n();
    }
  }
  
  void x()
  {
    this.d = true;
    if (n() != null) {
      n().n();
    }
  }
  
  boolean y()
  {
    return this.d;
  }
  
  boolean z()
  {
    return g() == AdUnit.AdState.STATE_ACTIVE;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */