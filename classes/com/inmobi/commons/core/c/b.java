package com.inmobi.commons.core.c;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private int a = 0;
  private String b = "telemetry";
  private boolean c = false;
  private boolean d = false;
  private Map<String, a> e = new HashMap();
  
  public b() {}
  
  public b(String paramString, JSONObject paramJSONObject, b paramb)
  {
    if (paramJSONObject == null)
    {
      a(paramString, paramb);
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (paramString.trim().length() == 0)
        {
          localObject = paramb.a();
          this.b = ((String)localObject);
          if (!paramJSONObject.has("enabled")) {
            break label338;
          }
          bool = paramJSONObject.getBoolean("enabled");
          this.c = bool;
          if (paramJSONObject.has("samplingFactor"))
          {
            i = paramJSONObject.getInt("samplingFactor");
            a(i);
            if (!paramJSONObject.has("metricEnabled")) {
              continue;
            }
            bool = paramJSONObject.getBoolean("metricEnabled");
            a(bool);
            this.e = new HashMap();
            if (!paramJSONObject.has("events")) {
              break;
            }
            paramJSONObject = paramJSONObject.getJSONArray("events");
            i = 0;
            if (i >= paramJSONObject.length()) {
              break;
            }
            localObject = new a();
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            ((a)localObject).a(localJSONObject.getString("type"));
            if (!localJSONObject.has("samplingFactor")) {
              continue;
            }
            j = localJSONObject.getInt("samplingFactor");
            ((a)localObject).a(j);
            if (!localJSONObject.has("metricEnabled")) {
              continue;
            }
            bool = localJSONObject.getBoolean("metricEnabled");
            ((a)localObject).a(bool);
            this.e.put(((a)localObject).a(), localObject);
            i += 1;
            continue;
          }
          int i = paramb.c();
          continue;
          bool = paramb.d();
          continue;
          int j = c();
          continue;
          bool = d();
          continue;
        }
        Object localObject = paramString;
      }
      catch (JSONException paramJSONObject)
      {
        a(paramString, paramb);
        return;
      }
      continue;
      label338:
      boolean bool = true;
    }
  }
  
  private void a(String paramString, b paramb)
  {
    b(true);
    b(paramString);
  }
  
  public a a(String paramString)
  {
    a locala = (a)this.e.get(paramString);
    if (locala != null) {
      return locala;
    }
    return new a(paramString, c(), d());
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  static final class a
  {
    private String a;
    private int b;
    private boolean c;
    
    public a() {}
    
    public a(String paramString, int paramInt, boolean paramBoolean)
    {
      a(paramString);
      a(paramInt);
      a(paramBoolean);
    }
    
    public String a()
    {
      return this.a;
    }
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
    }
    
    public void a(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public boolean c()
    {
      return this.c;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */