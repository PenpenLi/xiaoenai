package com.bumptech.glide.d.b.d;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.d.b.b.i;
import com.bumptech.glide.i.h;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private final i a;
  private final com.bumptech.glide.d.b.a.c b;
  private final com.bumptech.glide.d.a c;
  private final Handler d = new Handler(Looper.getMainLooper());
  private a e;
  
  public b(i parami, com.bumptech.glide.d.b.a.c paramc, com.bumptech.glide.d.a parama)
  {
    this.a = parami;
    this.b = paramc;
    this.c = parama;
  }
  
  private static int a(d paramd)
  {
    return h.a(paramd.a(), paramd.b(), paramd.c());
  }
  
  c a(d[] paramArrayOfd)
  {
    int k = 0;
    int m = this.a.b();
    int n = this.a.a();
    int i1 = this.b.a();
    int i2 = paramArrayOfd.length;
    int i = 0;
    int j = 0;
    while (i < i2)
    {
      j += paramArrayOfd[i].d();
      i += 1;
    }
    float f = (m - n + i1) / j;
    HashMap localHashMap = new HashMap();
    j = paramArrayOfd.length;
    i = k;
    while (i < j)
    {
      d locald = paramArrayOfd[i];
      localHashMap.put(locald, Integer.valueOf(Math.round(locald.d() * f) / a(locald)));
      i += 1;
    }
    return new c(localHashMap);
  }
  
  public void a(d.a... paramVarArgs)
  {
    if (this.e != null) {
      this.e.a();
    }
    d[] arrayOfd = new d[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      d.a locala = paramVarArgs[i];
      if (locala.a() == null) {
        if ((this.c != com.bumptech.glide.d.a.a) && (this.c != com.bumptech.glide.d.a.b)) {
          break label93;
        }
      }
      label93:
      for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;; localConfig = Bitmap.Config.RGB_565)
      {
        locala.a(localConfig);
        arrayOfd[i] = locala.b();
        i += 1;
        break;
      }
    }
    paramVarArgs = a(arrayOfd);
    this.e = new a(this.b, this.a, paramVarArgs);
    this.d.post(this.e);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */