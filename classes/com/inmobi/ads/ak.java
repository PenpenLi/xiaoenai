package com.inmobi.ads;

import android.content.ContentValues;
import java.util.Map;

public class ak
{
  private static final String a = ak.class.getSimpleName();
  private long b;
  private String c;
  private Map<String, String> d;
  private String e;
  private String f = "int";
  
  public ak(long paramLong, String paramString)
  {
    this.b = paramLong;
    this.c = paramString;
    if (this.c == null) {
      this.c = "";
    }
  }
  
  public ak(ContentValues paramContentValues)
  {
    this.b = paramContentValues.getAsLong("placement_id").longValue();
    this.c = paramContentValues.getAsString("tp_key");
  }
  
  public Map<String, String> a()
  {
    return this.d;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ak)paramObject;
      if (this.b != ((ak)paramObject).b) {
        return false;
      }
    } while ((this.c == null) && (((ak)paramObject).c == null));
    if ((this.c != null) && (((ak)paramObject).c != null)) {
      return this.c.equals(((ak)paramObject).c);
    }
    return false;
  }
  
  public ContentValues f()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("placement_id", Long.valueOf(this.b));
    localContentValues.put("last_accessed_ts", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("tp_key", this.c);
    return localContentValues;
  }
  
  public int hashCode()
  {
    int j = (int)(this.b ^ this.b >>> 32);
    int i = j;
    if (this.c != null) {
      i = j * 31 + this.c.hashCode();
    }
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */