package com.meiqia.core.a.a;

import com.meiqia.core.a.a.b.e;
import com.meiqia.core.a.a.c.g;
import com.meiqia.core.a.a.d.d.a;
import com.meiqia.core.a.a.e.f;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class c
  implements a
{
  public static int a;
  public static boolean b;
  public static final List<com.meiqia.core.a.a.b.a> c;
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  private volatile boolean i = false;
  private a.a j = a.a.a;
  private final d k;
  private List<com.meiqia.core.a.a.b.a> l;
  private com.meiqia.core.a.a.b.a m = null;
  private a.b n;
  private d.a o = null;
  private ByteBuffer p = ByteBuffer.allocate(0);
  private com.meiqia.core.a.a.e.a q = null;
  private String r = null;
  private Integer s = null;
  private Boolean t = null;
  private String u = null;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      a = 16384;
      b = false;
      c = new ArrayList(4);
      c.add(new com.meiqia.core.a.a.b.c());
      c.add(new com.meiqia.core.a.a.b.b());
      c.add(new e());
      c.add(new com.meiqia.core.a.a.b.d());
      return;
    }
  }
  
  public c(d paramd, com.meiqia.core.a.a.b.a parama)
  {
    if ((paramd == null) || ((parama == null) && (this.n == a.b.b))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.f = new LinkedBlockingQueue();
    this.g = new LinkedBlockingQueue();
    this.k = paramd;
    this.n = a.b.a;
    if (parama != null) {
      this.m = parama.c();
    }
  }
  
  private void a(f paramf)
  {
    if (b) {
      System.out.println("open using draft: " + this.m.getClass().getSimpleName());
    }
    this.j = a.a.c;
    try
    {
      this.k.a(this, paramf);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.k.a(this, paramf);
    }
  }
  
  private void a(Collection<com.meiqia.core.a.a.d.d> paramCollection)
  {
    if (!b()) {
      throw new g();
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((com.meiqia.core.a.a.d.d)paramCollection.next());
    }
  }
  
  private void a(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      e((ByteBuffer)paramList.next());
    }
  }
  
  /* Error */
  private boolean b(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   7: ifne +65 -> 72
    //   10: aload_1
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 241	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   16: pop
    //   17: aload_0
    //   18: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   21: ifnonnull +199 -> 220
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 244	com/meiqia/core/a/a/c:d	(Ljava/nio/ByteBuffer;)Lcom/meiqia/core/a/a/b/a$b;
    //   29: astore_3
    //   30: getstatic 249	com/meiqia/core/a/a/b/a$b:a	Lcom/meiqia/core/a/a/b/a$b;
    //   33: astore 4
    //   35: aload_3
    //   36: aload 4
    //   38: if_acmpne +182 -> 220
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   46: aload_0
    //   47: invokeinterface 252 2 0
    //   52: invokestatic 257	com/meiqia/core/a/a/f/b:a	(Ljava/lang/String;)[B
    //   55: invokestatic 261	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   58: invokespecial 225	com/meiqia/core/a/a/c:e	(Ljava/nio/ByteBuffer;)V
    //   61: aload_0
    //   62: bipush -3
    //   64: ldc_w 263
    //   67: invokevirtual 266	com/meiqia/core/a/a/c:a	(ILjava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   76: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   79: aload_1
    //   80: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   83: if_icmpge +41 -> 124
    //   86: aload_0
    //   87: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   90: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   93: aload_1
    //   94: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   97: iadd
    //   98: invokestatic 107	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   106: invokevirtual 272	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   109: pop
    //   110: aload_2
    //   111: aload_0
    //   112: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   115: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload_0
    //   120: aload_2
    //   121: putfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   124: aload_0
    //   125: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   128: aload_1
    //   129: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   132: pop
    //   133: aload_0
    //   134: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   137: invokevirtual 272	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   140: pop
    //   141: aload_0
    //   142: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   145: astore_2
    //   146: goto -134 -> 12
    //   149: astore_3
    //   150: aload_0
    //   151: sipush 1006
    //   154: ldc_w 278
    //   157: iconst_1
    //   158: invokespecial 281	com/meiqia/core/a/a/c:c	(ILjava/lang/String;Z)V
    //   161: goto -91 -> 70
    //   164: astore_3
    //   165: aload_0
    //   166: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   169: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   172: ifne +581 -> 753
    //   175: aload_2
    //   176: invokevirtual 284	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   179: pop
    //   180: aload_3
    //   181: invokevirtual 286	com/meiqia/core/a/a/c/a:a	()I
    //   184: istore 8
    //   186: iload 8
    //   188: ifne +532 -> 720
    //   191: aload_2
    //   192: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   195: bipush 16
    //   197: iadd
    //   198: istore 7
    //   200: aload_0
    //   201: iload 7
    //   203: invokestatic 107	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   206: putfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   209: aload_0
    //   210: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   213: aload_1
    //   214: invokevirtual 276	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   217: pop
    //   218: iconst_0
    //   219: ireturn
    //   220: aload_0
    //   221: getfield 121	com/meiqia/core/a/a/c:n	Lcom/meiqia/core/a/a/a$b;
    //   224: getstatic 125	com/meiqia/core/a/a/a$b:b	Lcom/meiqia/core/a/a/a$b;
    //   227: if_acmpne +302 -> 529
    //   230: aload_0
    //   231: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   234: ifnonnull +228 -> 462
    //   237: aload_0
    //   238: getfield 288	com/meiqia/core/a/a/c:l	Ljava/util/List;
    //   241: invokeinterface 222 1 0
    //   246: astore_3
    //   247: aload_3
    //   248: invokeinterface 209 1 0
    //   253: ifeq +189 -> 442
    //   256: aload_3
    //   257: invokeinterface 213 1 0
    //   262: checkcast 145	com/meiqia/core/a/a/b/a
    //   265: invokevirtual 148	com/meiqia/core/a/a/b/a:c	()Lcom/meiqia/core/a/a/b/a;
    //   268: astore 4
    //   270: aload 4
    //   272: aload_0
    //   273: getfield 121	com/meiqia/core/a/a/c:n	Lcom/meiqia/core/a/a/a$b;
    //   276: invokevirtual 291	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/a$b;)V
    //   279: aload_2
    //   280: invokevirtual 284	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   283: pop
    //   284: aload 4
    //   286: aload_2
    //   287: invokevirtual 294	com/meiqia/core/a/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/meiqia/core/a/a/e/f;
    //   290: astore 5
    //   292: aload 5
    //   294: instanceof 296
    //   297: ifne +16 -> 313
    //   300: aload_0
    //   301: sipush 1002
    //   304: ldc_w 298
    //   307: iconst_0
    //   308: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   311: iconst_0
    //   312: ireturn
    //   313: aload 5
    //   315: checkcast 296	com/meiqia/core/a/a/e/a
    //   318: astore 5
    //   320: aload 4
    //   322: aload 5
    //   324: invokevirtual 303	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/e/a;)Lcom/meiqia/core/a/a/b/a$b;
    //   327: getstatic 249	com/meiqia/core/a/a/b/a$b:a	Lcom/meiqia/core/a/a/b/a$b;
    //   330: if_acmpne -83 -> 247
    //   333: aload_0
    //   334: aload 5
    //   336: invokeinterface 305 1 0
    //   341: putfield 119	com/meiqia/core/a/a/c:u	Ljava/lang/String;
    //   344: aload_0
    //   345: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   348: aload_0
    //   349: aload 4
    //   351: aload 5
    //   353: invokeinterface 308 4 0
    //   358: astore 6
    //   360: aload_0
    //   361: aload 4
    //   363: aload 4
    //   365: aload 5
    //   367: aload 6
    //   369: invokevirtual 311	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/e/a;Lcom/meiqia/core/a/a/e/i;)Lcom/meiqia/core/a/a/e/c;
    //   372: aload_0
    //   373: getfield 121	com/meiqia/core/a/a/c:n	Lcom/meiqia/core/a/a/a$b;
    //   376: invokevirtual 314	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/e/f;Lcom/meiqia/core/a/a/a$b;)Ljava/util/List;
    //   379: invokespecial 316	com/meiqia/core/a/a/c:a	(Ljava/util/List;)V
    //   382: aload_0
    //   383: aload 4
    //   385: putfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   388: aload_0
    //   389: aload 5
    //   391: invokespecial 318	com/meiqia/core/a/a/c:a	(Lcom/meiqia/core/a/a/e/f;)V
    //   394: iconst_1
    //   395: ireturn
    //   396: astore 4
    //   398: aload_0
    //   399: aload 4
    //   401: invokevirtual 319	com/meiqia/core/a/a/c/b:a	()I
    //   404: aload 4
    //   406: invokevirtual 322	com/meiqia/core/a/a/c/b:getMessage	()Ljava/lang/String;
    //   409: iconst_0
    //   410: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   413: iconst_0
    //   414: ireturn
    //   415: astore 4
    //   417: aload_0
    //   418: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   421: aload_0
    //   422: aload 4
    //   424: invokeinterface 192 3 0
    //   429: aload_0
    //   430: iconst_m1
    //   431: aload 4
    //   433: invokevirtual 323	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   436: iconst_0
    //   437: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   440: iconst_0
    //   441: ireturn
    //   442: aload_0
    //   443: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   446: ifnonnull +345 -> 791
    //   449: aload_0
    //   450: sipush 1002
    //   453: ldc_w 325
    //   456: invokevirtual 266	com/meiqia/core/a/a/c:a	(ILjava/lang/String;)V
    //   459: goto +332 -> 791
    //   462: aload_0
    //   463: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   466: aload_2
    //   467: invokevirtual 294	com/meiqia/core/a/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/meiqia/core/a/a/e/f;
    //   470: astore_3
    //   471: aload_3
    //   472: instanceof 296
    //   475: ifne +16 -> 491
    //   478: aload_0
    //   479: sipush 1002
    //   482: ldc_w 298
    //   485: iconst_0
    //   486: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   489: iconst_0
    //   490: ireturn
    //   491: aload_3
    //   492: checkcast 296	com/meiqia/core/a/a/e/a
    //   495: astore_3
    //   496: aload_0
    //   497: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   500: aload_3
    //   501: invokevirtual 303	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/e/a;)Lcom/meiqia/core/a/a/b/a$b;
    //   504: getstatic 249	com/meiqia/core/a/a/b/a$b:a	Lcom/meiqia/core/a/a/b/a$b;
    //   507: if_acmpne +10 -> 517
    //   510: aload_0
    //   511: aload_3
    //   512: invokespecial 318	com/meiqia/core/a/a/c:a	(Lcom/meiqia/core/a/a/e/f;)V
    //   515: iconst_1
    //   516: ireturn
    //   517: aload_0
    //   518: sipush 1002
    //   521: ldc_w 327
    //   524: invokevirtual 266	com/meiqia/core/a/a/c:a	(ILjava/lang/String;)V
    //   527: iconst_0
    //   528: ireturn
    //   529: aload_0
    //   530: getfield 121	com/meiqia/core/a/a/c:n	Lcom/meiqia/core/a/a/a$b;
    //   533: getstatic 143	com/meiqia/core/a/a/a$b:a	Lcom/meiqia/core/a/a/a$b;
    //   536: if_acmpne -318 -> 218
    //   539: aload_0
    //   540: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   543: aload_0
    //   544: getfield 121	com/meiqia/core/a/a/c:n	Lcom/meiqia/core/a/a/a$b;
    //   547: invokevirtual 291	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/a$b;)V
    //   550: aload_0
    //   551: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   554: aload_2
    //   555: invokevirtual 294	com/meiqia/core/a/a/b/a:d	(Ljava/nio/ByteBuffer;)Lcom/meiqia/core/a/a/e/f;
    //   558: astore_3
    //   559: aload_3
    //   560: instanceof 329
    //   563: ifne +16 -> 579
    //   566: aload_0
    //   567: sipush 1002
    //   570: ldc_w 298
    //   573: iconst_0
    //   574: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   577: iconst_0
    //   578: ireturn
    //   579: aload_3
    //   580: checkcast 329	com/meiqia/core/a/a/e/h
    //   583: astore_3
    //   584: aload_0
    //   585: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   588: aload_0
    //   589: getfield 111	com/meiqia/core/a/a/c:q	Lcom/meiqia/core/a/a/e/a;
    //   592: aload_3
    //   593: invokevirtual 332	com/meiqia/core/a/a/b/a:a	(Lcom/meiqia/core/a/a/e/a;Lcom/meiqia/core/a/a/e/h;)Lcom/meiqia/core/a/a/b/a$b;
    //   596: astore 4
    //   598: getstatic 249	com/meiqia/core/a/a/b/a$b:a	Lcom/meiqia/core/a/a/b/a$b;
    //   601: astore 5
    //   603: aload 4
    //   605: aload 5
    //   607: if_acmpne +65 -> 672
    //   610: aload_0
    //   611: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   614: aload_0
    //   615: aload_0
    //   616: getfield 111	com/meiqia/core/a/a/c:q	Lcom/meiqia/core/a/a/e/a;
    //   619: aload_3
    //   620: invokeinterface 335 4 0
    //   625: aload_0
    //   626: aload_3
    //   627: invokespecial 318	com/meiqia/core/a/a/c:a	(Lcom/meiqia/core/a/a/e/f;)V
    //   630: iconst_1
    //   631: ireturn
    //   632: astore_3
    //   633: aload_0
    //   634: aload_3
    //   635: invokevirtual 319	com/meiqia/core/a/a/c/b:a	()I
    //   638: aload_3
    //   639: invokevirtual 322	com/meiqia/core/a/a/c/b:getMessage	()Ljava/lang/String;
    //   642: iconst_0
    //   643: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   646: iconst_0
    //   647: ireturn
    //   648: astore_3
    //   649: aload_0
    //   650: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   653: aload_0
    //   654: aload_3
    //   655: invokeinterface 192 3 0
    //   660: aload_0
    //   661: iconst_m1
    //   662: aload_3
    //   663: invokevirtual 323	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   666: iconst_0
    //   667: invokevirtual 300	com/meiqia/core/a/a/c:b	(ILjava/lang/String;Z)V
    //   670: iconst_0
    //   671: ireturn
    //   672: aload_0
    //   673: sipush 1002
    //   676: new 159	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 337
    //   686: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   693: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   696: ldc_w 342
    //   699: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokevirtual 266	com/meiqia/core/a/a/c:a	(ILjava/lang/String;)V
    //   708: goto -490 -> 218
    //   711: astore_3
    //   712: aload_0
    //   713: aload_3
    //   714: invokevirtual 345	com/meiqia/core/a/a/c:a	(Lcom/meiqia/core/a/a/c/b;)V
    //   717: goto -499 -> 218
    //   720: iload 8
    //   722: istore 7
    //   724: getstatic 55	com/meiqia/core/a/a/c:h	Z
    //   727: ifne -527 -> 200
    //   730: iload 8
    //   732: istore 7
    //   734: aload_3
    //   735: invokevirtual 286	com/meiqia/core/a/a/c/a:a	()I
    //   738: aload_2
    //   739: invokevirtual 269	java/nio/ByteBuffer:remaining	()I
    //   742: if_icmpge -542 -> 200
    //   745: new 347	java/lang/AssertionError
    //   748: dup
    //   749: invokespecial 348	java/lang/AssertionError:<init>	()V
    //   752: athrow
    //   753: aload_0
    //   754: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   757: aload_0
    //   758: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   761: invokevirtual 351	java/nio/ByteBuffer:limit	()I
    //   764: invokevirtual 355	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   767: pop
    //   768: aload_0
    //   769: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   772: aload_0
    //   773: getfield 109	com/meiqia/core/a/a/c:p	Ljava/nio/ByteBuffer;
    //   776: invokevirtual 237	java/nio/ByteBuffer:capacity	()I
    //   779: invokevirtual 357	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   782: pop
    //   783: goto -565 -> 218
    //   786: astore 4
    //   788: goto -541 -> 247
    //   791: iconst_0
    //   792: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	c
    //   0	793	1	paramByteBuffer	ByteBuffer
    //   11	728	2	localByteBuffer	ByteBuffer
    //   29	7	3	localb1	com.meiqia.core.a.a.b.a.b
    //   149	1	3	localb2	com.meiqia.core.a.a.c.b
    //   164	17	3	locala	com.meiqia.core.a.a.c.a
    //   246	381	3	localObject1	Object
    //   632	7	3	localb3	com.meiqia.core.a.a.c.b
    //   648	15	3	localRuntimeException1	RuntimeException
    //   711	24	3	locald1	com.meiqia.core.a.a.c.d
    //   33	351	4	localObject2	Object
    //   396	9	4	localb4	com.meiqia.core.a.a.c.b
    //   415	17	4	localRuntimeException2	RuntimeException
    //   596	8	4	localb5	com.meiqia.core.a.a.b.a.b
    //   786	1	4	locald2	com.meiqia.core.a.a.c.d
    //   290	316	5	localObject3	Object
    //   358	10	6	locali	com.meiqia.core.a.a.e.i
    //   198	535	7	i1	int
    //   184	547	8	i2	int
    // Exception table:
    //   from	to	target	type
    //   41	70	149	com/meiqia/core/a/a/c/b
    //   17	35	164	com/meiqia/core/a/a/c/a
    //   41	70	164	com/meiqia/core/a/a/c/a
    //   150	161	164	com/meiqia/core/a/a/c/a
    //   220	247	164	com/meiqia/core/a/a/c/a
    //   247	270	164	com/meiqia/core/a/a/c/a
    //   270	311	164	com/meiqia/core/a/a/c/a
    //   313	344	164	com/meiqia/core/a/a/c/a
    //   344	360	164	com/meiqia/core/a/a/c/a
    //   360	394	164	com/meiqia/core/a/a/c/a
    //   398	413	164	com/meiqia/core/a/a/c/a
    //   417	440	164	com/meiqia/core/a/a/c/a
    //   442	459	164	com/meiqia/core/a/a/c/a
    //   462	489	164	com/meiqia/core/a/a/c/a
    //   491	515	164	com/meiqia/core/a/a/c/a
    //   517	527	164	com/meiqia/core/a/a/c/a
    //   529	577	164	com/meiqia/core/a/a/c/a
    //   579	603	164	com/meiqia/core/a/a/c/a
    //   610	625	164	com/meiqia/core/a/a/c/a
    //   625	630	164	com/meiqia/core/a/a/c/a
    //   633	646	164	com/meiqia/core/a/a/c/a
    //   649	670	164	com/meiqia/core/a/a/c/a
    //   672	708	164	com/meiqia/core/a/a/c/a
    //   712	717	164	com/meiqia/core/a/a/c/a
    //   344	360	396	com/meiqia/core/a/a/c/b
    //   344	360	415	java/lang/RuntimeException
    //   610	625	632	com/meiqia/core/a/a/c/b
    //   610	625	648	java/lang/RuntimeException
    //   220	247	711	com/meiqia/core/a/a/c/d
    //   247	270	711	com/meiqia/core/a/a/c/d
    //   442	459	711	com/meiqia/core/a/a/c/d
    //   462	489	711	com/meiqia/core/a/a/c/d
    //   491	515	711	com/meiqia/core/a/a/c/d
    //   517	527	711	com/meiqia/core/a/a/c/d
    //   529	577	711	com/meiqia/core/a/a/c/d
    //   579	603	711	com/meiqia/core/a/a/c/d
    //   610	625	711	com/meiqia/core/a/a/c/d
    //   625	630	711	com/meiqia/core/a/a/c/d
    //   633	646	711	com/meiqia/core/a/a/c/d
    //   649	670	711	com/meiqia/core/a/a/c/d
    //   672	708	711	com/meiqia/core/a/a/c/d
    //   270	311	786	com/meiqia/core/a/a/c/d
    //   313	344	786	com/meiqia/core/a/a/c/d
    //   344	360	786	com/meiqia/core/a/a/c/d
    //   360	394	786	com/meiqia/core/a/a/c/d
    //   398	413	786	com/meiqia/core/a/a/c/d
    //   417	440	786	com/meiqia/core/a/a/c/d
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.j != a.a.d) && (this.j != a.a.e))
    {
      if (this.j != a.a.c) {
        break label191;
      }
      if (paramInt == 1006)
      {
        if ((!h) && (paramBoolean)) {
          throw new AssertionError();
        }
        this.j = a.a.d;
        b(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if ((this.m.b() == com.meiqia.core.a.a.b.a.a.a) || (!paramBoolean)) {}
    for (;;)
    {
      try
      {
        this.k.a(this, paramInt, paramString);
        a(new com.meiqia.core.a.a.d.b(paramInt, paramString));
        b(paramInt, paramString, paramBoolean);
        if (paramInt == 1002) {
          b(paramInt, paramString, paramBoolean);
        }
        this.j = a.a.d;
        this.p = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.k.a(this, localRuntimeException);
        continue;
      }
      catch (com.meiqia.core.a.a.c.b localb)
      {
        this.k.a(this, localb);
        b(1006, "generated frame is invalid", false);
        continue;
      }
      label191:
      if (paramInt == -3)
      {
        if ((!h) && (!paramBoolean)) {
          throw new AssertionError();
        }
        b(-3, paramString, true);
      }
      else
      {
        b(-1, paramString, false);
      }
    }
  }
  
  private void c(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      d.a locala1;
      boolean bool;
      int i1;
      try
      {
        Iterator localIterator = this.m.c(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          paramByteBuffer = (com.meiqia.core.a.a.d.d)localIterator.next();
          if (b) {
            System.out.println("matched frame: " + paramByteBuffer);
          }
          locala1 = paramByteBuffer.f();
          bool = paramByteBuffer.d();
          if (locala1 != d.a.f) {
            break label188;
          }
          if (!(paramByteBuffer instanceof com.meiqia.core.a.a.d.a)) {
            break label487;
          }
          paramByteBuffer = (com.meiqia.core.a.a.d.a)paramByteBuffer;
          i1 = paramByteBuffer.a();
          paramByteBuffer = paramByteBuffer.b();
          if (this.j == a.a.d) {
            a(i1, paramByteBuffer, true);
          }
        }
        else
        {
          return;
        }
      }
      catch (com.meiqia.core.a.a.c.b paramByteBuffer)
      {
        this.k.a(this, paramByteBuffer);
        a(paramByteBuffer);
      }
      if (this.m.b() == com.meiqia.core.a.a.b.a.a.c)
      {
        c(i1, paramByteBuffer, true);
      }
      else
      {
        b(i1, paramByteBuffer, false);
        continue;
        label188:
        if (locala1 == d.a.d)
        {
          this.k.b(this, paramByteBuffer);
        }
        else if (locala1 == d.a.e)
        {
          this.k.c(this, paramByteBuffer);
        }
        else
        {
          if ((!bool) || (locala1 == d.a.a))
          {
            if (locala1 != d.a.a)
            {
              if (this.o != null) {
                throw new com.meiqia.core.a.a.c.b(1002, "Previous continuous frame sequence not completed.");
              }
              this.o = locala1;
            }
            label338:
            do
            {
              for (;;)
              {
                try
                {
                  this.k.a(this, paramByteBuffer);
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.k.a(this, paramByteBuffer);
                }
                break;
                if (!bool) {
                  break label338;
                }
                if (this.o == null) {
                  throw new com.meiqia.core.a.a.c.b(1002, "Continuous frame sequence was not started.");
                }
                this.o = null;
              }
            } while (this.o != null);
            throw new com.meiqia.core.a.a.c.b(1002, "Continuous frame sequence was not started.");
          }
          if (this.o != null) {
            throw new com.meiqia.core.a.a.c.b(1002, "Continuous frame sequence not completed.");
          }
          d.a locala2 = d.a.b;
          if (locala1 == locala2)
          {
            try
            {
              this.k.a(this, com.meiqia.core.a.a.f.b.a(paramByteBuffer.c()));
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.k.a(this, paramByteBuffer);
            }
          }
          else
          {
            locala2 = d.a.c;
            if (locala1 == locala2)
            {
              try
              {
                this.k.a(this, paramByteBuffer.c());
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.k.a(this, paramByteBuffer);
              }
            }
            else
            {
              throw new com.meiqia.core.a.a.c.b(1002, "non control or continious frame expected");
              label487:
              paramByteBuffer = "";
              i1 = 1005;
            }
          }
        }
      }
    }
  }
  
  private com.meiqia.core.a.a.b.a.b d(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > com.meiqia.core.a.a.b.a.c.length) {
      return com.meiqia.core.a.a.b.a.b.b;
    }
    if (paramByteBuffer.limit() < com.meiqia.core.a.a.b.a.c.length) {
      throw new com.meiqia.core.a.a.c.a(com.meiqia.core.a.a.b.a.c.length);
    }
    int i1 = 0;
    while (paramByteBuffer.hasRemaining())
    {
      if (com.meiqia.core.a.a.b.a.c[i1] != paramByteBuffer.get())
      {
        paramByteBuffer.reset();
        return com.meiqia.core.a.a.b.a.b.b;
      }
      i1 += 1;
    }
    return com.meiqia.core.a.a.b.a.b.a;
  }
  
  private void e(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (b)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder().append("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000) {
        break label93;
      }
    }
    label93:
    for (String str = "too big to display";; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.f.add(paramByteBuffer);
      this.k.a(this);
      return;
    }
  }
  
  public InetSocketAddress a()
  {
    return this.k.b(this);
  }
  
  public void a(int paramInt)
  {
    c(paramInt, "", false);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }
  
  /* Error */
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	com/meiqia/core/a/a/c:j	Lcom/meiqia/core/a/a/a$a;
    //   6: astore 4
    //   8: getstatic 361	com/meiqia/core/a/a/a$a:e	Lcom/meiqia/core/a/a/a$a;
    //   11: astore 5
    //   13: aload 4
    //   15: aload 5
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 486	com/meiqia/core/a/a/c:d	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 486	com/meiqia/core/a/a/c:d	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 491	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 493	com/meiqia/core/a/a/c:e	Ljava/nio/channels/ByteChannel;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 493	com/meiqia/core/a/a/c:e	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 498 1 0
    //   57: aload_0
    //   58: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 501 5 0
    //   70: aload_0
    //   71: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   81: invokevirtual 503	com/meiqia/core/a/a/b/a:a	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 111	com/meiqia/core/a/a/c:q	Lcom/meiqia/core/a/a/e/a;
    //   89: aload_0
    //   90: getstatic 361	com/meiqia/core/a/a/a$a:e	Lcom/meiqia/core/a/a/a$a;
    //   93: putfield 97	com/meiqia/core/a/a/c:j	Lcom/meiqia/core/a/a/a$a;
    //   96: aload_0
    //   97: getfield 137	com/meiqia/core/a/a/c:f	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 506 1 0
    //   105: goto -85 -> 20
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   119: aload_0
    //   120: aload 4
    //   122: invokeinterface 192 3 0
    //   127: goto -70 -> 57
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   135: aload_0
    //   136: aload_2
    //   137: invokeinterface 192 3 0
    //   142: goto -72 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	c
    //   0	145	1	paramInt	int
    //   0	145	2	paramString	String
    //   0	145	3	paramBoolean	boolean
    //   6	38	4	localObject	Object
    //   113	8	4	localIOException	java.io.IOException
    //   11	5	5	locala	a.a
    // Exception table:
    //   from	to	target	type
    //   2	13	108	finally
    //   23	37	108	finally
    //   37	43	108	finally
    //   48	57	108	finally
    //   57	70	108	finally
    //   70	84	108	finally
    //   84	105	108	finally
    //   115	127	108	finally
    //   131	142	108	finally
    //   48	57	113	java/io/IOException
    //   57	70	130	java/lang/RuntimeException
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, "", paramBoolean);
  }
  
  public void a(com.meiqia.core.a.a.c.b paramb)
  {
    c(paramb.a(), paramb.getMessage(), false);
  }
  
  public void a(com.meiqia.core.a.a.d.d paramd)
  {
    if (b) {
      System.out.println("send frame: " + paramd);
    }
    e(this.m.a(paramd));
  }
  
  public void a(com.meiqia.core.a.a.e.b paramb)
  {
    if ((!h) && (this.j == a.a.b)) {
      throw new AssertionError("shall only be called once");
    }
    this.q = this.m.a(paramb);
    this.u = paramb.a();
    if ((!h) && (this.u == null)) {
      throw new AssertionError();
    }
    try
    {
      this.k.a(this, this.q);
      a(this.m.a(this.q, this.n));
      return;
    }
    catch (com.meiqia.core.a.a.c.b paramb)
    {
      throw new com.meiqia.core.a.a.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException paramb)
    {
      this.k.a(this, paramb);
      throw new com.meiqia.core.a.a.c.d("rejected because of" + paramb);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    com.meiqia.core.a.a.b.a locala = this.m;
    if (this.n == a.b.a) {}
    for (boolean bool = true;; bool = false)
    {
      a(locala.a(paramString, bool));
      return;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if ((!h) && (!paramByteBuffer.hasRemaining())) {
      throw new AssertionError();
    }
    String str;
    if (b)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder().append("process(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() > 1000)
      {
        str = "too big to display";
        localPrintStream.println(str + "}");
      }
    }
    else
    {
      if (this.j == a.a.a) {
        break label165;
      }
      c(paramByteBuffer);
    }
    for (;;)
    {
      if ((h) || (d()) || (e()) || (!paramByteBuffer.hasRemaining())) {
        return;
      }
      throw new AssertionError();
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
      break;
      label165:
      if (b(paramByteBuffer))
      {
        if ((!h) && (this.p.hasRemaining() == paramByteBuffer.hasRemaining()) && (paramByteBuffer.hasRemaining())) {
          throw new AssertionError();
        }
        if (paramByteBuffer.hasRemaining()) {
          c(paramByteBuffer);
        } else if (this.p.hasRemaining()) {
          c(this.p);
        }
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }
  
  /* Error */
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/meiqia/core/a/a/c:i	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 115	com/meiqia/core/a/a/c:s	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 113	com/meiqia/core/a/a/c:r	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 566	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 117	com/meiqia/core/a/a/c:t	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 91	com/meiqia/core/a/a/c:i	Z
    //   42: aload_0
    //   43: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   46: aload_0
    //   47: invokeinterface 469 2 0
    //   52: aload_0
    //   53: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 568 5 0
    //   65: aload_0
    //   66: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 99	com/meiqia/core/a/a/c:m	Lcom/meiqia/core/a/a/b/a;
    //   76: invokevirtual 503	com/meiqia/core/a/a/b/a:a	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 111	com/meiqia/core/a/a/c:q	Lcom/meiqia/core/a/a/e/a;
    //   84: goto -71 -> 13
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 141	com/meiqia/core/a/a/c:k	Lcom/meiqia/core/a/a/d;
    //   97: aload_0
    //   98: aload_2
    //   99: invokeinterface 192 3 0
    //   104: goto -39 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	c
    //   0	107	1	paramInt	int
    //   0	107	2	paramString	String
    //   0	107	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   16	52	87	finally
    //   52	65	87	finally
    //   65	79	87	finally
    //   79	84	87	finally
    //   93	104	87	finally
    //   52	65	92	java/lang/RuntimeException
  }
  
  public boolean b()
  {
    if ((h) || (this.j != a.a.c) || (!this.i))
    {
      if (this.j == a.a.c) {
        return true;
      }
    }
    else {
      throw new AssertionError();
    }
    return false;
  }
  
  public void c()
  {
    if (g() == a.a.a)
    {
      a(-1, true);
      return;
    }
    if (this.i)
    {
      a(this.s.intValue(), this.r, this.t.booleanValue());
      return;
    }
    if (this.m.b() == com.meiqia.core.a.a.b.a.a.a)
    {
      a(1000, true);
      return;
    }
    if (this.m.b() == com.meiqia.core.a.a.b.a.a.b)
    {
      if (this.n == a.b.b)
      {
        a(1006, true);
        return;
      }
      a(1000, true);
      return;
    }
    a(1006, true);
  }
  
  public boolean d()
  {
    return this.j == a.a.d;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j == a.a.e;
  }
  
  public a.a g()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */