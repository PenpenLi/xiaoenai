package com.bumptech.glide.g.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class f
{
  public <Z> j<Z> a(ImageView paramImageView, Class<Z> paramClass)
  {
    if (com.bumptech.glide.d.d.b.b.class.isAssignableFrom(paramClass)) {
      return new d(paramImageView);
    }
    if (Bitmap.class.equals(paramClass)) {
      return new b(paramImageView);
    }
    if (Drawable.class.isAssignableFrom(paramClass)) {
      return new c(paramImageView);
    }
    throw new IllegalArgumentException("Unhandled class: " + paramClass + ", try .as*(Class).transcode(ResourceTranscoder)");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */