package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class g
  implements d.a
{
  private static final String a = g.class.getSimpleName();
  private h b;
  private a c;
  private c d;
  private boolean e = false;
  private long f = 0L;
  
  public g(h paramh, a parama)
  {
    this.b = paramh;
    this.c = parama;
    this.d = c.a();
  }
  
  private void a(long paramLong, String paramString)
  {
    this.e = true;
    this.c.a(this.d.b(paramLong, paramString));
  }
  
  private void a(h paramh)
  {
    e locale = new e(paramh.a(), paramh.c(), paramh.g());
    locale.d(paramh.d());
    locale.a(paramh.e());
    locale.a(paramh.h());
    locale.b(paramh.i());
    locale.a(paramh.f().c());
    locale.b(paramh.j());
    locale.b(paramh.i());
    locale.c(paramh.k());
    locale.b(paramh.b() * 1000);
    locale.c(paramh.b() * 1000);
    this.f = SystemClock.elapsedRealtime();
    new d(locale, this).a();
  }
  
  private List<a> c(f paramf)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = new JSONObject(paramf.c());
      String str = ((JSONObject)localObject).getString("requestId").trim();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("ads");
      localObject = localArrayList;
      if (localJSONArray != null)
      {
        int j = Math.min(paramf.b().d(), localJSONArray.length());
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localArrayList.add(new a(paramf, localJSONArray.getJSONObject(i).toString(), str + "_" + i));
          i += 1;
        }
      }
      return (List<a>)localObject;
    }
    catch (JSONException paramf)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while parsing ad response.", paramf);
      localObject = new HashMap();
      ((Map)localObject).put("type", this.b.h());
      ((Map)localObject).put("errorCode", "ParsingError");
      ((Map)localObject).put("reason", paramf.getLocalizedMessage());
      com.inmobi.commons.core.c.a.a().a("ads", "ServerError", (Map)localObject);
      localObject = null;
    }
  }
  
  public void a()
  {
    this.e = false;
    this.d.a(this.b.h(), this.b.f().e());
    int i = this.d.a(this.b.c(), this.b.k());
    if (i == 0)
    {
      a(this.b);
      return;
    }
    if (i <= this.b.f().d())
    {
      a(this.b.c(), this.b.k());
      a(this.b);
      return;
    }
    a(this.b.c(), this.b.k());
  }
  
  public void a(f paramf)
  {
    long l = SystemClock.elapsedRealtime();
    List localList = c(paramf);
    if (localList == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Could not parse ad response:" + paramf.c());
      if (!this.e) {
        this.c.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
      }
    }
    do
    {
      return;
      if (localList.size() != 0) {
        break;
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ad response received but no ad available:" + paramf.c());
      paramf = new HashMap();
      paramf.put("type", this.b.h());
      paramf.put("loadLatency", Long.valueOf(l - this.f));
      com.inmobi.commons.core.c.a.a().a("ads", "ServerNoFill", paramf);
    } while (this.e);
    this.c.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL));
    return;
    paramf = new HashMap();
    paramf.put("type", this.b.h());
    paramf.put("count", Integer.valueOf(localList.size()));
    paramf.put("loadLatency", Long.valueOf(l - this.f));
    com.inmobi.commons.core.c.a.a().a("ads", "ServerFill", paramf);
    if (!this.e)
    {
      this.c.a((a)localList.get(0));
      localList.remove(0);
    }
    this.d.a(localList, this.b.f().b(), this.b.h());
  }
  
  public void b(f paramf)
  {
    if (!this.e)
    {
      long l = SystemClock.elapsedRealtime();
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.b.h());
      localHashMap.put("errorCode", String.valueOf(paramf.d().a().getValue()));
      localHashMap.put("reason", paramf.d().b());
      localHashMap.put("loadLatency", Long.valueOf(l - this.f));
      com.inmobi.commons.core.c.a.a().a("ads", "ServerError", localHashMap);
      this.c.a(paramf.a());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(InMobiAdRequestStatus paramInMobiAdRequestStatus);
    
    public abstract void a(a parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */