package com.baidu.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.location.b.a.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class au
  implements ax, n
{
  private static final String h2 = "GeofenceMan";
  private static final int h3 = 3;
  public static final int h4 = 10;
  private static final String h5 = "http://loc.map.baidu.com/fence";
  private static final String h6 = "geofence_id";
  private static final String h7 = ";";
  private static final String h9 = "status_code";
  private static final String i = "GeofenceMan";
  private static au ia;
  private static final int ic = 5;
  private static final int id = 2;
  private static final int ie = 1;
  private static final String ih = "geofence_ids";
  private Context h1;
  private Object h8 = new Object();
  private HandlerThread ib;
  private a ig;
  
  private void b8()
  {
    this.ib = new HandlerThread("GeofenceMan", 10);
    this.ib.start();
    this.ig = new a(this.ib.getLooper());
  }
  
  /* Error */
  private void b9()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/baidu/location/au:h1	Landroid/content/Context;
    //   6: invokestatic 98	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   9: invokevirtual 102	com/baidu/location/m:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +98 -> 112
    //   17: aload_1
    //   18: invokevirtual 107	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   21: invokestatic 113	java/lang/System:currentTimeMillis	()J
    //   24: lstore_3
    //   25: aload_1
    //   26: ldc 115
    //   28: iconst_5
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: ldc 117
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc 119
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc 121
    //   46: aastore
    //   47: dup
    //   48: iconst_3
    //   49: ldc 123
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: lload_3
    //   55: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aastore
    //   59: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 139	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: ldc -115
    //   68: iconst_4
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: ldc 119
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: ldc 121
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: ldc 123
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: lload_3
    //   90: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: aastore
    //   94: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokevirtual 139	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 144	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   104: aload_1
    //   105: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   108: aload_1
    //   109: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: aload_1
    //   121: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   124: goto -12 -> 112
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_1
    //   134: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   137: aload_1
    //   138: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: aload_2
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	au
    //   12	109	1	localSQLiteDatabase	SQLiteDatabase
    //   127	11	1	localObject1	Object
    //   115	1	2	localException	Exception
    //   132	10	2	localObject2	Object
    //   24	66	3	l	long
    // Exception table:
    //   from	to	target	type
    //   21	104	115	java/lang/Exception
    //   2	13	127	finally
    //   17	21	127	finally
    //   104	112	127	finally
    //   116	124	127	finally
    //   133	143	127	finally
    //   21	104	132	finally
  }
  
  private void ca()
  {
    this.ig.sendEmptyMessage(3);
  }
  
  private final void cb()
  {
    if (!s.jdMethod_if(this.h1)) {
      throw new IllegalStateException("Not net connection");
    }
  }
  
  /* Error */
  private long cc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_0
    //   3: lstore 4
    //   5: lload 4
    //   7: lstore_2
    //   8: aload_0
    //   9: getfield 93	com/baidu/location/au:h1	Landroid/content/Context;
    //   12: invokestatic 98	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   15: invokevirtual 172	com/baidu/location/m:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_1
    //   19: lload 4
    //   21: lstore_2
    //   22: aload_1
    //   23: ifnull +24 -> 47
    //   26: lload 4
    //   28: lstore_2
    //   29: aload_1
    //   30: ldc 119
    //   32: invokestatic 178	android/database/DatabaseUtils:queryNumEntries	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)J
    //   35: lstore 4
    //   37: lload 4
    //   39: lstore_2
    //   40: aload_1
    //   41: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   44: lload 4
    //   46: lstore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: lload_2
    //   50: lreturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: goto -10 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	au
    //   18	23	1	localSQLiteDatabase	SQLiteDatabase
    //   51	4	1	localObject	Object
    //   56	1	1	localException	Exception
    //   7	43	2	l1	long
    //   3	42	4	l2	long
    // Exception table:
    //   from	to	target	type
    //   8	19	51	finally
    //   29	37	51	finally
    //   40	44	51	finally
    //   8	19	56	java/lang/Exception
    //   29	37	56	java/lang/Exception
    //   40	44	56	java/lang/Exception
  }
  
  public static int jdMethod_do(Context paramContext)
  {
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    if (paramContext != null)
    {
      if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007"))) {
        return 1;
      }
      if (paramContext.startsWith("46001")) {
        return 2;
      }
      if (paramContext.startsWith("46003")) {
        return 3;
      }
    }
    return 5;
  }
  
  private int jdMethod_do(List paramList)
  {
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = m.a(this.h1).getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.beginTransaction();
          try
          {
            paramList = paramList.iterator();
            if (paramList.hasNext())
            {
              String str = (String)paramList.next();
              String[] arrayOfString = new String[1];
              arrayOfString[0] = str;
              localSQLiteDatabase.delete("geofence", String.format("%s=?", new Object[] { "geofence_id" }), arrayOfString);
              localSQLiteDatabase.delete("geofence_detail", String.format("%s=?", new Object[] { "geofence_id" }), arrayOfString);
              continue;
            }
            paramList = finally;
          }
          catch (Exception paramList)
          {
            localSQLiteDatabase.endTransaction();
            j = 1;
            localSQLiteDatabase.close();
            return j;
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            j = 0;
            continue;
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
        }
        int j = 0;
      }
      finally {}
    }
  }
  
  public static au jdMethod_for(Context paramContext)
  {
    if (ia == null)
    {
      ia = new au();
      ia.b8();
      ia.h1 = paramContext;
    }
    return ia;
  }
  
  private int jdMethod_if(aq paramaq, String paramString)
  {
    int j = 0;
    int k = 0;
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      try
      {
        localSQLiteDatabase = m.a(this.h1).getWritableDatabase();
        long l;
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.beginTransaction();
          l = System.currentTimeMillis();
        }
        try
        {
          Object localObject = new ContentValues();
          String str = paramaq.getGeofenceId();
          ((ContentValues)localObject).put("geofence_id", str);
          ((ContentValues)localObject).put("longitude", Double.valueOf(paramaq.a()));
          ((ContentValues)localObject).put("latitude", Double.valueOf(paramaq.jdMethod_case()));
          ((ContentValues)localObject).put("radius", Float.valueOf(paramaq.jdMethod_do()));
          ((ContentValues)localObject).put("radius_type", Integer.valueOf(paramaq.jdMethod_new()));
          ((ContentValues)localObject).put("valid_date", Long.valueOf(l));
          ((ContentValues)localObject).put("duration_millis", Long.valueOf(paramaq.jdMethod_goto()));
          ((ContentValues)localObject).put("coord_type", paramaq.jdMethod_int());
          if (!paramaq.jdMethod_byte()) {
            break label410;
          }
          j = 1;
          ((ContentValues)localObject).put("is_lac", Integer.valueOf(j));
          if (!paramaq.jdMethod_if()) {
            break label416;
          }
          j = 1;
          ((ContentValues)localObject).put("is_cell", Integer.valueOf(j));
          if (!paramaq.jdMethod_for()) {
            break label422;
          }
          j = 1;
          ((ContentValues)localObject).put("is_wifi", Integer.valueOf(j));
          ((ContentValues)localObject).put("next_active_time", Integer.valueOf(0));
          ((ContentValues)localObject).put("next_exit_active_time", Integer.valueOf(0));
          localSQLiteDatabase.insert("geofence", null, (ContentValues)localObject);
          localObject = paramString.split(";");
          int m = localObject.length;
          j = 0;
          if (j < m)
          {
            paramString = localObject[j];
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("geofence_id", str);
            localContentValues.put("ap_backup", paramString);
            int n = paramString.lastIndexOf("|");
            paramaq = paramString;
            if (n != -1) {
              paramaq = paramString.substring(0, n);
            }
            localContentValues.put("ap", paramaq);
            localSQLiteDatabase.insert("geofence_detail", null, localContentValues);
            j += 1;
            continue;
          }
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          j = k;
        }
        catch (Exception paramaq)
        {
          localSQLiteDatabase.endTransaction();
          j = 1;
          continue;
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
        localSQLiteDatabase.close();
        return j;
      }
      finally {}
      label410:
      j = 0;
      continue;
      label416:
      j = 0;
      continue;
      label422:
      j = 0;
    }
  }
  
  private void jdMethod_if(int paramInt, String paramString, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
  {
    if (paramInt == 1) {}
    paramOnAddBDGeofencesResultListener.onAddBDGeofencesResult(paramInt, paramString);
  }
  
  private void jdMethod_if(int paramInt, String[] paramArrayOfString, GeofenceClient.OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
  {
    paramOnRemoveBDGeofencesResultListener.onRemoveBDGeofencesByRequestIdsResult(paramInt, paramArrayOfString);
  }
  
  private void jdMethod_if(GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener, int paramInt, String paramString)
  {
    Message localMessage = Message.obtain(this.ig);
    localMessage.what = 0;
    localMessage.obj = paramOnAddBDGeofencesResultListener;
    paramOnAddBDGeofencesResultListener = new Bundle();
    paramOnAddBDGeofencesResultListener.putInt("status_code", paramInt);
    paramOnAddBDGeofencesResultListener.putString("geofence_id", paramString);
    localMessage.setData(paramOnAddBDGeofencesResultListener);
    this.ig.sendMessage(localMessage);
  }
  
  public static void jdMethod_int(Context paramContext)
  {
    a0.cq().jdMethod_try(f.getServiceContext());
  }
  
  public void b7()
  {
    synchronized (this.h8)
    {
      this.ig.post(new au.3(this));
      return;
    }
  }
  
  public void jdMethod_do(aq paramaq)
  {
    this.ig.post(new au.1(this, paramaq));
  }
  
  /* Error */
  public void jdMethod_do(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc2_w 443
    //   3: lstore 5
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_1
    //   8: invokestatic 450	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore 11
    //   13: iload 11
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 93	com/baidu/location/au:h1	Landroid/content/Context;
    //   25: invokestatic 98	com/baidu/location/m:a	(Landroid/content/Context;)Lcom/baidu/location/m;
    //   28: invokevirtual 102	com/baidu/location/m:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -15 -> 18
    //   36: new 245	android/content/ContentValues
    //   39: dup
    //   40: invokespecial 246	android/content/ContentValues:<init>	()V
    //   43: astore 4
    //   45: iload_2
    //   46: ifeq +87 -> 133
    //   49: invokestatic 113	java/lang/System:currentTimeMillis	()J
    //   52: lstore 9
    //   54: lload 5
    //   56: lstore 7
    //   58: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   61: lconst_0
    //   62: lcmp
    //   63: ifeq +22 -> 85
    //   66: lload 5
    //   68: lstore 7
    //   70: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   73: ldc2_w 443
    //   76: lcmp
    //   77: ifeq +8 -> 85
    //   80: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   83: lstore 7
    //   85: aload 4
    //   87: ldc_w 326
    //   90: lload 7
    //   92: lload 9
    //   94: ladd
    //   95: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   98: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   101: aload_3
    //   102: ldc 119
    //   104: aload 4
    //   106: ldc_w 456
    //   109: iconst_1
    //   110: anewarray 131	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: invokevirtual 460	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   120: pop
    //   121: aload_3
    //   122: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   125: goto -107 -> 18
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: invokestatic 113	java/lang/System:currentTimeMillis	()J
    //   136: lstore 9
    //   138: lload 5
    //   140: lstore 7
    //   142: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   145: lconst_0
    //   146: lcmp
    //   147: ifeq +22 -> 169
    //   150: lload 5
    //   152: lstore 7
    //   154: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   157: ldc2_w 443
    //   160: lcmp
    //   161: ifeq +8 -> 169
    //   164: invokestatic 454	com/baidu/location/GeofenceClient:d	()J
    //   167: lstore 7
    //   169: aload 4
    //   171: ldc_w 328
    //   174: lload 7
    //   176: lload 9
    //   178: ladd
    //   179: invokestatic 129	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   185: goto -84 -> 101
    //   188: astore_1
    //   189: aload_3
    //   190: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   193: goto -175 -> 18
    //   196: astore_1
    //   197: aload_3
    //   198: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	au
    //   0	203	1	paramString	String
    //   0	203	2	paramBoolean	boolean
    //   31	167	3	localSQLiteDatabase	SQLiteDatabase
    //   43	127	4	localContentValues	ContentValues
    //   3	148	5	l1	long
    //   56	119	7	l2	long
    //   52	125	9	l3	long
    //   11	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	13	128	finally
    //   21	32	128	finally
    //   121	125	128	finally
    //   189	193	128	finally
    //   197	203	128	finally
    //   36	45	188	java/lang/Exception
    //   49	54	188	java/lang/Exception
    //   58	66	188	java/lang/Exception
    //   70	85	188	java/lang/Exception
    //   85	101	188	java/lang/Exception
    //   101	121	188	java/lang/Exception
    //   133	138	188	java/lang/Exception
    //   142	150	188	java/lang/Exception
    //   154	169	188	java/lang/Exception
    //   169	185	188	java/lang/Exception
    //   36	45	196	finally
    //   49	54	196	finally
    //   58	66	196	finally
    //   70	85	196	finally
    //   85	101	196	finally
    //   101	121	196	finally
    //   133	138	196	finally
    //   142	150	196	finally
    //   154	169	196	finally
    //   169	185	196	finally
  }
  
  public void jdMethod_if(aq paramaq)
  {
    this.ig.post(new au.2(this, paramaq));
  }
  
  public void jdMethod_if(aq paramaq, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
  {
    cb();
    an.a(paramOnAddBDGeofencesResultListener, "OnAddBDGeofenceRecesResultListener not provided.");
    if (cc() >= 10L)
    {
      paramOnAddBDGeofencesResultListener.onAddBDGeofencesResult(1001, paramaq.getGeofenceId());
      return;
    }
    new b(paramaq, paramOnAddBDGeofencesResultListener).ag();
    ca();
  }
  
  public void jdMethod_if(List paramList, GeofenceClient.OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      an.jdMethod_if(bool, "geofenceRequestIds can't be null nor empty.");
      an.a(paramOnRemoveBDGeofencesResultListener, "onRemoveBDGeofencesResultListener not provided.");
      this.ig.post(new d(paramList, paramOnRemoveBDGeofencesResultListener));
      return;
    }
  }
  
  private class a
    extends Handler
  {
    public static final int jdField_do = 2;
    public static final int jdField_for = 3;
    public static final int jdField_if = 0;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      int i = paramMessage.what;
      Object localObject = paramMessage.getData();
      switch (i)
      {
      case 1: 
      default: 
        return;
      case 0: 
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("status_code", 1);
        }
        break;
      }
      for (localObject = ((Bundle)localObject).getString("geofence_id");; localObject = null)
      {
        paramMessage = (GeofenceClient.OnAddBDGeofencesResultListener)paramMessage.obj;
        au.jdMethod_if(au.this, i, (String)localObject, paramMessage);
        return;
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("status_code", 1);
        }
        for (localObject = ((Bundle)localObject).getStringArray("geofence_ids");; localObject = null)
        {
          paramMessage = (GeofenceClient.OnRemoveBDGeofencesResultListener)paramMessage.obj;
          au.jdMethod_if(au.this, i, (String[])localObject, paramMessage);
          return;
          au.this.b7();
          return;
          i = 1;
        }
        i = 1;
      }
    }
  }
  
  class b
    extends s
  {
    private static final String dE = "error";
    private static final int dF = -3;
    private static final String dG = "ext";
    private static final String dH = "cl";
    private static final String dI = "fence";
    private static final String dJ = "lac";
    private static final String dL = "wf";
    private static final String dN = "radius";
    private GeofenceClient.OnAddBDGeofencesResultListener dD;
    private int dM;
    private final aq dO;
    
    public b(aq paramaq, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
    {
      this.dO = paramaq;
      this.dD = paramOnAddBDGeofencesResultListener;
      this.cT = new ArrayList();
    }
    
    public void T()
    {
      this.cR = "http://loc.map.baidu.com/fence";
      Object localObject = new DecimalFormat("0.00000");
      localObject = Jni.i(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&sdk=%s", new Object[] { ((DecimalFormat)localObject).format(this.dO.a()), ((DecimalFormat)localObject).format(this.dO.jdMethod_case()), String.valueOf(this.dO.jdMethod_new()), String.valueOf(this.dO.jdMethod_int()), Integer.valueOf(au.jdMethod_do(au.jdMethod_if(au.this))), a.jdMethod_if(au.jdMethod_if(au.this)), Float.valueOf(4.2F) }));
      this.cT.add(new BasicNameValuePair("fence", (String)localObject));
      this.cT.add(new BasicNameValuePair("ext", Jni.i(String.format("&ki=%s&sn=%s", new Object[] { v.a(au.jdMethod_if(au.this)), v.jdMethod_if(au.jdMethod_if(au.this)) }))));
    }
    
    public void ag()
    {
      N();
    }
    
    public void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null))
      {
        Object localObject = null;
        try
        {
          JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.cS, "UTF-8"));
          if (localJSONObject != null)
          {
            localObject = new StringBuilder();
            if (localJSONObject.has("lac"))
            {
              str = localJSONObject.getString("lac");
              if (!TextUtils.isEmpty(str))
              {
                ((StringBuilder)localObject).append(str);
                this.dO.jdMethod_do(true);
              }
            }
            if (localJSONObject.has("cl"))
            {
              str = localJSONObject.getString("cl");
              if (!TextUtils.isEmpty(str))
              {
                ((StringBuilder)localObject).append(str);
                this.dO.a(true);
              }
            }
            if (localJSONObject.has("wf"))
            {
              str = localJSONObject.getString("wf");
              if (!TextUtils.isEmpty(str))
              {
                ((StringBuilder)localObject).append(str);
                this.dO.jdMethod_if(true);
              }
            }
            String str = ((StringBuilder)localObject).toString();
            if (localJSONObject.has("radius"))
            {
              float f = Float.valueOf(localJSONObject.getString("radius")).floatValue();
              this.dO.a(f);
            }
            localObject = str;
            if (localJSONObject.has("error"))
            {
              this.dM = Integer.valueOf(localJSONObject.getString("error")).intValue();
              localObject = str;
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label323;
          }
          if (this.dM == -3)
          {
            au.jdMethod_if(au.this, this.dD, 1002, this.dO.getGeofenceId());
            return;
          }
        }
        catch (Exception localException)
        {
          au.jdMethod_if(au.this, this.dD, 1, this.dO.getGeofenceId());
          return;
        }
        au.jdMethod_if(au.this, this.dD, this.dM, this.dO.getGeofenceId());
        return;
        label323:
        au.jdMethod_do(au.this).post(new au.c(au.this, this.dO, localException, this.dD));
        return;
      }
      au.jdMethod_if(au.this, this.dD, 1, this.dO.getGeofenceId());
    }
  }
  
  private class c
    implements Runnable
  {
    private final aq jdField_do;
    private final GeofenceClient.OnAddBDGeofencesResultListener jdField_for;
    private final String jdField_if;
    
    public c(aq paramaq, String paramString, GeofenceClient.OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
    {
      this.jdField_do = paramaq;
      this.jdField_if = paramString;
      this.jdField_for = paramOnAddBDGeofencesResultListener;
    }
    
    public void run()
    {
      int i = au.jdMethod_if(au.this, this.jdField_do, this.jdField_if);
      au.jdMethod_if(au.this, this.jdField_for, i, this.jdField_do.getGeofenceId());
      if (f.getServiceContext() != null) {
        a0.cq().jdMethod_for(this.jdField_do);
      }
    }
  }
  
  private class d
    implements Runnable
  {
    private final GeofenceClient.OnRemoveBDGeofencesResultListener jdField_do;
    private final List jdField_if;
    
    public d(List paramList, GeofenceClient.OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
    {
      this.jdField_if = paramList;
      this.jdField_do = paramOnRemoveBDGeofencesResultListener;
    }
    
    public void run()
    {
      int i = au.jdMethod_if(au.this, this.jdField_if);
      Message localMessage = Message.obtain(au.jdMethod_do(au.this));
      localMessage.what = 2;
      localMessage.obj = this.jdField_do;
      Bundle localBundle = new Bundle();
      localBundle.putInt("status_code", i);
      localBundle.putStringArray("geofence_ids", (String[])this.jdField_if.toArray(new String[this.jdField_if.size()]));
      localMessage.setData(localBundle);
      au.jdMethod_do(au.this).sendMessage(localMessage);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */