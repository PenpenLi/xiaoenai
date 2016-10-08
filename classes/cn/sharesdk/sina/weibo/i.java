package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import com.mob.tools.b.b;
import java.util.Iterator;
import java.util.List;

public class i
{
  private static final Uri a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  private static i b;
  private static a c = null;
  private Context d;
  
  private i(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new i(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      return a(paramContext.signatures, "18da2bf10352443a00a5e046d9fca6bd");
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static boolean a(Signature[] paramArrayOfSignature, String paramString)
  {
    if ((paramArrayOfSignature == null) || (paramString == null)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfSignature.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(b.c(paramArrayOfSignature[i].toByteArray())))
        {
          cn.sharesdk.framework.utils.d.a().d("check pass", new Object[0]);
          return true;
        }
        i += 1;
      }
    }
  }
  
  private a b(Context paramContext)
  {
    int j = 1;
    a locala = c(paramContext);
    paramContext = d(paramContext);
    int i;
    if (locala != null)
    {
      i = 1;
      if (paramContext == null) {
        break label52;
      }
      label25:
      if ((i == 0) || (j == 0)) {
        break label60;
      }
      if (locala.b() < paramContext.b()) {
        break label58;
      }
    }
    label52:
    label58:
    label60:
    while (i != 0)
    {
      return locala;
      i = 0;
      break;
      j = 0;
      break label25;
      return paramContext;
    }
    if (j != 0) {
      return paramContext;
    }
    return null;
  }
  
  /* Error */
  private a c(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 121	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: aload_2
    //   6: getstatic 26	cn/sharesdk/sina/weibo/i:a	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 127	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +17 -> 35
    //   21: aload_3
    //   22: ifnull +9 -> 31
    //   25: aload_3
    //   26: invokeinterface 132 1 0
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: ldc -122
    //   40: invokeinterface 138 2 0
    //   45: istore 6
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: ldc -116
    //   52: invokeinterface 138 2 0
    //   57: istore 7
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: invokeinterface 144 1 0
    //   67: ifeq +117 -> 184
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: iload 6
    //   75: invokeinterface 148 2 0
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: invokestatic 153	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   89: istore 6
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: iload 7
    //   96: invokeinterface 148 2 0
    //   101: astore 5
    //   103: aload_3
    //   104: astore_2
    //   105: aload 5
    //   107: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +74 -> 184
    //   113: aload_3
    //   114: astore_2
    //   115: aload_1
    //   116: aload 5
    //   118: invokestatic 155	cn/sharesdk/sina/weibo/i:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   121: ifeq +63 -> 184
    //   124: aload_3
    //   125: astore_2
    //   126: new 6	cn/sharesdk/sina/weibo/i$a
    //   129: dup
    //   130: invokespecial 156	cn/sharesdk/sina/weibo/i$a:<init>	()V
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: aload 5
    //   141: invokestatic 159	cn/sharesdk/sina/weibo/i$a:a	(Lcn/sharesdk/sina/weibo/i$a;Ljava/lang/String;)V
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: iload 6
    //   150: invokestatic 162	cn/sharesdk/sina/weibo/i$a:a	(Lcn/sharesdk/sina/weibo/i$a;I)V
    //   153: aload 4
    //   155: astore_1
    //   156: aload_3
    //   157: ifnull -124 -> 33
    //   160: aload_3
    //   161: invokeinterface 132 1 0
    //   166: aload 4
    //   168: areturn
    //   169: astore 4
    //   171: aload_3
    //   172: astore_2
    //   173: aload 4
    //   175: invokevirtual 165	java/lang/NumberFormatException:printStackTrace	()V
    //   178: iconst_m1
    //   179: istore 6
    //   181: goto -90 -> 91
    //   184: aload_3
    //   185: ifnull +9 -> 194
    //   188: aload_3
    //   189: invokeinterface 132 1 0
    //   194: aconst_null
    //   195: areturn
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_3
    //   199: aload_3
    //   200: astore_2
    //   201: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   204: aload_1
    //   205: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   215: pop
    //   216: aload_3
    //   217: ifnull -23 -> 194
    //   220: aload_3
    //   221: invokeinterface 132 1 0
    //   226: goto -32 -> 194
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_2
    //   232: aload_2
    //   233: ifnull +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 132 1 0
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: goto -13 -> 232
    //   248: astore_1
    //   249: goto -50 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	i
    //   0	252	1	paramContext	Context
    //   4	233	2	localObject1	Object
    //   16	205	3	localCursor	android.database.Cursor
    //   80	87	4	localObject2	Object
    //   169	5	4	localNumberFormatException	NumberFormatException
    //   101	39	5	str	String
    //   45	135	6	i	int
    //   57	38	7	j	int
    // Exception table:
    //   from	to	target	type
    //   84	91	169	java/lang/NumberFormatException
    //   5	17	196	java/lang/Exception
    //   5	17	229	finally
    //   37	47	244	finally
    //   49	59	244	finally
    //   61	70	244	finally
    //   72	82	244	finally
    //   84	91	244	finally
    //   93	103	244	finally
    //   105	113	244	finally
    //   115	124	244	finally
    //   126	135	244	finally
    //   137	144	244	finally
    //   146	153	244	finally
    //   173	178	244	finally
    //   201	216	244	finally
    //   37	47	248	java/lang/Exception
    //   49	59	248	java/lang/Exception
    //   61	70	248	java/lang/Exception
    //   72	82	248	java/lang/Exception
    //   84	91	248	java/lang/Exception
    //   93	103	248	java/lang/Exception
    //   105	113	248	java/lang/Exception
    //   115	124	248	java/lang/Exception
    //   126	135	248	java/lang/Exception
    //   137	144	248	java/lang/Exception
    //   146	153	248	java/lang/Exception
    //   173	178	248	java/lang/Exception
  }
  
  private a d(Context paramContext)
  {
    a locala = null;
    Iterator localIterator = null;
    Object localObject = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    localObject = localIterator;
    if (paramContext != null)
    {
      if (!paramContext.isEmpty()) {
        break label53;
      }
      localObject = localIterator;
    }
    label53:
    do
    {
      return (a)localObject;
      localIterator = paramContext.iterator();
      paramContext = locala;
      localObject = paramContext;
    } while (!localIterator.hasNext());
    localObject = (ResolveInfo)localIterator.next();
    if ((((ResolveInfo)localObject).serviceInfo != null) && (((ResolveInfo)localObject).serviceInfo.applicationInfo != null) && (!TextUtils.isEmpty(((ResolveInfo)localObject).serviceInfo.applicationInfo.packageName)))
    {
      locala = a(((ResolveInfo)localObject).serviceInfo.applicationInfo.packageName);
      if (locala != null) {
        if (paramContext == null) {
          localObject = locala;
        }
      }
    }
    for (;;)
    {
      paramContext = (Context)localObject;
      break;
      localObject = locala;
      if (paramContext.b() >= locala.b()) {
        localObject = paramContext;
      }
    }
  }
  
  /* Error */
  public a a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 41	cn/sharesdk/sina/weibo/i:d	Landroid/content/Context;
    //   13: aload_1
    //   14: iconst_2
    //   15: invokevirtual 233	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore_2
    //   19: bipush 63
    //   21: newarray <illegal type>
    //   23: astore 4
    //   25: aload_2
    //   26: invokevirtual 237	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: ldc -17
    //   31: invokevirtual 245	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: new 247	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   44: astore 5
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload 4
    //   51: iconst_0
    //   52: sipush 4096
    //   55: invokevirtual 254	java/io/InputStream:read	([BII)I
    //   58: istore 6
    //   60: iload 6
    //   62: iconst_m1
    //   63: if_icmpeq +72 -> 135
    //   66: aload_3
    //   67: astore_2
    //   68: aload 5
    //   70: new 89	java/lang/String
    //   73: dup
    //   74: aload 4
    //   76: iconst_0
    //   77: iload 6
    //   79: invokespecial 257	java/lang/String:<init>	([BII)V
    //   82: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload_3
    //   91: astore_2
    //   92: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   95: aload_1
    //   96: invokevirtual 262	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   106: pop
    //   107: aload_3
    //   108: ifnull -101 -> 7
    //   111: aload_3
    //   112: invokevirtual 263	java/io/InputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   121: aload_1
    //   122: invokevirtual 264	java/io/IOException:getMessage	()Ljava/lang/String;
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   132: pop
    //   133: aconst_null
    //   134: areturn
    //   135: aload_3
    //   136: astore_2
    //   137: aload 5
    //   139: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +20 -> 165
    //   148: aload_3
    //   149: astore_2
    //   150: aload_0
    //   151: getfield 41	cn/sharesdk/sina/weibo/i:d	Landroid/content/Context;
    //   154: aload_1
    //   155: invokestatic 155	cn/sharesdk/sina/weibo/i:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   158: istore 7
    //   160: iload 7
    //   162: ifne +31 -> 193
    //   165: aload_3
    //   166: ifnull -159 -> 7
    //   169: aload_3
    //   170: invokevirtual 263	java/io/InputStream:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_1
    //   176: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   179: aload_1
    //   180: invokevirtual 264	java/io/IOException:getMessage	()Ljava/lang/String;
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   190: pop
    //   191: aconst_null
    //   192: areturn
    //   193: aload_3
    //   194: astore_2
    //   195: new 269	org/json/JSONObject
    //   198: dup
    //   199: aload 5
    //   201: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokespecial 270	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   207: ldc -122
    //   209: iconst_m1
    //   210: invokevirtual 274	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   213: istore 6
    //   215: aload_3
    //   216: astore_2
    //   217: new 6	cn/sharesdk/sina/weibo/i$a
    //   220: dup
    //   221: invokespecial 156	cn/sharesdk/sina/weibo/i$a:<init>	()V
    //   224: astore 4
    //   226: aload_3
    //   227: astore_2
    //   228: aload 4
    //   230: aload_1
    //   231: invokestatic 159	cn/sharesdk/sina/weibo/i$a:a	(Lcn/sharesdk/sina/weibo/i$a;Ljava/lang/String;)V
    //   234: aload_3
    //   235: astore_2
    //   236: aload 4
    //   238: iload 6
    //   240: invokestatic 162	cn/sharesdk/sina/weibo/i$a:a	(Lcn/sharesdk/sina/weibo/i$a;I)V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 263	java/io/InputStream:close	()V
    //   251: aload 4
    //   253: areturn
    //   254: astore_1
    //   255: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   258: aload_1
    //   259: invokevirtual 264	java/io/IOException:getMessage	()Ljava/lang/String;
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   269: pop
    //   270: goto -19 -> 251
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_3
    //   276: aload_3
    //   277: astore_2
    //   278: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   281: aload_1
    //   282: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   292: pop
    //   293: aload_3
    //   294: ifnull -287 -> 7
    //   297: aload_3
    //   298: invokevirtual 263	java/io/InputStream:close	()V
    //   301: aconst_null
    //   302: areturn
    //   303: astore_1
    //   304: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   307: aload_1
    //   308: invokevirtual 264	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   318: pop
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_2
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 263	java/io/InputStream:close	()V
    //   332: aload_1
    //   333: athrow
    //   334: astore_2
    //   335: invokestatic 98	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   338: aload_2
    //   339: invokevirtual 264	java/io/IOException:getMessage	()Ljava/lang/String;
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokevirtual 172	com/mob/tools/log/d:e	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   349: pop
    //   350: goto -18 -> 332
    //   353: astore_1
    //   354: goto -30 -> 324
    //   357: astore_1
    //   358: goto -82 -> 276
    //   361: astore_1
    //   362: aconst_null
    //   363: astore_3
    //   364: goto -274 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	i
    //   0	367	1	paramString	String
    //   18	311	2	localObject1	Object
    //   334	5	2	localIOException	java.io.IOException
    //   34	330	3	localInputStream	java.io.InputStream
    //   23	229	4	localObject2	Object
    //   44	156	5	localStringBuilder	StringBuilder
    //   58	181	6	i	int
    //   158	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   37	46	89	android/content/pm/PackageManager$NameNotFoundException
    //   48	60	89	android/content/pm/PackageManager$NameNotFoundException
    //   68	86	89	android/content/pm/PackageManager$NameNotFoundException
    //   137	148	89	android/content/pm/PackageManager$NameNotFoundException
    //   150	160	89	android/content/pm/PackageManager$NameNotFoundException
    //   195	215	89	android/content/pm/PackageManager$NameNotFoundException
    //   217	226	89	android/content/pm/PackageManager$NameNotFoundException
    //   228	234	89	android/content/pm/PackageManager$NameNotFoundException
    //   236	243	89	android/content/pm/PackageManager$NameNotFoundException
    //   111	115	117	java/io/IOException
    //   169	173	175	java/io/IOException
    //   247	251	254	java/io/IOException
    //   9	35	273	java/lang/Exception
    //   297	301	303	java/io/IOException
    //   9	35	321	finally
    //   328	332	334	java/io/IOException
    //   37	46	353	finally
    //   48	60	353	finally
    //   68	86	353	finally
    //   92	107	353	finally
    //   137	148	353	finally
    //   150	160	353	finally
    //   195	215	353	finally
    //   217	226	353	finally
    //   228	234	353	finally
    //   236	243	353	finally
    //   278	293	353	finally
    //   37	46	357	java/lang/Exception
    //   48	60	357	java/lang/Exception
    //   68	86	357	java/lang/Exception
    //   137	148	357	java/lang/Exception
    //   150	160	357	java/lang/Exception
    //   195	215	357	java/lang/Exception
    //   217	226	357	java/lang/Exception
    //   228	234	357	java/lang/Exception
    //   236	243	357	java/lang/Exception
    //   9	35	361	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public String a()
  {
    try
    {
      if (c == null) {
        c = b(this.d);
      }
      String str = c.a();
      return str;
    }
    finally {}
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 28	cn/sharesdk/sina/weibo/i:c	Lcn/sharesdk/sina/weibo/i$a;
    //   5: ifnonnull +14 -> 19
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 41	cn/sharesdk/sina/weibo/i:d	Landroid/content/Context;
    //   13: invokespecial 276	cn/sharesdk/sina/weibo/i:b	(Landroid/content/Context;)Lcn/sharesdk/sina/weibo/i$a;
    //   16: putstatic 28	cn/sharesdk/sina/weibo/i:c	Lcn/sharesdk/sina/weibo/i$a;
    //   19: getstatic 28	cn/sharesdk/sina/weibo/i:c	Lcn/sharesdk/sina/weibo/i$a;
    //   22: ifnull +14 -> 36
    //   25: getstatic 28	cn/sharesdk/sina/weibo/i:c	Lcn/sharesdk/sina/weibo/i$a;
    //   28: invokevirtual 280	cn/sharesdk/sina/weibo/i$a:c	()Z
    //   31: istore_3
    //   32: iload_3
    //   33: ifne +9 -> 42
    //   36: iconst_m1
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: getstatic 28	cn/sharesdk/sina/weibo/i:c	Lcn/sharesdk/sina/weibo/i$a;
    //   45: invokevirtual 113	cn/sharesdk/sina/weibo/i$a:b	()I
    //   48: istore_2
    //   49: goto -11 -> 38
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	i
    //   52	4	1	localObject	Object
    //   37	12	2	i	int
    //   31	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	52	finally
    //   19	32	52	finally
    //   42	49	52	finally
  }
  
  public static class a
  {
    private String a;
    private int b;
    
    private void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    private void a(String paramString)
    {
      this.a = paramString;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public boolean c()
    {
      return (!TextUtils.isEmpty(this.a)) && (this.b > 0);
    }
    
    public String toString()
    {
      return "WeiboInfo: PackageName = " + this.a + ", supportApi = " + this.b;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */