package com.alibaba.mtl.log.model;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.h;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.n;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
{
  public String U;
  public String V = "3";
  private String W;
  public String X = null;
  public String Y = "";
  public int id;
  private Map<String, String> k;
  private String u;
  private String v;
  private String w;
  private String x;
  
  public a() {}
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    this.U = paramString2;
    this.u = paramString1;
    this.v = paramString3;
    this.w = paramString4;
    this.x = paramString5;
    this.k = paramMap;
    this.X = String.valueOf(System.currentTimeMillis());
    q();
  }
  
  public String h()
  {
    try
    {
      Object localObject = c.decode(this.W.getBytes("UTF-8"), 2);
      if (localObject != null)
      {
        localObject = new String(n.a((byte[])localObject, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"));
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  public String i()
  {
    return this.W;
  }
  
  public void m(String paramString)
  {
    if (paramString != null) {}
    try
    {
      this.W = new String(c.encode(n.a(paramString.getBytes(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"), 2), "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void n(String paramString)
  {
    this.W = paramString;
  }
  
  public void q()
  {
    if (TextUtils.isEmpty(this.X)) {
      this.X = String.valueOf(System.currentTimeMillis());
    }
    String str = h.a(this.u, this.U, this.v, this.w, this.x, this.k, this.Y, this.X);
    i.a("UTLog", new Object[] { this, str });
    m(str);
  }
  
  public String toString()
  {
    return "Log [id=" + this.id + ", eventId=" + this.U + ", index=" + this.Y + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */