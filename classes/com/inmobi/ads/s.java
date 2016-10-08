package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import com.inmobi.rendering.RenderingProperties.PlacementType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class s
  extends AdUnit
{
  private static final String a = s.class.getSimpleName();
  private static Handler f;
  @NonNull
  private final Context b;
  @NonNull
  private final String c;
  private boolean d = false;
  private q e;
  
  public s(@NonNull Context paramContext, long paramLong, Integer[] paramArrayOfInteger, AdUnit.a parama)
  {
    super(paramContext, paramLong, parama);
    this.b = paramContext;
    this.c = a(paramArrayOfInteger);
    f = new Handler(Looper.getMainLooper());
  }
  
  private int B()
  {
    return DisplayInfo.a().b();
  }
  
  private String C()
  {
    return "NS-1.0.0-20160411";
  }
  
  private void D()
  {
    f.post(new s.2(this));
  }
  
  private static String a(Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger.length == 0) {
      return "";
    }
    int j = paramArrayOfInteger.length;
    int i = 0;
    String str = "";
    while (i < j)
    {
      Integer localInteger = paramArrayOfInteger[i];
      str = str + ((Integer)localInteger).intValue() + ",";
      i += 1;
    }
    return str.substring(0, str.length() - 1);
  }
  
  private void a(q paramq)
  {
    f.post(new s.1(this, paramq));
  }
  
  protected String a()
  {
    return "inlban";
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    super.a(paramInMobiAdRequestStatus);
  }
  
  public void a(a parama)
  {
    if (g() == AdUnit.AdState.STATE_LOADING)
    {
      if (b(parama))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ad fetch successful");
        new a(this, parama.c()).start();
      }
    }
    else {
      return;
    }
    c("ParsingFailed");
    a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true);
  }
  
  protected String c()
  {
    return null;
  }
  
  protected RenderingProperties.PlacementType d()
  {
    return RenderingProperties.PlacementType.INLINE;
  }
  
  protected Map<String, String> e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("a-adPositions", this.c);
    localHashMap.put("a-parentViewWidth", String.valueOf(B()));
    localHashMap.put("a-productVersion", C());
    localHashMap.put("trackerType", "url_ping");
    return localHashMap;
  }
  
  public void o()
  {
    if (this.d)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ad unit is already destroyed! Returning ...");
      return;
    }
    super.o();
  }
  
  protected void q() {}
  
  protected void t()
  {
    k();
  }
  
  @Nullable
  public q x()
  {
    q localq = this.e;
    this.e = null;
    return localq;
  }
  
  public void y()
  {
    if (this.d) {
      return;
    }
    super.t();
    a(AdUnit.AdState.STATE_CREATED);
    this.d = true;
  }
  
  boolean z()
  {
    return AdUnit.AdState.STATE_LOADING != g();
  }
  
  private static class a
    extends Thread
  {
    @NonNull
    private s a;
    @NonNull
    private String b;
    
    a(@NonNull s params, @NonNull String paramString)
    {
      this.a = params;
      this.b = paramString;
    }
    
    public void run()
    {
      try
      {
        Object localObject = new x(new JSONObject(this.a.h()));
        if (((x)localObject).h())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("type", this.a.a());
          com.inmobi.commons.core.c.a.a().a("ads", "AdLoadSuccessful", localHashMap);
          localObject = new q(s.b(this.a), (x)localObject, this.b);
          s.b(this.a, (q)localObject);
          return;
        }
        this.a.c("DataModelValidationFailed");
        s.c(this.a);
        return;
      }
      catch (JSONException localJSONException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, s.A(), "Failed to parse Native strand data model", localJSONException);
        this.a.c("InternalError");
        s.c(this.a);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */