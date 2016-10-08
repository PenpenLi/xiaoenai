package com.bumptech.glide.d.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

public class e
{
  private final URL a;
  private final f b;
  private final String c;
  private String d;
  private URL e;
  
  public e(String paramString)
  {
    this(paramString, f.a);
  }
  
  public e(String paramString, f paramf)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("String url must not be empty or null: " + paramString);
    }
    if (paramf == null) {
      throw new IllegalArgumentException("Headers must not be null");
    }
    this.c = paramString;
    this.a = null;
    this.b = paramf;
  }
  
  public e(URL paramURL)
  {
    this(paramURL, f.a);
  }
  
  public e(URL paramURL, f paramf)
  {
    if (paramURL == null) {
      throw new IllegalArgumentException("URL must not be null!");
    }
    if (paramf == null) {
      throw new IllegalArgumentException("Headers must not be null");
    }
    this.a = paramURL;
    this.c = null;
    this.b = paramf;
  }
  
  private URL d()
  {
    if (this.e == null) {
      this.e = new URL(e());
    }
    return this.e;
  }
  
  private String e()
  {
    if (TextUtils.isEmpty(this.d))
    {
      String str2 = this.c;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.a.toString();
      }
      this.d = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%");
    }
    return this.d;
  }
  
  public URL a()
  {
    return d();
  }
  
  public Map<String, String> b()
  {
    return this.b.a();
  }
  
  public String c()
  {
    if (this.c != null) {
      return this.c;
    }
    return this.a.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      bool1 = bool2;
      if (c().equals(((e)paramObject).c()))
      {
        bool1 = bool2;
        if (this.b.equals(((e)paramObject).b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return c().hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return c() + '\n' + this.b.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */