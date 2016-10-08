package com.bumptech.glide.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.d.c.b;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import java.io.File;
import java.io.InputStream;

public class c
  extends b<InputStream>
  implements d<File>
{
  public c(l<Uri, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<File, InputStream>
  {
    public l<File, InputStream> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new c(paramc.b(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */