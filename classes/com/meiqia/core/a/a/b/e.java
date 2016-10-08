package com.meiqia.core.a.a.b;

import com.meiqia.core.a.a.d.d.a;
import com.meiqia.core.a.a.e.f;
import com.meiqia.core.a.a.e.h;
import com.meiqia.core.a.a.e.i;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class e
  extends d
{
  private static final byte[] j = { -1, 0 };
  private boolean i = false;
  private final Random k = new Random();
  
  private static byte[] a(String paramString)
  {
    long l2;
    try
    {
      l1 = Long.parseLong(paramString.replaceAll("[^0-9]", ""));
      l2 = paramString.split(" ").length - 1;
      if (l2 == 0L) {
        throw new com.meiqia.core.a.a.c.d("invalid Sec-WebSocket-Key (/key2/)");
      }
    }
    catch (NumberFormatException paramString)
    {
      throw new com.meiqia.core.a.a.c.d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
    }
    long l1 = new Long(l1 / l2).longValue();
    int m = (byte)(int)(l1 >> 24);
    int n = (byte)(int)(l1 << 8 >> 24);
    int i1 = (byte)(int)(l1 << 16 >> 24);
    int i2 = (byte)(int)(l1 << 24 >> 24);
    return new byte[] { m, n, i1, i2 };
  }
  
  public static byte[] a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int m = paramString1[0];
    int n = paramString1[1];
    int i1 = paramString1[2];
    int i2 = paramString1[3];
    int i3 = paramString2[0];
    int i4 = paramString2[1];
    int i5 = paramString2[2];
    int i6 = paramString2[3];
    int i7 = paramArrayOfByte[0];
    int i8 = paramArrayOfByte[1];
    int i9 = paramArrayOfByte[2];
    int i10 = paramArrayOfByte[3];
    int i11 = paramArrayOfByte[4];
    int i12 = paramArrayOfByte[5];
    int i13 = paramArrayOfByte[6];
    int i14 = paramArrayOfByte[7];
    try
    {
      paramString1 = MessageDigest.getInstance("MD5");
      return paramString1.digest(new byte[] { m, n, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14 });
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  private static String e()
  {
    Random localRandom = new Random();
    long l = localRandom.nextInt(12) + 1;
    String str = Long.toString((localRandom.nextInt(Math.abs(new Long(4294967295L / l).intValue())) + 1) * l);
    int n = localRandom.nextInt(12);
    int m = 0;
    while (m < n + 1)
    {
      int i1 = Math.abs(localRandom.nextInt(str.length()));
      char c2 = (char)(localRandom.nextInt(95) + 33);
      char c1 = c2;
      if (c2 >= '0')
      {
        c1 = c2;
        if (c2 <= '9') {
          c1 = (char)(c2 - '\017');
        }
      }
      str = new StringBuilder(str).insert(i1, c1).toString();
      m += 1;
    }
    m = 0;
    while (m < l)
    {
      n = Math.abs(localRandom.nextInt(str.length() - 1) + 1);
      str = new StringBuilder(str).insert(n, " ").toString();
      m += 1;
    }
    return str;
  }
  
  public a.b a(com.meiqia.core.a.a.e.a parama)
  {
    if ((parama.b("Upgrade").equals("WebSocket")) && (parama.b("Connection").contains("Upgrade")) && (parama.b("Sec-WebSocket-Key1").length() > 0) && (!parama.b("Sec-WebSocket-Key2").isEmpty()) && (parama.c("Origin"))) {
      return a.b.a;
    }
    return a.b.b;
  }
  
  public a.b a(com.meiqia.core.a.a.e.a parama, h paramh)
  {
    if (this.i) {
      return a.b.b;
    }
    try
    {
      if ((!paramh.b("Sec-WebSocket-Origin").equals(parama.b("Origin"))) || (!a(paramh))) {
        return a.b.b;
      }
      paramh = paramh.c();
      if ((paramh == null) || (paramh.length == 0)) {
        throw new com.meiqia.core.a.a.c.a();
      }
    }
    catch (com.meiqia.core.a.a.c.d parama)
    {
      throw new RuntimeException("bad handshakerequest", parama);
    }
    if (Arrays.equals(paramh, a(parama.b("Sec-WebSocket-Key1"), parama.b("Sec-WebSocket-Key2"), parama.c()))) {
      return a.b.a;
    }
    parama = a.b.b;
    return parama;
  }
  
  public com.meiqia.core.a.a.e.b a(com.meiqia.core.a.a.e.b paramb)
  {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Key1", e());
    paramb.a("Sec-WebSocket-Key2", e());
    if (!paramb.c("Origin")) {
      paramb.a("Origin", "random" + this.k.nextInt());
    }
    byte[] arrayOfByte = new byte[8];
    this.k.nextBytes(arrayOfByte);
    paramb.a(arrayOfByte);
    return paramb;
  }
  
  public com.meiqia.core.a.a.e.c a(com.meiqia.core.a.a.e.a parama, i parami)
  {
    parami.a("WebSocket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Sec-WebSocket-Origin", parama.b("Origin"));
    parami.a("Sec-WebSocket-Location", "ws://" + parama.b("Host") + parama.a());
    String str1 = parama.b("Sec-WebSocket-Key1");
    String str2 = parama.b("Sec-WebSocket-Key2");
    parama = parama.c();
    if ((str1 == null) || (str2 == null) || (parama == null) || (parama.length != 8)) {
      throw new com.meiqia.core.a.a.c.d("Bad keys");
    }
    parami.a(a(str1, str2, parama));
    return parami;
  }
  
  public ByteBuffer a(com.meiqia.core.a.a.d.d paramd)
  {
    if (paramd.f() == d.a.f) {
      return ByteBuffer.wrap(j);
    }
    return super.a(paramd);
  }
  
  public a.a b()
  {
    return a.a.b;
  }
  
  public a c()
  {
    return new e();
  }
  
  public List<com.meiqia.core.a.a.d.d> c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    List localList2 = super.e(paramByteBuffer);
    List localList1 = localList2;
    if (localList2 == null)
    {
      paramByteBuffer.reset();
      localList1 = this.g;
      this.f = true;
      if (this.h == null)
      {
        this.h = ByteBuffer.allocate(2);
        if (paramByteBuffer.remaining() > this.h.remaining()) {
          throw new com.meiqia.core.a.a.c.c();
        }
      }
      else
      {
        throw new com.meiqia.core.a.a.c.c();
      }
      this.h.put(paramByteBuffer);
      if (this.h.hasRemaining()) {
        break label139;
      }
      if (Arrays.equals(this.h.array(), j)) {
        localList1.add(new com.meiqia.core.a.a.d.b(1000));
      }
    }
    else
    {
      return localList1;
    }
    throw new com.meiqia.core.a.a.c.c();
    label139:
    this.g = new LinkedList();
    return localList1;
  }
  
  public f d(ByteBuffer paramByteBuffer)
  {
    com.meiqia.core.a.a.e.c localc = a(paramByteBuffer, this.d);
    if (((localc.c("Sec-WebSocket-Key1")) || (this.d == com.meiqia.core.a.a.a.b.a)) && (!localc.c("Sec-WebSocket-Version"))) {
      if (this.d != com.meiqia.core.a.a.a.b.b) {
        break label76;
      }
    }
    for (int m = 8;; m = 16)
    {
      byte[] arrayOfByte = new byte[m];
      try
      {
        paramByteBuffer.get(arrayOfByte);
        localc.a(arrayOfByte);
        return localc;
      }
      catch (BufferUnderflowException localBufferUnderflowException)
      {
        label76:
        throw new com.meiqia.core.a.a.c.a(paramByteBuffer.capacity() + 16);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */