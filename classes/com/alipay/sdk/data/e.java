package com.alipay.sdk.data;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class e
{
  public a a;
  public WeakReference<c> b = null;
  public boolean c = true;
  boolean d = true;
  private JSONObject e;
  private JSONObject f;
  private long g;
  
  public e(a parama, JSONObject paramJSONObject)
  {
    this(parama, paramJSONObject, (byte)0);
  }
  
  private e(a parama, JSONObject paramJSONObject, byte paramByte)
  {
    this.a = parama;
    this.e = paramJSONObject;
    this.f = null;
    this.b = new WeakReference(null);
  }
  
  private void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  private void a(c paramc)
  {
    this.b = new WeakReference(paramc);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject;
  }
  
  private void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  private boolean a()
  {
    return this.d;
  }
  
  private String b()
  {
    return this.a.a;
  }
  
  private void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  private long c()
  {
    return this.g;
  }
  
  private c d()
  {
    return (c)this.b.get();
  }
  
  private boolean e()
  {
    return this.c;
  }
  
  private a f()
  {
    return this.a;
  }
  
  /* Error */
  public final JSONObject a(String paramString)
  {
    // Byte code:
    //   0: new 70	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 71	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: new 70	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 71	org/json/JSONObject:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 73
    //   19: getstatic 78	android/os/Build:MODEL	Ljava/lang/String;
    //   22: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: new 70	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 71	org/json/JSONObject:<init>	()V
    //   33: astore 4
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 38	com/alipay/sdk/data/e:f	Lorg/json/JSONObject;
    //   40: invokestatic 87	com/alipay/sdk/util/c:a	(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   43: astore_3
    //   44: aload_3
    //   45: ldc 89
    //   47: aload_0
    //   48: getfield 34	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   51: getfield 91	com/alipay/sdk/data/a:b	Ljava/lang/String;
    //   54: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_3
    //   59: ldc 93
    //   61: aload_0
    //   62: getfield 34	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   65: getfield 95	com/alipay/sdk/data/a:e	Ljava/lang/String;
    //   68: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_3
    //   73: ldc 97
    //   75: aload_0
    //   76: getfield 34	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   79: getfield 99	com/alipay/sdk/data/a:d	Ljava/lang/String;
    //   82: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: aload_0
    //   87: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   90: ifnonnull +14 -> 104
    //   93: aload_0
    //   94: new 70	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 71	org/json/JSONObject:<init>	()V
    //   101: putfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   104: aload_0
    //   105: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   108: ldc 101
    //   110: aload 4
    //   112: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_0
    //   117: getfield 34	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   120: getfield 103	com/alipay/sdk/data/a:c	Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: istore 7
    //   132: iload 7
    //   134: ifne +43 -> 177
    //   137: aload 5
    //   139: ldc 111
    //   141: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   144: astore 5
    //   146: aload 4
    //   148: ldc 119
    //   150: aload 5
    //   152: iconst_1
    //   153: aaload
    //   154: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 5
    //   160: arraylength
    //   161: iconst_1
    //   162: if_icmple +15 -> 177
    //   165: aload 4
    //   167: ldc 121
    //   169: aload 5
    //   171: iconst_2
    //   172: aaload
    //   173: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload_0
    //   178: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   181: ldc 123
    //   183: aload_0
    //   184: getfield 32	com/alipay/sdk/data/e:d	Z
    //   187: invokevirtual 126	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_0
    //   192: getfield 30	com/alipay/sdk/data/e:c	Z
    //   195: ifeq +149 -> 344
    //   198: new 70	org/json/JSONObject
    //   201: dup
    //   202: invokespecial 71	org/json/JSONObject:<init>	()V
    //   205: astore 4
    //   207: new 128	java/lang/StringBuilder
    //   210: dup
    //   211: ldc -126
    //   213: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_0
    //   217: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   220: invokevirtual 136	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: pop
    //   230: aload_0
    //   231: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   234: invokevirtual 136	org/json/JSONObject:toString	()Ljava/lang/String;
    //   237: astore 6
    //   239: aload_1
    //   240: getstatic 144	com/alipay/sdk/cons/a:c	Ljava/lang/String;
    //   243: invokestatic 149	com/alipay/sdk/encrypt/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 5
    //   248: aload_1
    //   249: aload 6
    //   251: invokestatic 152	com/alipay/sdk/encrypt/e:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: astore_1
    //   255: aload 4
    //   257: ldc -102
    //   259: invokestatic 160	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   262: ldc -94
    //   264: iconst_4
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload 5
    //   272: invokevirtual 166	java/lang/String:length	()I
    //   275: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload 5
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_1
    //   287: invokevirtual 166	java/lang/String:length	()I
    //   290: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: dup
    //   295: iconst_3
    //   296: aload_1
    //   297: aastore
    //   298: invokestatic 176	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   301: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   304: pop
    //   305: aload_3
    //   306: ldc -78
    //   308: aload 4
    //   310: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   313: pop
    //   314: aload_2
    //   315: ldc -76
    //   317: aload_3
    //   318: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   321: pop
    //   322: new 128	java/lang/StringBuilder
    //   325: dup
    //   326: ldc -74
    //   328: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_2
    //   332: invokevirtual 136	org/json/JSONObject:toString	()Ljava/lang/String;
    //   335: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: pop
    //   342: aload_2
    //   343: areturn
    //   344: aload_3
    //   345: ldc -78
    //   347: aload_0
    //   348: getfield 36	com/alipay/sdk/data/e:e	Lorg/json/JSONObject;
    //   351: invokevirtual 82	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   354: pop
    //   355: goto -41 -> 314
    //   358: astore_1
    //   359: goto -37 -> 322
    //   362: astore 4
    //   364: goto -187 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	e
    //   0	367	1	paramString	String
    //   7	336	2	localJSONObject1	JSONObject
    //   15	330	3	localJSONObject2	JSONObject
    //   33	276	4	localJSONObject3	JSONObject
    //   362	1	4	localException	Exception
    //   123	159	5	localObject	Object
    //   237	13	6	str	String
    //   130	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	104	358	java/lang/Exception
    //   104	132	358	java/lang/Exception
    //   177	314	358	java/lang/Exception
    //   314	322	358	java/lang/Exception
    //   344	355	358	java/lang/Exception
    //   137	177	362	java/lang/Exception
  }
  
  public final String toString()
  {
    return this.a.toString() + ", requestData = " + com.alipay.sdk.util.c.a(this.e, this.f) + ", timeStamp = " + this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\data\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */