package com.bumptech.glide.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.n;

public class c
  extends n<ParcelFileDescriptor>
  implements b<Integer>
{
  public c(Context paramContext, l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paramContext, paraml);
  }
  
  public static class a
    implements m<Integer, ParcelFileDescriptor>
  {
    public l<Integer, ParcelFileDescriptor> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new c(paramContext, paramc.b(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */