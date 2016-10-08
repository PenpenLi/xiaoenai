package com.inmobi.ads;

import android.content.ContentValues;

class a
{
  private static final String a = a.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private long e;
  private long f;
  private String g;
  
  public a(ContentValues paramContentValues)
  {
    this.b = paramContentValues.getAsString("ad_type");
    this.c = paramContentValues.getAsString("ad_size");
    this.d = paramContentValues.getAsString("ad_content");
    this.e = paramContentValues.getAsLong("placement_id").longValue();
    this.f = paramContentValues.getAsLong("insertion_ts").longValue();
    this.g = paramContentValues.getAsString("imp_id");
  }
  
  public a(f paramf, String paramString1, String paramString2)
  {
    this.b = paramf.b().b();
    this.c = paramf.b().c();
    this.d = paramString1;
    this.e = paramf.b().e();
    this.f = System.currentTimeMillis();
    this.g = paramString2;
  }
  
  public ContentValues a()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ad_type", this.b);
    localContentValues.put("ad_size", this.c);
    localContentValues.put("ad_content", this.d);
    localContentValues.put("placement_id", Long.valueOf(this.e));
    localContentValues.put("insertion_ts", Long.valueOf(this.f));
    localContentValues.put("imp_id", this.g);
    return localContentValues;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public long d()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */