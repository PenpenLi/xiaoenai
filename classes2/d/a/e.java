package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.f.a.a;
import com.f.a.c.a;
import com.f.a.c.b;
import com.f.a.c.c;
import com.f.a.c.d;
import com.f.a.c.e;
import com.f.a.c.f;
import com.f.a.c.g;
import com.f.a.c.h;
import com.f.a.c.i;
import com.f.a.c.j;
import com.f.a.o;
import java.util.Iterator;
import java.util.List;

public final class e
  implements m, s
{
  private static Context o;
  private final long a = 28800000L;
  private final int b = 5000;
  private p c = null;
  private o d = null;
  private x e = null;
  private ab f = null;
  private aa g = null;
  private ac h = null;
  private a i = null;
  private dk.a j = null;
  private int k = 10;
  private long l = 0L;
  private int m = 0;
  private int n = 0;
  
  public e(Context paramContext)
  {
    o = paramContext;
    this.c = new p(paramContext);
    this.e = new x(paramContext);
    this.d = o.a(paramContext);
    this.j = dk.a(paramContext).b();
    this.i = new a();
    this.g = aa.a(o);
    this.f = ab.a(o);
    this.h = ac.a(o, this.e);
    paramContext = t.a(o);
    this.l = paramContext.getLong("thtstart", 0L);
    this.m = paramContext.getInt("gkvc", 0);
    this.n = paramContext.getInt("ekvc", 0);
  }
  
  private void a(int paramInt)
  {
    a(a(new int[] { paramInt, (int)(System.currentTimeMillis() - this.e.n()) }));
    com.f.a.m.a(new f(this), paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, z paramz)
  {
    int i1;
    if (paramInt1 > 0)
    {
      List localList = paramz.b.b;
      if (localList.size() >= paramInt1)
      {
        int i2 = localList.size();
        i1 = localList.size() - 1;
        while (i1 >= i2 - paramInt1)
        {
          localList.remove(i1);
          i1 -= 1;
        }
      }
      localList.size();
      localList.clear();
    }
    if (paramInt2 > 0)
    {
      paramz = paramz.b.a;
      if (paramz.size() >= paramInt2)
      {
        i1 = paramz.size();
        paramInt1 = paramz.size() - 1;
        while (paramInt1 >= i1 - paramInt2)
        {
          paramz.remove(paramInt1);
          paramInt1 -= 1;
        }
      }
      paramz.size();
      paramz.clear();
    }
  }
  
  private void a(z paramz)
  {
    if (paramz != null) {}
    try
    {
      di localdi = di.a(o);
      localdi.a();
      try
      {
        Object localObject = localdi.b();
        localObject = new bf().a((ba)localObject);
        paramz.a.O = Base64.encodeToString((byte[])localObject, 0);
        paramz = o.a(o).b(c(paramz));
        if (paramz == null) {
          return;
        }
        if (!com.f.a.e.a(o, paramz))
        {
          if (g()) {}
          for (paramz = dg.b(o, a.a(o), paramz);; paramz = dg.a(o, a.a(o), paramz))
          {
            paramz = paramz.c();
            localObject = o.a(o);
            ((o)localObject).f();
            ((o)localObject).a(paramz);
            localdi.c();
            z.c = 0L;
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      return;
    }
    catch (Exception paramz) {}
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = this.e.e();
    if (bool) {
      z.c = this.e.m();
    }
    if (b(paramBoolean)) {
      f();
    }
    while ((!bool) && (!e())) {
      return;
    }
    b();
  }
  
  private void b(int paramInt)
  {
    a(paramInt);
  }
  
  private boolean b(z paramz)
  {
    if (paramz == null) {}
    while (!paramz.a()) {
      return false;
    }
    return true;
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (!av.j(o))
    {
      ax.a("network is unavailable");
      return false;
    }
    if (this.e.e()) {
      return true;
    }
    return this.i.b(paramBoolean).a(paramBoolean);
  }
  
  private z c(z paramz)
  {
    int i4 = 5000;
    int i3;
    if (paramz.b.a != null)
    {
      i3 = 0;
      i1 = 0;
      for (;;)
      {
        i2 = i1;
        if (i3 >= paramz.b.a.size()) {
          break;
        }
        i1 += ((z.g)paramz.b.a.get(i3)).b.size();
        i3 += 1;
      }
    }
    int i2 = 0;
    int i1 = i2;
    if (paramz.b.b != null)
    {
      i3 = 0;
      for (;;)
      {
        i1 = i2;
        if (i3 >= paramz.b.b.size()) {
          break;
        }
        i2 += ((z.g)paramz.b.b.get(i3)).b.size();
        i3 += 1;
      }
    }
    long l1 = System.currentTimeMillis();
    if (l1 - this.l > 28800000L)
    {
      i2 = i1 - 5000;
      if (i2 > 0) {
        a(60536, i2, paramz);
      }
      this.m = 0;
      if (i2 > 0) {
        i1 = 5000;
      }
      this.n = i1;
      this.l = l1;
      return paramz;
    }
    if (this.m > 5000)
    {
      i3 = 0;
      if (this.n <= 5000) {
        break label300;
      }
      i2 = i1;
      label238:
      if ((i3 > 0) || (i2 > 0)) {
        a(i3, i2, paramz);
      }
      if (i3 <= 0) {
        break label314;
      }
      i3 = 5000;
      label265:
      this.m = i3;
      if (i2 <= 0) {
        break label325;
      }
    }
    label300:
    label314:
    label325:
    for (i1 = i4;; i1 = this.n + i1)
    {
      this.n = i1;
      return paramz;
      i3 = this.m + 0 - 5000;
      break;
      i2 = this.n + i1 - 5000;
      break label238;
      i3 = this.m + 0;
      break label265;
    }
  }
  
  private boolean e()
  {
    return this.c.a() > this.k;
  }
  
  private void f()
  {
    try
    {
      if (this.d.g())
      {
        localObject = new u(o, this.e);
        ((u)localObject).a(this);
        if (this.f.b()) {
          ((u)localObject).b(true);
        }
        ((u)localObject).a();
        return;
      }
      Object localObject = a(new int[0]);
      if (b((z)localObject))
      {
        u localu = new u(o, this.e);
        localu.a(this);
        if (this.f.b()) {
          localu.b(true);
        }
        localu.a(c((z)localObject));
        localu.a(g());
        localu.a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if ((!(localThrowable instanceof OutOfMemoryError)) || (localThrowable != null)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private boolean g()
  {
    switch (this.j.c(-1))
    {
    case 0: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return a.j;
  }
  
  protected z a(int... paramVarArgs)
  {
    int i1 = 0;
    label252:
    label255:
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(a.a(o)))
        {
          ax.d("Appkey is missing ,Please check AndroidManifest.xml");
          return null;
        }
        Object localObject2 = o.a(o).e();
        if ((localObject2 == null) && (this.c.a() == 0)) {
          return null;
        }
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new z();
        }
        this.c.a((z)localObject1);
        if ((((z)localObject1).b.c != null) && (ax.a) && (((z)localObject1).b.c.size() > 0))
        {
          localObject2 = ((z)localObject1).b.c.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (((z.n)((Iterator)localObject2).next()).h.size() <= 0) {
              break label252;
            }
            i1 = 1;
            break label255;
          }
          if (i1 == 0) {
            ax.c("missing Activities or PageViews");
          }
        }
        this.f.a((z)localObject1, o);
        if ((paramVarArgs != null) && (paramVarArgs.length == 2))
        {
          ((z)localObject1).b.e.a = Integer.valueOf(paramVarArgs[0] / 1000);
          ((z)localObject1).b.e.b = paramVarArgs[1];
          ((z)localObject1).b.e.c = true;
        }
        return (z)localObject1;
      }
      catch (Exception paramVarArgs)
      {
        ax.b("Fail to construct message ...", paramVarArgs);
        o.a(o).f();
        ax.a(paramVarArgs);
        return null;
      }
    }
  }
  
  public void a()
  {
    if (av.j(o))
    {
      f();
      return;
    }
    ax.a("network is unavailable");
  }
  
  public void a(dk.a parama)
  {
    this.g.a(parama);
    this.f.a(parama);
    this.h.a(parama);
    this.i.a(parama);
  }
  
  public void a(n paramn)
  {
    if (paramn != null) {
      this.c.a(paramn);
    }
    a(paramn instanceof z.n);
  }
  
  public void b()
  {
    if (this.c.a() > 0) {}
    try
    {
      this.d.a(a(new int[0]));
      t.a(o).edit().putLong("thtstart", this.l).putInt("gkvc", this.m).putInt("ekvc", this.n).commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ax.a(localThrowable);
        if ((localThrowable instanceof OutOfMemoryError)) {
          this.d.f();
        }
        if (localThrowable != null) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public void b(n paramn)
  {
    this.c.a(paramn);
  }
  
  public void c()
  {
    a(a(new int[0]));
  }
  
  public class a
  {
    private c.h b;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    
    public a()
    {
      this$1 = e.a(e.this).a(-1, -1);
      this.c = e.this[0];
      this.d = e.this[1];
    }
    
    private c.h a(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      case 2: 
      case 3: 
      case 7: 
      default: 
        if ((this.b instanceof c.d)) {
          return this.b;
        }
        break;
      case 1: 
        if ((this.b instanceof c.d)) {
          return this.b;
        }
        return new c.d();
      case 6: 
        if ((this.b instanceof c.e))
        {
          c.h localh = this.b;
          ((c.e)localh).a(paramInt2);
          return localh;
        }
        return new c.e(e.c(e.this), paramInt2);
      case 4: 
        if ((this.b instanceof c.f)) {
          return this.b;
        }
        return new c.f(e.c(e.this));
      case 0: 
        if ((this.b instanceof c.g)) {
          return this.b;
        }
        return new c.g();
      case 5: 
        if ((this.b instanceof c.i)) {
          return this.b;
        }
        return new c.i(e.d());
      case 8: 
        if ((this.b instanceof c.j)) {
          return this.b;
        }
        return new c.j(e.c(e.this));
      }
      return new c.d();
    }
    
    public void a(dk.a parama)
    {
      parama = parama.a(-1, -1);
      this.c = parama[0];
      this.d = parama[1];
    }
    
    protected void a(boolean paramBoolean)
    {
      int k = 1;
      int i = 1;
      int j = 0;
      Object localObject;
      if (e.b(e.this).b()) {
        if (((this.b instanceof c.b)) && (this.b.a()))
        {
          if (i == 0) {
            break label92;
          }
          localObject = this.b;
          label50:
          this.b = ((c.h)localObject);
        }
      }
      for (;;)
      {
        ax.a("Report policy : " + this.b.getClass().getSimpleName());
        return;
        i = 0;
        break;
        label92:
        localObject = new c.b(e.c(e.this), e.b(e.this));
        break label50;
        if (((this.b instanceof c.c)) && (this.b.a())) {}
        for (i = k;; i = 0)
        {
          if (i != 0) {
            break label207;
          }
          if ((!paramBoolean) || (!e.d(e.this).a())) {
            break label209;
          }
          this.b = new c.c((int)e.d(e.this).b());
          e.a(e.this, (int)e.d(e.this).b());
          break;
        }
        label207:
        continue;
        label209:
        if ((ax.a) && (e.a(e.this).b()))
        {
          ax.a("Debug: send log every 15 seconds");
          this.b = new c.a(e.c(e.this));
        }
        else
        {
          if (e.e(e.this).a())
          {
            ax.a("Start A/B Test");
            i = j;
            if (e.e(e.this).b() == 6)
            {
              if (!e.a(e.this).a()) {
                break label338;
              }
              i = e.a(e.this).d(90000);
            }
            for (;;)
            {
              this.b = a(e.e(e.this).b(), i);
              break;
              label338:
              if (this.d > 0) {
                i = this.d;
              } else {
                i = this.f;
              }
            }
          }
          j = this.e;
          i = this.f;
          if (this.c != -1)
          {
            j = this.c;
            i = this.d;
          }
          this.b = a(j, i);
        }
      }
    }
    
    public c.h b(boolean paramBoolean)
    {
      a(paramBoolean);
      return this.b;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */