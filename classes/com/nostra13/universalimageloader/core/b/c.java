package com.nostra13.universalimageloader.core.b;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.a.d;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.a.h;
import com.nostra13.universalimageloader.core.d.b;

public class c
{
  private final String a;
  private final String b;
  private final String c;
  private final e d;
  private final d e;
  private final h f;
  private final b g;
  private final Object h;
  private final boolean i;
  private final BitmapFactory.Options j;
  
  public c(String paramString1, String paramString2, String paramString3, e parame, h paramh, b paramb, com.nostra13.universalimageloader.core.c paramc)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = parame;
    this.e = paramc.j();
    this.f = paramh;
    this.g = paramb;
    this.h = paramc.n();
    this.i = paramc.m();
    this.j = new BitmapFactory.Options();
    a(paramc.k(), this.j);
  }
  
  private void a(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inDensity = paramOptions1.inDensity;
    paramOptions2.inDither = paramOptions1.inDither;
    paramOptions2.inInputShareable = paramOptions1.inInputShareable;
    paramOptions2.inJustDecodeBounds = paramOptions1.inJustDecodeBounds;
    paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
    paramOptions2.inPurgeable = paramOptions1.inPurgeable;
    paramOptions2.inSampleSize = paramOptions1.inSampleSize;
    paramOptions2.inScaled = paramOptions1.inScaled;
    paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
    paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
    paramOptions2.inTempStorage = paramOptions1.inTempStorage;
    if (Build.VERSION.SDK_INT >= 10) {
      b(paramOptions1, paramOptions2);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      c(paramOptions1, paramOptions2);
    }
  }
  
  @TargetApi(10)
  private void b(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
  }
  
  @TargetApi(11)
  private void c(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inBitmap = paramOptions1.inBitmap;
    paramOptions2.inMutable = paramOptions1.inMutable;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public e c()
  {
    return this.d;
  }
  
  public d d()
  {
    return this.e;
  }
  
  public h e()
  {
    return this.f;
  }
  
  public b f()
  {
    return this.g;
  }
  
  public Object g()
  {
    return this.h;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public BitmapFactory.Options i()
  {
    return this.j;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */