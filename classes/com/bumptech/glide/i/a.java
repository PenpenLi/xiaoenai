package com.bumptech.glide.i;

import android.util.Log;
import java.util.Queue;

public final class a
{
  private static final a b = new a();
  private final Queue<byte[]> a = h.a(0);
  
  public static a a()
  {
    return b;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramArrayOfByte.length != 65536) {
      return false;
    }
    synchronized (this.a)
    {
      if (this.a.size() < 32)
      {
        bool = true;
        this.a.offer(paramArrayOfByte);
      }
      return bool;
    }
  }
  
  public byte[] b()
  {
    synchronized (this.a)
    {
      byte[] arrayOfByte = (byte[])this.a.poll();
      ??? = arrayOfByte;
      if (arrayOfByte == null)
      {
        arrayOfByte = new byte[65536];
        ??? = arrayOfByte;
        if (Log.isLoggable("ByteArrayPool", 3))
        {
          Log.d("ByteArrayPool", "Created temp bytes");
          ??? = arrayOfByte;
        }
      }
      return (byte[])???;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */