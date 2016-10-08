package com.inmobi.commons.core.c;

import android.content.ContentValues;

public class e
{
  private static final String a = e.class.getSimpleName();
  private String b;
  private String c;
  private long d;
  private String e;
  
  public e(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.e = null;
    this.d = System.currentTimeMillis();
  }
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.b = paramString2;
    this.e = paramString3;
    this.d = System.currentTimeMillis();
  }
  
  public static e a(ContentValues paramContentValues)
  {
    String str1 = paramContentValues.getAsString("eventType");
    String str2 = paramContentValues.getAsString("componentType");
    String str3 = paramContentValues.getAsString("payload");
    long l = Long.valueOf(paramContentValues.getAsString("ts")).longValue();
    paramContentValues = new e(str2, str1, str3);
    paramContentValues.d = l;
    return paramContentValues;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    if (this.e == null) {
      return "";
    }
    return this.e;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("componentType", a());
    localContentValues.put("eventType", b());
    localContentValues.put("payload", c());
    localContentValues.put("ts", String.valueOf(d()));
    return localContentValues;
  }
  
  public String toString()
  {
    return b() + "@" + a() + " ";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */