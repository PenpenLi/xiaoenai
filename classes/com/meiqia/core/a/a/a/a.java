package com.meiqia.core.a.a.a;

import com.meiqia.core.a.a.e.f;
import com.meiqia.core.a.a.e.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public abstract class a
  extends com.meiqia.core.a.a.b
  implements com.meiqia.core.a.a.a, Runnable
{
  protected URI a = null;
  private com.meiqia.core.a.a.c c = null;
  private Socket d = null;
  private InputStream e;
  private OutputStream f;
  private Proxy g = Proxy.NO_PROXY;
  private Thread h;
  private com.meiqia.core.a.a.b.a i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public a(URI paramURI)
  {
    this(paramURI, new com.meiqia.core.a.a.b.c());
  }
  
  public a(URI paramURI, com.meiqia.core.a.a.b.a parama)
  {
    this(paramURI, parama, null, 0);
  }
  
  public a(URI paramURI, com.meiqia.core.a.a.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.a = paramURI;
    this.i = parama;
    this.j = paramMap;
    this.m = paramInt;
    this.c = new com.meiqia.core.a.a.c(this, parama);
  }
  
  private int g()
  {
    int i1 = this.a.getPort();
    int n = i1;
    String str;
    if (i1 == -1)
    {
      str = this.a.getScheme();
      if (str.equals("wss")) {
        n = 443;
      }
    }
    else
    {
      return n;
    }
    if (str.equals("ws")) {
      return 80;
    }
    throw new RuntimeException("unkonow scheme" + str);
  }
  
  private void h()
  {
    Object localObject2 = this.a.getPath();
    Object localObject3 = this.a.getQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + "?" + (String)localObject3;
    }
    int n = g();
    localObject3 = new StringBuilder().append(this.a.getHost());
    if (n != 80) {}
    for (Object localObject1 = ":" + n;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.meiqia.core.a.a.e.d();
      ((com.meiqia.core.a.a.e.d)localObject1).a((String)localObject2);
      ((com.meiqia.core.a.a.e.d)localObject1).a("Host", (String)localObject3);
      if (this.j == null) {
        break;
      }
      localObject2 = this.j.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.meiqia.core.a.a.e.d)localObject1).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.c.a((com.meiqia.core.a.a.e.b)localObject1);
  }
  
  public InetSocketAddress a()
  {
    return this.c.a();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public final void a(com.meiqia.core.a.a.a parama) {}
  
  public void a(com.meiqia.core.a.a.a parama, int paramInt, String paramString)
  {
    a(paramInt, paramString);
  }
  
  public final void a(com.meiqia.core.a.a.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    if (this.h != null) {
      this.h.interrupt();
    }
    try
    {
      if (this.d != null) {
        this.d.close();
      }
      b(paramInt, paramString, paramBoolean);
      return;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        a(this, parama);
      }
    }
  }
  
  public void a(com.meiqia.core.a.a.a parama, com.meiqia.core.a.a.d.d paramd)
  {
    b(paramd);
  }
  
  public final void a(com.meiqia.core.a.a.a parama, f paramf)
  {
    this.k.countDown();
    a((h)paramf);
  }
  
  public final void a(com.meiqia.core.a.a.a parama, Exception paramException)
  {
    a(paramException);
  }
  
  public final void a(com.meiqia.core.a.a.a parama, String paramString)
  {
    b(paramString);
  }
  
  public final void a(com.meiqia.core.a.a.a parama, ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
  }
  
  public void a(com.meiqia.core.a.a.d.d paramd)
  {
    this.c.a(paramd);
  }
  
  public abstract void a(h paramh);
  
  public abstract void a(Exception paramException);
  
  public void a(String paramString)
  {
    this.c.a(paramString);
  }
  
  public void a(ByteBuffer paramByteBuffer) {}
  
  public InetSocketAddress b(com.meiqia.core.a.a.a parama)
  {
    if (this.d != null) {
      return (InetSocketAddress)this.d.getLocalSocketAddress();
    }
    return null;
  }
  
  public abstract void b(int paramInt, String paramString, boolean paramBoolean);
  
  public void b(com.meiqia.core.a.a.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, paramString, paramBoolean);
  }
  
  public void b(com.meiqia.core.a.a.d.d paramd) {}
  
  public abstract void b(String paramString);
  
  public boolean b()
  {
    return this.c.b();
  }
  
  public void c()
  {
    if (this.h != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    this.h = new Thread(this);
    this.h.start();
  }
  
  public void d()
  {
    if (this.h != null) {
      this.c.a(1000);
    }
  }
  
  public com.meiqia.core.a.a.a e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.c.f();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 233	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 73	com/meiqia/core/a/a/a/a:g	Ljava/net/Proxy;
    //   16: invokespecial 297	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   26: invokevirtual 300	java/net/Socket:isBound	()Z
    //   29: ifne +32 -> 61
    //   32: aload_0
    //   33: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   36: new 271	java/net/InetSocketAddress
    //   39: dup
    //   40: aload_0
    //   41: getfield 62	com/meiqia/core/a/a/a/a:a	Ljava/net/URI;
    //   44: invokevirtual 160	java/net/URI:getHost	()Ljava/lang/String;
    //   47: aload_0
    //   48: invokespecial 157	com/meiqia/core/a/a/a/a:g	()I
    //   51: invokespecial 303	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   54: aload_0
    //   55: getfield 84	com/meiqia/core/a/a/a/a:m	I
    //   58: invokevirtual 307	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   66: invokevirtual 311	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   69: putfield 313	com/meiqia/core/a/a/a/a:e	Ljava/io/InputStream;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   77: invokevirtual 317	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   80: putfield 107	com/meiqia/core/a/a/a/a:f	Ljava/io/OutputStream;
    //   83: aload_0
    //   84: invokespecial 319	com/meiqia/core/a/a/a/a:h	()V
    //   87: aload_0
    //   88: new 228	java/lang/Thread
    //   91: dup
    //   92: new 10	com/meiqia/core/a/a/a/a$a
    //   95: dup
    //   96: aload_0
    //   97: aconst_null
    //   98: invokespecial 322	com/meiqia/core/a/a/a/a$a:<init>	(Lcom/meiqia/core/a/a/a/a;Lcom/meiqia/core/a/a/a/b;)V
    //   101: invokespecial 283	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   104: putfield 226	com/meiqia/core/a/a/a/a:h	Ljava/lang/Thread;
    //   107: aload_0
    //   108: getfield 226	com/meiqia/core/a/a/a/a:h	Ljava/lang/Thread;
    //   111: invokevirtual 286	java/lang/Thread:start	()V
    //   114: getstatic 324	com/meiqia/core/a/a/c:a	I
    //   117: newarray <illegal type>
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual 325	com/meiqia/core/a/a/a/a:f	()Z
    //   124: ifne +106 -> 230
    //   127: aload_0
    //   128: getfield 313	com/meiqia/core/a/a/a/a:e	Ljava/io/InputStream;
    //   131: aload_1
    //   132: invokevirtual 331	java/io/InputStream:read	([B)I
    //   135: istore_2
    //   136: iload_2
    //   137: iconst_m1
    //   138: if_icmpeq +92 -> 230
    //   141: aload_0
    //   142: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   145: aload_1
    //   146: iconst_0
    //   147: iload_2
    //   148: invokestatic 337	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   151: invokevirtual 338	com/meiqia/core/a/a/c:a	(Ljava/nio/ByteBuffer;)V
    //   154: goto -34 -> 120
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   162: invokevirtual 340	com/meiqia/core/a/a/c:c	()V
    //   165: getstatic 46	com/meiqia/core/a/a/a/a:b	Z
    //   168: ifne +61 -> 229
    //   171: aload_0
    //   172: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   175: invokevirtual 343	java/net/Socket:isClosed	()Z
    //   178: ifne +51 -> 229
    //   181: new 345	java/lang/AssertionError
    //   184: dup
    //   185: invokespecial 346	java/lang/AssertionError:<init>	()V
    //   188: athrow
    //   189: aload_0
    //   190: getfield 66	com/meiqia/core/a/a/a/a:d	Ljava/net/Socket;
    //   193: invokevirtual 343	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 221	java/io/IOException
    //   202: dup
    //   203: invokespecial 347	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_1
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   213: aload_1
    //   214: invokevirtual 241	com/meiqia/core/a/a/a/a:a	(Lcom/meiqia/core/a/a/a;Ljava/lang/Exception;)V
    //   217: aload_0
    //   218: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   221: iconst_m1
    //   222: aload_1
    //   223: invokevirtual 350	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 352	com/meiqia/core/a/a/c:b	(ILjava/lang/String;)V
    //   229: return
    //   230: aload_0
    //   231: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   234: invokevirtual 340	com/meiqia/core/a/a/c:c	()V
    //   237: goto -72 -> 165
    //   240: astore_1
    //   241: aload_0
    //   242: aload_1
    //   243: invokevirtual 254	com/meiqia/core/a/a/a/a:a	(Ljava/lang/Exception;)V
    //   246: aload_0
    //   247: getfield 64	com/meiqia/core/a/a/a/a:c	Lcom/meiqia/core/a/a/c;
    //   250: sipush 1006
    //   253: aload_1
    //   254: invokevirtual 353	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   257: invokevirtual 352	com/meiqia/core/a/a/c:b	(ILjava/lang/String;)V
    //   260: goto -95 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	a
    //   119	27	1	arrayOfByte	byte[]
    //   157	1	1	localIOException	IOException
    //   207	16	1	localException	Exception
    //   240	14	1	localRuntimeException	RuntimeException
    //   135	13	2	n	int
    // Exception table:
    //   from	to	target	type
    //   120	136	157	java/io/IOException
    //   141	154	157	java/io/IOException
    //   230	237	157	java/io/IOException
    //   0	22	207	java/lang/Exception
    //   22	61	207	java/lang/Exception
    //   61	87	207	java/lang/Exception
    //   189	207	207	java/lang/Exception
    //   120	136	240	java/lang/RuntimeException
    //   141	154	240	java/lang/RuntimeException
    //   230	237	240	java/lang/RuntimeException
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted())
        {
          ByteBuffer localByteBuffer = (ByteBuffer)a.a(a.this).f.take();
          a.b(a.this).write(localByteBuffer.array(), 0, localByteBuffer.limit());
          a.b(a.this).flush();
        }
        return;
      }
      catch (IOException localIOException)
      {
        a.a(a.this).c();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */