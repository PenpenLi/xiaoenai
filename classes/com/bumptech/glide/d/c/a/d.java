package com.bumptech.glide.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.c.c;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import com.bumptech.glide.d.c.p;

public class d
  extends p<ParcelFileDescriptor>
  implements b<String>
{
  public d(l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<String, ParcelFileDescriptor>
  {
    public l<String, ParcelFileDescriptor> a(Context paramContext, c paramc)
    {
      return new d(paramc.b(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */