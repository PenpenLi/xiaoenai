package com.bumptech.glide.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.d.c.c;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.n;
import java.io.InputStream;

public class e
  extends n<InputStream>
  implements d<Integer>
{
  public e(Context paramContext, l<Uri, InputStream> paraml)
  {
    super(paramContext, paraml);
  }
  
  public static class a
    implements m<Integer, InputStream>
  {
    public l<Integer, InputStream> a(Context paramContext, c paramc)
    {
      return new e(paramContext, paramc.b(Uri.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */