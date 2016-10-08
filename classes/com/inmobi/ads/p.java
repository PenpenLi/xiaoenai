package com.inmobi.ads;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class p
  extends AdUnit
  implements n.a
{
  private static final String a = p.class.getSimpleName();
  private Map<p, WeakReference<View>> b = new HashMap();
  private WeakHashMap<View, p> c = new WeakHashMap();
  private String d;
  private String e;
  private n f;
  private URL g;
  private String h;
  private int i = 0;
  private long j = 0L;
  
  public p(long paramLong, AdUnit.a parama)
  {
    super(com.inmobi.commons.a.a.b(), paramLong, parama);
  }
  
  private String b(Map<String, String> paramMap)
  {
    com.inmobi.commons.core.utilities.c.a(paramMap);
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return this.e + "recordEvent(8)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e + "recordEvent(8, ");
    localStringBuilder.append(new JSONObject(paramMap).toString());
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  void A()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Impression record requested for Ad unit (" + hashCode() + ")");
    if (AdUnit.AdState.STATE_ATTACHED == g())
    {
      a(AdUnit.AdState.STATE_RENDERED);
      n().a(true);
      String str = this.e + "recordEvent(18)";
      n().b(str);
      if (this.h != null) {
        n().b(this.h);
      }
      if (this.g != null) {
        com.inmobi.rendering.a.c.a().a(this.g.toExternalForm(), true);
      }
    }
  }
  
  void B()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Open landing page requested");
    com.inmobi.commons.core.c.a.a().a(new e("ads", "OpenLandingPage"));
    if ((AdUnit.AdState.STATE_RENDERED == g()) || (AdUnit.AdState.STATE_ATTACHED == g()))
    {
      String str = this.e + "openLandingPage()";
      n().b(str);
    }
  }
  
  protected String a()
  {
    return "native";
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (AdUnit.AdState.STATE_ATTACHED != g());
      a(AdUnit.AdState.STATE_LOADED);
      InMobiNative.sMappedAdUnits.remove(paramView);
      this.f.a(paramView);
      this.b.remove(this);
      paramView = (p)this.c.remove(paramView);
    } while (paramView == null);
    paramView.a(AdUnit.AdState.STATE_LOADED);
    this.b.remove(paramView);
  }
  
  public void a(View paramView, Object paramObject)
  {
    A();
  }
  
  public void a(View paramView, URL paramURL, String paramString)
  {
    boolean bool2 = true;
    Object localObject = new HashMap();
    boolean bool1;
    if (paramString != null)
    {
      bool1 = true;
      ((Map)localObject).put("customScript", Boolean.valueOf(bool1));
      if (paramURL == null) {
        break label208;
      }
      bool1 = bool2;
      label42:
      ((Map)localObject).put("customUrl", Boolean.valueOf(bool1));
      com.inmobi.commons.core.c.a.a().a("ads", "TrackImpression", (Map)localObject);
      localObject = (WeakReference)this.b.get(this);
      if (localObject == null) {
        break label247;
      }
    }
    label208:
    label214:
    label247:
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (!paramView.equals(localObject))
      {
        if ((AdUnit.AdState.STATE_LOADED != g()) && (AdUnit.AdState.STATE_ATTACHED != g())) {
          break label214;
        }
        a((View)localObject);
        a(paramView);
        this.b.put(this, new WeakReference(paramView));
        this.c.put(paramView, this);
        this.g = paramURL;
        this.h = paramString;
        this.f.a(paramView, this, l().l());
        a(AdUnit.AdState.STATE_ATTACHED);
      }
      while ((g() == AdUnit.AdState.STATE_RENDERED) || (g() == AdUnit.AdState.STATE_ACTIVE))
      {
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label42;
      }
      Logger.a(Logger.InternalLogLevel.ERROR, a, "Please wait for the ad to finish loading before making a call to bind.");
      return;
    }
  }
  
  public void a(a parama)
  {
    super.a(parama);
    if (AdUnit.AdState.STATE_AVAILABLE == g()) {
      b(this.d);
    }
  }
  
  void a(Map<String, String> paramMap, URL paramURL, String paramString)
  {
    boolean bool2 = false;
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Click record requested");
    HashMap localHashMap = new HashMap();
    if (paramString != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localHashMap.put("customScript", Boolean.valueOf(bool1));
      bool1 = bool2;
      if (paramURL != null) {
        bool1 = true;
      }
      localHashMap.put("customUrl", Boolean.valueOf(bool1));
      com.inmobi.commons.core.c.a.a().a("ads", "ReportClick", localHashMap);
      if ((AdUnit.AdState.STATE_ATTACHED != g()) && (AdUnit.AdState.STATE_RENDERED != g())) {
        break;
      }
      n().d();
      paramMap = b(paramMap);
      n().b(paramMap);
      if (paramString != null) {
        n().b(paramString);
      }
      if (paramURL != null) {
        com.inmobi.rendering.a.c.a().a(paramURL.toExternalForm(), true);
      }
      return;
    }
    com.inmobi.commons.core.c.a.a().a(new e("ads", "InvalidClickReport"));
    Logger.a(Logger.InternalLogLevel.ERROR, a, "reportAdClick call made in wrong state");
  }
  
  public boolean b(a parama)
  {
    if (!super.b(parama)) {}
    for (;;)
    {
      return false;
      try
      {
        parama = new JSONObject(parama.b());
        this.d = parama.getString("contextCode");
        this.e = parama.getString("namespace");
        if ((this.d != null) && (this.d.trim().length() != 0) && (this.e != null))
        {
          int k = this.e.trim().length();
          if (k != 0) {
            return true;
          }
        }
      }
      catch (JSONException parama)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Exception while parsing ad.", parama);
      }
    }
    return false;
  }
  
  protected String c()
  {
    return null;
  }
  
  public void c(RenderView paramRenderView)
  {
    super.c(paramRenderView);
    if (AdUnit.AdState.STATE_AVAILABLE == g())
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
  
  public void e(RenderView paramRenderView)
  {
    super.e(paramRenderView);
    if ((AdUnit.AdState.STATE_RENDERED == g()) || (AdUnit.AdState.STATE_ATTACHED == g()))
    {
      this.i += 1;
      a(AdUnit.AdState.STATE_ACTIVE);
      m().b();
    }
    while (g() != AdUnit.AdState.STATE_ACTIVE) {
      return;
    }
    this.i += 1;
  }
  
  public void f(RenderView paramRenderView)
  {
    super.f(paramRenderView);
    if (AdUnit.AdState.STATE_ACTIVE == g())
    {
      this.i -= 1;
      if (this.i == 0)
      {
        a(AdUnit.AdState.STATE_RENDERED);
        paramRenderView = new HashMap();
        paramRenderView.put("type", a());
        paramRenderView.put("impId", j());
        com.inmobi.commons.core.c.a.a().a("ads", "AdRendered", paramRenderView);
        m().c();
      }
    }
  }
  
  public void o()
  {
    if (this.j != 0L)
    {
      int k = l().f();
      if (SystemClock.elapsedRealtime() - this.j < k * 1000)
      {
        a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST).setCustomMessage("Ad cannot be refreshed before " + k + " seconds"), false);
        Logger.a(Logger.InternalLogLevel.ERROR, a, "Ad cannot be refreshed before " + k + " seconds");
        return;
      }
    }
    this.j = SystemClock.elapsedRealtime();
    super.o();
    this.f = new n(l().l(), new am(l().l()), this);
  }
  
  protected void t()
  {
    k();
    this.b.clear();
    this.c.clear();
    if (this.f != null) {
      this.f.e();
    }
    this.h = null;
    this.g = null;
    if ((n() != null) && (n().getParent() != null)) {
      ((ViewGroup)n().getParent()).removeView(n());
    }
    super.t();
  }
  
  public void x()
  {
    if (AdUnit.AdState.STATE_ATTACHED == g())
    {
      Object localObject = (WeakReference)this.b.get(this);
      if (localObject != null)
      {
        localObject = (View)((WeakReference)localObject).get();
        if ((this.f != null) && (localObject != null)) {
          this.f.a((View)localObject, this, l().l());
        }
      }
    }
  }
  
  public void y()
  {
    if (AdUnit.AdState.STATE_ATTACHED == g())
    {
      Object localObject = (WeakReference)this.b.get(this);
      if (localObject != null)
      {
        localObject = (View)((WeakReference)localObject).get();
        if ((this.f != null) && (localObject != null)) {
          this.f.a((View)localObject);
        }
      }
    }
  }
  
  public Object z()
  {
    return h();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */