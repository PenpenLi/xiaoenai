package com.nostra13.universalimageloader.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class a
  implements com.nostra13.universalimageloader.a.b.a
{
  private final com.nostra13.universalimageloader.a.b.a a;
  private final Comparator<String> b;
  
  public a(com.nostra13.universalimageloader.a.b.a parama, Comparator<String> paramComparator)
  {
    this.a = parama;
    this.b = paramComparator;
  }
  
  public Bitmap a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public Collection<String> a()
  {
    return this.a.a();
  }
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.a().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (this.b.compare(paramString, str) != 0) {
            continue;
          }
          if (str != null) {
            this.a.b(str);
          }
          return this.a.a(paramString, paramBitmap);
        }
      }
      String str = null;
    }
  }
  
  public Bitmap b(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public void b()
  {
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\a\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */