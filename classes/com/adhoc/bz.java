package com.adhoc;

import android.annotation.TargetApi;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class bz
{
  private static final bz a = ;
  
  public static bz a()
  {
    return a;
  }
  
  static byte[] a(List<bi> paramList)
  {
    eo localeo = new eo();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      bi localbi = (bi)paramList.get(i);
      if (localbi == bi.a) {}
      for (;;)
      {
        i += 1;
        break;
        localeo.b(localbi.toString().length());
        localeo.a(localbi.toString());
      }
    }
    return localeo.q();
  }
  
  /* Error */
  private static bz c()
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: pop
    //   6: new 79	com/adhoc/by
    //   9: dup
    //   10: aconst_null
    //   11: ldc 81
    //   13: iconst_1
    //   14: anewarray 73	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: getstatic 87	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   22: aastore
    //   23: invokespecial 90	com/adhoc/by:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   26: astore 5
    //   28: new 79	com/adhoc/by
    //   31: dup
    //   32: aconst_null
    //   33: ldc 92
    //   35: iconst_1
    //   36: anewarray 73	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 50
    //   43: aastore
    //   44: invokespecial 90	com/adhoc/by:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   47: astore 6
    //   49: ldc 94
    //   51: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore_1
    //   55: aload_1
    //   56: ldc 96
    //   58: iconst_1
    //   59: anewarray 73	java/lang/Class
    //   62: dup
    //   63: iconst_0
    //   64: ldc 98
    //   66: aastore
    //   67: invokevirtual 102	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore_0
    //   71: aload_1
    //   72: ldc 104
    //   74: iconst_1
    //   75: anewarray 73	java/lang/Class
    //   78: dup
    //   79: iconst_0
    //   80: ldc 98
    //   82: aastore
    //   83: invokevirtual 102	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   86: astore_1
    //   87: ldc 106
    //   89: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   92: pop
    //   93: new 79	com/adhoc/by
    //   96: dup
    //   97: ldc 108
    //   99: ldc 110
    //   101: iconst_0
    //   102: anewarray 73	java/lang/Class
    //   105: invokespecial 90	com/adhoc/by:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   108: astore_2
    //   109: new 79	com/adhoc/by
    //   112: dup
    //   113: aconst_null
    //   114: ldc 112
    //   116: iconst_1
    //   117: anewarray 73	java/lang/Class
    //   120: dup
    //   121: iconst_0
    //   122: ldc 108
    //   124: aastore
    //   125: invokespecial 90	com/adhoc/by:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   128: astore 4
    //   130: aload_2
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: new 6	com/adhoc/bz$a
    //   138: dup
    //   139: aload 5
    //   141: aload 6
    //   143: aload_0
    //   144: aload_1
    //   145: aload_3
    //   146: aload_2
    //   147: invokespecial 115	com/adhoc/bz$a:<init>	(Lcom/adhoc/by;Lcom/adhoc/by;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/adhoc/by;Lcom/adhoc/by;)V
    //   150: areturn
    //   151: astore_0
    //   152: ldc 117
    //   154: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   157: pop
    //   158: goto -152 -> 6
    //   161: astore_0
    //   162: ldc 119
    //   164: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   167: astore_0
    //   168: new 121	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   175: ldc 119
    //   177: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc -128
    //   182: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   191: astore_1
    //   192: new 121	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   199: ldc 119
    //   201: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc -125
    //   206: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   215: astore_2
    //   216: new 121	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   223: ldc 119
    //   225: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc -123
    //   230: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   239: astore_3
    //   240: new 9	com/adhoc/bz$b
    //   243: dup
    //   244: aload_0
    //   245: ldc -121
    //   247: iconst_2
    //   248: anewarray 73	java/lang/Class
    //   251: dup
    //   252: iconst_0
    //   253: ldc -119
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload_1
    //   259: aastore
    //   260: invokevirtual 102	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   263: aload_0
    //   264: ldc -118
    //   266: iconst_1
    //   267: anewarray 73	java/lang/Class
    //   270: dup
    //   271: iconst_0
    //   272: ldc -119
    //   274: aastore
    //   275: invokevirtual 102	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   278: aload_0
    //   279: ldc -116
    //   281: iconst_1
    //   282: anewarray 73	java/lang/Class
    //   285: dup
    //   286: iconst_0
    //   287: ldc -119
    //   289: aastore
    //   290: invokevirtual 102	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   293: aload_2
    //   294: aload_3
    //   295: invokespecial 143	com/adhoc/bz$b:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   298: astore_0
    //   299: aload_0
    //   300: areturn
    //   301: astore_0
    //   302: new 2	com/adhoc/bz
    //   305: dup
    //   306: invokespecial 144	com/adhoc/bz:<init>	()V
    //   309: areturn
    //   310: astore_2
    //   311: aconst_null
    //   312: astore_2
    //   313: aload_2
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -182 -> 135
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_1
    //   323: aconst_null
    //   324: astore_0
    //   325: aconst_null
    //   326: astore_2
    //   327: aconst_null
    //   328: astore 4
    //   330: aload_1
    //   331: astore_3
    //   332: aload_0
    //   333: astore_1
    //   334: aload_2
    //   335: astore_0
    //   336: aload 4
    //   338: astore_2
    //   339: goto -204 -> 135
    //   342: astore_1
    //   343: aconst_null
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_3
    //   347: aload_0
    //   348: astore_2
    //   349: aload_3
    //   350: astore_0
    //   351: goto -24 -> 327
    //   354: astore_2
    //   355: aconst_null
    //   356: astore_3
    //   357: aload_0
    //   358: astore_2
    //   359: aload_1
    //   360: astore_0
    //   361: aload_3
    //   362: astore_1
    //   363: goto -36 -> 327
    //   366: astore_3
    //   367: aload_0
    //   368: astore_3
    //   369: aload_1
    //   370: astore_0
    //   371: aload_2
    //   372: astore_1
    //   373: aload_3
    //   374: astore_2
    //   375: goto -48 -> 327
    //   378: astore_3
    //   379: goto -66 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	74	0	localMethod	Method
    //   151	1	0	localClassNotFoundException1	ClassNotFoundException
    //   161	1	0	localClassNotFoundException2	ClassNotFoundException
    //   167	133	0	localObject1	Object
    //   301	1	0	localThrowable1	Throwable
    //   320	1	0	localThrowable2	Throwable
    //   324	47	0	localObject2	Object
    //   54	280	1	localObject3	Object
    //   342	1	1	localThrowable3	Throwable
    //   344	29	1	localObject4	Object
    //   108	186	2	localObject5	Object
    //   310	1	2	localClassNotFoundException3	ClassNotFoundException
    //   312	37	2	localObject6	Object
    //   354	1	2	localThrowable4	Throwable
    //   358	17	2	localObject7	Object
    //   131	231	3	localObject8	Object
    //   366	1	3	localThrowable5	Throwable
    //   368	6	3	localObject9	Object
    //   378	1	3	localClassNotFoundException4	ClassNotFoundException
    //   128	209	4	localby1	by
    //   26	114	5	localby2	by
    //   47	95	6	localby3	by
    // Exception table:
    //   from	to	target	type
    //   0	6	151	java/lang/ClassNotFoundException
    //   6	49	161	java/lang/ClassNotFoundException
    //   49	71	161	java/lang/ClassNotFoundException
    //   71	87	161	java/lang/ClassNotFoundException
    //   135	151	161	java/lang/ClassNotFoundException
    //   152	158	161	java/lang/ClassNotFoundException
    //   162	299	301	java/lang/Throwable
    //   87	109	310	java/lang/ClassNotFoundException
    //   49	71	320	java/lang/Throwable
    //   71	87	342	java/lang/Throwable
    //   87	109	354	java/lang/Throwable
    //   109	130	366	java/lang/Throwable
    //   109	130	378	java/lang/ClassNotFoundException
  }
  
  public void a(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void a(Socket paramSocket) {}
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket) {}
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<bi> paramList) {}
  
  public String b()
  {
    return "OkHttp";
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void b(Socket paramSocket) {}
  
  static class a
    extends bz
  {
    private final by<Socket> a;
    private final by<Socket> b;
    private final Method c;
    private final Method d;
    private final by<Socket> e;
    private final by<Socket> f;
    
    public a(by<Socket> paramby1, by<Socket> paramby2, Method paramMethod1, Method paramMethod2, by<Socket> paramby3, by<Socket> paramby4)
    {
      this.a = paramby1;
      this.b = paramby2;
      this.c = paramMethod1;
      this.d = paramMethod2;
      this.e = paramby3;
      this.f = paramby4;
    }
    
    public void a(Socket paramSocket)
    {
      if (this.c == null) {
        return;
      }
      try
      {
        this.c.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
    
    public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public void a(SSLSocket paramSSLSocket, String paramString, List<bi> paramList)
    {
      if (paramString != null) {}
      try
      {
        this.a.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.b.b(paramSSLSocket, new Object[] { paramString });
        if ((this.f != null) && (this.f.a(paramSSLSocket)))
        {
          paramString = a(paramList);
          this.f.d(paramSSLSocket, new Object[] { paramString });
        }
        return;
      }
      catch (Throwable paramSSLSocket)
      {
        fl.a(paramSSLSocket);
      }
    }
    
    public String b(SSLSocket paramSSLSocket)
    {
      if (this.e == null) {}
      while (!this.e.a(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.e.d(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, cb.c);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
    }
    
    public void b(Socket paramSocket)
    {
      if (this.d == null) {
        return;
      }
      try
      {
        this.d.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
  }
  
  static class b
    extends bz
  {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;
    
    public b(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
      this.d = paramClass1;
      this.e = paramClass2;
    }
    
    public void a(SSLSocket paramSSLSocket)
    {
      try
      {
        this.c.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (Throwable paramSSLSocket)
      {
        throw new AssertionError();
      }
    }
    
    @TargetApi(19)
    public void a(SSLSocket paramSSLSocket, String paramString, List<bi> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int j = paramList.size();
      int i = 0;
      Object localObject;
      if (i < j)
      {
        localObject = (bi)paramList.get(i);
        if (localObject == bi.a) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((bi)localObject).toString());
        }
      }
      try
      {
        paramList = bz.class.getClassLoader();
        localObject = this.d;
        Class localClass = this.e;
        paramString = new bz.c(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public String b(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (bz.c)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
        if ((!bz.c.a(paramSSLSocket)) && (bz.c.b(paramSSLSocket) == null))
        {
          bt.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (bz.c.a(paramSSLSocket)) {
          paramSSLSocket = null;
        } else {
          paramSSLSocket = bz.c.b(paramSSLSocket);
        }
      }
      catch (Throwable paramSSLSocket)
      {
        throw new AssertionError();
      }
      return paramSSLSocket;
    }
  }
  
  static class c
    implements InvocationHandler
  {
    private final List<String> a;
    private boolean b;
    private String c;
    
    public c(List<String> paramList)
    {
      this.a = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = cb.b;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.b = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.a;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = ((List)paramObject).size();
        int i = 0;
        while (i < j)
        {
          if (this.a.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            this.c = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.a.get(0);
        this.c = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.c = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */