package com.bumptech.glide.g.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.a.a;

public abstract class e<Z>
  extends k<ImageView, Z>
  implements a.a
{
  public e(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  public void a(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  public void a(Exception paramException, Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
  
  protected abstract void a(Z paramZ);
  
  public void a(Z paramZ, a<? super Z> parama)
  {
    if ((parama == null) || (!parama.a(paramZ, this))) {
      a(paramZ);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */