package com.xiaoenai.app.a;

import android.content.ContentValues;

public class b
{
  private String a;
  private String b = "";
  private int c;
  private long d;
  private long e;
  private int f;
  private String g;
  private long h;
  private long i;
  
  public ContentValues a()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("request_url", this.a);
    localContentValues.put("request_parameters", this.b);
    localContentValues.put("request_method", Integer.valueOf(this.c));
    localContentValues.put("request_time", Long.valueOf(this.d));
    localContentValues.put("response_time", Long.valueOf(this.e));
    localContentValues.put("response_code", Integer.valueOf(this.f));
    localContentValues.put("response_result", this.g);
    localContentValues.put("request_size", Long.valueOf(this.h));
    localContentValues.put("response_size", Long.valueOf(this.i));
    return localContentValues;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public void d(long paramLong)
  {
    this.h = paramLong;
  }
  
  public String toString()
  {
    return "HttpAnalyticsEntity{requestUrl='" + this.a + '\'' + ", requestParams='" + this.b + '\'' + ", requestMothed=" + this.c + ", requestTime=" + this.d + ", responseTime=" + this.e + ", responseCode=" + this.f + ", responseResult='" + this.g + '\'' + ", requestSize=" + this.h + ", responseSize=" + this.i + '}';
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */