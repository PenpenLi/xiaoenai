package com.nostra13.universalimageloader.core.d;

import java.io.InputStream;
import java.util.Locale;

public abstract interface b
{
  public abstract InputStream a(String paramString, Object paramObject);
  
  public static enum a
  {
    private String h;
    private String i;
    
    private a(String paramString)
    {
      this.h = paramString;
      this.i = (paramString + "://");
    }
    
    public static a a(String paramString)
    {
      if (paramString != null)
      {
        a[] arrayOfa = values();
        int m = arrayOfa.length;
        int k = 0;
        while (k < m)
        {
          a locala = arrayOfa[k];
          if (locala.d(paramString)) {
            return locala;
          }
          k += 1;
        }
      }
      return g;
    }
    
    private boolean d(String paramString)
    {
      return paramString.toLowerCase(Locale.US).startsWith(this.i);
    }
    
    public String b(String paramString)
    {
      return this.i + paramString;
    }
    
    public String c(String paramString)
    {
      if (!d(paramString)) {
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] { paramString, this.h }));
      }
      return paramString.substring(this.i.length());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */