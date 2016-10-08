package com.adhoc;

import java.io.IOException;
import java.util.Set;

class cn
  extends bv
{
  cn(ch paramch, String paramString, Object[] paramArrayOfObject, int paramInt1, eo parameo, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      boolean bool = ch.h(this.f).a(this.a, this.c, this.d, this.e);
      if (bool) {
        this.f.i.a(this.a, ce.l);
      }
      if ((bool) || (this.e)) {
        synchronized (this.f)
        {
          ch.i(this.f).remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */