package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.f.a.a;
import com.f.a.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class p
{
  private List<n> a = new ArrayList();
  private Context b = null;
  
  public p(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void c(z paramz)
  {
    try
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((n)((Iterator)localObject).next()).a(paramz);
      }
      localObject = t.a(this.b);
    }
    finally {}
    if (localObject == null) {
      return;
    }
    Object localObject = ((SharedPreferences)localObject).getString("userlevel", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramz.b.j = ((String)localObject);
    }
    this.a.clear();
    if (z.c != 0L) {
      paramz.b.d.a = z.c;
    }
    cn.a(this.b).a(paramz);
    localObject = l.a(this.b);
    if ((localObject != null) && (!TextUtils.isEmpty(localObject[0])) && (!TextUtils.isEmpty(localObject[1])))
    {
      paramz.b.g.a = localObject[0];
      paramz.b.g.b = localObject[1];
    }
    aa.a(this.b).a(paramz);
  }
  
  public int a()
  {
    try
    {
      int j = this.a.size();
      long l = z.c;
      int i = j;
      if (l != 0L) {
        i = j + 1;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(n paramn)
  {
    try
    {
      this.a.add(paramn);
      return;
    }
    finally
    {
      paramn = finally;
      throw paramn;
    }
  }
  
  public void a(z paramz)
  {
    if (w.g(this.b) == null) {
      return;
    }
    b(paramz);
    c(paramz);
  }
  
  void b(z paramz)
  {
    paramz.a.a = a.a(this.b);
    paramz.a.b = a.b(this.b);
    paramz.a.c = aw.a(a.c(this.b));
    paramz.a.m = a.d(this.b);
    paramz.a.l = a.e(this.b);
    paramz.a.e = av.r(this.b);
    int i = Integer.parseInt(av.a(this.b));
    Object localObject = av.b(this.b);
    SharedPreferences localSharedPreferences = t.a(this.b);
    if (localSharedPreferences == null)
    {
      paramz.a.h = i;
      paramz.a.d = ((String)localObject);
    }
    for (;;)
    {
      paramz.a.f = av.s(this.b);
      paramz.a.g = av.u(this.b);
      if ((a.a != null) && (a.b != null))
      {
        paramz.a.i = a.a;
        paramz.a.j = a.b;
      }
      paramz.a.t = av.c(this.b);
      paramz.a.n = av.d(this.b);
      paramz.a.s = av.o(this.b);
      paramz.a.B = av.v(this.b);
      paramz.a.C = av.w(this.b);
      localObject = av.p(this.b);
      if (localObject != null) {
        paramz.a.r = (localObject[1] + "*" + localObject[0]);
      }
      if ((a.d != null) && (a.c != null)) {}
      localObject = av.h(this.b);
      if ("Wi-Fi".equals(localObject[0]))
      {
        paramz.a.H = "wifi";
        label354:
        if (!"".equals(localObject[1])) {
          paramz.a.I = localObject[1];
        }
        localObject = av.e(this.b);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramz.a.J = ((String)localObject);
        }
        paramz.a.G = av.g(this.b);
        localObject = av.m(this.b);
        paramz.a.F = localObject[0];
        paramz.a.E = localObject[1];
        paramz.a.D = av.k(this.b);
        x.a(this.b, paramz);
      }
      try
      {
        localObject = di.a(this.b).b();
        if (localObject == null)
        {
          return;
          paramz.a.h = localSharedPreferences.getInt("versioncode", 0);
          paramz.a.d = localSharedPreferences.getString("versionname", "");
          continue;
          if ("2G/3G".equals(localObject[0]))
          {
            paramz.a.H = "2G/3G";
            break label354;
          }
          paramz.a.H = "unknow";
          break label354;
        }
        localObject = new bf().a((ba)localObject);
        paramz.a.O = Base64.encodeToString((byte[])localObject, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            localObject = dk.a(this.b).a();
            if (localObject == null)
            {
              ax.d("trans the imprint is null");
              return;
            }
            localObject = new bf().a((ba)localObject);
            paramz.a.N = Base64.encodeToString((byte[])localObject, 0);
            return;
          }
          catch (Exception paramz) {}
          localException = localException;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */