package com.adhoc;

import android.content.Context;
import android.os.Handler;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.adhoc.adhocsdk.OnAdHocReceivedData;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class s
{
  private static s b;
  private static int c = 0;
  public boolean a;
  private long d;
  private Context e;
  private ExperimentFlags f = null;
  private Handler g = null;
  
  private s(Context paramContext)
  {
    try
    {
      this.e = paramContext;
      this.g = new Handler(this.e.getMainLooper());
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  public static s a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new s(paramContext);
      }
      return b;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        fl.a(paramContext);
      }
    }
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = new JSONObject(paramJSONObject.toString());
    JSONObject localJSONObject1;
    if (localJSONObject2 != null)
    {
      localJSONObject1 = localJSONObject2.optJSONObject("flags");
      paramJSONObject = localJSONObject1;
      if (localJSONObject1 != null) {
        fm.a(fm.c(this.e), "adhoc_abtest_flags_auto", localJSONObject1.optString("__autoexperiment__", "{}"));
      }
    }
    for (paramJSONObject = localJSONObject1;; paramJSONObject = null)
    {
      if (paramJSONObject == null) {
        return null;
      }
      paramJSONObject.remove("__autoexperiment__");
      paramJSONObject = localJSONObject2.optJSONArray("experiments");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localJSONObject1 = paramJSONObject.optJSONObject(i);
        JSONArray localJSONArray1 = localJSONObject1.optJSONArray("flags");
        JSONArray localJSONArray2 = new JSONArray();
        int j = 0;
        if (j < localJSONArray1.length())
        {
          JSONObject localJSONObject3 = new JSONObject();
          if ("__autoexperiment__".equals(localJSONArray1.getString(j))) {
            localJSONObject3.put("__autoexperiment__", true);
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject3);
            j += 1;
            break;
            localJSONObject3.put(localJSONArray1.getString(j), false);
          }
        }
        localJSONObject1.put("flags", localJSONArray2);
        i += 1;
      }
      fm.a(fm.c(this.e), "adhoc_abtest_flags", localJSONObject2.toString());
      return localJSONObject2;
    }
  }
  
  private void a(OnAdHocReceivedData paramOnAdHocReceivedData, Handler paramHandler, ExperimentFlags paramExperimentFlags)
  {
    if (paramOnAdHocReceivedData != null) {
      paramHandler.post(new Thread(new u(this, paramOnAdHocReceivedData, paramExperimentFlags)));
    }
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong < c * 1000;
  }
  
  /* Error */
  private ExperimentFlags b()
  {
    // Byte code:
    //   0: new 168	com/adhoc/adhocsdk/ExperimentFlags
    //   3: dup
    //   4: new 64	org/json/JSONObject
    //   7: dup
    //   8: invokespecial 116	org/json/JSONObject:<init>	()V
    //   11: invokespecial 171	com/adhoc/adhocsdk/ExperimentFlags:<init>	(Lorg/json/JSONObject;)V
    //   14: astore_2
    //   15: aload_2
    //   16: getstatic 176	com/adhoc/adhocsdk/ExperimentFlags$a:b	Lcom/adhoc/adhocsdk/ExperimentFlags$a;
    //   19: invokevirtual 177	com/adhoc/adhocsdk/ExperimentFlags$a:toString	()Ljava/lang/String;
    //   22: invokevirtual 180	com/adhoc/adhocsdk/ExperimentFlags:setFlagState	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: invokespecial 182	com/adhoc/s:c	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: ldc -72
    //   37: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: istore 4
    //   42: aload_2
    //   43: astore_1
    //   44: iload 4
    //   46: ifne +33 -> 79
    //   49: aload_2
    //   50: astore_1
    //   51: new 168	com/adhoc/adhocsdk/ExperimentFlags
    //   54: dup
    //   55: new 64	org/json/JSONObject
    //   58: dup
    //   59: aload_3
    //   60: invokespecial 71	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 171	com/adhoc/adhocsdk/ExperimentFlags:<init>	(Lorg/json/JSONObject;)V
    //   66: astore_3
    //   67: aload_3
    //   68: getstatic 186	com/adhoc/adhocsdk/ExperimentFlags$a:a	Lcom/adhoc/adhocsdk/ExperimentFlags$a;
    //   71: invokevirtual 177	com/adhoc/adhocsdk/ExperimentFlags$a:toString	()Ljava/lang/String;
    //   74: invokevirtual 180	com/adhoc/adhocsdk/ExperimentFlags:setFlagState	(Ljava/lang/String;)V
    //   77: aload_3
    //   78: astore_1
    //   79: aload_1
    //   80: areturn
    //   81: astore_1
    //   82: aload_2
    //   83: astore_1
    //   84: ldc -68
    //   86: invokestatic 190	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: areturn
    //   91: astore_2
    //   92: aload_2
    //   93: invokestatic 51	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: aload_3
    //   100: astore_1
    //   101: goto -9 -> 92
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto -25 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	s
    //   26	54	1	localObject1	Object
    //   81	1	1	localJSONException1	org.json.JSONException
    //   83	18	1	localObject2	Object
    //   104	1	1	localJSONException2	org.json.JSONException
    //   14	76	2	localExperimentFlags	ExperimentFlags
    //   91	2	2	localThrowable1	Throwable
    //   98	1	2	localThrowable2	Throwable
    //   106	1	2	localObject3	Object
    //   31	75	3	localObject4	Object
    //   40	5	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   51	67	81	org/json/JSONException
    //   27	32	91	java/lang/Throwable
    //   34	42	91	java/lang/Throwable
    //   51	67	91	java/lang/Throwable
    //   84	89	91	java/lang/Throwable
    //   67	77	98	java/lang/Throwable
    //   67	77	104	org/json/JSONException
  }
  
  private long c(Context paramContext)
  {
    return fm.c(fm.c(paramContext), "get_flag_timestamp");
  }
  
  private String c()
  {
    return fm.a(fm.c(this.e), "adhoc_abtest_flags");
  }
  
  private void d(Context paramContext)
  {
    try
    {
      if (!fm.a(paramContext)) {
        return;
      }
      this.a = false;
      this.d = System.currentTimeMillis();
      fm.a(fm.c(paramContext), "get_flag_timestamp", System.currentTimeMillis());
      paramContext = m.a(this.e).a();
      paramContext = bl.a(bf.a("application/json; charset=utf-8"), paramContext.toString());
      paramContext = new bj.a().a("https://experiment.appadhoc.com/get_flags_async").a(paramContext).a();
      fk.a().a(paramContext, new v(this));
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  public void a()
  {
    c = fm.b(fm.c(this.e), "get_flag_gap_time");
    this.d = c(this.e);
    if (!a(this.d))
    {
      d(this.e);
      return;
    }
    fl.a("网络获取flag失败，时间间隔是" + c + "秒" + "duration is : " + (System.currentTimeMillis() - this.d));
  }
  
  public void a(int paramInt)
  {
    c = paramInt;
    fm.a(fm.c(this.e), "get_flag_gap_time", paramInt);
  }
  
  public void a(int paramInt, OnAdHocReceivedData paramOnAdHocReceivedData)
  {
    try
    {
      if (!fm.a(this.e))
      {
        this.f = b();
        fl.b("取本地flags 结果：" + this.f);
      }
      fl.a("超时时间:" + paramInt);
      long l = paramInt / 3;
      Object localObject = m.a(this.e).a().toString();
      bg localbg = new bg();
      localbg.a(l, TimeUnit.MILLISECONDS);
      localbg.c(l, TimeUnit.MILLISECONDS);
      localbg.b(l, TimeUnit.MILLISECONDS);
      localObject = bl.a(bf.a("application/json; charset=utf-8"), ((String)localObject).toString());
      localbg.a(new bj.a().a("https://experiment.appadhoc.com/get_flags_async").a((bl)localObject).a()).a(new t(this, paramInt, paramOnAdHocReceivedData));
      return;
    }
    catch (Throwable paramOnAdHocReceivedData)
    {
      fl.a(paramOnAdHocReceivedData);
      return;
    }
    finally
    {
      fl.a("client set null");
    }
  }
  
  public void a(OnAdHocReceivedData paramOnAdHocReceivedData)
  {
    a(n.a, paramOnAdHocReceivedData);
  }
  
  public ExperimentFlags b(Context paramContext)
  {
    ExperimentFlags localExperimentFlags = b();
    String str2 = "null";
    String str1 = str2;
    if (localExperimentFlags != null)
    {
      str1 = str2;
      if (localExperimentFlags.getRawFlags() != null) {
        str1 = localExperimentFlags.getRawFlags().toString();
      }
    }
    fl.a("取本地flags 结果：" + str1);
    boolean bool = a(this.d);
    if ((this.a) && (!bool))
    {
      d(paramContext);
      return localExperimentFlags;
    }
    this.a = false;
    fl.a("网络获取flag失败，当前时间间隔是" + c + "秒" + "duration is : " + (System.currentTimeMillis() - this.d));
    return localExperimentFlags;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */