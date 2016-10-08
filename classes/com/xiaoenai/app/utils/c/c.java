package com.xiaoenai.app.utils.c;

import com.xiaoenai.app.utils.ak;

public class c
  extends a
{
  private static double a = 8.0D;
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return Integer.MIN_VALUE;
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
      return 31;
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      return 30;
    }
    if (d(paramInt2)) {
      return 29;
    }
    return 28;
  }
  
  public static void a()
  {
    a = ak.c();
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a.a(paramInt1, paramInt2, paramInt3, i, a);
    }
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt1 > 12)) {
      return Integer.MIN_VALUE;
    }
    int[] arrayOfInt = a(1, paramInt1, paramInt2, 0, a);
    arrayOfInt = a(a(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2]) + 29);
    if (a(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], a)[1] != paramInt1) {
      return 29;
    }
    return 30;
  }
  
  public static int[] b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramInt2, paramInt3, a);
  }
  
  public static boolean d(int paramInt)
  {
    return ((paramInt % 4 == 0) && (paramInt % 100 != 0)) || (paramInt % 400 == 0);
  }
  
  public static int e(int paramInt)
  {
    int i = c(paramInt, a);
    int j = c(paramInt - 1, a);
    if (Math.abs(j - i) > 355)
    {
      j = d(j, a);
      if (j >= 3) {
        return j - 2;
      }
    }
    if (Math.abs(i - c(paramInt + 1, a)) > 355)
    {
      paramInt = d(i, a);
      if (paramInt < 3) {
        return paramInt + 10;
      }
    }
    return Integer.MIN_VALUE;
  }
  
  public static int f(int paramInt)
  {
    int i = b.a(paramInt);
    paramInt = i;
    if (i == 0) {
      paramInt = Integer.MIN_VALUE;
    }
    return paramInt;
  }
  
  public static int g(int paramInt)
  {
    while (!d(paramInt)) {
      paramInt += 1;
    }
    return paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */