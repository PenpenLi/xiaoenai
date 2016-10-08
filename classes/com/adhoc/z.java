package com.adhoc;

import android.content.Context;
import java.io.IOException;
import org.json.JSONObject;

class z
  implements an
{
  z(w paramw, Context paramContext, JSONObject paramJSONObject) {}
  
  public void a(bj parambj, IOException paramIOException)
  {
    try
    {
      fl.b(parambj.c() + " error");
      fl.a(paramIOException);
      w.a(w.a(), this.a, this.b);
      return;
    }
    catch (Throwable parambj)
    {
      fl.a(parambj);
    }
  }
  
  public void a(bn parambn)
  {
    if (parambn != null) {}
    try
    {
      fl.a(parambn.h().e());
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
      return;
    }
    finally
    {
      if (parambn != null) {
        parambn.h().close();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */