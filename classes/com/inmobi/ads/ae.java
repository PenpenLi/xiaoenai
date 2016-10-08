package com.inmobi.ads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ae
{
  private static final String a = ae.class.getSimpleName();
  private final int[] b = new int['È'];
  private final int[] c = new int['È'];
  private int d = 0;
  private final int[] e = new int['È'];
  private final int[] f = new int['È'];
  private int g = 0;
  private final q[] h = new q['È'];
  
  private ae(int[] paramArrayOfInt)
  {
    this.d = Math.min(paramArrayOfInt.length, 200);
    System.arraycopy(paramArrayOfInt, 0, this.c, 0, this.d);
    System.arraycopy(paramArrayOfInt, 0, this.b, 0, this.d);
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt1 = Arrays.binarySearch(paramArrayOfInt, 0, paramInt1, paramInt2);
    if (paramInt1 < 0) {
      return paramInt1 ^ 0xFFFFFFFF;
    }
    paramInt2 = paramArrayOfInt[paramInt1];
    while ((paramInt1 >= 0) && (paramArrayOfInt[paramInt1] == paramInt2)) {
      paramInt1 -= 1;
    }
    return paramInt1 + 1;
  }
  
  @NonNull
  static ae a(@NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    int i = 0;
    Object localObject = paramInMobiClientPositioning.getFixedPositions();
    int n = paramInMobiClientPositioning.getRepeatingInterval();
    if (Integer.MAX_VALUE == paramInMobiClientPositioning.getRepeatingInterval()) {}
    int j;
    int m;
    for (int k = ((List)localObject).size();; k = 200)
    {
      paramInMobiClientPositioning = new int[k];
      localObject = ((List)localObject).iterator();
      j = 0;
      for (;;)
      {
        m = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        j = ((Integer)((Iterator)localObject).next()).intValue() - i;
        paramInMobiClientPositioning[i] = j;
        i += 1;
      }
    }
    while (m < k)
    {
      j = j + n - 1;
      paramInMobiClientPositioning[m] = j;
      m += 1;
    }
    return new ae(paramInMobiClientPositioning);
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt2 = Arrays.binarySearch(paramArrayOfInt, 0, paramInt1, paramInt2);
    int i;
    if (paramInt2 < 0)
    {
      i = paramInt2 ^ 0xFFFFFFFF;
      return i;
    }
    int j = paramArrayOfInt[paramInt2];
    for (;;)
    {
      i = paramInt2;
      if (paramInt2 >= paramInt1) {
        break;
      }
      i = paramInt2;
      if (paramArrayOfInt[paramInt2] != j) {
        break;
      }
      paramInt2 += 1;
    }
  }
  
  @NonNull
  static ae c()
  {
    return new ae(new int[0]);
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int m = 0;
    int[] arrayOfInt1 = new int[this.g];
    int[] arrayOfInt2 = new int[this.g];
    int j = 0;
    int i = 0;
    if (j < this.g)
    {
      int n = this.e[j];
      int i1 = this.f[j];
      int k;
      if ((paramInt1 <= i1) && (i1 < paramInt2))
      {
        arrayOfInt1[i] = n;
        arrayOfInt2[i] = (i1 - i);
        this.h[j].c();
        this.h[j] = null;
        k = i + 1;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        k = i;
        if (i > 0)
        {
          k = j - i;
          this.e[k] = n;
          this.f[k] = (i1 - i);
          this.h[k] = this.h[j];
          k = i;
        }
      }
    }
    if (i == 0) {
      return 0;
    }
    paramInt1 = arrayOfInt2[0];
    j = a(this.c, this.d, paramInt1);
    paramInt1 = this.d - 1;
    for (;;)
    {
      paramInt2 = m;
      if (paramInt1 < j) {
        break;
      }
      this.b[(paramInt1 + i)] = this.b[paramInt1];
      this.c[(paramInt1 + i)] = (this.c[paramInt1] - i);
      paramInt1 -= 1;
    }
    while (paramInt2 < i)
    {
      this.b[(j + paramInt2)] = arrayOfInt1[paramInt2];
      this.c[(j + paramInt2)] = arrayOfInt2[paramInt2];
      paramInt2 += 1;
    }
    this.d += i;
    this.g -= i;
    return i;
  }
  
  @Nullable
  q a(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.f, 0, this.g, paramInt);
    if (paramInt < 0) {
      return null;
    }
    return this.h[paramInt];
  }
  
  void a()
  {
    if (this.g == 0) {
      return;
    }
    a(0, this.f[(this.g - 1)] + 1);
  }
  
  void a(q paramq, int paramInt)
  {
    int i = a(this.c, this.d, paramInt);
    if ((i == this.d) || (this.c[i] != paramInt)) {}
    for (;;)
    {
      return;
      int k = this.b[i];
      int j = b(this.e, this.g, k);
      if (j < this.g)
      {
        int m = this.g - j;
        System.arraycopy(this.e, j, this.e, j + 1, m);
        System.arraycopy(this.f, j, this.f, j + 1, m);
        System.arraycopy(this.h, j, this.h, j + 1, m);
      }
      this.e[j] = k;
      this.f[j] = paramInt;
      this.h[j] = paramq;
      this.g += 1;
      paramInt = this.d - i - 1;
      System.arraycopy(this.c, i + 1, this.c, i, paramInt);
      System.arraycopy(this.b, i + 1, this.b, i, paramInt);
      this.d -= 1;
      paramInt = i;
      while (paramInt < this.d)
      {
        paramq = this.c;
        paramq[paramInt] += 1;
        paramInt += 1;
      }
      paramInt = j + 1;
      while (paramInt < this.g)
      {
        paramq = this.f;
        paramq[paramInt] += 1;
        paramInt += 1;
      }
    }
  }
  
  boolean b(int paramInt)
  {
    boolean bool = false;
    if (Arrays.binarySearch(this.c, 0, this.d, paramInt) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  @NonNull
  int[] b()
  {
    int[] arrayOfInt = new int[this.g];
    System.arraycopy(this.f, 0, arrayOfInt, 0, this.g);
    return arrayOfInt;
  }
  
  int c(int paramInt)
  {
    paramInt = b(this.c, this.d, paramInt);
    if (paramInt == this.d) {
      return -1;
    }
    return this.c[paramInt];
  }
  
  boolean d(int paramInt)
  {
    boolean bool = false;
    if (Arrays.binarySearch(this.f, 0, this.g, paramInt) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  void e(int paramInt)
  {
    int i = a(this.b, this.d, paramInt);
    int[] arrayOfInt;
    while (i < this.d)
    {
      arrayOfInt = this.b;
      arrayOfInt[i] += 1;
      arrayOfInt = this.c;
      arrayOfInt[i] += 1;
      i += 1;
    }
    paramInt = a(this.e, this.g, paramInt);
    while (paramInt < this.g)
    {
      arrayOfInt = this.e;
      arrayOfInt[paramInt] += 1;
      arrayOfInt = this.f;
      arrayOfInt[paramInt] += 1;
      paramInt += 1;
    }
  }
  
  void f(int paramInt)
  {
    int i = b(this.b, this.d, paramInt);
    int[] arrayOfInt;
    while (i < this.d)
    {
      arrayOfInt = this.b;
      arrayOfInt[i] -= 1;
      arrayOfInt = this.c;
      arrayOfInt[i] -= 1;
      i += 1;
    }
    paramInt = b(this.e, this.g, paramInt);
    while (paramInt < this.g)
    {
      arrayOfInt = this.e;
      arrayOfInt[paramInt] -= 1;
      arrayOfInt = this.f;
      arrayOfInt[paramInt] -= 1;
      paramInt += 1;
    }
  }
  
  int g(int paramInt)
  {
    int i = Arrays.binarySearch(this.f, 0, this.g, paramInt);
    if (i < 0) {
      return paramInt - (i ^ 0xFFFFFFFF);
    }
    return -1;
  }
  
  int h(int paramInt)
  {
    return b(this.e, this.g, paramInt) + paramInt;
  }
  
  int i(int paramInt)
  {
    int i = -1;
    if (paramInt == 0) {
      paramInt = 0;
    }
    int j;
    do
    {
      return paramInt;
      j = g(paramInt - 1);
      paramInt = i;
    } while (j == -1);
    return j + 1;
  }
  
  int j(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return h(paramInt - 1) + 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */