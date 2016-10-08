package com.unionpay.mobile.android.global;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.unionpay.mobile.android.utils.d;

public final class a
{
  public static int A;
  public static int B;
  public static int C;
  public static int D;
  public static int E;
  public static int F;
  public static int G;
  public static int H;
  public static int I;
  public static int J;
  public static int K;
  public static int L = 0;
  public static int M = 0;
  private static boolean N;
  public static int a = 48;
  public static int b = 8;
  public static int c = 4;
  public static int d = 12;
  public static int e = 8;
  public static int f = 8;
  public static int g = 4;
  public static int h = 8;
  public static int i = 2;
  public static int j = 16;
  public static int k = 52;
  public static int l = 320;
  public static int m = 32;
  public static int n = 54;
  public static int o = 45;
  public static int p = 35;
  public static int q = 40;
  public static int r = 54;
  public static int s = 10;
  public static int t = 0;
  public static int u = 28;
  public static int v = 30;
  public static int w = 22;
  public static int x = 40;
  public static int y = n;
  public static int z = 46;
  
  static
  {
    A = 45;
    B = 32;
    C = 6;
    D = 25;
    E = 95;
    F = 25;
    G = 25;
    H = 1;
    I = 0;
    J = 5;
    K = 1;
    N = false;
  }
  
  public static void a(Context paramContext)
  {
    b.a(paramContext);
    if (!N)
    {
      a = d.a(paramContext, a);
      b = d.a(paramContext, b);
      c = d.a(paramContext, c);
      d = d.a(paramContext, d);
      e = d.a(paramContext, e);
      f = d.a(paramContext, f);
      g = d.a(paramContext, g);
      h = d.a(paramContext, h);
      i = d.a(paramContext, i);
      j = d.a(paramContext, j);
      k = d.a(paramContext, k);
      m = d.a(paramContext, m);
      n = d.a(paramContext, n);
      o = d.a(paramContext, o);
      p = d.a(paramContext, p);
      q = d.a(paramContext, q);
      r = d.a(paramContext, r);
      s = d.a(paramContext, s);
      u = d.a(paramContext, u);
      v = d.a(paramContext, v);
      w = d.a(paramContext, w);
      z = d.a(paramContext, z);
      x = d.a(paramContext, x);
      A = d.a(paramContext, A);
      B = d.a(paramContext, B);
      C = d.a(paramContext, C);
      y = d.a(paramContext, y);
      D = d.a(paramContext, D);
      E = d.a(paramContext, E);
      F = d.a(paramContext, F);
      G = d.a(paramContext, G);
      H = d.a(paramContext, H);
      K = (int)(paramContext.getResources().getDisplayMetrics().density + 0.5D);
      I = paramContext.getResources().getDisplayMetrics().widthPixels;
      t = paramContext.getResources().getDisplayMetrics().heightPixels;
      if (I > t)
      {
        int i1 = I + t;
        I = i1;
        t = i1 - t;
        I -= t;
      }
      J = d.a(paramContext, J);
      N = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\global\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */