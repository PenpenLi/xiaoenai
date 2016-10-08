package com.adhoc;

import java.io.IOException;
import java.util.List;
import java.util.Set;

class cl
  extends bv
{
  cl(ch paramch, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    if (ch.h(this.d).a(this.a, this.c)) {
      try
      {
        this.d.i.a(this.a, ce.l);
        synchronized (this.d)
        {
          ch.i(this.d).remove(Integer.valueOf(this.a));
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */