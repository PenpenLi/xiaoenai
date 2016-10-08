package com.xiaoenai.app.classes.home.mode;

import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView;
import com.c.a.l;
import com.xiaoenai.app.utils.ab;

public class a
{
  private static final int a = ab.b() / 2;
  private static final int b = ab.a() / 2;
  
  public static void a(ImageView paramImageView)
  {
    double d = Math.random();
    int i = (int)(a * d) - 80;
    int j = (int)(d * b);
    d = Math.random();
    int k = (int)(a * d) + a + 80;
    int m = (int)(d * b) + j;
    float f = Math.abs((float)(Math.atan2(m - j, k - i) * 180.0D / 3.141592653589793D));
    paramImageView.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, i, j));
    l locall = l.a(paramImageView, "rotation", new float[] { f }).b(1L);
    locall.a(new b(paramImageView, i, k, j, m));
    locall.a();
  }
  
  private static void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setLayoutParams(new AbsoluteLayout.LayoutParams(-2, -2, paramInt1, paramInt2));
    b(paramImageView);
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3)
  {
    double d1 = Math.random();
    double d2 = Math.random();
    a(paramImageView1, (int)(d1 * ab.b()), (int)(d2 * b));
    d1 = Math.random();
    d2 = Math.random();
    a(paramImageView2, (int)(d1 * ab.b()), (int)(d2 * b));
    d1 = Math.random();
    d2 = Math.random();
    a(paramImageView3, (int)(d1 * ab.b()), (int)(d2 * b));
  }
  
  private static void b(ImageView paramImageView)
  {
    l locall = l.a(paramImageView, "alpha", new float[] { 0.0F }).b(2000L);
    locall.a(new d(paramImageView));
    locall.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */