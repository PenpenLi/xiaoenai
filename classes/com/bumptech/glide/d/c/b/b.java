package com.bumptech.glide.d.c.b;

import android.content.Context;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.c.m;
import java.io.InputStream;

public class b
  implements d<byte[]>
{
  private final String a;
  
  public b()
  {
    this("");
  }
  
  @Deprecated
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public com.bumptech.glide.d.a.c<InputStream> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new com.bumptech.glide.d.a.b(paramArrayOfByte, this.a);
  }
  
  public static class a
    implements m<byte[], InputStream>
  {
    public l<byte[], InputStream> a(Context paramContext, com.bumptech.glide.d.c.c paramc)
    {
      return new b();
    }
    
    public void a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */