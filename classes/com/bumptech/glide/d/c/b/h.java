package com.bumptech.glide.d.c.b;

import android.content.Context;
import com.bumptech.glide.d.c.c;
import com.bumptech.glide.d.c.e;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.r;
import java.io.InputStream;
import java.net.URL;

public class h
  extends r<InputStream>
{
  public h(l<e, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<URL, InputStream>
  {
    public l<URL, InputStream> a(Context paramContext, c paramc)
    {
      return new h(paramc.b(e.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */