package b.a.a;

import b.a.f;
import c.e;
import java.io.IOException;
import java.util.Set;

class j
  extends f
{
  j(d paramd, String paramString, Object[] paramArrayOfObject, int paramInt1, e parame, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      boolean bool = d.h(this.f).a(this.a, this.c, this.d, this.e);
      if (bool) {
        this.f.i.a(this.a, a.l);
      }
      if ((bool) || (this.e)) {
        synchronized (this.f)
        {
          d.i(this.f).remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */