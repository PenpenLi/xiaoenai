package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.g;
import com.ta.utdid2.b.a.i;
import java.util.zip.Adler32;

public class b
{
  private static a a = null;
  static final Object e = new Object();
  static String k = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
  
  static long a(a parama)
  {
    if (parama != null)
    {
      parama = String.format("%s%s%s%s%s", new Object[] { parama.f(), parama.getDeviceId(), Long.valueOf(parama.a()), parama.e(), parama.d() });
      if (!i.a(parama))
      {
        Adler32 localAdler32 = new Adler32();
        localAdler32.reset();
        localAdler32.update(parama.getBytes());
        return localAdler32.getValue();
      }
    }
    return 0L;
  }
  
  private static a a(Context paramContext)
  {
    if (paramContext != null)
    {
      new a();
      label128:
      for (;;)
      {
        synchronized (e)
        {
          String str1 = c.a(paramContext).getValue();
          if (!i.a(str1))
          {
            if (!str1.endsWith("\n")) {
              break label128;
            }
            str1 = str1.substring(0, str1.length() - 1);
            a locala = new a();
            long l = System.currentTimeMillis();
            String str2 = g.a(paramContext);
            paramContext = g.b(paramContext);
            locala.d(str2);
            locala.b(str2);
            locala.b(l);
            locala.c(paramContext);
            locala.e(str1);
            locala.a(a(locala));
            return locala;
          }
        }
      }
    }
    return null;
  }
  
  public static a b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (a != null)
        {
          paramContext = a;
          return paramContext;
        }
        if (paramContext != null)
        {
          paramContext = a(paramContext);
          a = paramContext;
        }
        else
        {
          paramContext = null;
        }
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\device\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */