package d.a;

import android.content.Context;
import android.util.Base64;
import com.f.a.a;
import com.f.a.e;
import com.f.a.o;
import com.f.a.o.a;

public class u
{
  private static Context d;
  private di a;
  private dk b;
  private final int c = 1;
  private x e;
  private q f;
  private z g;
  private boolean h = false;
  private boolean i;
  
  public u(Context paramContext, x paramx)
  {
    this.a = di.a(paramContext);
    this.b = dk.a(paramContext);
    d = paramContext;
    this.e = paramx;
    this.f = new q(paramContext);
    this.f.a(this.e);
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    ao localao = new ao();
    bd localbd = new bd(new bn.a());
    try
    {
      localbd.a(localao, paramArrayOfByte);
      if (localao.a == 1)
      {
        this.b.b(localao.d());
        this.b.d();
      }
      ax.b("send log:" + localao.b());
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    if (localao.a == 1) {
      return 2;
    }
    return 3;
  }
  
  private void b()
  {
    o.a(d).h().a(new v(this));
  }
  
  private void c()
  {
    this.a.a();
    Object localObject1 = this.g;
    try
    {
      Object localObject2 = this.a.b();
      localObject2 = new bf().a((ba)localObject2);
      ((z)localObject1).a.O = Base64.encodeToString((byte[])localObject2, 0);
      localObject1 = o.a(d).b((z)localObject1);
      if (e.a(d, (byte[])localObject1)) {
        label65:
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ax.a(localException);
      }
      if (localObject1 == null)
      {
        ax.d("message is null");
        return;
      }
      label105:
      byte[] arrayOfByte;
      if (!this.h)
      {
        localObject1 = dg.a(d, a.a(d), (byte[])localObject1);
        localObject1 = ((dg)localObject1).c();
        o.a(d).f();
        arrayOfByte = this.f.a((byte[])localObject1);
        if (arrayOfByte != null) {
          break label196;
        }
      }
      label196:
      for (int j = 1;; j = a(arrayOfByte)) {
        switch (j)
        {
        default: 
          return;
        case 1: 
          if (this.i) {
            break label65;
          }
          o.a(d).a((byte[])localObject1);
          return;
          localObject1 = dg.b(d, a.a(d), (byte[])localObject1);
          break label105;
        }
      }
      if (this.e.l()) {
        this.e.k();
      }
      this.a.c();
      this.e.j();
      z.c = 0L;
      return;
    }
    this.e.j();
  }
  
  public void a()
  {
    if (this.g != null)
    {
      c();
      return;
    }
    b();
  }
  
  public void a(s params)
  {
    this.b.a(params);
  }
  
  public void a(z paramz)
  {
    this.g = paramz;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */