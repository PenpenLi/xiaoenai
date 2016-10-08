package b.a.a;

import b.a.f;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class h
  extends f
{
  h(d paramd, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    if (d.h(this.d).a(this.a, this.c)) {
      try
      {
        this.d.i.a(this.a, a.l);
        synchronized (this.d)
        {
          d.i(this.d).remove(Integer.valueOf(this.a));
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */