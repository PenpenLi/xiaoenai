package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.a;
import com.inmobi.commons.core.utilities.uid.d;
import com.inmobi.signals.LocationInfo;
import com.inmobi.signals.a.c;
import com.inmobi.signals.b.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  extends NetworkRequest
{
  private long d;
  private String e = "json";
  private String f;
  private int g = 1;
  private String h;
  private String i;
  private Map<String, String> j;
  private Map<String, String> k;
  
  public e(String paramString, long paramLong, d paramd)
  {
    super(NetworkRequest.RequestType.POST, paramString, true, paramd, true);
    this.d = paramLong;
    this.c.put("im-plid", String.valueOf(this.d));
    this.c.putAll(com.inmobi.commons.core.utilities.info.e.g());
    this.c.putAll(DisplayInfo.c());
    this.c.put("u-appIS", a.a().b());
    this.c.putAll(LocationInfo.a().g());
    this.c.putAll(LocationInfo.a().f());
    this.c.putAll(b.b());
    this.c.putAll(b.d());
    this.c.putAll(c.c());
    this.c.putAll(c.d());
    this.c.putAll(c.a());
  }
  
  public void a()
  {
    super.a();
    this.c.put("format", this.e);
    this.c.put("mk-ads", String.valueOf(this.g));
    this.c.put("adtype", this.h);
    if (this.i != null) {
      this.c.put("p-keywords", this.i);
    }
    if (this.j != null)
    {
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!this.c.containsKey(localEntry.getKey())) {
          this.c.put(localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    if (this.k != null) {
      this.c.putAll(this.k);
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.j = paramMap;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(Map<String, String> paramMap)
  {
    this.k = paramMap;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public int d()
  {
    return this.g;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public long e()
  {
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */