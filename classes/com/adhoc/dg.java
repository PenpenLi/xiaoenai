package com.adhoc;

import java.util.Arrays;

public final class dg
{
  private int a;
  private int b;
  private int c;
  private final int[] d = new int[10];
  
  dg a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.d.length) {
      return this;
    }
    int i = 1 << paramInt1;
    this.a |= i;
    if ((paramInt2 & 0x1) != 0)
    {
      this.b |= i;
      if ((paramInt2 & 0x2) == 0) {
        break label86;
      }
    }
    label86:
    for (this.c = (i | this.c);; this.c = ((i ^ 0xFFFFFFFF) & this.c))
    {
      this.d[paramInt1] = paramInt3;
      return this;
      this.b &= (i ^ 0xFFFFFFFF);
      break;
    }
  }
  
  void a()
  {
    this.c = 0;
    this.b = 0;
    this.a = 0;
    Arrays.fill(this.d, 0);
  }
  
  void a(dg paramdg)
  {
    int i = 0;
    if (i < 10)
    {
      if (!paramdg.a(i)) {}
      for (;;)
      {
        i += 1;
        break;
        a(i, paramdg.c(i), paramdg.b(i));
      }
    }
  }
  
  boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  int b()
  {
    return Integer.bitCount(this.a);
  }
  
  int b(int paramInt)
  {
    return this.d[paramInt];
  }
  
  int c()
  {
    if ((0x2 & this.a) != 0) {
      return this.d[1];
    }
    return -1;
  }
  
  int c(int paramInt)
  {
    int i = 0;
    if (g(paramInt)) {
      i = 2;
    }
    int j = i;
    if (f(paramInt)) {
      j = i | 0x1;
    }
    return j;
  }
  
  int d(int paramInt)
  {
    if ((0x20 & this.a) != 0) {
      paramInt = this.d[5];
    }
    return paramInt;
  }
  
  int e(int paramInt)
  {
    if ((0x80 & this.a) != 0) {
      paramInt = this.d[7];
    }
    return paramInt;
  }
  
  boolean f(int paramInt)
  {
    return (1 << paramInt & this.b) != 0;
  }
  
  boolean g(int paramInt)
  {
    return (1 << paramInt & this.c) != 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */