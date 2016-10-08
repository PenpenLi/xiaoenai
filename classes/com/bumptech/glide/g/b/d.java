package com.bumptech.glide.g.b;

import android.widget.ImageView;
import com.bumptech.glide.d.d.b.b;
import com.bumptech.glide.g.a.a;

public class d
  extends e<b>
{
  private int b;
  private b c;
  
  public d(ImageView paramImageView)
  {
    this(paramImageView, -1);
  }
  
  public d(ImageView paramImageView, int paramInt)
  {
    super(paramImageView);
    this.b = paramInt;
  }
  
  protected void a(b paramb)
  {
    ((ImageView)this.a).setImageDrawable(paramb);
  }
  
  public void a(b paramb, a<? super b> parama)
  {
    Object localObject = paramb;
    if (!paramb.a())
    {
      float f1 = ((ImageView)this.a).getWidth() / ((ImageView)this.a).getHeight();
      float f2 = paramb.getIntrinsicWidth() / paramb.getIntrinsicHeight();
      localObject = paramb;
      if (Math.abs(f1 - 1.0F) <= 0.05F)
      {
        localObject = paramb;
        if (Math.abs(f2 - 1.0F) <= 0.05F) {
          localObject = new i(paramb, ((ImageView)this.a).getWidth());
        }
      }
    }
    super.a(localObject, parama);
    this.c = ((b)localObject);
    ((b)localObject).a(this.b);
    ((b)localObject).start();
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.start();
    }
  }
  
  public void e()
  {
    if (this.c != null) {
      this.c.stop();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */