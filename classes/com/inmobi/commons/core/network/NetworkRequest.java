package com.inmobi.commons.core.network;

import android.util.Base64;
import com.inmobi.commons.core.configs.f;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.c;
import java.util.HashMap;
import java.util.Map;

public class NetworkRequest
{
  private static final String d = NetworkRequest.class.getSimpleName();
  protected Map<String, String> a = new HashMap();
  protected Map<String, String> b = new HashMap();
  protected Map<String, String> c = new HashMap();
  private RequestType e;
  private String f;
  private com.inmobi.commons.core.utilities.uid.d g;
  private int h = 60000;
  private int i = 60000;
  private boolean j = true;
  private boolean k;
  private byte[] l;
  private byte[] m;
  private boolean n = true;
  private long o = -1L;
  private boolean p;
  
  public NetworkRequest(RequestType paramRequestType, String paramString, boolean paramBoolean, com.inmobi.commons.core.utilities.uid.d paramd)
  {
    this(paramRequestType, paramString, paramBoolean, paramd, false);
  }
  
  public NetworkRequest(RequestType paramRequestType, String paramString, boolean paramBoolean1, com.inmobi.commons.core.utilities.uid.d paramd, boolean paramBoolean2)
  {
    this.e = paramRequestType;
    this.f = paramString;
    this.k = paramBoolean1;
    this.g = paramd;
    this.a.put("User-Agent", com.inmobi.commons.a.a.d());
    this.p = paramBoolean2;
  }
  
  private String a(String paramString)
  {
    byte[] arrayOfByte = com.inmobi.commons.core.utilities.a.b.a(8);
    this.l = com.inmobi.commons.core.utilities.a.b.a(16);
    this.m = com.inmobi.commons.core.utilities.a.b.b();
    HashMap localHashMap = new HashMap();
    f localf = new f();
    com.inmobi.commons.core.configs.b.a().a(localf, null);
    localHashMap.put("sm", com.inmobi.commons.core.utilities.a.b.a(paramString, this.m, this.l, arrayOfByte, localf.f(), localf.e()));
    localHashMap.put("sn", localf.g());
    return c.a(localHashMap, "&");
  }
  
  private void a(Map<String, String> paramMap)
  {
    paramMap.putAll(com.inmobi.commons.core.utilities.info.a.a().c());
    paramMap.putAll(com.inmobi.commons.core.utilities.info.b.a());
    paramMap.putAll(com.inmobi.commons.core.utilities.info.d.a());
    if (this.g != null)
    {
      if (q()) {
        paramMap.putAll(this.g.a());
      }
    }
    else {
      return;
    }
    paramMap.putAll(this.g.b());
  }
  
  public void a()
  {
    if (this.n)
    {
      if (this.e != RequestType.GET) {
        break label26;
      }
      a(this.b);
    }
    label26:
    while (this.e != RequestType.POST) {
      return;
    }
    a(this.c);
  }
  
  public void a(long paramLong)
  {
    this.o = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    return com.inmobi.commons.core.utilities.a.b.a(Base64.decode(paramArrayOfByte, 0), this.m, this.l);
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(Map<String, String> paramMap)
  {
    this.b.putAll(paramMap);
  }
  
  public void d(Map<String, String> paramMap)
  {
    this.c.putAll(paramMap);
  }
  
  public long f()
  {
    return this.o;
  }
  
  public boolean g()
  {
    return this.o != -1L;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public Map<String, String> i()
  {
    c.a(this.a);
    return this.a;
  }
  
  public String j()
  {
    Object localObject2 = this.f;
    String str = k();
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (str.trim().length() != 0)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).contains("?")) {
          localObject1 = (String)localObject2 + "?";
        }
        localObject2 = localObject1;
        if (!((String)localObject1).endsWith("&"))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith("?")) {
            localObject2 = (String)localObject1 + "&";
          }
        }
        localObject1 = (String)localObject2 + str;
      }
    }
    return (String)localObject1;
  }
  
  public String k()
  {
    c.a(this.b);
    String str = c.a(this.b, "&");
    Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Get params: " + str);
    return str;
  }
  
  public String l()
  {
    c.a(this.c);
    String str2 = c.a(this.c, "&");
    Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Post body url: " + h());
    Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Post body: " + str2);
    String str1 = str2;
    if (q())
    {
      str1 = a(str2);
      Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Encrypted post body: " + str1);
    }
    return str1;
  }
  
  public boolean m()
  {
    return this.j;
  }
  
  public RequestType n()
  {
    return this.e;
  }
  
  public int o()
  {
    return this.h;
  }
  
  public int p()
  {
    return this.i;
  }
  
  public boolean q()
  {
    return this.k;
  }
  
  public boolean r()
  {
    return this.p;
  }
  
  public static enum RequestType
  {
    GET,  POST;
    
    private RequestType() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\network\NetworkRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */