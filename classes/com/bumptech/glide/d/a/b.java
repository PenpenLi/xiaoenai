package com.bumptech.glide.d.a;

import com.bumptech.glide.e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class b
  implements c<InputStream>
{
  private final byte[] a;
  private final String b;
  
  public b(byte[] paramArrayOfByte, String paramString)
  {
    this.a = paramArrayOfByte;
    this.b = paramString;
  }
  
  public void a() {}
  
  public InputStream b(e parame)
  {
    return new ByteArrayInputStream(this.a);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */