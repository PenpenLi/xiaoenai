package b.a;

import b.a.d.a;
import b.a.d.f;
import b.ai;
import java.io.IOException;
import java.lang.reflect.Field;
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
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class h
{
  private static final h a = ;
  
  public static h a()
  {
    return a;
  }
  
  static <T> T a(Object paramObject, Class<T> paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        if ((localObject == null) || (!paramClass.isInstance(localObject))) {
          break label110;
        }
        localObject = paramClass.cast(localObject);
        return (T)localObject;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    if (!paramString.equals("delegate"))
    {
      paramObject = a(paramObject, Object.class, "delegate");
      if (paramObject != null) {
        return (T)a(paramObject, paramClass, paramString);
      }
    }
    return null;
    label110:
    return null;
  }
  
  static byte[] a(List<ai> paramList)
  {
    c.e locale = new c.e();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      ai localai = (ai)paramList.get(i);
      if (localai == ai.a) {}
      for (;;)
      {
        i += 1;
        break;
        locale.b(localai.toString().length());
        locale.a(localai.toString());
      }
    }
    return locale.r();
  }
  
  /* Error */
  private static h c()
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: new 122	b/a/g
    //   9: dup
    //   10: aconst_null
    //   11: ldc 124
    //   13: iconst_1
    //   14: anewarray 36	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: getstatic 130	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   22: aastore
    //   23: invokespecial 133	b/a/g:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   26: astore_3
    //   27: new 122	b/a/g
    //   30: dup
    //   31: aconst_null
    //   32: ldc -121
    //   34: iconst_1
    //   35: anewarray 36	java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc 67
    //   42: aastore
    //   43: invokespecial 133	b/a/g:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   46: astore 4
    //   48: ldc -119
    //   50: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   53: pop
    //   54: new 122	b/a/g
    //   57: dup
    //   58: ldc -117
    //   60: ldc -115
    //   62: iconst_0
    //   63: anewarray 36	java/lang/Class
    //   66: invokespecial 133	b/a/g:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   69: astore_0
    //   70: new 122	b/a/g
    //   73: dup
    //   74: aconst_null
    //   75: ldc -113
    //   77: iconst_1
    //   78: anewarray 36	java/lang/Class
    //   81: dup
    //   82: iconst_0
    //   83: ldc -117
    //   85: aastore
    //   86: invokespecial 133	b/a/g:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   89: astore_2
    //   90: new 6	b/a/h$a
    //   93: dup
    //   94: aload_1
    //   95: aload_3
    //   96: aload 4
    //   98: aload_0
    //   99: aload_2
    //   100: invokespecial 146	b/a/h$a:<init>	(Ljava/lang/Class;Lb/a/g;Lb/a/g;Lb/a/g;Lb/a/g;)V
    //   103: areturn
    //   104: astore_0
    //   105: ldc -108
    //   107: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   110: astore_1
    //   111: goto -105 -> 6
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: goto -29 -> 90
    //   122: astore_0
    //   123: ldc -106
    //   125: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   128: astore_0
    //   129: new 152	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   136: ldc -106
    //   138: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc -97
    //   143: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   152: astore_1
    //   153: new 152	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   160: ldc -106
    //   162: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc -94
    //   167: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   176: astore_2
    //   177: new 152	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   184: ldc -106
    //   186: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc -92
    //   191: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 120	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   200: astore_3
    //   201: new 9	b/a/h$b
    //   204: dup
    //   205: aload_0
    //   206: ldc -90
    //   208: iconst_2
    //   209: anewarray 36	java/lang/Class
    //   212: dup
    //   213: iconst_0
    //   214: ldc -88
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: aload_1
    //   220: aastore
    //   221: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   224: aload_0
    //   225: ldc -83
    //   227: iconst_1
    //   228: anewarray 36	java/lang/Class
    //   231: dup
    //   232: iconst_0
    //   233: ldc -88
    //   235: aastore
    //   236: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   239: aload_0
    //   240: ldc -81
    //   242: iconst_1
    //   243: anewarray 36	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: ldc -88
    //   250: aastore
    //   251: invokevirtual 172	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   254: aload_2
    //   255: aload_3
    //   256: invokespecial 178	b/a/h$b:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   259: astore_0
    //   260: aload_0
    //   261: areturn
    //   262: astore_0
    //   263: new 2	b/a/h
    //   266: dup
    //   267: invokespecial 179	b/a/h:<init>	()V
    //   270: areturn
    //   271: astore_0
    //   272: goto -9 -> 263
    //   275: astore_2
    //   276: goto -159 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   69	30	0	localg1	g
    //   104	1	0	localClassNotFoundException1	ClassNotFoundException
    //   114	1	0	localClassNotFoundException2	ClassNotFoundException
    //   116	1	0	localObject1	Object
    //   122	1	0	localClassNotFoundException3	ClassNotFoundException
    //   128	133	0	localObject2	Object
    //   262	1	0	localClassNotFoundException4	ClassNotFoundException
    //   271	1	0	localNoSuchMethodException	NoSuchMethodException
    //   5	215	1	localClass	Class
    //   89	166	2	localObject3	Object
    //   275	1	2	localClassNotFoundException5	ClassNotFoundException
    //   26	230	3	localObject4	Object
    //   46	51	4	localg2	g
    // Exception table:
    //   from	to	target	type
    //   0	6	104	java/lang/ClassNotFoundException
    //   48	70	114	java/lang/ClassNotFoundException
    //   6	48	122	java/lang/ClassNotFoundException
    //   90	104	122	java/lang/ClassNotFoundException
    //   105	111	122	java/lang/ClassNotFoundException
    //   123	260	262	java/lang/ClassNotFoundException
    //   123	260	271	java/lang/NoSuchMethodException
    //   70	90	275	java/lang/ClassNotFoundException
  }
  
  public f a(X509TrustManager paramX509TrustManager)
  {
    return new b.a.d.e(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public X509TrustManager a(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      paramSSLSocketFactory = a(paramSSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      paramSSLSocketFactory = (X509TrustManager)a(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
      return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException paramSSLSocketFactory) {}
    return null;
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket) {}
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<ai> paramList) {}
  
  public String b()
  {
    return "OkHttp";
  }
  
  public String b(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  private static class a
    extends h
  {
    private final Class<?> a;
    private final g<Socket> b;
    private final g<Socket> c;
    private final g<Socket> d;
    private final g<Socket> e;
    
    public a(Class<?> paramClass, g<Socket> paramg1, g<Socket> paramg2, g<Socket> paramg3, g<Socket> paramg4)
    {
      this.a = paramClass;
      this.b = paramg1;
      this.c = paramg2;
      this.d = paramg3;
      this.e = paramg4;
    }
    
    public f a(X509TrustManager paramX509TrustManager)
    {
      f localf = a.a(paramX509TrustManager);
      if (localf != null) {
        return localf;
      }
      return super.a(paramX509TrustManager);
    }
    
    public X509TrustManager a(SSLSocketFactory paramSSLSocketFactory)
    {
      Object localObject = a(paramSSLSocketFactory, this.a, "sslParameters");
      if (localObject == null) {}
      for (;;)
      {
        try
        {
          localObject = a(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
          paramSSLSocketFactory = (SSLSocketFactory)localObject;
          localObject = (X509TrustManager)a(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
          if (localObject != null) {
            return (X509TrustManager)localObject;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          return super.a(paramSSLSocketFactory);
        }
        return (X509TrustManager)a(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
        paramSSLSocketFactory = localClassNotFoundException;
      }
    }
    
    public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (j.a(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public void a(SSLSocket paramSSLSocket, String paramString, List<ai> paramList)
    {
      if (paramString != null)
      {
        this.b.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.c.b(paramSSLSocket, new Object[] { paramString });
      }
      if ((this.e != null) && (this.e.a(paramSSLSocket)))
      {
        paramString = a(paramList);
        this.e.d(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public String b(SSLSocket paramSSLSocket)
    {
      if (this.d == null) {}
      while (!this.d.a(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.d.d(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, j.c);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
    }
  }
  
  private static class b
    extends h
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
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public void a(SSLSocket paramSSLSocket, String paramString, List<ai> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int j = paramList.size();
      int i = 0;
      Object localObject;
      if (i < j)
      {
        localObject = (ai)paramList.get(i);
        if (localObject == ai.a) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((ai)localObject).toString());
        }
      }
      try
      {
        paramList = h.class.getClassLoader();
        localObject = this.d;
        Class localClass = this.e;
        paramString = new h.c(paramString);
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
        paramSSLSocket = (h.c)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
        if ((!h.c.a(paramSSLSocket)) && (h.c.b(paramSSLSocket) == null))
        {
          d.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (h.c.a(paramSSLSocket)) {
          paramSSLSocket = null;
        } else {
          paramSSLSocket = h.c.b(paramSSLSocket);
        }
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
      return paramSSLSocket;
    }
  }
  
  private static class c
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
        paramObject = j.b;
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */