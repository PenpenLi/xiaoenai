package com.bumptech.glide.d.c.b;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.d.a.h;
import com.bumptech.glide.d.a.i;
import com.bumptech.glide.d.c.e;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.q;
import java.io.InputStream;

public class g
  extends q<InputStream>
  implements d<Uri>
{
  public g(Context paramContext, l<e, InputStream> paraml)
  {
    super(paramContext, paraml);
  }
  
  protected com.bumptech.glide.d.a.c<InputStream> a(Context paramContext, Uri paramUri)
  {
    return new i(paramContext, paramUri);
  }
  
  protected com.bumptech.glide.d.a.c<InputStream> a(Context paramContext, String paramString)
  {
    return new h(paramContext.getApplicationContext().getAssets(), paramString);
  }
  
  public static class a
    implements m<Uri, InputStream>
  {
    public l<Uri, InputStream> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new g(paramContext, paramc.b(e.class, InputStream.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */