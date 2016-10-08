package com.meiqia.core.a.a.b;

import com.meiqia.core.a.a.d.d.a;
import com.meiqia.core.a.a.e.c;
import com.meiqia.core.a.a.e.e;
import com.meiqia.core.a.a.e.f;
import com.meiqia.core.a.a.e.h;
import com.meiqia.core.a.a.e.i;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = com.meiqia.core.a.a.f.b.a("<policy-file-request/>\000");
  protected com.meiqia.core.a.a.a.b d = null;
  protected d.a e = null;
  
  public static c a(ByteBuffer paramByteBuffer, com.meiqia.core.a.a.a.b paramb)
  {
    Object localObject = b(paramByteBuffer);
    if (localObject == null) {
      throw new com.meiqia.core.a.a.c.a(paramByteBuffer.capacity() + 128);
    }
    localObject = ((String)localObject).split(" ", 3);
    if (localObject.length != 3) {
      throw new com.meiqia.core.a.a.c.d();
    }
    if (paramb == com.meiqia.core.a.a.a.b.a)
    {
      paramb = new e();
      i locali = (i)paramb;
      locali.a(Short.parseShort(localObject[1]));
      locali.a(localObject[2]);
    }
    for (localObject = b(paramByteBuffer);; localObject = b(paramByteBuffer))
    {
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label175;
      }
      localObject = ((String)localObject).split(":", 2);
      if (localObject.length != 2)
      {
        throw new com.meiqia.core.a.a.c.d("not an http header");
        paramb = new com.meiqia.core.a.a.e.d();
        paramb.a(localObject[1]);
        break;
      }
      paramb.a(localObject[0], localObject[1].replaceFirst("^ +", ""));
    }
    label175:
    if (localObject == null) {
      throw new com.meiqia.core.a.a.c.a();
    }
    return paramb;
  }
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48;; i = b1) {
      if (paramByteBuffer.hasRemaining())
      {
        b1 = paramByteBuffer.get();
        localByteBuffer.put(b1);
        if ((i == 13) && (b1 == 10))
        {
          localByteBuffer.limit(localByteBuffer.position() - 2);
          localByteBuffer.position(0);
          return localByteBuffer;
        }
      }
      else
      {
        paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        return null;
      }
    }
  }
  
  public static String b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = a(paramByteBuffer);
    if (paramByteBuffer == null) {
      return null;
    }
    return com.meiqia.core.a.a.f.b.a(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public int a(int paramInt)
  {
    if (paramInt < 0) {
      throw new com.meiqia.core.a.a.c.b(1002, "Negative count");
    }
    return paramInt;
  }
  
  public abstract b a(com.meiqia.core.a.a.e.a parama);
  
  public abstract b a(com.meiqia.core.a.a.e.a parama, h paramh);
  
  public abstract com.meiqia.core.a.a.e.b a(com.meiqia.core.a.a.e.b paramb);
  
  public abstract c a(com.meiqia.core.a.a.e.a parama, i parami);
  
  public abstract ByteBuffer a(com.meiqia.core.a.a.d.d paramd);
  
  public List<ByteBuffer> a(f paramf, com.meiqia.core.a.a.a.b paramb)
  {
    return a(paramf, paramb, true);
  }
  
  public List<ByteBuffer> a(f paramf, com.meiqia.core.a.a.a.b paramb, boolean paramBoolean)
  {
    paramb = new StringBuilder(100);
    if ((paramf instanceof com.meiqia.core.a.a.e.a))
    {
      paramb.append("GET ");
      paramb.append(((com.meiqia.core.a.a.e.a)paramf).a());
      paramb.append(" HTTP/1.1");
    }
    Object localObject;
    for (;;)
    {
      paramb.append("\r\n");
      localObject = paramf.b();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = paramf.b(str1);
        paramb.append(str1);
        paramb.append(": ");
        paramb.append(str2);
        paramb.append("\r\n");
      }
      if (!(paramf instanceof h)) {
        break;
      }
      paramb.append("HTTP/1.1 101 " + ((h)paramf).a());
    }
    throw new RuntimeException("unknow role");
    paramb.append("\r\n");
    paramb = com.meiqia.core.a.a.f.b.b(paramb.toString());
    if (paramBoolean)
    {
      paramf = paramf.c();
      if (paramf != null) {
        break label253;
      }
    }
    label253:
    for (int i = 0;; i = paramf.length)
    {
      localObject = ByteBuffer.allocate(i + paramb.length);
      ((ByteBuffer)localObject).put(paramb);
      if (paramf != null) {
        ((ByteBuffer)localObject).put(paramf);
      }
      ((ByteBuffer)localObject).flip();
      return Collections.singletonList(localObject);
      paramf = null;
      break;
    }
  }
  
  public abstract List<com.meiqia.core.a.a.d.d> a(String paramString, boolean paramBoolean);
  
  public abstract void a();
  
  public void a(com.meiqia.core.a.a.a.b paramb)
  {
    this.d = paramb;
  }
  
  protected boolean a(f paramf)
  {
    return (paramf.b("Upgrade").equalsIgnoreCase("websocket")) && (paramf.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract a b();
  
  public abstract a c();
  
  public abstract List<com.meiqia.core.a.a.d.d> c(ByteBuffer paramByteBuffer);
  
  public f d(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, this.d);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */