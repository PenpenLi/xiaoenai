package com.inmobi.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.c;
import com.inmobi.rendering.InMobiAdActivity;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class q
  implements ac.a, ac.b
{
  private static final String a = q.class.getSimpleName();
  private static final ab k = new ab();
  @NonNull
  private final Context b;
  @NonNull
  private final x c;
  @NonNull
  private final String d;
  @NonNull
  private final ac e;
  @NonNull
  private Map<Integer, Integer> f = new HashMap();
  @NonNull
  private List<NativeStrandAsset> g = new ArrayList();
  private boolean h;
  private boolean i = false;
  @Nullable
  private a j;
  
  q(@NonNull Context paramContext, @NonNull x paramx, @NonNull String paramString)
  {
    this.b = paramContext;
    this.c = paramx;
    this.d = paramString;
    this.e = new ac(paramContext, paramx, this, this);
    this.h = false;
    this.i = false;
    this.c.a().a(System.currentTimeMillis());
    paramContext = b(this.c.a());
    c(this.c.a(), paramContext);
    d(this.c.a(), paramContext);
  }
  
  private void a(int paramInt, @NonNull v paramv)
  {
    this.f.put(Integer.valueOf(paramInt), Integer.valueOf(1));
    paramv.a(System.currentTimeMillis());
    if (this.h)
    {
      e(paramv, b(paramv));
      return;
    }
    this.g.add(paramv);
  }
  
  private void a(@NonNull NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "inlban");
    localHashMap.put("impId", this.d);
    a.a().a("ads", "AdRendered", localHashMap);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Impression record requested");
    paramNativeStrandAsset.a(ai.a.d, paramMap);
    if (this.j != null) {
      this.j.a();
    }
  }
  
  private void a(@NonNull String paramString1, @Nullable String paramString2)
  {
    try
    {
      Intent localIntent = Intent.parseUri(paramString1, 0);
      localIntent.setFlags(268435456);
      this.b.startActivity(localIntent);
      return;
    }
    catch (URISyntaxException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      do
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Deep linking failed for url:" + paramString1, localActivityNotFoundException);
      } while (!a(paramString2));
      a(paramString2, null);
    }
  }
  
  private boolean a(@NonNull ag paramag)
  {
    paramag = paramag.a();
    return (paramag == null) || (this != paramag);
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() != 0);
  }
  
  private Map<String, String> b(@NonNull NativeStrandAsset paramNativeStrandAsset)
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("$LTS", String.valueOf(this.c.a().m()));
    paramNativeStrandAsset = this.c.a(paramNativeStrandAsset);
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (paramNativeStrandAsset != null)
    {
      l1 = l2;
      if (0L != paramNativeStrandAsset.m()) {
        l1 = paramNativeStrandAsset.m();
      }
    }
    localHashMap.put("$STS", String.valueOf(l1));
    localHashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
    return localHashMap;
  }
  
  private void b(@NonNull NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    a.a().a("ads", "ReportClick", localHashMap);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Click impression record requested");
    paramNativeStrandAsset.a(ai.a.f, paramMap);
    if (this.j != null) {
      this.j.b();
    }
  }
  
  private void b(String paramString)
  {
    InMobiAdActivity.c(null);
    Intent localIntent = new Intent(this.b, InMobiAdActivity.class);
    localIntent.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
    if (!(this.b instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    localIntent.putExtra("com.inmobi.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", paramString);
    this.b.startActivity(localIntent);
  }
  
  static boolean b(@NonNull View paramView)
  {
    return paramView instanceof ag;
  }
  
  private void c(@NonNull NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    paramNativeStrandAsset.a(ai.a.b, paramMap);
  }
  
  private void d()
  {
    v localv = this.c.a(0);
    if ((this.f.get(Integer.valueOf(0)) == null) && (localv != null)) {
      a(0, localv);
    }
  }
  
  private void d(@NonNull NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    paramNativeStrandAsset.a(ai.a.c, paramMap);
  }
  
  private void e(@Nullable NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    if (paramNativeStrandAsset == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot report page view impression on null page container! Ignoring ...");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramNativeStrandAsset.f());
      localJSONObject.put("asset", paramNativeStrandAsset.e());
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "inlban");
      localHashMap.put("impId", this.d);
      localHashMap.put("pageJson", localJSONObject);
      a.a().a("ads", "PageRendered", localHashMap);
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Page-view impression record request");
      paramNativeStrandAsset.a(ai.a.e, paramMap);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void f(@NonNull NativeStrandAsset paramNativeStrandAsset, @Nullable Map<String, String> paramMap)
  {
    if (!paramNativeStrandAsset.g()) {}
    NativeStrandAsset.AssetInteractionMode localAssetInteractionMode;
    do
    {
      return;
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Asset interaction requested");
      localAssetInteractionMode = paramNativeStrandAsset.h();
    } while (NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_NO_ACTION == localAssetInteractionMode);
    String str = paramNativeStrandAsset.i();
    if (!a(str))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Invalid url:" + str);
      return;
    }
    paramMap = c.a(str, paramMap);
    if (NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_IN_APP == localAssetInteractionMode)
    {
      if ((paramMap.startsWith("http")) && (!paramMap.contains("play.google.com")) && (!paramMap.contains("market.android.com")) && (!paramMap.contains("market%3A%2F%2F")))
      {
        b(paramMap);
        return;
      }
      a(paramMap, null);
      return;
    }
    if (NativeStrandAsset.AssetInteractionMode.ASSET_INTERACTION_MODE_BROWSER == localAssetInteractionMode)
    {
      a(paramMap, null);
      return;
    }
    a(paramMap, paramNativeStrandAsset.j());
  }
  
  public View a(@Nullable View paramView, @NonNull ViewGroup paramViewGroup, @NonNull b.f paramf)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Creating ad-view from data model");
    if (paramView == null) {
      paramView = this.e.a(null, paramViewGroup);
    }
    for (;;)
    {
      paramView.a(this);
      if (!this.h) {
        k.a((Activity)this.b, paramf, paramView, this);
      }
      return paramView;
      if (b(paramView))
      {
        paramView = (ag)paramView;
        if (a(paramView)) {
          paramView = this.e.a(paramView, paramViewGroup);
        } else {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Already showing same ad, ignoring getAdView");
        }
      }
      else
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "InMobiNativeStrand.getStrandView called with Non Strand View.");
        paramView = this.e.a(null, paramViewGroup);
      }
    }
  }
  
  @NonNull
  public x a()
  {
    return this.c;
  }
  
  public void a(int paramInt, NativeStrandAsset paramNativeStrandAsset)
  {
    if ((this.f.get(Integer.valueOf(paramInt)) != null) || (b())) {
      return;
    }
    d();
    a(paramInt, (v)paramNativeStrandAsset);
  }
  
  public void a(View paramView)
  {
    this.g.clear();
    paramView.setOnClickListener(null);
  }
  
  public void a(NativeStrandAsset paramNativeStrandAsset)
  {
    d();
    Map localMap = b(paramNativeStrandAsset);
    b(paramNativeStrandAsset, localMap);
    f(paramNativeStrandAsset, localMap);
  }
  
  public void a(@NonNull a parama)
  {
    this.j = parama;
  }
  
  public boolean b()
  {
    return this.i;
  }
  
  public void c()
  {
    if (this.i) {
      return;
    }
    this.j = null;
    this.i = true;
    this.e.b();
    this.g.clear();
    k.a((Activity)this.b, this);
  }
  
  void c(View paramView)
  {
    if ((this.h) || (b())) {
      return;
    }
    this.h = true;
    a(this.c.a(), b(this.c.a()));
    d();
    paramView = this.g.iterator();
    while (paramView.hasNext())
    {
      NativeStrandAsset localNativeStrandAsset = (NativeStrandAsset)paramView.next();
      e(localNativeStrandAsset, b(localNativeStrandAsset));
    }
    this.g.clear();
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */