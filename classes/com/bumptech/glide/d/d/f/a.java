package com.bumptech.glide.d.d.f;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.d.a.m;
import com.bumptech.glide.d.d.b.b;

public class a
  implements c<com.bumptech.glide.d.d.e.a, b>
{
  private final c<Bitmap, m> a;
  
  public a(c<Bitmap, m> paramc)
  {
    this.a = paramc;
  }
  
  public k<b> a(k<com.bumptech.glide.d.d.e.a> paramk)
  {
    paramk = (com.bumptech.glide.d.d.e.a)paramk.b();
    k localk = paramk.b();
    if (localk != null) {
      return this.a.a(localk);
    }
    return paramk.c();
  }
  
  public String a()
  {
    return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */