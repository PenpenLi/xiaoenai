package d.a;

import android.content.Context;

public final class g
  implements m
{
  private static g c;
  private m a;
  private Context b;
  
  private g(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new e(this.b);
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new g(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public void a(n paramn)
  {
    com.f.a.m.b(new h(this, paramn));
  }
  
  public void b()
  {
    com.f.a.m.b(new i(this));
  }
  
  public void b(n paramn)
  {
    this.a.b(paramn);
  }
  
  public void c()
  {
    com.f.a.m.c(new j(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */