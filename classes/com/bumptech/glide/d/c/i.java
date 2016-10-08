package com.bumptech.glide.d.c;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.b;
import java.io.InputStream;
import java.io.OutputStream;

public class i
  implements b<h>
{
  private final b<InputStream> a;
  private final b<ParcelFileDescriptor> b;
  private String c;
  
  public i(b<InputStream> paramb, b<ParcelFileDescriptor> paramb1)
  {
    this.a = paramb;
    this.b = paramb1;
  }
  
  public String a()
  {
    if (this.c == null) {
      this.c = (this.a.a() + this.b.a());
    }
    return this.c;
  }
  
  public boolean a(h paramh, OutputStream paramOutputStream)
  {
    if (paramh.a() != null) {
      return this.a.a(paramh.a(), paramOutputStream);
    }
    return this.b.a(paramh.b(), paramOutputStream);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */