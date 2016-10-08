package com.bumptech.glide.d.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.c.c;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import java.io.File;

public class a
  extends com.bumptech.glide.d.c.b<ParcelFileDescriptor>
  implements b<File>
{
  public a(l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<File, ParcelFileDescriptor>
  {
    public l<File, ParcelFileDescriptor> a(Context paramContext, c paramc)
    {
      return new a(paramc.b(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */