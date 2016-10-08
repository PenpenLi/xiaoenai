package com.nostra13.universalimageloader.b;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.a.h;

public final class a
{
  private static e a;
  
  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    a = new e(i, i);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = a.a();
    int j = a.b();
    while ((paramInt1 / paramInt3 > i) || (paramInt2 / paramInt3 > j)) {
      if (paramBoolean) {
        paramInt3 *= 2;
      } else {
        paramInt3 += 1;
      }
    }
    return paramInt3;
  }
  
  public static int a(e parame)
  {
    int i = parame.a();
    int j = parame.b();
    int k = a.a();
    int m = a.b();
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }
  
  public static int a(e parame1, e parame2, h paramh, boolean paramBoolean)
  {
    int k = 1;
    int m = parame1.a();
    int n = parame1.b();
    int i1 = parame2.a();
    int i2 = parame2.b();
    int i;
    switch (1.a[paramh.ordinal()])
    {
    default: 
      i = 1;
      if (i < 1) {
        i = k;
      }
      break;
    }
    for (;;)
    {
      return a(m, n, i, paramBoolean);
      int i3;
      int i4;
      int j;
      if (paramBoolean)
      {
        i3 = m / 2;
        i4 = n / 2;
        j = 1;
        for (;;)
        {
          if (i3 / j <= i1)
          {
            i = j;
            if (i4 / j <= i2) {
              break;
            }
          }
          j *= 2;
        }
      }
      i = Math.max(m / i1, n / i2);
      break;
      if (paramBoolean)
      {
        i3 = m / 2;
        i4 = n / 2;
        j = 1;
        for (;;)
        {
          i = j;
          if (i3 / j <= i1) {
            break;
          }
          i = j;
          if (i4 / j <= i2) {
            break;
          }
          j *= 2;
        }
      }
      i = Math.min(m / i1, n / i2);
      break;
    }
  }
  
  public static e a(com.nostra13.universalimageloader.core.e.a parama, e parame)
  {
    int j = parama.a();
    int i = j;
    if (j <= 0) {
      i = parame.a();
    }
    int k = parama.b();
    j = k;
    if (k <= 0) {
      j = parame.b();
    }
    return new e(i, j);
  }
  
  public static float b(e parame1, e parame2, h paramh, boolean paramBoolean)
  {
    int k = parame1.a();
    int m = parame1.b();
    int i = parame2.a();
    int j = parame2.b();
    float f1 = k / i;
    float f2 = m / j;
    if (((paramh == h.a) && (f1 >= f2)) || ((paramh == h.b) && (f1 < f2))) {
      j = (int)(m / f1);
    }
    for (;;)
    {
      f2 = 1.0F;
      if ((paramBoolean) || (i >= k) || (j >= m))
      {
        f1 = f2;
        if (paramBoolean)
        {
          f1 = f2;
          if (i != k)
          {
            f1 = f2;
            if (j == m) {}
          }
        }
      }
      else
      {
        f1 = i / k;
      }
      return f1;
      i = (int)(k / f2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */