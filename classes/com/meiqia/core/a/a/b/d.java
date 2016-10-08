package com.meiqia.core.a.a.b;

import com.meiqia.core.a.a.c.f;
import com.meiqia.core.a.a.d.d.a;
import com.meiqia.core.a.a.d.e;
import com.meiqia.core.a.a.e.h;
import com.meiqia.core.a.a.e.i;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d
  extends a
{
  protected boolean f = false;
  protected List<com.meiqia.core.a.a.d.d> g = new LinkedList();
  protected ByteBuffer h;
  private final Random i = new Random();
  
  public a.b a(com.meiqia.core.a.a.e.a parama)
  {
    if ((parama.c("Origin")) && (a(parama))) {
      return a.b.a;
    }
    return a.b.b;
  }
  
  public a.b a(com.meiqia.core.a.a.e.a parama, h paramh)
  {
    if ((parama.b("WebSocket-Origin").equals(paramh.b("Origin"))) && (a(paramh))) {
      return a.b.a;
    }
    return a.b.b;
  }
  
  public com.meiqia.core.a.a.e.b a(com.meiqia.core.a.a.e.b paramb)
  {
    paramb.a("Upgrade", "WebSocket");
    paramb.a("Connection", "Upgrade");
    if (!paramb.c("Origin")) {
      paramb.a("Origin", "random" + this.i.nextInt());
    }
    return paramb;
  }
  
  public com.meiqia.core.a.a.e.c a(com.meiqia.core.a.a.e.a parama, i parami)
  {
    parami.a("Web Socket Protocol Handshake");
    parami.a("Upgrade", "WebSocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("WebSocket-Origin", parama.b("Origin"));
    parami.a("WebSocket-Location", "ws://" + parama.b("Host") + parama.a());
    return parami;
  }
  
  public ByteBuffer a(com.meiqia.core.a.a.d.d paramd)
  {
    if (paramd.f() != d.a.b) {
      throw new RuntimeException("only text frames supported");
    }
    paramd = paramd.c();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramd.remaining() + 2);
    localByteBuffer.put((byte)0);
    paramd.mark();
    localByteBuffer.put(paramd);
    paramd.reset();
    localByteBuffer.put((byte)-1);
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  public List<com.meiqia.core.a.a.d.d> a(String paramString, boolean paramBoolean)
  {
    e locale = new e();
    try
    {
      locale.a(ByteBuffer.wrap(com.meiqia.core.a.a.f.b.a(paramString)));
      locale.a(true);
      locale.a(d.a.b);
      locale.b(paramBoolean);
      return Collections.singletonList(locale);
    }
    catch (com.meiqia.core.a.a.c.b paramString)
    {
      throw new f(paramString);
    }
  }
  
  public void a()
  {
    this.f = false;
    this.h = null;
  }
  
  public a.a b()
  {
    return a.a.a;
  }
  
  public a c()
  {
    return new d();
  }
  
  public List<com.meiqia.core.a.a.d.d> c(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = e(paramByteBuffer);
    if (paramByteBuffer == null) {
      throw new com.meiqia.core.a.a.c.b(1002);
    }
    return paramByteBuffer;
  }
  
  public ByteBuffer d()
  {
    return ByteBuffer.allocate(b);
  }
  
  protected List<com.meiqia.core.a.a.d.d> e(ByteBuffer paramByteBuffer)
  {
    Object localObject2 = null;
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.f) {
          throw new com.meiqia.core.a.a.c.c("unexpected START_OF_FRAME");
        }
        this.f = true;
      }
      else if (b == -1)
      {
        if (!this.f) {
          throw new com.meiqia.core.a.a.c.c("unexpected END_OF_FRAME");
        }
        if (this.h != null)
        {
          this.h.flip();
          localObject1 = new e();
          ((e)localObject1).a(this.h);
          ((e)localObject1).a(true);
          ((e)localObject1).a(d.a.b);
          this.g.add(localObject1);
          this.h = null;
          paramByteBuffer.mark();
        }
        this.f = false;
      }
      else
      {
        localObject1 = localObject2;
        if (!this.f) {
          return localObject1;
        }
        if (this.h == null) {
          this.h = d();
        }
        for (;;)
        {
          this.h.put(b);
          break;
          if (!this.h.hasRemaining()) {
            this.h = f(this.h);
          }
        }
      }
    }
    Object localObject1 = this.g;
    this.g = new LinkedList();
    return (List<com.meiqia.core.a.a.d.d>)localObject1;
  }
  
  public ByteBuffer f(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.flip();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(a(paramByteBuffer.capacity() * 2));
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */