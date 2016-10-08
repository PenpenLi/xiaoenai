package com.bumptech.glide.d.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

@TargetApi(19)
public class i
  implements g
{
  private static final Bitmap.Config[] a = { Bitmap.Config.ARGB_8888, null };
  private static final Bitmap.Config[] b = { Bitmap.Config.RGB_565 };
  private static final Bitmap.Config[] c = { Bitmap.Config.ARGB_4444 };
  private static final Bitmap.Config[] d = { Bitmap.Config.ALPHA_8 };
  private final b e = new b();
  private final e<a, Bitmap> f = new e();
  private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> g = new HashMap();
  
  private a a(a parama, int paramInt, Bitmap.Config paramConfig)
  {
    Bitmap.Config[] arrayOfConfig = b(paramConfig);
    int j = arrayOfConfig.length;
    int i = 0;
    for (;;)
    {
      a locala = parama;
      Bitmap.Config localConfig;
      Integer localInteger;
      if (i < j)
      {
        localConfig = arrayOfConfig[i];
        localInteger = (Integer)a(localConfig).ceilingKey(Integer.valueOf(paramInt));
        if ((localInteger == null) || (localInteger.intValue() > paramInt * 8)) {
          break label131;
        }
        if (localInteger.intValue() == paramInt)
        {
          if (localConfig != null) {
            break label116;
          }
          locala = parama;
          if (paramConfig == null) {
            break label113;
          }
        }
      }
      for (;;)
      {
        this.e.a(parama);
        locala = this.e.a(localInteger.intValue(), localConfig);
        label113:
        label116:
        do
        {
          return locala;
          locala = parama;
        } while (localConfig.equals(paramConfig));
      }
      label131:
      i += 1;
    }
  }
  
  private NavigableMap<Integer, Integer> a(Bitmap.Config paramConfig)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.g.get(paramConfig);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.g.put(paramConfig, localObject);
    }
    return (NavigableMap<Integer, Integer>)localObject;
  }
  
  private void a(Integer paramInteger, Bitmap.Config paramConfig)
  {
    paramConfig = a(paramConfig);
    Integer localInteger = (Integer)paramConfig.get(paramInteger);
    if (localInteger.intValue() == 1)
    {
      paramConfig.remove(paramInteger);
      return;
    }
    paramConfig.put(paramInteger, Integer.valueOf(localInteger.intValue() - 1));
  }
  
  private static String b(int paramInt, Bitmap.Config paramConfig)
  {
    return "[" + paramInt + "](" + paramConfig + ")";
  }
  
  private static Bitmap.Config[] b(Bitmap.Config paramConfig)
  {
    switch (1.a[paramConfig.ordinal()])
    {
    default: 
      return new Bitmap.Config[] { paramConfig };
    case 1: 
      return a;
    case 2: 
      return b;
    case 3: 
      return c;
    }
    return d;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = (Bitmap)this.f.a();
    if (localBitmap != null) {
      a(Integer.valueOf(com.bumptech.glide.i.h.a(localBitmap)), localBitmap.getConfig());
    }
    return localBitmap;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = com.bumptech.glide.i.h.a(paramInt1, paramInt2, paramConfig);
    paramConfig = a(this.e.a(i, paramConfig), i, paramConfig);
    Bitmap localBitmap = (Bitmap)this.f.a(paramConfig);
    if (localBitmap != null)
    {
      a(Integer.valueOf(com.bumptech.glide.i.h.a(localBitmap)), localBitmap.getConfig());
      if (localBitmap.getConfig() == null) {
        break label86;
      }
    }
    label86:
    for (paramConfig = localBitmap.getConfig();; paramConfig = Bitmap.Config.ARGB_8888)
    {
      localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i = com.bumptech.glide.i.h.a(paramBitmap);
    a locala = this.e.a(i, paramBitmap.getConfig());
    this.f.a(locala, paramBitmap);
    paramBitmap = a(paramBitmap.getConfig());
    Integer localInteger = (Integer)paramBitmap.get(Integer.valueOf(a.a(locala)));
    int j = a.a(locala);
    if (localInteger == null) {}
    for (i = 1;; i = localInteger.intValue() + 1)
    {
      paramBitmap.put(Integer.valueOf(j), Integer.valueOf(i));
      return;
    }
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return b(com.bumptech.glide.i.h.a(paramInt1, paramInt2, paramConfig), paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return b(com.bumptech.glide.i.h.a(paramBitmap), paramBitmap.getConfig());
  }
  
  public int c(Bitmap paramBitmap)
  {
    return com.bumptech.glide.i.h.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f).append(", sortedSizes=(");
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey()).append('[').append(localEntry.getValue()).append("], ");
    }
    if (!this.g.isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    return ")}";
  }
  
  static final class a
    implements h
  {
    private final i.b a;
    private int b;
    private Bitmap.Config c;
    
    public a(i.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.a(this);
    }
    
    public void a(int paramInt, Bitmap.Config paramConfig)
    {
      this.b = paramInt;
      this.c = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.b == ((a)paramObject).b)
        {
          if (this.c != null) {
            break label49;
          }
          bool1 = bool2;
          if (((a)paramObject).c != null) {}
        }
      }
      for (;;)
      {
        bool1 = true;
        label49:
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!this.c.equals(((a)paramObject).c));
      }
    }
    
    public int hashCode()
    {
      int j = this.b;
      if (this.c != null) {}
      for (int i = this.c.hashCode();; i = 0) {
        return i + j * 31;
      }
    }
    
    public String toString()
    {
      return i.a(this.b, this.c);
    }
  }
  
  static class b
    extends b<i.a>
  {
    protected i.a a()
    {
      return new i.a(this);
    }
    
    public i.a a(int paramInt, Bitmap.Config paramConfig)
    {
      i.a locala = (i.a)c();
      locala.a(paramInt, paramConfig);
      return locala;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */