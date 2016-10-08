package com.adhoc;

import java.io.IOException;
import java.util.List;
import java.util.Set;

class cm
  extends bv
{
  cm(ch paramch, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    boolean bool = ch.h(this.e).a(this.a, this.c, this.d);
    if (bool) {}
    try
    {
      this.e.i.a(this.a, ce.l);
      if ((bool) || (this.d)) {
        synchronized (this.e)
        {
          ch.i(this.e).remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */