package com.bumptech.glide.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.d.e;
import com.bumptech.glide.i.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class i
  implements e<InputStream, b>
{
  private static final b a = new b();
  private static final a b = new a();
  private final Context c;
  private final b d;
  private final com.bumptech.glide.d.b.a.c e;
  private final a f;
  private final a g;
  
  public i(Context paramContext, com.bumptech.glide.d.b.a.c paramc)
  {
    this(paramContext, paramc, a, b);
  }
  
  i(Context paramContext, com.bumptech.glide.d.b.a.c paramc, b paramb, a parama)
  {
    this.c = paramContext;
    this.e = paramc;
    this.f = parama;
    this.g = new a(paramc);
    this.d = paramb;
  }
  
  private Bitmap a(com.bumptech.glide.b.a parama, com.bumptech.glide.b.c paramc, byte[] paramArrayOfByte)
  {
    parama.a(paramc, paramArrayOfByte);
    parama.a();
    return parama.f();
  }
  
  private d a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, com.bumptech.glide.b.d paramd, com.bumptech.glide.b.a parama)
  {
    paramd = paramd.b();
    if ((paramd.a() <= 0) || (paramd.b() != 0)) {}
    do
    {
      return null;
      parama = a(parama, paramd, paramArrayOfByte);
    } while (parama == null);
    com.bumptech.glide.d.d.d locald = com.bumptech.glide.d.d.d.b();
    return new d(new b(this.c, this.g, this.e, locald, paramInt1, paramInt2, paramd, paramArrayOfByte, parama));
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      byte[] arrayOfByte = new byte['䀀'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      Log.w("GifResourceDecoder", "Error reading data from stream", paramInputStream);
    }
    for (;;)
    {
      localByteArrayOutputStream.flush();
    }
  }
  
  public d a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInputStream);
    paramInputStream = this.d.a((byte[])localObject1);
    com.bumptech.glide.b.a locala = this.f.a(this.g);
    try
    {
      localObject1 = a((byte[])localObject1, paramInt1, paramInt2, paramInputStream, locala);
      return (d)localObject1;
    }
    finally
    {
      this.d.a(paramInputStream);
      this.f.a(locala);
    }
  }
  
  public String a()
  {
    return "";
  }
  
  static class a
  {
    private final Queue<com.bumptech.glide.b.a> a = h.a(0);
    
    public com.bumptech.glide.b.a a(a.a parama)
    {
      try
      {
        com.bumptech.glide.b.a locala2 = (com.bumptech.glide.b.a)this.a.poll();
        com.bumptech.glide.b.a locala1 = locala2;
        if (locala2 == null) {
          locala1 = new com.bumptech.glide.b.a(parama);
        }
        return locala1;
      }
      finally {}
    }
    
    public void a(com.bumptech.glide.b.a parama)
    {
      try
      {
        parama.g();
        this.a.offer(parama);
        return;
      }
      finally
      {
        parama = finally;
        throw parama;
      }
    }
  }
  
  static class b
  {
    private final Queue<com.bumptech.glide.b.d> a = h.a(0);
    
    public com.bumptech.glide.b.d a(byte[] paramArrayOfByte)
    {
      try
      {
        com.bumptech.glide.b.d locald2 = (com.bumptech.glide.b.d)this.a.poll();
        com.bumptech.glide.b.d locald1 = locald2;
        if (locald2 == null) {
          locald1 = new com.bumptech.glide.b.d();
        }
        paramArrayOfByte = locald1.a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      finally {}
    }
    
    public void a(com.bumptech.glide.b.d paramd)
    {
      try
      {
        paramd.a();
        this.a.offer(paramd);
        return;
      }
      finally
      {
        paramd = finally;
        throw paramd;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */