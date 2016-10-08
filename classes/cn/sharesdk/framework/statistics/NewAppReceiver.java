package cn.sharesdk.framework.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.mob.tools.b.c;
import com.mob.tools.b.f;
import com.mob.tools.b.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class NewAppReceiver
  extends BroadcastReceiver
  implements Handler.Callback
{
  private static final String[] a = { "android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED" };
  private static NewAppReceiver b;
  private static String f;
  private Context c;
  private IntentFilter[] d;
  private Handler e;
  
  private NewAppReceiver(Context paramContext, String paramString)
  {
    this.c = paramContext;
    f = paramString;
    this.d = new IntentFilter[] { new IntentFilter(), new IntentFilter() };
    this.d[0].addAction("cn.sharesdk.START_UP");
    paramContext = a;
    int j = paramContext.length;
    while (i < j)
    {
      paramString = paramContext[i];
      this.d[1].addAction(paramString);
      i += 1;
    }
    this.d[1].addDataScheme("package");
    this.e = new Handler(this);
    this.e.sendEmptyMessage(1);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: ifnonnull +17 -> 23
    //   9: new 2	cn/sharesdk/framework/statistics/NewAppReceiver
    //   12: dup
    //   13: aload_0
    //   14: getstatic 45	cn/sharesdk/framework/statistics/NewAppReceiver:f	Ljava/lang/String;
    //   17: invokespecial 79	cn/sharesdk/framework/statistics/NewAppReceiver:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   20: putstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   23: invokestatic 81	cn/sharesdk/framework/statistics/NewAppReceiver:b	()V
    //   26: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   29: getfield 50	cn/sharesdk/framework/statistics/NewAppReceiver:d	[Landroid/content/IntentFilter;
    //   32: astore_1
    //   33: aload_1
    //   34: arraylength
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge +32 -> 74
    //   45: aload_1
    //   46: iload_3
    //   47: aaload
    //   48: astore_2
    //   49: aload_0
    //   50: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   53: aload_2
    //   54: invokevirtual 87	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   57: pop
    //   58: iload_3
    //   59: iconst_1
    //   60: iadd
    //   61: istore_3
    //   62: goto -23 -> 39
    //   65: astore_0
    //   66: invokestatic 92	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   69: aload_0
    //   70: invokevirtual 98	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
    //   73: pop
    //   74: ldc 2
    //   76: monitorexit
    //   77: return
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramContext	Context
    //   0	84	1	paramString	String
    //   48	6	2	localIntentFilter	IntentFilter
    //   38	24	3	i	int
    //   35	8	4	j	int
    // Exception table:
    //   from	to	target	type
    //   26	37	65	java/lang/Throwable
    //   49	58	65	java/lang/Throwable
    //   3	23	78	finally
    //   23	26	78	finally
    //   26	37	78	finally
    //   49	58	78	finally
    //   66	74	78	finally
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +15 -> 23
    //   11: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   14: getfield 43	cn/sharesdk/framework/statistics/NewAppReceiver:c	Landroid/content/Context;
    //   17: getstatic 77	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   20: invokevirtual 107	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: astore_0
    //   28: invokestatic 92	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
    //   31: aload_0
    //   32: invokevirtual 109	com/mob/tools/log/d:d	(Ljava/lang/Throwable;)I
    //   35: pop
    //   36: goto -13 -> 23
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localNewAppReceiver	NewAppReceiver
    //   27	5	0	localThrowable	Throwable
    //   39	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	23	27	java/lang/Throwable
    //   3	7	39	finally
    //   11	23	39	finally
    //   28	36	39	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b.a(this.c);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getAction();
    }
    int i;
    if ("cn.sharesdk.START_UP".equals(str))
    {
      paramContext = c.a(paramContext).x();
      paramIntent = paramIntent.getStringExtra("packageName");
      if ((paramIntent == null) || (!paramIntent.equals(paramContext))) {
        break label120;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        cn.sharesdk.framework.utils.d.a().d("========= receive broadcast: " + str, new Object[0]);
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 60000L);
      }
      return;
      if (a(str)) {
        i = 1;
      } else {
        label120:
        i = 0;
      }
    }
  }
  
  private static class a
  {
    private f a;
    
    public a(Context paramContext)
    {
      try
      {
        Object localObject = c.a(paramContext);
        String str = g.e(paramContext, null);
        if (((c)localObject).C())
        {
          localObject = new File(((c)localObject).D(), "ShareSDK");
          if (((File)localObject).exists())
          {
            localObject = new File((File)localObject, ".ba");
            if ((((File)localObject).exists()) && (((File)localObject).renameTo(new File(g.b(paramContext), ".ba")))) {
              ((File)localObject).delete();
            }
          }
          paramContext = new File(g.b(paramContext));
          if (paramContext.exists())
          {
            this.a = new f();
            paramContext = new File(paramContext, ".ba");
            this.a.a(paramContext.getAbsolutePath());
            return;
          }
        }
        this.a = new f();
        paramContext = new File(str, ".ba");
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
        this.a.a(paramContext.getAbsolutePath());
        return;
      }
      catch (Exception paramContext)
      {
        cn.sharesdk.framework.utils.d.a().w(paramContext);
        if (this.a == null) {
          this.a = new f();
        }
      }
    }
    
    public ArrayList<HashMap<String, String>> a()
    {
      Object localObject = this.a.d("buffered_apps");
      if (localObject == null) {
        return new ArrayList();
      }
      return (ArrayList)localObject;
    }
    
    public void a(long paramLong)
    {
      this.a.a("buffered_apps_time", Long.valueOf(paramLong));
    }
    
    public void a(ArrayList<HashMap<String, String>> paramArrayList)
    {
      this.a.a("buffered_apps", paramArrayList);
    }
    
    public long b()
    {
      return this.a.c("buffered_apps_time");
    }
  }
  
  private static class b
    extends Thread
  {
    private Context a;
    private NewAppReceiver.a b;
    
    private b(Context paramContext)
    {
      this.a = paramContext;
      this.b = new NewAppReceiver.a(paramContext);
    }
    
    private ArrayList<HashMap<String, String>> a(HashMap<String, HashMap<String, String>> paramHashMap)
    {
      ArrayList localArrayList = new ArrayList();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext()) {
        localArrayList.add(((Map.Entry)paramHashMap.next()).getValue());
      }
      return localArrayList;
    }
    
    private HashMap<String, HashMap<String, String>> a(ArrayList<HashMap<String, String>> paramArrayList)
    {
      HashMap localHashMap1 = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        HashMap localHashMap2 = (HashMap)paramArrayList.next();
        String str = (String)localHashMap2.get("pkg");
        if (!TextUtils.isEmpty(str)) {
          localHashMap1.put(str, localHashMap2);
        }
      }
      return localHashMap1;
    }
    
    public static void a(Context paramContext)
    {
      new b(paramContext).start();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   4: invokestatic 95	com/mob/tools/b/c:a	(Landroid/content/Context;)Lcom/mob/tools/b/c;
      //   7: astore_1
      //   8: aload_1
      //   9: iconst_0
      //   10: invokevirtual 98	com/mob/tools/b/c:a	(Z)Ljava/util/ArrayList;
      //   13: astore_2
      //   14: aload_0
      //   15: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   18: invokevirtual 101	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	()Ljava/util/ArrayList;
      //   21: astore_3
      //   22: aload_0
      //   23: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   26: aload_2
      //   27: invokevirtual 104	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	(Ljava/util/ArrayList;)V
      //   30: aload_0
      //   31: aload_2
      //   32: invokespecial 106	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   35: astore 5
      //   37: aload_0
      //   38: aload_3
      //   39: invokespecial 106	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   42: astore 4
      //   44: aload_3
      //   45: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   48: astore 6
      //   50: aload 6
      //   52: invokeinterface 46 1 0
      //   57: ifeq +42 -> 99
      //   60: aload 6
      //   62: invokeinterface 50 1 0
      //   67: checkcast 30	java/util/HashMap
      //   70: ldc 66
      //   72: invokevirtual 70	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   75: checkcast 72	java/lang/String
      //   78: astore 7
      //   80: aload 7
      //   82: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   85: ifne -35 -> 50
      //   88: aload 5
      //   90: aload 7
      //   92: invokevirtual 109	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   95: pop
      //   96: goto -46 -> 50
      //   99: aload_2
      //   100: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   103: astore 6
      //   105: aload 6
      //   107: invokeinterface 46 1 0
      //   112: ifeq +42 -> 154
      //   115: aload 6
      //   117: invokeinterface 50 1 0
      //   122: checkcast 30	java/util/HashMap
      //   125: ldc 66
      //   127: invokevirtual 70	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   130: checkcast 72	java/lang/String
      //   133: astore 7
      //   135: aload 7
      //   137: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   140: ifne -35 -> 105
      //   143: aload 4
      //   145: aload 7
      //   147: invokevirtual 109	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   150: pop
      //   151: goto -46 -> 105
      //   154: aload_0
      //   155: aload 5
      //   157: invokespecial 111	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   160: astore 5
      //   162: aload_0
      //   163: aload 4
      //   165: invokespecial 111	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   168: astore 4
      //   170: invokestatic 117	java/lang/System:currentTimeMillis	()J
      //   173: aload_0
      //   174: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   177: invokevirtual 119	cn/sharesdk/framework/statistics/NewAppReceiver$a:b	()J
      //   180: lsub
      //   181: ldc2_w 120
      //   184: lcmp
      //   185: iflt +113 -> 298
      //   188: iconst_1
      //   189: istore 8
      //   191: iload 8
      //   193: ifne +10 -> 203
      //   196: aload_3
      //   197: invokevirtual 125	java/util/ArrayList:size	()I
      //   200: ifgt +116 -> 316
      //   203: aload_0
      //   204: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   207: invokestatic 117	java/lang/System:currentTimeMillis	()J
      //   210: invokevirtual 128	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	(J)V
      //   213: aload_0
      //   214: aload_0
      //   215: aload_2
      //   216: invokespecial 106	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   219: invokespecial 111	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   222: astore_2
      //   223: aload_0
      //   224: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   227: invokestatic 131	cn/sharesdk/framework/statistics/NewAppReceiver:a	()Ljava/lang/String;
      //   230: invokestatic 136	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;Ljava/lang/String;)Lcn/sharesdk/framework/statistics/a;
      //   233: ldc -118
      //   235: aload_2
      //   236: invokevirtual 141	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   239: aload 4
      //   241: invokevirtual 125	java/util/ArrayList:size	()I
      //   244: ifle +53 -> 297
      //   247: invokestatic 146	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
      //   250: new 148	java/lang/StringBuilder
      //   253: dup
      //   254: invokespecial 149	java/lang/StringBuilder:<init>	()V
      //   257: ldc -105
      //   259: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   262: aload_1
      //   263: invokevirtual 158	com/mob/tools/b/c:x	()Ljava/lang/String;
      //   266: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   272: iconst_0
      //   273: anewarray 163	java/lang/Object
      //   276: invokevirtual 169	com/mob/tools/log/d:d	(Ljava/lang/Object;[Ljava/lang/Object;)I
      //   279: pop
      //   280: aload_0
      //   281: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   284: invokestatic 131	cn/sharesdk/framework/statistics/NewAppReceiver:a	()Ljava/lang/String;
      //   287: invokestatic 136	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;Ljava/lang/String;)Lcn/sharesdk/framework/statistics/a;
      //   290: ldc -85
      //   292: aload 4
      //   294: invokevirtual 141	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   297: return
      //   298: iconst_0
      //   299: istore 8
      //   301: goto -110 -> 191
      //   304: astore_2
      //   305: invokestatic 146	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
      //   308: aload_2
      //   309: invokevirtual 175	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
      //   312: pop
      //   313: goto -74 -> 239
      //   316: aload 5
      //   318: invokevirtual 125	java/util/ArrayList:size	()I
      //   321: ifle -82 -> 239
      //   324: invokestatic 146	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
      //   327: new 148	java/lang/StringBuilder
      //   330: dup
      //   331: invokespecial 149	java/lang/StringBuilder:<init>	()V
      //   334: ldc -79
      //   336: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   339: aload_1
      //   340: invokevirtual 158	com/mob/tools/b/c:x	()Ljava/lang/String;
      //   343: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   349: iconst_0
      //   350: anewarray 163	java/lang/Object
      //   353: invokevirtual 169	com/mob/tools/log/d:d	(Ljava/lang/Object;[Ljava/lang/Object;)I
      //   356: pop
      //   357: aload_0
      //   358: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   361: invokestatic 131	cn/sharesdk/framework/statistics/NewAppReceiver:a	()Ljava/lang/String;
      //   364: invokestatic 136	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;Ljava/lang/String;)Lcn/sharesdk/framework/statistics/a;
      //   367: ldc -77
      //   369: aload 5
      //   371: invokevirtual 141	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   374: goto -135 -> 239
      //   377: astore_2
      //   378: invokestatic 146	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
      //   381: aload_2
      //   382: invokevirtual 175	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
      //   385: pop
      //   386: goto -147 -> 239
      //   389: astore_1
      //   390: invokestatic 146	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/d;
      //   393: aload_1
      //   394: invokevirtual 175	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
      //   397: pop
      //   398: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	399	0	this	b
      //   7	333	1	localc	c
      //   389	5	1	localThrowable1	Throwable
      //   13	223	2	localArrayList1	ArrayList
      //   304	5	2	localThrowable2	Throwable
      //   377	5	2	localThrowable3	Throwable
      //   21	176	3	localArrayList2	ArrayList
      //   42	251	4	localObject1	Object
      //   35	335	5	localObject2	Object
      //   48	68	6	localIterator	Iterator
      //   78	68	7	str	String
      //   189	111	8	i	int
      // Exception table:
      //   from	to	target	type
      //   213	239	304	java/lang/Throwable
      //   357	374	377	java/lang/Throwable
      //   280	297	389	java/lang/Throwable
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\statistics\NewAppReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */