package com.adhoc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class cp
  extends bv
{
  cp(ch.b paramb, String paramString, Object[] paramArrayOfObject, cr paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void b()
  {
    try
    {
      ch.f(this.c.c).a(this.a);
      return;
    }
    catch (IOException localIOException1)
    {
      bt.a.log(Level.INFO, "StreamHandler failure for " + ch.a(this.c.c), localIOException1);
      try
      {
        this.a.a(ce.b);
        return;
      }
      catch (IOException localIOException2) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */