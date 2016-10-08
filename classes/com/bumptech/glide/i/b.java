package com.bumptech.glide.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends FilterInputStream
{
  private final long a;
  private int b;
  
  b(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.a = paramLong;
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 0) {
      this.b += paramInt;
    }
    while (this.a - this.b <= 0L) {
      return paramInt;
    }
    throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong)
  {
    return new b(paramInputStream, paramLong);
  }
  
  public int available()
  {
    try
    {
      long l = Math.max(this.a - this.b, this.in.available());
      int i = (int)l;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read()
  {
    try
    {
      int i = a(super.read());
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = a(super.read(paramArrayOfByte, paramInt1, paramInt2));
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */