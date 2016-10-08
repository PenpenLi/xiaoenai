package com.mob.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.a.i;
import com.mob.tools.a.l;
import com.mob.tools.a.l.a;
import com.mob.tools.b.b;
import com.mob.tools.b.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

public class d
  extends com.mob.tools.f
{
  private static d a;
  private static String b = "http://api.exc.mob.com:80";
  private HashMap<String, Integer> c;
  private Context d;
  private c e;
  private l f;
  private e g;
  private File h;
  private com.mob.tools.b.d i;
  
  private d(Context paramContext)
  {
    super("MOB_LOGGER");
    this.d = paramContext.getApplicationContext();
    this.f = new l();
    this.e = c.a(paramContext);
    this.g = e.a(paramContext);
    this.c = new HashMap();
    this.i = new com.mob.tools.b.d();
    this.h = new File(paramContext.getFilesDir(), ".lock");
    if (!this.h.exists()) {}
    try
    {
      this.h.createNewFile();
      com.mob.tools.log.d.setContext(paramContext);
      startThread();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.mob.tools.e.a().w(localException);
      }
    }
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int j = paramString.read(arrayOfByte, 0, 1024);
      if (j == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, j);
    }
    ((GZIPOutputStream)localObject).flush();
    ((GZIPOutputStream)localObject).close();
    localObject = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramString.close();
    return Base64.encodeToString((byte[])localObject, 2);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      if (!this.g.b()) {
        return;
      }
      if ("none".equals(this.e.u())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString1)
    {
      com.mob.tools.e.a().w(paramString1);
      return;
    }
    paramArrayOfString = g.a(this.d, paramArrayOfString);
    int j = 0;
    while (j < paramArrayOfString.size())
    {
      f localf = (f)paramArrayOfString.get(j);
      HashMap localHashMap = c(paramInt, paramString1, paramString2);
      localHashMap.put("errmsg", localf.a);
      if (a(a(new com.mob.tools.b.e().a(localHashMap)), true)) {
        g.a(this.d, localf.b);
      }
      j += 1;
    }
  }
  
  private void a(Message paramMessage)
  {
    this.handler.sendMessageDelayed(paramMessage, 1000L);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ("none".equals(this.e.u())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      com.mob.tools.e.a().w(paramString);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new i("m", paramString));
    paramString = new l.a();
    paramString.a = 10000;
    paramString.b = 10000;
    this.f.httpPost(c(), localArrayList, null, null, paramString);
    return true;
  }
  
  private String b()
  {
    return b + "/errconf";
  }
  
  /* Error */
  private void b(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 192	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 244	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: new 246	com/mob/tools/a/i
    //   14: dup
    //   15: ldc_w 283
    //   18: aload_3
    //   19: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   22: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload 4
    //   28: new 246	com/mob/tools/a/i
    //   31: dup
    //   32: ldc_w 285
    //   35: aload_2
    //   36: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   39: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload 4
    //   45: new 246	com/mob/tools/a/i
    //   48: dup
    //   49: ldc_w 287
    //   52: aload_0
    //   53: getfield 60	com/mob/a/a/d:e	Lcom/mob/tools/b/c;
    //   56: invokevirtual 290	com/mob/tools/b/c:x	()Ljava/lang/String;
    //   59: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 4
    //   68: new 246	com/mob/tools/a/i
    //   71: dup
    //   72: ldc_w 292
    //   75: aload_0
    //   76: getfield 60	com/mob/a/a/d:e	Lcom/mob/tools/b/c;
    //   79: invokevirtual 295	com/mob/tools/b/c:z	()I
    //   82: invokestatic 299	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload 4
    //   94: new 246	com/mob/tools/a/i
    //   97: dup
    //   98: ldc_w 301
    //   101: iload_1
    //   102: invokestatic 299	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   111: pop
    //   112: aload 4
    //   114: new 246	com/mob/tools/a/i
    //   117: dup
    //   118: ldc_w 303
    //   121: aload_0
    //   122: getfield 60	com/mob/a/a/d:e	Lcom/mob/tools/b/c;
    //   125: invokevirtual 306	com/mob/tools/b/c:v	()I
    //   128: invokestatic 299	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   131: invokespecial 251	com/mob/tools/a/i:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   134: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: new 256	com/mob/tools/a/l$a
    //   141: dup
    //   142: invokespecial 257	com/mob/tools/a/l$a:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: sipush 10000
    //   150: putfield 260	com/mob/tools/a/l$a:a	I
    //   153: aload_2
    //   154: sipush 10000
    //   157: putfield 262	com/mob/tools/a/l$a:b	I
    //   160: aload_0
    //   161: getfield 53	com/mob/a/a/d:f	Lcom/mob/tools/a/l;
    //   164: aload_0
    //   165: invokespecial 308	com/mob/a/a/d:b	()Ljava/lang/String;
    //   168: aload 4
    //   170: aconst_null
    //   171: aconst_null
    //   172: aload_2
    //   173: invokevirtual 268	com/mob/tools/a/l:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/a/i;Ljava/util/ArrayList;Lcom/mob/tools/a/l$a;)Ljava/lang/String;
    //   176: astore_2
    //   177: invokestatic 110	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   180: ldc_w 310
    //   183: iconst_1
    //   184: anewarray 312	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: aastore
    //   191: invokevirtual 315	com/mob/tools/log/d:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   194: pop
    //   195: new 216	com/mob/tools/b/e
    //   198: dup
    //   199: invokespecial 217	com/mob/tools/b/e:<init>	()V
    //   202: aload_2
    //   203: invokevirtual 318	com/mob/tools/b/e:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   206: astore_2
    //   207: ldc_w 320
    //   210: aload_2
    //   211: ldc_w 322
    //   214: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   220: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +18 -> 241
    //   226: invokestatic 110	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   229: ldc_w 330
    //   232: iconst_0
    //   233: anewarray 312	java/lang/Object
    //   236: invokevirtual 315	com/mob/tools/log/d:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   239: pop
    //   240: return
    //   241: aload_2
    //   242: ldc_w 332
    //   245: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +387 -> 637
    //   253: aload_2
    //   254: instanceof 69
    //   257: ifeq +380 -> 637
    //   260: aload_2
    //   261: checkcast 69	java/util/HashMap
    //   264: astore_2
    //   265: aload_2
    //   266: ldc_w 334
    //   269: invokevirtual 337	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   272: istore 10
    //   274: iload 10
    //   276: ifeq +35 -> 311
    //   279: aload_2
    //   280: ldc_w 334
    //   283: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   289: invokestatic 342	com/mob/tools/b/g:e	(Ljava/lang/String;)J
    //   292: lstore 6
    //   294: invokestatic 348	java/lang/System:currentTimeMillis	()J
    //   297: lstore 8
    //   299: aload_0
    //   300: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   303: lload 8
    //   305: lload 6
    //   307: lsub
    //   308: invokevirtual 351	com/mob/a/a/e:a	(J)V
    //   311: ldc_w 353
    //   314: aload_2
    //   315: ldc_w 355
    //   318: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   321: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +299 -> 626
    //   330: aload_0
    //   331: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   334: iconst_1
    //   335: invokevirtual 358	com/mob/a/a/e:a	(Z)V
    //   338: aload_2
    //   339: ldc_w 360
    //   342: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   345: astore_3
    //   346: aload_3
    //   347: ifnull +98 -> 445
    //   350: aload_3
    //   351: instanceof 69
    //   354: ifeq +91 -> 445
    //   357: aload_3
    //   358: checkcast 69	java/util/HashMap
    //   361: astore 5
    //   363: aload 5
    //   365: ldc_w 362
    //   368: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   374: astore_3
    //   375: aload 5
    //   377: ldc_w 364
    //   380: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   386: astore 4
    //   388: aload 5
    //   390: ldc_w 366
    //   393: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   396: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   399: astore 5
    //   401: aload_0
    //   402: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   405: ldc_w 353
    //   408: aload_3
    //   409: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   412: invokevirtual 368	com/mob/a/a/e:b	(Z)V
    //   415: aload_0
    //   416: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   419: ldc_w 353
    //   422: aload 4
    //   424: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: invokevirtual 370	com/mob/a/a/e:c	(Z)V
    //   430: aload_0
    //   431: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   434: ldc_w 353
    //   437: aload 5
    //   439: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: invokevirtual 372	com/mob/a/a/e:d	(Z)V
    //   445: aload_2
    //   446: ldc_w 374
    //   449: invokevirtual 337	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   452: ifeq +85 -> 537
    //   455: aload_2
    //   456: ldc_w 376
    //   459: invokevirtual 337	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   462: ifeq +75 -> 537
    //   465: aload_2
    //   466: ldc_w 374
    //   469: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   475: astore_3
    //   476: aload_2
    //   477: ldc_w 376
    //   480: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   483: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   486: astore 4
    //   488: aload_3
    //   489: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   492: ifne +45 -> 537
    //   495: aload 4
    //   497: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   500: ifne +37 -> 537
    //   503: new 270	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 384
    //   513: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 386
    //   523: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 4
    //   528: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: putstatic 29	com/mob/a/a/d:b	Ljava/lang/String;
    //   537: aload_2
    //   538: ldc_w 388
    //   541: invokevirtual 325	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   544: astore_2
    //   545: aload_2
    //   546: ifnull +91 -> 637
    //   549: aload_2
    //   550: instanceof 192
    //   553: ifeq +84 -> 637
    //   556: aload_2
    //   557: checkcast 192	java/util/ArrayList
    //   560: astore_2
    //   561: aload_2
    //   562: invokevirtual 196	java/util/ArrayList:size	()I
    //   565: ifle +72 -> 637
    //   568: new 69	java/util/HashMap
    //   571: dup
    //   572: invokespecial 70	java/util/HashMap:<init>	()V
    //   575: astore_3
    //   576: aload_3
    //   577: ldc_w 390
    //   580: aload_2
    //   581: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   584: pop
    //   585: aload_0
    //   586: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   589: new 216	com/mob/tools/b/e
    //   592: dup
    //   593: invokespecial 217	com/mob/tools/b/e:<init>	()V
    //   596: aload_3
    //   597: invokevirtual 220	com/mob/tools/b/e:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   600: invokevirtual 392	com/mob/a/a/e:a	(Ljava/lang/String;)V
    //   603: return
    //   604: astore_2
    //   605: invokestatic 110	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   608: aload_2
    //   609: invokevirtual 114	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
    //   612: pop
    //   613: return
    //   614: astore_3
    //   615: invokestatic 110	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   618: aload_3
    //   619: invokevirtual 114	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
    //   622: pop
    //   623: goto -312 -> 311
    //   626: aload_0
    //   627: getfield 67	com/mob/a/a/d:g	Lcom/mob/a/a/e;
    //   630: iconst_0
    //   631: invokevirtual 358	com/mob/a/a/e:a	(Z)V
    //   634: goto -296 -> 338
    //   637: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	d
    //   0	638	1	paramInt	int
    //   0	638	2	paramString1	String
    //   0	638	3	paramString2	String
    //   7	520	4	localObject1	Object
    //   361	77	5	localObject2	Object
    //   292	14	6	l1	long
    //   297	7	8	l2	long
    //   272	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   138	240	604	java/lang/Throwable
    //   241	249	604	java/lang/Throwable
    //   253	274	604	java/lang/Throwable
    //   311	338	604	java/lang/Throwable
    //   338	346	604	java/lang/Throwable
    //   350	445	604	java/lang/Throwable
    //   445	537	604	java/lang/Throwable
    //   537	545	604	java/lang/Throwable
    //   549	603	604	java/lang/Throwable
    //   615	623	604	java/lang/Throwable
    //   626	634	604	java/lang/Throwable
    //   279	311	614	java/lang/Throwable
  }
  
  private void b(Message paramMessage)
  {
    try
    {
      int j = paramMessage.arg1;
      Object localObject = (Object[])paramMessage.obj;
      paramMessage = (String)localObject[0];
      localObject = (String)localObject[1];
      b(j, paramMessage, (String)localObject);
      a(j, paramMessage, (String)localObject, null);
      return;
    }
    catch (Throwable paramMessage)
    {
      com.mob.tools.e.a().w(paramMessage);
    }
  }
  
  private String c()
  {
    return b + "/errlog";
  }
  
  private HashMap<String, Object> c(int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key", paramString2);
    localHashMap.put("plat", Integer.valueOf(this.e.v()));
    localHashMap.put("sdk", paramString1);
    localHashMap.put("sdkver", Integer.valueOf(paramInt));
    localHashMap.put("appname", this.e.y());
    localHashMap.put("apppkg", this.e.x());
    localHashMap.put("appver", String.valueOf(this.e.z()));
    localHashMap.put("deviceid", this.e.w());
    localHashMap.put("model", this.e.d());
    localHashMap.put("mac", this.e.c());
    localHashMap.put("udid", this.e.f());
    localHashMap.put("sysver", String.valueOf(this.e.l()));
    localHashMap.put("networktype", this.e.u());
    return localHashMap;
  }
  
  private void c(Message paramMessage)
  {
    int k;
    String str2;
    int j;
    Object localObject2;
    try
    {
      k = paramMessage.arg1;
      Object localObject1 = (Object[])paramMessage.obj;
      String str1 = (String)localObject1[0];
      str2 = (String)localObject1[1];
      localObject1 = (String)localObject1[2];
      if (paramMessage.arg2 == 0) {}
      for (j = 2;; j = 1)
      {
        localObject2 = this.g.f();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject2 = (ArrayList)new com.mob.tools.b.e().a((String)localObject2).get("fakelist");
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        String str3;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str3 = (String)((Iterator)localObject2).next();
        } while ((TextUtils.isEmpty(str3)) || (!((String)localObject1).contains(str3)));
        return;
        if (paramMessage.arg2 != 2) {
          break label450;
        }
      }
      localObject2 = b.b((String)localObject1);
      long l1;
      long l2;
      j = ((Integer)this.c.get(localObject2)).intValue();
    }
    catch (Throwable paramMessage)
    {
      try
      {
        this.i.a(this.h.getAbsolutePath());
        if (this.i.a(false))
        {
          l1 = System.currentTimeMillis();
          l2 = this.g.a();
          g.a(this.d, l1 - l2, (String)localObject1, j, (String)localObject2);
        }
        this.i.b();
        this.c.remove(localObject2);
        if ((3 != j) || (!this.g.e())) {
          break label368;
        }
        a(k, str1, str2, new String[] { String.valueOf(3) });
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!this.c.containsKey(localObject2)) {
          break label457;
        }
      }
      paramMessage = paramMessage;
      com.mob.tools.e.a().w(paramMessage);
      return;
    }
    for (;;)
    {
      j += 1;
      this.c.put(localObject2, Integer.valueOf(j));
      if (j < 3)
      {
        a(paramMessage);
        return;
      }
      com.mob.tools.e.a().w(localThrowable);
      return;
      label368:
      if ((1 == j) && (this.g.c()))
      {
        a(k, localThrowable, str2, new String[] { String.valueOf(1) });
        Process.killProcess(Process.myPid());
        System.exit(0);
        return;
      }
      if ((2 == j) && (this.g.d()))
      {
        a(k, localThrowable, str2, new String[] { String.valueOf(2) });
        return;
        label450:
        j = 1;
        break;
      }
      return;
      label457:
      j = 0;
    }
  }
  
  public Context a()
  {
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = new Object[] { paramString1, paramString2, paramString3 };
    this.handler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    localMessage.arg1 = paramInt;
    localMessage.obj = new Object[] { paramString1, paramString2 };
    this.handler.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    try
    {
      this.handler.wait();
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  protected void onMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      b(paramMessage);
      return;
    }
    c(paramMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */