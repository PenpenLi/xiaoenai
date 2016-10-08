package com.adhoc;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class ba
{
  private final String[] a;
  
  private ba(a parama)
  {
    this.a = ((String[])a.a(parama).toArray(new String[a.a(parama).size()]));
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    paramInt *= 2;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public a b()
  {
    a locala = new a();
    Collections.addAll(a.a(locala), this.a);
    return locala;
  }
  
  public String b(int paramInt)
  {
    paramInt = paramInt * 2 + 1;
    if ((paramInt < 0) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  public Date b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return dr.a(paramString);
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = a();
    while (i < j)
    {
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private final List<String> a = new ArrayList(20);
    
    private void d(String paramString1, String paramString2)
    {
      if (paramString1 == null) {
        throw new IllegalArgumentException("name == null");
      }
      boolean bool;
      if (Build.VERSION.SDK_INT > 8) {
        bool = paramString1.isEmpty();
      }
      while (bool)
      {
        throw new IllegalArgumentException("name is empty");
        if (paramString1.length() == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      int j = paramString1.length();
      int i = 0;
      int k;
      while (i < j)
      {
        k = paramString1.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
        }
        i += 1;
      }
      if (paramString2 == null) {
        throw new IllegalArgumentException("value == null");
      }
      j = paramString2.length();
      i = 0;
      while (i < j)
      {
        k = paramString2.charAt(i);
        if ((k <= 31) || (k >= 127)) {
          throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2 }));
        }
        i += 1;
      }
    }
    
    a a(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1) {
        return b(paramString.substring(0, i), paramString.substring(i + 1));
      }
      if (paramString.startsWith(":")) {
        return b("", paramString.substring(1));
      }
      return b("", paramString);
    }
    
    public a a(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      return b(paramString1, paramString2);
    }
    
    public ba a()
    {
      return new ba(this, null);
    }
    
    public a b(String paramString)
    {
      int j;
      for (int i = 0; i < this.a.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
        {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    a b(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }
    
    public a c(String paramString1, String paramString2)
    {
      d(paramString1, paramString2);
      b(paramString1);
      b(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */