package com.bumptech.glide.d.d.a;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class o
{
  private static final byte[] a;
  private static final int[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  private final c c;
  
  static
  {
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = "Exif\000\000".getBytes("UTF-8");
      localObject = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    a = (byte[])localObject;
  }
  
  public o(InputStream paramInputStream)
  {
    this.c = new c(paramInputStream);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private static int a(b paramb)
  {
    int i = "Exif\000\000".length();
    int j = paramb.b(i);
    ByteOrder localByteOrder;
    label47:
    int n;
    int m;
    if (j == 19789)
    {
      localByteOrder = ByteOrder.BIG_ENDIAN;
      paramb.a(localByteOrder);
      j = i + paramb.a(i + 4);
      int k = paramb.b(j);
      i = 0;
      if (i >= k) {
        break label484;
      }
      n = a(j, i);
      m = paramb.b(n);
      if (m == 274) {
        break label138;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      if (j == 18761)
      {
        localByteOrder = ByteOrder.LITTLE_ENDIAN;
        break;
      }
      if (Log.isLoggable("ImageHeaderParser", 3)) {
        Log.d("ImageHeaderParser", "Unknown endianness = " + j);
      }
      localByteOrder = ByteOrder.BIG_ENDIAN;
      break;
      label138:
      int i1 = paramb.b(n + 2);
      if ((i1 < 1) || (i1 > 12))
      {
        if (Log.isLoggable("ImageHeaderParser", 3)) {
          Log.d("ImageHeaderParser", "Got invalid format code=" + i1);
        }
      }
      else
      {
        int i2 = paramb.a(n + 4);
        if (i2 < 0)
        {
          if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Negative tiff component count");
          }
        }
        else
        {
          if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + m + " formatCode=" + i1 + " componentCount=" + i2);
          }
          i2 += b[i1];
          if (i2 > 4)
          {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
              Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + i1);
            }
          }
          else
          {
            n += 8;
            if ((n < 0) || (n > paramb.a()))
            {
              if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + n + " tagType=" + m);
              }
            }
            else
            {
              if ((i2 >= 0) && (n + i2 <= paramb.a())) {
                break label477;
              }
              if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + m);
              }
            }
          }
        }
      }
    }
    label477:
    return paramb.b(n);
    label484:
    return -1;
  }
  
  private static boolean a(int paramInt)
  {
    return ((paramInt & 0xFFD8) == 65496) || (paramInt == 19789) || (paramInt == 18761);
  }
  
  private byte[] d()
  {
    int i = this.c.b();
    if (i != 255) {
      if (Log.isLoggable("ImageHeaderParser", 3)) {
        Log.d("ImageHeaderParser", "Unknown segmentId=" + i);
      }
    }
    int j;
    label183:
    byte[] arrayOfByte;
    int k;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            return null;
            i = this.c.b();
          } while (i == 218);
          if (i != 217) {
            break;
          }
        } while (!Log.isLoggable("ImageHeaderParser", 3));
        Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
        return null;
        j = this.c.a() - 2;
        if (i == 225) {
          break label183;
        }
        l = this.c.a(j);
        if (l == j) {
          break;
        }
      } while (!Log.isLoggable("ImageHeaderParser", 3));
      Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + i + ", wanted to skip: " + j + ", but actually skipped: " + l);
      return null;
      arrayOfByte = new byte[j];
      k = this.c.a(arrayOfByte);
      if (k == j) {
        return arrayOfByte;
      }
    } while (!Log.isLoggable("ImageHeaderParser", 3));
    Log.d("ImageHeaderParser", "Unable to read segment data, type: " + i + ", length: " + j + ", actually read: " + k);
    return null;
    return arrayOfByte;
  }
  
  public boolean a()
  {
    return b().a();
  }
  
  public a b()
  {
    int i = this.c.a();
    if (i == 65496) {
      return a.b;
    }
    i = i << 16 & 0xFFFF0000 | this.c.a() & 0xFFFF;
    if (i == -1991225785)
    {
      this.c.a(21L);
      if (this.c.c() >= 3) {
        return a.c;
      }
      return a.d;
    }
    if (i >> 8 == 4671814) {
      return a.a;
    }
    return a.e;
  }
  
  public int c()
  {
    int k = 0;
    if (!a(this.c.a())) {
      return -1;
    }
    byte[] arrayOfByte = d();
    int i;
    int j;
    if ((arrayOfByte != null) && (arrayOfByte.length > a.length))
    {
      i = 1;
      if (i == 0) {
        break label96;
      }
      j = 0;
      label44:
      if (j >= a.length) {
        break label96;
      }
      if (arrayOfByte[j] == a[j]) {
        break label87;
      }
      i = k;
    }
    label87:
    label96:
    for (;;)
    {
      if (i != 0)
      {
        return a(new b(arrayOfByte));
        i = 0;
        break;
        j += 1;
        break label44;
      }
      return -1;
    }
  }
  
  public static enum a
  {
    private final boolean f;
    
    private a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public boolean a()
    {
      return this.f;
    }
  }
  
  private static class b
  {
    private final ByteBuffer a;
    
    public b(byte[] paramArrayOfByte)
    {
      this.a = ByteBuffer.wrap(paramArrayOfByte);
      this.a.order(ByteOrder.BIG_ENDIAN);
    }
    
    public int a()
    {
      return this.a.array().length;
    }
    
    public int a(int paramInt)
    {
      return this.a.getInt(paramInt);
    }
    
    public void a(ByteOrder paramByteOrder)
    {
      this.a.order(paramByteOrder);
    }
    
    public short b(int paramInt)
    {
      return this.a.getShort(paramInt);
    }
  }
  
  private static class c
  {
    private final InputStream a;
    
    public c(InputStream paramInputStream)
    {
      this.a = paramInputStream;
    }
    
    public int a()
    {
      return this.a.read() << 8 & 0xFF00 | this.a.read() & 0xFF;
    }
    
    public int a(byte[] paramArrayOfByte)
    {
      int i = paramArrayOfByte.length;
      while (i > 0)
      {
        int j = this.a.read(paramArrayOfByte, paramArrayOfByte.length - i, i);
        if (j == -1) {
          break;
        }
        i -= j;
      }
      return paramArrayOfByte.length - i;
    }
    
    public long a(long paramLong)
    {
      if (paramLong < 0L) {
        return 0L;
      }
      long l1 = paramLong;
      for (;;)
      {
        if (l1 > 0L)
        {
          long l2 = this.a.skip(l1);
          if (l2 > 0L)
          {
            l1 -= l2;
            continue;
          }
          if (this.a.read() != -1) {}
        }
        else
        {
          return paramLong - l1;
        }
        l1 -= 1L;
      }
    }
    
    public short b()
    {
      return (short)(this.a.read() & 0xFF);
    }
    
    public int c()
    {
      return this.a.read();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */