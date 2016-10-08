package com.xiaoenai.app.utils.c;

class a
{
  static double a(double paramDouble)
  {
    return b(paramDouble);
  }
  
  static double a(int paramInt, double paramDouble)
  {
    return a(paramInt - 0.5D - paramDouble / 24.0D);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = (14 - paramInt2) / 12;
    int i = paramInt3 + 4800 - j;
    j = j * 12 + paramInt2 - 3;
    paramInt3 = (j * 153 + 2) / 5 + paramInt1 + i * 365 + i / 4 - i / 100 + i / 400 - 32045;
    paramInt2 = paramInt3;
    if (paramInt3 < 2299161) {
      paramInt2 = (j * 153 + 2) / 5 + paramInt1 + i * 365 + i / 4 - 32083;
    }
    return paramInt2;
  }
  
  public static int[] a(int paramInt)
  {
    int i;
    if (paramInt > 2299160)
    {
      i = paramInt + 32044;
      paramInt = (i * 4 + 3) / 146097;
      i -= 146097 * paramInt / 4;
    }
    for (;;)
    {
      int j = (i * 4 + 3) / 1461;
      i -= j * 1461 / 4;
      int k = (i * 5 + 2) / 153;
      return new int[] { i - (k * 153 + 2) / 5 + 1, k + 3 - k / 10 * 12, paramInt * 100 + j - 4800 + k / 10 };
      i = paramInt + 32082;
      paramInt = 0;
    }
  }
  
  static int[] a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    int m = a(paramInt1, paramInt2, paramInt3);
    int i = c((m - 2415021.076998695D) / 29.530588853D);
    paramInt1 = b(i + 1, paramDouble);
    paramInt2 = paramInt1;
    if (paramInt1 > m) {
      paramInt2 = b(i, paramDouble);
    }
    paramInt1 = c(paramInt3, paramDouble);
    int j;
    int n;
    if (paramInt1 >= paramInt2)
    {
      j = c(paramInt3 - 1, paramDouble);
      i = paramInt1;
      n = c((paramInt2 - j) / 29);
      int k = n + 11;
      paramInt1 = k;
      if (i - j <= 365) {
        break label228;
      }
      i = d(j, paramDouble);
      paramInt1 = k;
      if (n < i) {
        break label228;
      }
      j = n + 10;
      paramInt1 = j;
      if (n != i) {
        break label228;
      }
      i = 1;
      paramInt1 = j;
    }
    for (;;)
    {
      j = paramInt1;
      if (paramInt1 > 12) {
        j = paramInt1 - 12;
      }
      paramInt1 = paramInt3;
      if (j >= 11)
      {
        paramInt1 = paramInt3;
        if (n < 4) {
          paramInt1 = paramInt3 - 1;
        }
      }
      return new int[] { m - paramInt2 + 1, j, paramInt1, i };
      i = c(paramInt3 + 1, paramDouble);
      paramInt3 += 1;
      j = paramInt1;
      break;
      label228:
      i = 0;
    }
  }
  
  static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    int j;
    if (paramInt2 < 11) {
      j = c(paramInt3 - 1, paramDouble);
    }
    int m;
    int k;
    for (int i = c(paramInt3, paramDouble);; i = c(paramInt3 + 1, paramDouble))
    {
      m = c(0.5D + (j - 2415021.076998695D) / 29.530588853D);
      k = paramInt2 - 11;
      paramInt3 = k;
      if (k < 0) {
        paramInt3 = k + 12;
      }
      if (i - j <= 365) {
        break label184;
      }
      k = d(j, paramDouble);
      j = k - 2;
      i = j;
      if (j < 0) {
        i = j + 12;
      }
      if ((paramInt4 == 0) || (paramInt2 == i)) {
        break;
      }
      return new int[] { 0, 0, 0 };
      j = c(paramInt3, paramDouble);
    }
    if ((paramInt4 != 0) || (paramInt3 >= k)) {}
    label184:
    for (paramInt2 = paramInt3 + 1;; paramInt2 = paramInt3) {
      return a(b(paramInt2 + m, paramDouble) + paramInt1 - 1);
    }
  }
  
  static double b(double paramDouble)
  {
    paramDouble = (paramDouble - 2451545.0D) / 36525.0D;
    double d1 = paramDouble * paramDouble;
    double d2 = 357.5291D + 35999.0503D * paramDouble - 1.559E-4D * d1 - 4.8E-7D * paramDouble * d1;
    double d3 = Math.sin(0.017453292519943295D * d2);
    paramDouble = (0.019993D - paramDouble * 1.01E-4D) * Math.sin(2.0D * 0.017453292519943295D * d2) + (1.9146D - 0.004817D * paramDouble - d1 * 1.4E-5D) * d3 + 2.9E-4D * Math.sin(0.017453292519943295D * 3.0D * d2) + (280.46645D + 36000.76983D * paramDouble + 3.032E-4D * d1);
    return paramDouble - c(paramDouble / 360.0D) * 360;
  }
  
  static double b(int paramInt)
  {
    return c(paramInt);
  }
  
  static int b(int paramInt, double paramDouble)
  {
    return c(b(paramInt) + 0.5D + paramDouble / 24.0D);
  }
  
  static double c(int paramInt)
  {
    double d2 = paramInt / 1236.85D;
    double d3 = d2 * d2;
    double d4 = d3 * d2;
    double d5 = paramInt;
    double d6 = Math.sin((166.56D + 132.87D * d2 - 0.009173D * d3) * 0.017453292519943295D);
    double d1 = 359.2242D + 29.10535608D * paramInt - 3.33E-5D * d3 - 3.47E-6D * d4;
    double d19 = 306.0253D + 385.81691806D * paramInt + 0.0107306D * d3 + 1.236E-5D * d4;
    double d18 = 21.2964D + 390.67050646D * paramInt - 0.0016528D * d3 - 2.39E-6D * d4;
    double d7 = Math.sin(d1 * 0.017453292519943295D);
    double d8 = Math.sin(2.0D * 0.017453292519943295D * d1);
    double d9 = Math.sin(d19 * 0.017453292519943295D);
    double d10 = Math.sin(2.0D * 0.017453292519943295D * d19);
    double d11 = Math.sin(3.0D * 0.017453292519943295D * d19);
    double d12 = Math.sin(2.0D * 0.017453292519943295D * d18);
    double d13 = Math.sin((d1 + d19) * 0.017453292519943295D);
    double d14 = Math.sin((d1 - d19) * 0.017453292519943295D);
    double d15 = Math.sin((2.0D * d18 + d1) * 0.017453292519943295D);
    double d16 = Math.sin((2.0D * d18 - d1) * 0.017453292519943295D);
    double d17 = Math.sin((2.0D * d18 + d19) * 0.017453292519943295D);
    d18 = Math.sin((d18 * 2.0D - d19) * 0.017453292519943295D);
    d19 = Math.sin(0.017453292519943295D * (d1 + d19 * 2.0D));
    if (d2 < -11.0D) {}
    for (d1 = d3 * 2.261E-4D + (0.001D + 8.39E-4D * d2) - 8.45E-6D * d4 - d2 * 8.1E-8D * d4;; d1 = d2 * 2.65E-4D - 2.78E-4D + d3 * 2.62E-4D) {
      return 2415020.75933D + 29.53058868D * d5 + 1.178E-4D * d3 - 1.55E-7D * d4 + 3.3E-4D * d6 + (d19 * 5.0E-4D + (d18 * 0.001D + ((0.1734D - 3.93E-4D * d2) * d7 + 0.0021D * d8 - 0.4068D * d9 + 0.0161D * d10 - 4.0E-4D * d11 + 0.0104D * d12 - 0.0051D * d13 - 0.0074D * d14 + 4.0E-4D * d15 - 4.0E-4D * d16 - 6.0E-4D * d17))) - d1;
    }
  }
  
  static int c(double paramDouble)
  {
    return (int)Math.floor(paramDouble);
  }
  
  static int c(int paramInt, double paramDouble)
  {
    int j = c((a(31, 12, paramInt) - 2415021.076998695D) / 29.530588853D);
    int i = b(j, paramDouble);
    paramInt = i;
    if (c(a(i, paramDouble) / 30.0D) >= 9) {
      paramInt = b(j - 1, paramDouble);
    }
    return paramInt;
  }
  
  static int d(int paramInt, double paramDouble)
  {
    int k = c(0.5D + (paramInt - 2415021.076998695D) / 29.530588853D);
    int i = 1;
    int j;
    for (paramInt = c(a(b(k + 1, paramDouble), paramDouble) / 30.0D);; paramInt = j)
    {
      i += 1;
      j = c(a(b(k + i, paramDouble), paramDouble) / 30.0D);
      if ((j == paramInt) || (i >= 14)) {
        return i - 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */