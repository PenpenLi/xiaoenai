package com.inmobi.commons.core.configs;

import com.inmobi.commons.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends a
{
  private static final Object g = new Object();
  private int a = 3;
  private int b = 60;
  private int c = 3;
  private List<a> d = new ArrayList();
  private b e = new b();
  private JSONObject f = new JSONObject();
  
  public long a(String paramString)
  {
    Object localObject = g;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.d.size())
        {
          a locala = (a)this.d.get(i);
          if (paramString.equals(a.a(locala)))
          {
            long l = a.b(locala);
            return l;
          }
        }
        else
        {
          return 86400L;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public String a()
  {
    return "root";
  }
  
  public void a(JSONObject arg1)
  {
    super.a(???);
    this.a = ???.getInt("maxRetries");
    this.b = ???.getInt("retryInterval");
    this.c = ???.getInt("waitTime");
    Object localObject1 = ???.getJSONObject("latestSdkInfo");
    b.a(this.e, ((JSONObject)localObject1).getString("version"));
    b.b(this.e, ((JSONObject)localObject1).getString("url"));
    localObject1 = ???.getJSONArray("components");
    synchronized (g)
    {
      this.d.clear();
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
        a locala = new a();
        a.a(locala, localJSONObject.getString("type"));
        a.a(locala, localJSONObject.getLong("expiry"));
        a.b(locala, localJSONObject.getString("protocol"));
        a.c(locala, localJSONObject.getString("url"));
        this.d.add(locala);
        i += 1;
      }
      return;
    }
  }
  
  public String b(String paramString)
  {
    Object localObject = g;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.d.size())
        {
          a locala = (a)this.d.get(i);
          if (paramString.equals(a.a(locala)))
          {
            paramString = a.d(locala);
            return paramString;
          }
        }
        else
        {
          return "";
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = super.b();
    JSONArray localJSONArray = new JSONArray();
    localJSONObject1.put("maxRetries", this.a);
    localJSONObject1.put("retryInterval", this.b);
    localJSONObject1.put("waitTime", this.c);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("version", b.a(this.e));
    ((JSONObject)localObject2).put("url", b.b(this.e));
    localJSONObject1.put("latestSdkInfo", localObject2);
    localObject2 = g;
    int i = 0;
    try
    {
      while (i < this.d.size())
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("type", a.a((a)this.d.get(i)));
        localJSONObject2.put("expiry", a.b((a)this.d.get(i)));
        localJSONObject2.put("protocol", a.c((a)this.d.get(i)));
        localJSONObject2.put("url", a.d((a)this.d.get(i)));
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("components", localJSONArray);
      return localJSONObject1;
    }
    finally {}
  }
  
  public boolean c()
  {
    if (this.d == null) {
      return false;
    }
    if ((this.a < 0) || (this.b < 0) || (this.c < 0)) {
      return false;
    }
    if ((this.e.a().trim().length() == 0) || ((!this.e.b().startsWith("http://")) && (!this.e.b().startsWith("https://")))) {
      return false;
    }
    Object localObject1 = g;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.d.size())
        {
          a locala = (a)this.d.get(i);
          if (locala.a().trim().length() == 0) {
            return false;
          }
          if ((locala.b().longValue() < 0L) || (locala.b().longValue() > 864000L)) {
            return false;
          }
          if (locala.c().trim().length() == 0) {
            return false;
          }
          if ((locala.d() == null) || (locala.d().trim().length() == 0) || ((!locala.d().startsWith("http://")) && (!locala.d().startsWith("https://")))) {
            return false;
          }
        }
        else
        {
          return true;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public a d()
  {
    return new g();
  }
  
  public int e()
  {
    return this.a;
  }
  
  public int f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public b h()
  {
    return this.e;
  }
  
  public JSONObject i()
  {
    return this.f;
  }
  
  static final class a
  {
    private String a;
    private long b;
    private String c;
    private String d;
    
    public String a()
    {
      return this.a;
    }
    
    public Long b()
    {
      return Long.valueOf(this.b);
    }
    
    public String c()
    {
      return this.c;
    }
    
    public String d()
    {
      return this.d;
    }
  }
  
  public static final class b
  {
    private String a = b.c();
    private String b = b.g();
    
    public String a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */