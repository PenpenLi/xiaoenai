package b.a.a;

import b.a.f;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class i
  extends f
{
  i(d paramd, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    boolean bool = d.h(this.e).a(this.a, this.c, this.d);
    if (bool) {}
    try
    {
      this.e.i.a(this.a, a.l);
      if ((bool) || (this.d)) {
        synchronized (this.e)
        {
          d.i(this.e).remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */