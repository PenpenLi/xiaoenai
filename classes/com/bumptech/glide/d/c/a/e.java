package com.bumptech.glide.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.a.d;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.q;

public class e
  extends q<ParcelFileDescriptor>
  implements b<Uri>
{
  public e(Context paramContext, l<com.bumptech.glide.d.c.e, ParcelFileDescriptor> paraml)
  {
    super(paramContext, paraml);
  }
  
  protected com.bumptech.glide.d.a.c<ParcelFileDescriptor> a(Context paramContext, Uri paramUri)
  {
    return new com.bumptech.glide.d.a.e(paramContext, paramUri);
  }
  
  protected com.bumptech.glide.d.a.c<ParcelFileDescriptor> a(Context paramContext, String paramString)
  {
    return new d(paramContext.getApplicationContext().getAssets(), paramString);
  }
  
  public static class a
    implements m<Uri, ParcelFileDescriptor>
  {
    public l<Uri, ParcelFileDescriptor> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new e(paramContext, paramc.b(com.bumptech.glide.d.c.e.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */