package com.bumptech.glide.d.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.d.a.m;
import com.bumptech.glide.d.d.a.n;

public class b
  implements c<Bitmap, m>
{
  private final Resources a;
  private final com.bumptech.glide.d.b.a.c b;
  
  public b(Resources paramResources, com.bumptech.glide.d.b.a.c paramc)
  {
    this.a = paramResources;
    this.b = paramc;
  }
  
  public k<m> a(k<Bitmap> paramk)
  {
    return new n(new m(this.a, (Bitmap)paramk.b()), this.b);
  }
  
  public String a()
  {
    return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */