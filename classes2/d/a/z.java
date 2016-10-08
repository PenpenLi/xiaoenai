package d.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.f.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class z
  implements Serializable
{
  public static long c = 0L;
  public m a = new m();
  public l b = new l();
  
  public boolean a()
  {
    return (this.a.t != null) && (this.a.s != null) && (this.a.r != null) && (this.a.a != null) && (this.a.b != null) && (this.a.f != null) && (this.a.e != null) && (this.a.d != null);
  }
  
  public static class a
    implements Serializable
  {
    public long a = 0L;
  }
  
  public static class b
    implements Serializable
  {
    public String a = null;
    public String b = null;
  }
  
  public static class c
    implements Serializable
  {
    public Map<String, List<z.d>> a = new HashMap();
    public Map<String, List<z.e>> b = new HashMap();
  }
  
  public static class d
    implements Serializable
  {
    public long a = 0L;
    public long b = 0L;
    public int c = 0;
    public int d = 0;
    public List<String> e = new ArrayList();
  }
  
  public static final class e
    implements Serializable
  {
    public int a = 0;
    public long b = 0L;
    public String c = null;
  }
  
  public static class f
    implements Serializable
  {
    public Integer a = Integer.valueOf(0);
    public long b = 0L;
    public boolean c = false;
  }
  
  public static class g
    implements Serializable
  {
    public String a = null;
    public List<z.i> b = new ArrayList();
  }
  
  public static class h
    implements n, Serializable
  {
    public long a = 0L;
    public long b = 0L;
    public String c = null;
    
    public void a(z paramz)
    {
      if (paramz.b.i != null) {
        paramz.b.i.add(this);
      }
    }
  }
  
  public static class i
    implements n, Serializable
  {
    public int a = 0;
    public String b = null;
    public String c = null;
    public long d = 0L;
    public long e = 0L;
    public Map<String, Object> f = new HashMap();
    
    public void a(z paramz)
    {
      int j = 0;
      if (this.b == null) {
        this.b = w.a();
      }
      if (paramz.b.a != null) {}
      for (;;)
      {
        int i;
        try
        {
          if (this.a == 1)
          {
            k = paramz.b.a.size();
            if (k <= 0) {
              continue;
            }
            i = 0;
            if (i < k)
            {
              localg1 = (z.g)paramz.b.a.get(i);
              if ((TextUtils.isEmpty(localg1.a)) || (!localg1.a.equals(this.b))) {
                break label476;
              }
              paramz.b.a.remove(localg1);
              localg1.b.add(this);
              paramz.b.a.add(localg1);
              return;
            }
            localg1 = new z.g();
            localg1.a = this.b;
            localg1.b.add(this);
            if (!paramz.b.a.contains(localg1)) {
              paramz.b.a.add(localg1);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          int k;
          z.g localg1;
          ax.a(localThrowable);
          continue;
          i += 1;
          continue;
          localg2 = new z.g();
          localg2.a = this.b;
          localg2.b.add(this);
          paramz.b.b.add(localg2);
          return;
        }
        if (paramz.b.b != null)
        {
          try
          {
            if (this.a != 2) {
              break label475;
            }
            k = paramz.b.b.size();
            if (k <= 0) {
              break label434;
            }
            i = j;
            if (i >= k) {
              continue;
            }
            localg1 = (z.g)paramz.b.b.get(i);
            if ((TextUtils.isEmpty(localg1.a)) || (!localg1.a.equals(this.b))) {
              continue;
            }
            paramz.b.b.remove(localg1);
            localg1.b.add(this);
            paramz.b.b.add(localg1);
            return;
          }
          catch (Throwable paramz)
          {
            ax.a(paramz);
            return;
          }
          localg1 = new z.g();
          localg1.a = this.b;
          localg1.b.add(this);
          paramz.b.a.add(localg1);
          continue;
          label434:
          z.g localg2 = new z.g();
          localg2.a = this.b;
          localg2.b.add(this);
          paramz.b.b.add(localg2);
        }
        else
        {
          label475:
          return;
          label476:
          i += 1;
        }
      }
    }
  }
  
  public static final class j
    implements Serializable
  {
    public double a = 0.0D;
    public double b = 0.0D;
    public long c = 0L;
  }
  
  public static final class k
    implements Serializable
  {
    public String a = null;
    public long b = 0L;
    public long c = 0L;
    public long d = 0L;
  }
  
  public static class l
    implements Serializable
  {
    public List<z.g> a = new ArrayList();
    public List<z.g> b = new ArrayList();
    public List<z.n> c = new ArrayList();
    public z.a d = new z.a();
    public z.f e = new z.f();
    public Map<String, Integer> f = new HashMap();
    public z.b g = new z.b();
    public z.c h = new z.c();
    public List<z.h> i = new ArrayList();
    public String j = null;
  }
  
  public static class m
    implements Serializable
  {
    public String A = Build.DEVICE;
    public String B = null;
    public String C = null;
    public long D = 8L;
    public String E = null;
    public String F = null;
    public String G = null;
    public String H = null;
    public String I = null;
    public String J = null;
    public long K = 0L;
    public long L = 0L;
    public long M = 0L;
    public String N = null;
    public String O = null;
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public int h = 0;
    public String i = a.a;
    public String j = a.b;
    public String k = "Android";
    public String l = null;
    public int m = 0;
    public String n = null;
    public String o = av.a();
    public String p = "Android";
    public String q = Build.VERSION.RELEASE;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = Build.MODEL;
    public String v = Build.BOARD;
    public String w = Build.BRAND;
    public long x = Build.TIME;
    public String y = Build.MANUFACTURER;
    public String z = Build.ID;
  }
  
  public static class n
    implements n, Serializable
  {
    public static Map<String, z.k> g = new HashMap();
    public int a = 0;
    public String b = null;
    public long c = 0L;
    public long d = 0L;
    public long e = 0L;
    public boolean f = false;
    public List<z.k> h = new ArrayList();
    public z.o i = new z.o();
    public z.j j = new z.j();
    
    public void a(z paramz)
    {
      if (paramz.b.c != null) {
        paramz.b.c.add(this);
      }
    }
  }
  
  public static final class o
    implements Serializable
  {
    public long a = 0L;
    public long b = 0L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */