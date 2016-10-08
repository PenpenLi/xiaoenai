package com.baidu.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.baidu.location.b.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class a0
  implements n
{
  public static final long i2 = 1800000L;
  private static final String i4 = "1";
  private static final String iR = "GeofenceStrategyService";
  private static final int iT = 30000;
  private static final int iU = 360000;
  private static final int iW = 6;
  private static final String iZ = "GeofenceStrategyService";
  private static final String ja = "com.baidu.locsdk.geofence.geofencestrategyservice";
  private static final int jb = 180000;
  private static final int jd = 60000;
  public static a0 jf;
  private static final String jh = "0";
  public static final String ji = "http://loc.map.baidu.com/fence";
  private static final String jk = "&gf=1";
  private String i0;
  private d i1;
  private boolean i3 = true;
  private Handler i5 = new Handler();
  private Map i6 = new HashMap();
  private String i7;
  private c i8;
  private PowerManager.WakeLock i9;
  private List iS;
  private String iV;
  private boolean iX;
  private boolean iY;
  private int jc;
  private HandlerThread je;
  private Messenger jg;
  private ar.b jj;
  private List jl;
  private ar.b jm;
  
  private void jdMethod_byte(Context paramContext)
  {
    if (this.i9 == null)
    {
      this.i9 = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "GeofenceStrategyService");
      this.i9.setReferenceCounted(false);
      this.i9.acquire(60000L);
    }
  }
  
  public static a0 cq()
  {
    if (jf == null)
    {
      jf = new a0();
      jf.cv();
    }
    return jf;
  }
  
  private Map cr()
  {
    String str1 = null;
    Cursor localCursor2 = null;
    HashMap localHashMap = new HashMap();
    SQLiteDatabase localSQLiteDatabase = m.a(f.getServiceContext()).getReadableDatabase();
    localCursor1 = localCursor2;
    localObject1 = str1;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localCursor1 = localCursor2;
        localObject1 = str1;
        localCursor2 = localSQLiteDatabase.rawQuery(String.format("SELECT a.ap, b.geofence_id FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND ((b.valid_date + b.duration_millis) >= %d) AND (b.next_exit_active_time < %d) ", new Object[] { "geofence_detail", "geofence", Long.valueOf(l), Long.valueOf(l) }), null);
        if (localCursor2 != null)
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          if (localCursor2.getCount() > 0)
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            localCursor2.moveToFirst();
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            int i = localCursor2.getColumnIndex("geofence_id");
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            int j = localCursor2.getColumnIndex("ap");
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            str1 = localCursor2.getString(i);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            str2 = localCursor2.getString(j);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            if (!localHashMap.containsKey(str1)) {
              continue;
            }
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            ((List)localHashMap.get(str1)).add(str2);
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            boolean bool = localCursor2.moveToNext();
            if (bool) {
              continue;
            }
          }
        }
        if (localCursor2 != null) {
          localCursor2.close();
        }
      }
      catch (Exception localException)
      {
        String str2;
        ArrayList localArrayList;
        localObject1 = localCursor1;
        localException.printStackTrace();
        if (localCursor1 == null) {
          continue;
        }
        localCursor1.close();
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
      }
      localSQLiteDatabase.close();
      return localHashMap;
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      localArrayList = new ArrayList();
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      localArrayList.add(str2);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      localHashMap.put(str1, localArrayList);
    }
  }
  
  private boolean cs()
  {
    if (this.jj == null) {}
    do
    {
      return true;
      if (this.jm == this.jj) {
        return false;
      }
    } while (!this.jj.a(this.jm));
    return false;
  }
  
  private void ct()
  {
    if (this.iX)
    {
      jdMethod_if(f.getServiceContext(), 30000);
      return;
    }
    Object localObject;
    int i;
    if (this.jc > 0)
    {
      localObject = f.getServiceContext();
      if (this.jc >= 6) {}
      for (i = 180000;; i = this.jc * 30000)
      {
        jdMethod_if((Context)localObject, i);
        return;
      }
    }
    aq localaq;
    if ((this.jl != null) && (this.jl.size() > 0))
    {
      localObject = this.jl.iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        localaq = (aq)((Iterator)localObject).next();
        if ((localaq.jdMethod_if()) || (localaq.jdMethod_for())) {
          break label251;
        }
        jdMethod_for(localaq);
        i = 1;
      }
    }
    label251:
    for (;;)
    {
      break;
      int j = i;
      if (this.iS != null)
      {
        j = i;
        if (this.iS.size() > 0)
        {
          localObject = this.iS.iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localaq = (aq)((Iterator)localObject).next();
            if ((!localaq.jdMethod_if()) && (!localaq.jdMethod_for()))
            {
              jdMethod_for(localaq);
              i = 1;
            }
          }
        }
      }
      if (j != 0)
      {
        jdMethod_if(f.getServiceContext(), 30000);
        return;
      }
      jdMethod_if(f.getServiceContext(), 180000);
      return;
      jdMethod_if(f.getServiceContext(), 360000);
      return;
    }
  }
  
  private void cu()
  {
    if ((this.i9 != null) && (this.i9.isHeld()))
    {
      this.i9.release();
      this.i9 = null;
    }
  }
  
  private void cv()
  {
    this.je = new HandlerThread("GeofenceStrategyService", 10);
    this.je.start();
    this.i5 = new Handler(this.je.getLooper());
    this.i1 = new d(null);
  }
  
  private List jdMethod_else(boolean paramBoolean)
  {
    Object localObject = t.an().ak();
    this.jm = ar.bW().bS();
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      this.i0 = String.format("%s|%s|%s|%s", new Object[] { Integer.valueOf(((t.a)localObject).jdField_do), Integer.valueOf(((t.a)localObject).jdField_if), Integer.valueOf(((t.a)localObject).jdField_for), Integer.valueOf(((t.a)localObject).jdField_try) });
      localArrayList.add(Jni.j(this.i0));
    }
    if (this.jm != null)
    {
      localObject = this.jm.jdField_for;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ScanResult localScanResult = (ScanResult)((Iterator)localObject).next();
          if (localScanResult != null) {
            localArrayList.add(Jni.j(localScanResult.BSSID.replace(":", "")));
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void jdMethod_for(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      paramList.set(i, String.format("'%s'", new Object[] { paramList.get(i) }));
      i += 1;
    }
    Object localObject1 = jdMethod_if(paramList, true);
    Object localObject2;
    Iterator localIterator1;
    Object localObject3;
    if (localObject1 != null)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (aq)paramList.next();
        localIterator1 = this.i6.entrySet().iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (Map.Entry)localIterator1.next();
          if (System.currentTimeMillis() - ((Long)((Map.Entry)localObject3).getValue()).longValue() >= 1800000L) {
            localIterator1.remove();
          }
          if (((aq)localObject2).getGeofenceId().equals(((Map.Entry)localObject3).getKey())) {
            paramList.remove();
          }
        }
      }
    }
    paramList = jdMethod_else(false);
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = cr();
      if (((Map)localObject2).size() > 0)
      {
        localIterator1 = paramList.iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label327;
          }
          localObject3 = (String)localIterator1.next();
          Iterator localIterator2 = ((Map)localObject2).entrySet().iterator();
          if (localIterator2.hasNext())
          {
            if (!((List)((Map.Entry)localIterator2.next()).getValue()).contains(localObject3)) {
              break;
            }
            localIterator2.remove();
          }
        }
      }
      label327:
      if (((Map)localObject2).size() > 0)
      {
        paramList.clear();
        paramList.addAll(((Map)localObject2).keySet());
        j = paramList.size();
        i = 0;
        while (i < j)
        {
          paramList.set(i, String.format("'%s'", new Object[] { paramList.get(i) }));
          i += 1;
        }
      }
    }
    for (paramList = jdMethod_if(paramList, false);; paramList = null)
    {
      localObject2 = new ArrayList();
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (aq)paramList.next();
          if ((!((List)localObject2).contains(localObject1)) || (this.i3)) {
            ((List)localObject2).add(localObject1);
          }
        }
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramList = ((List)localObject2).iterator();
        label517:
        while (paramList.hasNext())
        {
          localObject1 = (aq)paramList.next();
          if (localObject1 != null)
          {
            this.iX = true;
            jdMethod_for((aq)localObject1);
            this.i7 = this.i0;
            this.jj = this.jm;
            this.jc = 0;
          }
          else
          {
            this.iX = false;
            this.jc += 1;
            if (this.jc != Integer.MAX_VALUE) {
              break label611;
            }
          }
        }
        label611:
        for (i = 1;; i = this.jc)
        {
          this.jc = i;
          break label517;
          break;
        }
      }
      this.iX = false;
      return;
    }
  }
  
  /* Error */
  public List jdMethod_for(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 159	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   3: invokestatic 164	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   6: invokevirtual 168	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore 9
    //   20: aload 10
    //   22: ifnull +461 -> 483
    //   25: aconst_null
    //   26: astore 6
    //   28: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   31: lstore 22
    //   33: iload_2
    //   34: ifeq +452 -> 486
    //   37: ldc_w 482
    //   40: iconst_5
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: ldc -78
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc -76
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: aload_1
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: lload 22
    //   62: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   65: aastore
    //   66: dup
    //   67: iconst_4
    //   68: lload 22
    //   70: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: aastore
    //   74: invokestatic 192	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: astore_1
    //   78: aload 10
    //   80: aload_1
    //   81: aconst_null
    //   82: invokevirtual 198	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore_1
    //   86: aload 9
    //   88: astore 6
    //   90: aload_1
    //   91: ifnull +369 -> 460
    //   94: aload 9
    //   96: astore 6
    //   98: aload_1
    //   99: invokeinterface 204 1 0
    //   104: ifle +356 -> 460
    //   107: new 244	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 245	java/util/ArrayList:<init>	()V
    //   114: astore 6
    //   116: aload_1
    //   117: invokeinterface 208 1 0
    //   122: pop
    //   123: aload_1
    //   124: ldc -46
    //   126: invokeinterface 214 2 0
    //   131: istore 12
    //   133: aload_1
    //   134: ldc_w 484
    //   137: invokeinterface 214 2 0
    //   142: istore 13
    //   144: aload_1
    //   145: ldc_w 486
    //   148: invokeinterface 214 2 0
    //   153: istore 14
    //   155: aload_1
    //   156: ldc_w 488
    //   159: invokeinterface 214 2 0
    //   164: istore 15
    //   166: aload_1
    //   167: ldc_w 490
    //   170: invokeinterface 214 2 0
    //   175: istore 16
    //   177: aload_1
    //   178: ldc_w 492
    //   181: invokeinterface 214 2 0
    //   186: istore 17
    //   188: aload_1
    //   189: ldc_w 494
    //   192: invokeinterface 214 2 0
    //   197: istore 18
    //   199: aload_1
    //   200: ldc_w 496
    //   203: invokeinterface 214 2 0
    //   208: istore 19
    //   210: aload_1
    //   211: ldc_w 498
    //   214: invokeinterface 214 2 0
    //   219: istore 20
    //   221: aload_1
    //   222: ldc_w 500
    //   225: invokeinterface 214 2 0
    //   230: istore 21
    //   232: aload_1
    //   233: iload 12
    //   235: invokeinterface 220 2 0
    //   240: astore 7
    //   242: aload_1
    //   243: iload 13
    //   245: invokeinterface 220 2 0
    //   250: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   253: invokevirtual 509	java/lang/Float:floatValue	()F
    //   256: fstore_3
    //   257: aload_1
    //   258: iload 14
    //   260: invokeinterface 220 2 0
    //   265: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   268: invokevirtual 509	java/lang/Float:floatValue	()F
    //   271: fstore 4
    //   273: aload_1
    //   274: iload 15
    //   276: invokeinterface 220 2 0
    //   281: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   284: invokevirtual 509	java/lang/Float:floatValue	()F
    //   287: fstore 5
    //   289: aload_1
    //   290: iload 16
    //   292: invokeinterface 220 2 0
    //   297: astore 8
    //   299: aload_1
    //   300: iload 17
    //   302: invokeinterface 513 2 0
    //   307: lstore 22
    //   309: aload_1
    //   310: iload 18
    //   312: invokeinterface 517 2 0
    //   317: ifeq +213 -> 530
    //   320: iconst_1
    //   321: istore 24
    //   323: aload_1
    //   324: iload 19
    //   326: invokeinterface 517 2 0
    //   331: ifeq +205 -> 536
    //   334: iconst_1
    //   335: istore 25
    //   337: aload_1
    //   338: iload 20
    //   340: invokeinterface 517 2 0
    //   345: ifeq +197 -> 542
    //   348: iconst_1
    //   349: istore 26
    //   351: aload_1
    //   352: iload 21
    //   354: invokeinterface 517 2 0
    //   359: istore 11
    //   361: new 291	com/baidu/location/aq
    //   364: dup
    //   365: aload 7
    //   367: fload_3
    //   368: f2d
    //   369: fload 4
    //   371: f2d
    //   372: iload 11
    //   374: lload 22
    //   376: aload 8
    //   378: invokespecial 520	com/baidu/location/aq:<init>	(Ljava/lang/String;DDIJLjava/lang/String;)V
    //   381: astore 7
    //   383: aload 7
    //   385: ifnull +52 -> 437
    //   388: aload 7
    //   390: fload 5
    //   392: invokevirtual 523	com/baidu/location/aq:a	(F)V
    //   395: aload 7
    //   397: iload 24
    //   399: invokevirtual 525	com/baidu/location/aq:do	(Z)V
    //   402: aload 7
    //   404: iload 25
    //   406: invokevirtual 527	com/baidu/location/aq:a	(Z)V
    //   409: aload 7
    //   411: iload 26
    //   413: invokevirtual 529	com/baidu/location/aq:if	(Z)V
    //   416: aload_0
    //   417: getfield 101	com/baidu/location/a0:i3	Z
    //   420: ifne +17 -> 437
    //   423: iload_2
    //   424: ifeq +124 -> 548
    //   427: iconst_1
    //   428: istore 11
    //   430: aload 7
    //   432: iload 11
    //   434: invokevirtual 532	com/baidu/location/aq:a	(I)V
    //   437: aload 6
    //   439: aload 7
    //   441: invokeinterface 235 2 0
    //   446: pop
    //   447: aload_1
    //   448: invokeinterface 238 1 0
    //   453: istore 24
    //   455: iload 24
    //   457: ifne -225 -> 232
    //   460: aload 6
    //   462: astore 7
    //   464: aload_1
    //   465: ifnull +13 -> 478
    //   468: aload_1
    //   469: invokeinterface 241 1 0
    //   474: aload 6
    //   476: astore 7
    //   478: aload 10
    //   480: invokevirtual 242	android/database/sqlite/SQLiteDatabase:close	()V
    //   483: aload 7
    //   485: areturn
    //   486: ldc_w 534
    //   489: iconst_5
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: ldc -78
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: ldc -76
    //   502: aastore
    //   503: dup
    //   504: iconst_2
    //   505: aload_1
    //   506: aastore
    //   507: dup
    //   508: iconst_3
    //   509: lload 22
    //   511: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   514: aastore
    //   515: dup
    //   516: iconst_4
    //   517: lload 22
    //   519: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   522: aastore
    //   523: invokestatic 192	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   526: astore_1
    //   527: goto -449 -> 78
    //   530: iconst_0
    //   531: istore 24
    //   533: goto -210 -> 323
    //   536: iconst_0
    //   537: istore 25
    //   539: goto -202 -> 337
    //   542: iconst_0
    //   543: istore 26
    //   545: goto -194 -> 351
    //   548: iconst_0
    //   549: istore 11
    //   551: goto -121 -> 430
    //   554: astore_1
    //   555: aload 8
    //   557: astore_1
    //   558: aload_1
    //   559: astore 7
    //   561: aload 6
    //   563: ifnull -85 -> 478
    //   566: aload 6
    //   568: invokeinterface 241 1 0
    //   573: aload_1
    //   574: astore 7
    //   576: goto -98 -> 478
    //   579: astore 6
    //   581: aconst_null
    //   582: astore_1
    //   583: aload_1
    //   584: ifnull +9 -> 593
    //   587: aload_1
    //   588: invokeinterface 241 1 0
    //   593: aload 6
    //   595: athrow
    //   596: astore 6
    //   598: goto -15 -> 583
    //   601: astore 6
    //   603: aload_1
    //   604: astore 6
    //   606: aload 8
    //   608: astore_1
    //   609: goto -51 -> 558
    //   612: astore 7
    //   614: aload_1
    //   615: astore 7
    //   617: aload 6
    //   619: astore_1
    //   620: aload 7
    //   622: astore 6
    //   624: goto -66 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	a0
    //   0	627	1	paramString	String
    //   0	627	2	paramBoolean	boolean
    //   256	112	3	f1	float
    //   271	99	4	f2	float
    //   287	104	5	f3	float
    //   26	541	6	localObject1	Object
    //   579	15	6	localObject2	Object
    //   596	1	6	localObject3	Object
    //   601	1	6	localException1	Exception
    //   604	19	6	str1	String
    //   12	563	7	localObject4	Object
    //   612	1	7	localException2	Exception
    //   615	6	7	str2	String
    //   15	592	8	str3	String
    //   18	77	9	localObject5	Object
    //   9	470	10	localSQLiteDatabase	SQLiteDatabase
    //   359	191	11	i	int
    //   131	103	12	j	int
    //   142	102	13	k	int
    //   153	106	14	m	int
    //   164	111	15	n	int
    //   175	116	16	i10	int
    //   186	115	17	i11	int
    //   197	114	18	i12	int
    //   208	117	19	i13	int
    //   219	120	20	i14	int
    //   230	123	21	i15	int
    //   31	487	22	l	long
    //   321	211	24	bool1	boolean
    //   335	203	25	bool2	boolean
    //   349	195	26	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   37	78	554	java/lang/Exception
    //   78	86	554	java/lang/Exception
    //   486	527	554	java/lang/Exception
    //   37	78	579	finally
    //   78	86	579	finally
    //   486	527	579	finally
    //   98	116	596	finally
    //   116	232	596	finally
    //   232	320	596	finally
    //   323	334	596	finally
    //   337	348	596	finally
    //   351	383	596	finally
    //   388	423	596	finally
    //   430	437	596	finally
    //   437	455	596	finally
    //   98	116	601	java/lang/Exception
    //   116	232	612	java/lang/Exception
    //   232	320	612	java/lang/Exception
    //   323	334	612	java/lang/Exception
    //   337	348	612	java/lang/Exception
    //   351	383	612	java/lang/Exception
    //   388	423	612	java/lang/Exception
    //   430	437	612	java/lang/Exception
    //   437	455	612	java/lang/Exception
  }
  
  public void jdMethod_for(aq paramaq)
  {
    new a(paramaq, Jni.i(new b(null).e("&gf=1").replace("gcj02", paramaq.jdMethod_int()))).ai();
  }
  
  /* Error */
  public List jdMethod_if(List paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 553
    //   3: aload_1
    //   4: invokestatic 559	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   7: astore_1
    //   8: invokestatic 159	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   11: invokestatic 164	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   14: invokevirtual 168	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 10
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 9
    //   28: aload 10
    //   30: ifnull +468 -> 498
    //   33: aconst_null
    //   34: astore 6
    //   36: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   39: lstore 22
    //   41: iload_2
    //   42: ifeq +459 -> 501
    //   45: ldc_w 561
    //   48: iconst_5
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: ldc -78
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc -76
    //   61: aastore
    //   62: dup
    //   63: iconst_2
    //   64: aload_1
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: lload 22
    //   70: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: aastore
    //   74: dup
    //   75: iconst_4
    //   76: lload 22
    //   78: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: aastore
    //   82: invokestatic 192	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   85: astore_1
    //   86: aload 10
    //   88: aload_1
    //   89: aconst_null
    //   90: invokevirtual 198	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore_1
    //   94: aload 9
    //   96: astore 6
    //   98: aload_1
    //   99: ifnull +376 -> 475
    //   102: aload 9
    //   104: astore 6
    //   106: aload_1
    //   107: invokeinterface 204 1 0
    //   112: ifle +363 -> 475
    //   115: new 244	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 245	java/util/ArrayList:<init>	()V
    //   122: astore 6
    //   124: aload 6
    //   126: invokeinterface 459 1 0
    //   131: aload_1
    //   132: invokeinterface 208 1 0
    //   137: pop
    //   138: aload_1
    //   139: ldc -46
    //   141: invokeinterface 214 2 0
    //   146: istore 12
    //   148: aload_1
    //   149: ldc_w 484
    //   152: invokeinterface 214 2 0
    //   157: istore 13
    //   159: aload_1
    //   160: ldc_w 486
    //   163: invokeinterface 214 2 0
    //   168: istore 14
    //   170: aload_1
    //   171: ldc_w 488
    //   174: invokeinterface 214 2 0
    //   179: istore 15
    //   181: aload_1
    //   182: ldc_w 490
    //   185: invokeinterface 214 2 0
    //   190: istore 16
    //   192: aload_1
    //   193: ldc_w 492
    //   196: invokeinterface 214 2 0
    //   201: istore 17
    //   203: aload_1
    //   204: ldc_w 494
    //   207: invokeinterface 214 2 0
    //   212: istore 18
    //   214: aload_1
    //   215: ldc_w 496
    //   218: invokeinterface 214 2 0
    //   223: istore 19
    //   225: aload_1
    //   226: ldc_w 498
    //   229: invokeinterface 214 2 0
    //   234: istore 20
    //   236: aload_1
    //   237: ldc_w 500
    //   240: invokeinterface 214 2 0
    //   245: istore 21
    //   247: aload_1
    //   248: iload 12
    //   250: invokeinterface 220 2 0
    //   255: astore 7
    //   257: aload_1
    //   258: iload 13
    //   260: invokeinterface 220 2 0
    //   265: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   268: invokevirtual 509	java/lang/Float:floatValue	()F
    //   271: fstore_3
    //   272: aload_1
    //   273: iload 14
    //   275: invokeinterface 220 2 0
    //   280: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   283: invokevirtual 509	java/lang/Float:floatValue	()F
    //   286: fstore 4
    //   288: aload_1
    //   289: iload 15
    //   291: invokeinterface 220 2 0
    //   296: invokestatic 505	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   299: invokevirtual 509	java/lang/Float:floatValue	()F
    //   302: fstore 5
    //   304: aload_1
    //   305: iload 16
    //   307: invokeinterface 220 2 0
    //   312: astore 8
    //   314: aload_1
    //   315: iload 17
    //   317: invokeinterface 513 2 0
    //   322: lstore 22
    //   324: aload_1
    //   325: iload 18
    //   327: invokeinterface 517 2 0
    //   332: ifeq +213 -> 545
    //   335: iconst_1
    //   336: istore 24
    //   338: aload_1
    //   339: iload 19
    //   341: invokeinterface 517 2 0
    //   346: ifeq +205 -> 551
    //   349: iconst_1
    //   350: istore 25
    //   352: aload_1
    //   353: iload 20
    //   355: invokeinterface 517 2 0
    //   360: ifeq +197 -> 557
    //   363: iconst_1
    //   364: istore 26
    //   366: aload_1
    //   367: iload 21
    //   369: invokeinterface 517 2 0
    //   374: istore 11
    //   376: new 291	com/baidu/location/aq
    //   379: dup
    //   380: aload 7
    //   382: fload_3
    //   383: f2d
    //   384: fload 4
    //   386: f2d
    //   387: iload 11
    //   389: lload 22
    //   391: aload 8
    //   393: invokespecial 520	com/baidu/location/aq:<init>	(Ljava/lang/String;DDIJLjava/lang/String;)V
    //   396: astore 7
    //   398: aload 7
    //   400: ifnull +52 -> 452
    //   403: aload 7
    //   405: fload 5
    //   407: invokevirtual 523	com/baidu/location/aq:a	(F)V
    //   410: aload 7
    //   412: iload 24
    //   414: invokevirtual 525	com/baidu/location/aq:do	(Z)V
    //   417: aload 7
    //   419: iload 25
    //   421: invokevirtual 527	com/baidu/location/aq:a	(Z)V
    //   424: aload 7
    //   426: iload 26
    //   428: invokevirtual 529	com/baidu/location/aq:if	(Z)V
    //   431: aload_0
    //   432: getfield 101	com/baidu/location/a0:i3	Z
    //   435: ifne +17 -> 452
    //   438: iload_2
    //   439: ifeq +124 -> 563
    //   442: iconst_1
    //   443: istore 11
    //   445: aload 7
    //   447: iload 11
    //   449: invokevirtual 532	com/baidu/location/aq:a	(I)V
    //   452: aload 6
    //   454: aload 7
    //   456: invokeinterface 235 2 0
    //   461: pop
    //   462: aload_1
    //   463: invokeinterface 238 1 0
    //   468: istore 24
    //   470: iload 24
    //   472: ifne -225 -> 247
    //   475: aload 6
    //   477: astore 7
    //   479: aload_1
    //   480: ifnull +13 -> 493
    //   483: aload_1
    //   484: invokeinterface 241 1 0
    //   489: aload 6
    //   491: astore 7
    //   493: aload 10
    //   495: invokevirtual 242	android/database/sqlite/SQLiteDatabase:close	()V
    //   498: aload 7
    //   500: areturn
    //   501: ldc_w 563
    //   504: iconst_5
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: ldc -78
    //   512: aastore
    //   513: dup
    //   514: iconst_1
    //   515: ldc -76
    //   517: aastore
    //   518: dup
    //   519: iconst_2
    //   520: aload_1
    //   521: aastore
    //   522: dup
    //   523: iconst_3
    //   524: lload 22
    //   526: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   529: aastore
    //   530: dup
    //   531: iconst_4
    //   532: lload 22
    //   534: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   537: aastore
    //   538: invokestatic 192	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   541: astore_1
    //   542: goto -456 -> 86
    //   545: iconst_0
    //   546: istore 24
    //   548: goto -210 -> 338
    //   551: iconst_0
    //   552: istore 25
    //   554: goto -202 -> 352
    //   557: iconst_0
    //   558: istore 26
    //   560: goto -194 -> 366
    //   563: iconst_0
    //   564: istore 11
    //   566: goto -121 -> 445
    //   569: astore_1
    //   570: aload 8
    //   572: astore_1
    //   573: aload_1
    //   574: astore 7
    //   576: aload 6
    //   578: ifnull -85 -> 493
    //   581: aload 6
    //   583: invokeinterface 241 1 0
    //   588: aload_1
    //   589: astore 7
    //   591: goto -98 -> 493
    //   594: astore 6
    //   596: aconst_null
    //   597: astore_1
    //   598: aload_1
    //   599: ifnull +9 -> 608
    //   602: aload_1
    //   603: invokeinterface 241 1 0
    //   608: aload 6
    //   610: athrow
    //   611: astore 6
    //   613: goto -15 -> 598
    //   616: astore 6
    //   618: aload_1
    //   619: astore 6
    //   621: aload 8
    //   623: astore_1
    //   624: goto -51 -> 573
    //   627: astore 7
    //   629: aload_1
    //   630: astore 7
    //   632: aload 6
    //   634: astore_1
    //   635: aload 7
    //   637: astore 6
    //   639: goto -66 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	a0
    //   0	642	1	paramList	List
    //   0	642	2	paramBoolean	boolean
    //   271	112	3	f1	float
    //   286	99	4	f2	float
    //   302	104	5	f3	float
    //   34	548	6	localObject1	Object
    //   594	15	6	localObject2	Object
    //   611	1	6	localObject3	Object
    //   616	1	6	localException1	Exception
    //   619	19	6	localList1	List
    //   20	570	7	localObject4	Object
    //   627	1	7	localException2	Exception
    //   630	6	7	localList2	List
    //   23	599	8	str	String
    //   26	77	9	localObject5	Object
    //   17	477	10	localSQLiteDatabase	SQLiteDatabase
    //   374	191	11	i	int
    //   146	103	12	j	int
    //   157	102	13	k	int
    //   168	106	14	m	int
    //   179	111	15	n	int
    //   190	116	16	i10	int
    //   201	115	17	i11	int
    //   212	114	18	i12	int
    //   223	117	19	i13	int
    //   234	120	20	i14	int
    //   245	123	21	i15	int
    //   39	494	22	l	long
    //   336	211	24	bool1	boolean
    //   350	203	25	bool2	boolean
    //   364	195	26	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   36	41	569	java/lang/Exception
    //   45	86	569	java/lang/Exception
    //   86	94	569	java/lang/Exception
    //   501	542	569	java/lang/Exception
    //   36	41	594	finally
    //   45	86	594	finally
    //   86	94	594	finally
    //   501	542	594	finally
    //   106	124	611	finally
    //   124	247	611	finally
    //   247	335	611	finally
    //   338	349	611	finally
    //   352	363	611	finally
    //   366	398	611	finally
    //   403	438	611	finally
    //   445	452	611	finally
    //   452	470	611	finally
    //   106	124	616	java/lang/Exception
    //   124	247	627	java/lang/Exception
    //   247	335	627	java/lang/Exception
    //   338	349	627	java/lang/Exception
    //   352	363	627	java/lang/Exception
    //   366	398	627	java/lang/Exception
    //   403	438	627	java/lang/Exception
    //   445	452	627	java/lang/Exception
    //   452	470	627	java/lang/Exception
  }
  
  public void jdMethod_if(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.baidu.locsdk.geofence.geofencestrategyservice");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
    if (paramInt <= 0)
    {
      i.a(paramContext, localPendingIntent);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    i.a(paramContext, localPendingIntent, paramInt);
  }
  
  public void jdMethod_if(Context paramContext, Message paramMessage)
  {
    if (this.iY) {
      return;
    }
    this.jg = paramMessage.replyTo;
    this.iY = true;
    this.i8 = new c();
    paramContext.registerReceiver(this.i8, new IntentFilter("com.baidu.locsdk.geofence.geofencestrategyservice"));
    jdMethod_if(paramContext, 0);
  }
  
  public void jdMethod_new(Context paramContext)
  {
    jdMethod_if(paramContext, null);
  }
  
  public void jdMethod_try(Context paramContext)
  {
    this.iY = false;
    i.a(paramContext, PendingIntent.getBroadcast(paramContext, 0, new Intent("com.baidu.locsdk.geofence.geofencestrategyservice"), 134217728));
    cu();
    if (this.i8 != null) {}
    try
    {
      paramContext.unregisterReceiver(this.i8);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private class a
    extends s
  {
    private static final String dQ = "fence";
    private static final String dS = "bloc";
    private static final String dT = "ext";
    private static final String dU = "error";
    private static final String dW = "in";
    private aq dR;
    private final String dV;
    
    public a(aq paramaq, String paramString)
    {
      this.dR = paramaq;
      this.dV = paramString;
      this.cT = new ArrayList();
    }
    
    private void ah()
    {
      a0.jdMethod_if(a0.this, false);
      au.jdMethod_for(f.getServiceContext()).jdMethod_if(this.dR);
      if (a0.jdMethod_char(a0.this) != null)
      {
        Message localMessage = Message.obtain(null, 209);
        Bundle localBundle = new Bundle();
        localBundle.putString("geofence_id", this.dR.getGeofenceId());
        localMessage.setData(localBundle);
        a0.jdMethod_char(a0.this).send(localMessage);
      }
    }
    
    private void aj()
    {
      a0.jdMethod_if(a0.this, false);
      a0.jdMethod_goto(a0.this).put(this.dR.getGeofenceId(), Long.valueOf(System.currentTimeMillis()));
      au.jdMethod_for(f.getServiceContext()).jdMethod_do(this.dR);
      if (a0.jdMethod_char(a0.this) != null)
      {
        Message localMessage = Message.obtain(null, 208);
        Bundle localBundle = new Bundle();
        localBundle.putString("geofence_id", this.dR.getGeofenceId());
        localMessage.setData(localBundle);
        a0.jdMethod_char(a0.this).send(localMessage);
      }
    }
    
    void T()
    {
      this.cR = "http://loc.map.baidu.com/fence";
      Object localObject = new DecimalFormat("0.00000");
      String str1 = ((DecimalFormat)localObject).format(this.dR.a());
      String str2 = ((DecimalFormat)localObject).format(this.dR.jdMethod_case());
      float f = this.dR.jdMethod_do();
      String str3 = String.valueOf(this.dR.jdMethod_int());
      int i = au.jdMethod_do(f.getServiceContext());
      String str4 = a.jdMethod_if(f.getServiceContext());
      int j = this.dR.jdMethod_char();
      if (ar.bW().bZ()) {}
      for (localObject = "1";; localObject = "0")
      {
        localObject = Jni.i(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&fence_type=%s&wf_on=%s", new Object[] { str1, str2, String.valueOf(f), str3, Integer.valueOf(i), str4, Integer.valueOf(j), localObject }));
        this.cT.add(new BasicNameValuePair("fence", (String)localObject));
        this.cT.add(new BasicNameValuePair("bloc", this.dV));
        this.cT.add(new BasicNameValuePair("ext", Jni.i(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[] { v.a(f.getServiceContext()), v.jdMethod_if(f.getServiceContext()) }))));
        return;
      }
    }
    
    public void ai()
    {
      N();
    }
    
    void jdMethod_do(boolean paramBoolean)
    {
      int i = 0;
      a0.jdMethod_do(a0.this, false);
      if ((paramBoolean) && (this.cS != null)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "UTF-8"));
        if (localJSONObject != null)
        {
          int j = Integer.valueOf(localJSONObject.getString("error")).intValue();
          if (localJSONObject.has("in")) {
            i = Integer.valueOf(localJSONObject.getString("in")).intValue();
          }
          if (j == 0)
          {
            a0.jdMethod_do(a0.this, null);
            a0.jdMethod_if(a0.this, null);
            au.jdMethod_for(f.getServiceContext()).b7();
            if (a0.jdMethod_try(a0.this))
            {
              if (i == 1)
              {
                aj();
                return;
              }
              if (i == 0) {
                ah();
              }
            }
            else
            {
              if ((i == 1) && (this.dR.jdMethod_try() == 1))
              {
                aj();
                return;
              }
              if ((i == 0) && (this.dR.jdMethod_try() == 0)) {
                ah();
              }
            }
          }
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private class b
    extends ag
  {
    private b() {}
    
    void at() {}
    
    void jdMethod_byte(Message paramMessage) {}
  }
  
  public class c
    extends BroadcastReceiver
  {
    public c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      a0.jdMethod_if(a0.this, paramContext);
      a0.jdMethod_byte(a0.this).post(a0.jdMethod_if(a0.this));
    }
  }
  
  private class d
    implements b, Runnable
  {
    private d() {}
    
    public void run()
    {
      try
      {
        List localList = a0.jdMethod_for(a0.this, true);
        if ((!a0.jdMethod_for(a0.this).equals(a0.jdMethod_case(a0.this))) || (a0.jdMethod_else(a0.this)) || (!a0.jdMethod_new(a0.this)))
        {
          a0.jdMethod_do(a0.this, a0.jdMethod_for(a0.this));
          a0.jdMethod_if(a0.this, a0.jdMethod_int(a0.this));
          t.a locala = t.an().ak();
          String str = Jni.j(String.format("%s|%s|%s|0", new Object[] { Integer.valueOf(locala.jdField_do), Integer.valueOf(locala.jdField_if), Integer.valueOf(locala.jdField_for) }));
          a0.jdMethod_if(a0.this, String.format("%s|%s|%s|0", new Object[] { Integer.valueOf(locala.jdField_do), Integer.valueOf(locala.jdField_if), Integer.valueOf(locala.jdField_for) }));
          a0.jdMethod_if(a0.this, a0.this.jdMethod_for(str, true));
          a0.jdMethod_do(a0.this, a0.this.jdMethod_for(str, false));
          a0.jdMethod_for(a0.this, localList);
          a0.jdMethod_do(a0.this);
        }
        return;
      }
      catch (Exception localException)
      {
        a0.this.jdMethod_if(f.getServiceContext(), 360000);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */