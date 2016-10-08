package com.bumptech.glide.d.d.c;

import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.c.o;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import java.io.File;
import java.io.InputStream;

public class d
  implements com.bumptech.glide.f.b<InputStream, File>
{
  private static final a a = new a(null);
  private final e<File, File> b = new a();
  private final com.bumptech.glide.d.b<InputStream> c = new o();
  
  public e<File, File> a()
  {
    return this.b;
  }
  
  public e<InputStream, File> b()
  {
    return a;
  }
  
  public com.bumptech.glide.d.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<File> d()
  {
    return com.bumptech.glide.d.d.b.b();
  }
  
  private static class a
    implements e<InputStream, File>
  {
    public k<File> a(InputStream paramInputStream, int paramInt1, int paramInt2)
    {
      throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }
    
    public String a()
    {
      return "";
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */