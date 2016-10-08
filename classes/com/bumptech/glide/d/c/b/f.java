package com.bumptech.glide.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.d.c.c;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.p;
import java.io.InputStream;

public class f
  extends p<InputStream>
  implements d<String>
{
  public f(l<Uri, InputStream> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<String, InputStream>
  {
    public l<String, InputStream> a(Context paramContext, c paramc)
    {
      return new f(paramc.b(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */