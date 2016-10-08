package com.f.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import d.a.av;
import d.a.aw;
import d.a.ax;
import d.a.cn;
import d.a.z;
import d.a.z.a;
import d.a.z.b;
import d.a.z.c;
import d.a.z.d;
import d.a.z.e;
import d.a.z.f;
import d.a.z.g;
import d.a.z.h;
import d.a.z.i;
import d.a.z.j;
import d.a.z.k;
import d.a.z.l;
import d.a.z.m;
import d.a.z.n;
import d.a.z.o;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
{
  private static o a = null;
  private static Context b;
  private static String c;
  private static long e = 1209600000L;
  private static long f = 2097152L;
  private a d;
  
  public o(Context paramContext)
  {
    this.d = new a(paramContext);
  }
  
  public static o a(Context paramContext)
  {
    try
    {
      b = paramContext.getApplicationContext();
      c = paramContext.getPackageName();
      if (a == null) {
        a = new o(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(z paramz, JSONObject paramJSONObject, StringBuilder paramStringBuilder)
  {
    paramJSONObject.put("appkey", paramz.a.a);
    paramJSONObject.put("channel", paramz.a.b);
    if (paramz.a.c != null) {
      paramJSONObject.put("secret", paramz.a.c);
    }
    paramJSONObject.put("app_version", paramz.a.d);
    paramJSONObject.put("display_name", paramz.a.g);
    paramJSONObject.put("package_name", paramz.a.e);
    paramJSONObject.put("app_signature", paramz.a.f);
    paramJSONObject.put("version_code", paramz.a.h);
    paramJSONObject.put("wrapper_type", paramz.a.i);
    paramJSONObject.put("wrapper_version", paramz.a.j);
    paramJSONObject.put("sdk_type", paramz.a.k);
    paramJSONObject.put("sdk_version", paramz.a.l);
    paramJSONObject.put("vertical_type", paramz.a.m);
    paramJSONObject.put("idmd5", paramz.a.n);
    paramJSONObject.put("cpu", paramz.a.o);
    paramJSONObject.put("os", paramz.a.p);
    paramJSONObject.put("os_version", paramz.a.q);
    paramJSONObject.put("resolution", paramz.a.r);
    paramJSONObject.put("mc", paramz.a.s);
    paramJSONObject.put("device_id", paramz.a.t);
    paramJSONObject.put("device_model", paramz.a.u);
    paramJSONObject.put("device_board", paramz.a.v);
    paramJSONObject.put("device_brand", paramz.a.w);
    paramJSONObject.put("device_manutime", paramz.a.x);
    paramJSONObject.put("device_manufacturer", paramz.a.y);
    paramJSONObject.put("device_manuid", paramz.a.z);
    paramJSONObject.put("device_name", paramz.a.A);
    if (paramz.a.B != null) {
      paramJSONObject.put("sub_os_name", paramz.a.B);
    }
    if (paramz.a.C != null) {
      paramJSONObject.put("sub_os_version", paramz.a.C);
    }
    paramJSONObject.put("timezone", paramz.a.D);
    paramJSONObject.put("language", paramz.a.E);
    paramJSONObject.put("country", paramz.a.F);
    paramJSONObject.put("carrier", paramz.a.G);
    paramJSONObject.put("access", paramz.a.H);
    paramJSONObject.put("access_subtype", paramz.a.I);
    if (paramz.a.J == null) {}
    for (String str = "";; str = paramz.a.J)
    {
      paramJSONObject.put("mccmnc", str);
      paramJSONObject.put("successful_requests", paramz.a.K);
      paramJSONObject.put("failed_requests", paramz.a.L);
      paramJSONObject.put("req_time", paramz.a.M);
      paramJSONObject.put("imprint", paramz.a.N);
      paramJSONObject.put("id_tracking", paramz.a.O);
      paramStringBuilder.append("sdk_version:").append(paramz.a.l).append(";device_id:").append(paramz.a.t).append(";device_manufacturer:").append(paramz.a.y).append(";device_board:").append(paramz.a.v).append(";device_brand:").append(paramz.a.w).append(";os_version:").append(paramz.a.q);
      return;
    }
  }
  
  private static boolean a(File paramFile)
  {
    long l = paramFile.length();
    if ((paramFile.exists()) && (l > f))
    {
      cn.a(b).a(l, System.currentTimeMillis(), "__data_size_of");
      return true;
    }
    return false;
  }
  
  private void b(z paramz, JSONObject paramJSONObject, StringBuilder paramStringBuilder)
  {
    Object localObject1 = new JSONObject();
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    Object localObject6;
    int i;
    Object localObject7;
    JSONObject localJSONObject;
    if ((paramz.b.h != null) && (paramz.b.h.a != null) && (paramz.b.h.a.size() > 0))
    {
      localObject2 = new JSONObject();
      localObject3 = paramz.b.h.a.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = (String)((Map.Entry)localObject5).getKey();
        localObject5 = (List)((Map.Entry)localObject5).getValue();
        localObject6 = new JSONArray();
        i = 0;
        while (i < ((List)localObject5).size())
        {
          localObject7 = (z.d)((List)localObject5).get(i);
          localJSONObject = new JSONObject();
          localJSONObject.put("v_sum", ((z.d)localObject7).a);
          localJSONObject.put("ts_sum", ((z.d)localObject7).b);
          localJSONObject.put("tw_num", ((z.d)localObject7).c);
          localJSONObject.put("count", ((z.d)localObject7).d);
          localJSONObject.put("labels", new JSONArray(((z.d)localObject7).e));
          ((JSONArray)localObject6).put(localJSONObject);
          i += 1;
        }
        ((JSONObject)localObject2).put((String)localObject4, localObject6);
      }
      ((JSONObject)localObject1).put("ag", localObject2);
    }
    if ((paramz.b.h != null) && (paramz.b.h.b != null) && (paramz.b.h.b.size() > 0))
    {
      localObject2 = new JSONObject();
      localObject3 = paramz.b.h.b.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = (String)((Map.Entry)localObject5).getKey();
        localObject5 = (List)((Map.Entry)localObject5).getValue();
        localObject6 = new JSONArray();
        i = 0;
        while (i < ((List)localObject5).size())
        {
          localObject7 = (z.e)((List)localObject5).get(i);
          localJSONObject = new JSONObject();
          localJSONObject.put("value", ((z.e)localObject7).a);
          localJSONObject.put("ts", ((z.e)localObject7).b);
          localJSONObject.put("label", ((z.e)localObject7).c);
          ((JSONArray)localObject6).put(localJSONObject);
          i += 1;
        }
        ((JSONObject)localObject2).put((String)localObject4, localObject6);
      }
      ((JSONObject)localObject1).put("ve_meta", localObject2);
    }
    if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
    {
      paramJSONObject.put("cc", localObject1);
      paramStringBuilder.append("; cc: ").append(((JSONObject)localObject1).toString());
    }
    int j;
    if ((paramz.b.a != null) && (paramz.b.a.size() > 0))
    {
      localObject1 = new JSONArray();
      i = 0;
      while (i < paramz.b.a.size())
      {
        localObject2 = (z.g)paramz.b.a.get(i);
        localObject3 = new JSONArray();
        j = 0;
        while (j < ((z.g)localObject2).b.size())
        {
          localObject4 = new JSONObject();
          localObject5 = (z.i)((z.g)localObject2).b.get(j);
          ((JSONObject)localObject4).put("id", ((z.i)localObject5).c);
          ((JSONObject)localObject4).put("ts", ((z.i)localObject5).d);
          ((JSONObject)localObject4).put("du", ((z.i)localObject5).e);
          localObject5 = ((z.i)localObject5).f.entrySet().iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Map.Entry)((Iterator)localObject5).next();
            localObject7 = ((Map.Entry)localObject6).getValue();
            if (((localObject7 instanceof String)) || ((localObject7 instanceof Integer)) || ((localObject7 instanceof Long))) {
              ((JSONObject)localObject4).put((String)((Map.Entry)localObject6).getKey(), ((Map.Entry)localObject6).getValue());
            }
          }
          ((JSONArray)localObject3).put(localObject4);
          j += 1;
        }
        if ((((z.g)localObject2).a != null) && (localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put(((z.g)localObject2).a, localObject3);
          ((JSONArray)localObject1).put(localObject4);
        }
        i += 1;
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        paramJSONObject.put("ekv", localObject1);
        paramStringBuilder.append(";ekv:").append(((JSONArray)localObject1).toString());
      }
    }
    if ((paramz.b.b != null) && (paramz.b.b.size() > 0))
    {
      localObject1 = new JSONArray();
      i = 0;
      while (i < paramz.b.b.size())
      {
        localObject2 = (z.g)paramz.b.b.get(i);
        localObject3 = new JSONArray();
        j = 0;
        while (j < ((z.g)localObject2).b.size())
        {
          localObject5 = (z.i)((z.g)localObject2).b.get(j);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("id", ((z.i)localObject5).c);
          ((JSONObject)localObject4).put("ts", ((z.i)localObject5).d);
          ((JSONObject)localObject4).put("du", ((z.i)localObject5).e);
          localObject5 = ((z.i)localObject5).f.entrySet().iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (Map.Entry)((Iterator)localObject5).next();
            localObject7 = ((Map.Entry)localObject6).getValue();
            if (((localObject7 instanceof String)) || ((localObject7 instanceof Integer)) || ((localObject7 instanceof Long))) {
              ((JSONObject)localObject4).put((String)((Map.Entry)localObject6).getKey(), ((Map.Entry)localObject6).getValue());
            }
          }
          ((JSONArray)localObject3).put(localObject4);
          j += 1;
        }
        if ((((z.g)localObject2).a != null) && (localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put(((z.g)localObject2).a, localObject3);
          ((JSONArray)localObject1).put(localObject4);
        }
        i += 1;
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        paramJSONObject.put("gkv", localObject1);
        paramStringBuilder.append("; gkv:").append(((JSONArray)localObject1).toString());
      }
    }
    if ((paramz.b.i != null) && (paramz.b.i.size() > 0))
    {
      localObject1 = new JSONArray();
      i = 0;
      while (i < paramz.b.i.size())
      {
        localObject2 = (z.h)paramz.b.i.get(i);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ts", ((z.h)localObject2).a);
        ((JSONObject)localObject3).put("error_source", ((z.h)localObject2).b);
        ((JSONObject)localObject3).put("context", ((z.h)localObject2).c);
        ((JSONArray)localObject1).put(localObject3);
        i += 1;
      }
      paramJSONObject.put("error", localObject1);
    }
    if ((paramz.b.c != null) && (paramz.b.c.size() > 0))
    {
      localObject1 = new JSONArray();
      i = 0;
      while (i < paramz.b.c.size())
      {
        localObject2 = (z.n)paramz.b.c.get(i);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("id", ((z.n)localObject2).b);
        ((JSONObject)localObject3).put("start_time", ((z.n)localObject2).c);
        ((JSONObject)localObject3).put("end_time", ((z.n)localObject2).d);
        ((JSONObject)localObject3).put("duration", ((z.n)localObject2).e);
        if ((((z.n)localObject2).i.a != 0L) || (((z.n)localObject2).i.b != 0L))
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("download_traffic", ((z.n)localObject2).i.a);
          ((JSONObject)localObject4).put("upload_traffic", ((z.n)localObject2).i.b);
          ((JSONObject)localObject3).put("traffic", localObject4);
        }
        if (((z.n)localObject2).h.size() > 0)
        {
          localObject4 = new JSONArray();
          localObject5 = ((z.n)localObject2).h.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (z.k)((Iterator)localObject5).next();
            localObject7 = new JSONObject();
            ((JSONObject)localObject7).put("page_name", ((z.k)localObject6).a);
            ((JSONObject)localObject7).put("duration", ((z.k)localObject6).b);
            ((JSONArray)localObject4).put(localObject7);
          }
          ((JSONObject)localObject3).put("pages", localObject4);
        }
        if (((z.n)localObject2).j.c != 0L)
        {
          localObject4 = new JSONArray();
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("lat", ((z.n)localObject2).j.a);
          ((JSONObject)localObject5).put("lng", ((z.n)localObject2).j.b);
          ((JSONObject)localObject5).put("ts", ((z.n)localObject2).j.c);
          ((JSONArray)localObject4).put(localObject5);
          ((JSONObject)localObject3).put("locations", localObject4);
        }
        ((JSONArray)localObject1).put(localObject3);
        i += 1;
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        paramJSONObject.put("sessions", localObject1);
        paramStringBuilder.append("; sessions:").append(((JSONArray)localObject1).toString());
      }
    }
    if (paramz.b.d.a != 0L)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("ts", paramz.b.d.a);
      if (((JSONObject)localObject1).length() > 0)
      {
        paramJSONObject.put("activate_msg", localObject1);
        paramStringBuilder.append("; active_msg: ").append(((JSONObject)localObject1).toString());
      }
    }
    if (paramz.b.e.c)
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("interval", paramz.b.e.b);
      ((JSONObject)localObject2).put("latency", paramz.b.e.a);
      ((JSONObject)localObject1).put("latent", localObject2);
      if (((JSONObject)localObject1).length() > 0)
      {
        paramJSONObject.put("control_policy", localObject1);
        paramStringBuilder.append("; control_policy: ").append(((JSONObject)localObject1).toString());
      }
    }
    if (paramz.b.f.size() > 0)
    {
      localObject1 = new JSONObject();
      localObject2 = paramz.b.f.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put((String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
      }
      paramJSONObject.put("group_info", localObject1);
    }
    if ((paramz.b.g.a != null) || (paramz.b.g.b != null))
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("provider", paramz.b.g.a);
      ((JSONObject)localObject1).put("puid", paramz.b.g.b);
      if (((JSONObject)localObject1).length() > 0)
      {
        paramJSONObject.put("active_user", localObject1);
        paramStringBuilder.append("; active_user: ").append(((JSONObject)localObject1).toString());
      }
    }
    if (paramz.b.j != null) {
      paramJSONObject.put("userlevel", paramz.b.j);
    }
  }
  
  private SharedPreferences j()
  {
    return b.getSharedPreferences("mobclick_agent_user_" + c, 0);
  }
  
  private String k()
  {
    return "mobclick_agent_header_" + c;
  }
  
  private String l()
  {
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("versioncode", 0);
      int j = Integer.parseInt(av.a(b));
      if ((i != 0) && (j != i)) {
        return "mobclick_agent_cached_" + c + i;
      }
      return "mobclick_agent_cached_" + c + av.a(b);
    }
    return "mobclick_agent_cached_" + c + av.a(b);
  }
  
  void a(int paramInt)
  {
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("vt", paramInt).commit();
    }
  }
  
  /* Error */
  public void a(z paramz)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokespecial 662	com/f/a/o:l	()Ljava/lang/String;
    //   6: astore_3
    //   7: new 299	java/io/File
    //   10: dup
    //   11: getstatic 49	com/f/a/o:b	Landroid/content/Context;
    //   14: invokevirtual 47	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 666	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 669	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: aload_3
    //   24: invokespecial 672	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_3
    //   28: new 674	java/io/FileOutputStream
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 677	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_3
    //   37: new 679	java/io/ObjectOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 682	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 686	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   51: aload_2
    //   52: invokevirtual 689	java/io/ObjectOutputStream:flush	()V
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 692	java/io/ObjectOutputStream:close	()V
    //   63: aload_3
    //   64: ifnull +7 -> 71
    //   67: aload_3
    //   68: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   77: goto -14 -> 63
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   85: return
    //   86: astore_3
    //   87: aconst_null
    //   88: astore 4
    //   90: aload_2
    //   91: astore_1
    //   92: aload 4
    //   94: astore_2
    //   95: aload_3
    //   96: invokestatic 701	d/a/ax:a	(Ljava/lang/Throwable;)V
    //   99: aload_3
    //   100: invokevirtual 702	java/lang/Exception:printStackTrace	()V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 692	java/io/ObjectOutputStream:close	()V
    //   111: aload_1
    //   112: ifnull -41 -> 71
    //   115: aload_1
    //   116: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   119: return
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   125: return
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   131: goto -20 -> 111
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 692	java/io/ObjectOutputStream:close	()V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 693	java/io/FileOutputStream:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: aload_2
    //   159: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   162: goto -15 -> 147
    //   165: astore_2
    //   166: aload_2
    //   167: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   170: goto -15 -> 155
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_2
    //   176: goto -37 -> 139
    //   179: astore_1
    //   180: goto -41 -> 139
    //   183: astore 4
    //   185: aload_1
    //   186: astore_3
    //   187: aload 4
    //   189: astore_1
    //   190: goto -51 -> 139
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_3
    //   198: astore_1
    //   199: aload 4
    //   201: astore_3
    //   202: goto -107 -> 95
    //   205: astore 4
    //   207: aload_3
    //   208: astore_1
    //   209: aload 4
    //   211: astore_3
    //   212: goto -117 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	o
    //   0	215	1	paramz	z
    //   1	107	2	localObject1	Object
    //   126	2	2	localIOException1	java.io.IOException
    //   136	8	2	localObject2	Object
    //   157	2	2	localIOException2	java.io.IOException
    //   165	2	2	localIOException3	java.io.IOException
    //   175	22	2	localObject3	Object
    //   6	62	3	localObject4	Object
    //   86	14	3	localException1	Exception
    //   138	74	3	localObject5	Object
    //   88	5	4	localObject6	Object
    //   183	5	4	localObject7	Object
    //   193	7	4	localException2	Exception
    //   205	5	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   59	63	72	java/io/IOException
    //   67	71	80	java/io/IOException
    //   28	37	86	java/lang/Exception
    //   115	119	120	java/io/IOException
    //   107	111	126	java/io/IOException
    //   28	37	134	finally
    //   143	147	157	java/io/IOException
    //   151	155	165	java/io/IOException
    //   37	46	173	finally
    //   46	55	179	finally
    //   95	103	183	finally
    //   37	46	193	java/lang/Exception
    //   46	55	205	java/lang/Exception
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("appkey", paramString).commit();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte);
  }
  
  public String[] a()
  {
    Object localObject2 = null;
    Object localObject1 = j();
    String str1 = ((SharedPreferences)localObject1).getString("au_p", null);
    String str2 = ((SharedPreferences)localObject1).getString("au_u", null);
    localObject1 = localObject2;
    if (str1 != null)
    {
      localObject1 = localObject2;
      if (str2 != null)
      {
        localObject1 = new String[2];
        localObject1[0] = str1;
        localObject1[1] = str2;
      }
    }
    return (String[])localObject1;
  }
  
  String b()
  {
    String str = null;
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("appkey", null);
    }
    return str;
  }
  
  public byte[] b(z paramz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localJSONObject.put("header", new q(this, paramz, localStringBuilder));
      paramz = new r(this, paramz, localStringBuilder);
      if (paramz.length() > 0) {
        localJSONObject.put("body", paramz);
      }
      ax.a("serialize entry:" + String.valueOf(localStringBuilder));
      paramz = String.valueOf(localJSONObject).getBytes();
      return paramz;
    }
    catch (Exception paramz)
    {
      ax.b("Fail to serialize log ...", paramz);
    }
    return null;
  }
  
  String c()
  {
    String str = null;
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("st", null);
    }
    return str;
  }
  
  int d()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = d.a.t.a(b);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("vt", 0);
    }
    return i;
  }
  
  /* Error */
  public z e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 662	com/f/a/o:l	()Ljava/lang/String;
    //   4: astore_1
    //   5: new 299	java/io/File
    //   8: dup
    //   9: getstatic 49	com/f/a/o:b	Landroid/content/Context;
    //   12: invokevirtual 47	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokevirtual 666	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 669	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: aload_1
    //   22: invokespecial 672	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokestatic 756	com/f/a/o:a	(Ljava/io/File;)Z
    //   30: ifeq +10 -> 40
    //   33: aload_1
    //   34: invokevirtual 759	java/io/File:delete	()Z
    //   37: pop
    //   38: aconst_null
    //   39: areturn
    //   40: aload_1
    //   41: invokevirtual 307	java/io/File:exists	()Z
    //   44: istore 6
    //   46: iload 6
    //   48: ifeq +226 -> 274
    //   51: new 761	java/io/FileInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 762	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_2
    //   60: new 764	java/io/ObjectInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 767	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_1
    //   69: aload_1
    //   70: astore 4
    //   72: aload_2
    //   73: astore_3
    //   74: aload_1
    //   75: invokevirtual 770	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   78: checkcast 64	d/a/z
    //   81: astore 5
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 771	java/io/ObjectInputStream:close	()V
    //   91: aload 5
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull +10 -> 105
    //   98: aload_2
    //   99: invokevirtual 772	java/io/FileInputStream:close	()V
    //   102: aload 5
    //   104: astore_1
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   112: goto -21 -> 91
    //   115: astore_3
    //   116: aload 5
    //   118: astore_2
    //   119: aload_2
    //   120: astore_1
    //   121: getstatic 774	d/a/ax:a	Z
    //   124: ifeq -19 -> 105
    //   127: aload_3
    //   128: invokestatic 701	d/a/ax:a	(Ljava/lang/Throwable;)V
    //   131: aload_2
    //   132: astore_1
    //   133: goto -28 -> 105
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   141: aload 5
    //   143: astore_1
    //   144: goto -39 -> 105
    //   147: astore 5
    //   149: aconst_null
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_1
    //   154: astore 4
    //   156: aload_2
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 702	java/lang/Exception:printStackTrace	()V
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 771	java/io/ObjectInputStream:close	()V
    //   171: aload_2
    //   172: ifnull +97 -> 269
    //   175: aload_2
    //   176: invokevirtual 772	java/io/FileInputStream:close	()V
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -76 -> 105
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   189: goto -18 -> 171
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -94 -> 105
    //   202: astore_1
    //   203: aconst_null
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_2
    //   208: aload 4
    //   210: ifnull +8 -> 218
    //   213: aload 4
    //   215: invokevirtual 771	java/io/ObjectInputStream:close	()V
    //   218: aload_2
    //   219: ifnull +7 -> 226
    //   222: aload_2
    //   223: invokevirtual 772	java/io/FileInputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_3
    //   229: aload_3
    //   230: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   233: goto -15 -> 218
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 696	java/io/IOException:printStackTrace	()V
    //   241: goto -15 -> 226
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 4
    //   248: goto -40 -> 208
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: goto -46 -> 208
    //   257: astore 5
    //   259: aconst_null
    //   260: astore_1
    //   261: goto -108 -> 153
    //   264: astore 5
    //   266: goto -113 -> 153
    //   269: aconst_null
    //   270: astore_1
    //   271: goto -166 -> 105
    //   274: aconst_null
    //   275: areturn
    //   276: astore_3
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -160 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	o
    //   4	102	1	localObject1	Object
    //   107	2	1	localIOException1	java.io.IOException
    //   120	13	1	localObject2	Object
    //   136	2	1	localIOException2	java.io.IOException
    //   143	38	1	localObject3	Object
    //   184	2	1	localIOException3	java.io.IOException
    //   192	2	1	localIOException4	java.io.IOException
    //   198	1	1	localObject4	Object
    //   202	25	1	localObject5	Object
    //   244	1	1	localObject6	Object
    //   251	1	1	localObject7	Object
    //   260	11	1	localObject8	Object
    //   59	164	2	localObject9	Object
    //   236	2	2	localIOException5	java.io.IOException
    //   253	26	2	localObject10	Object
    //   73	1	3	localObject11	Object
    //   115	13	3	localException1	Exception
    //   157	1	3	localObject12	Object
    //   228	25	3	localIOException6	java.io.IOException
    //   276	1	3	localException2	Exception
    //   70	177	4	localObject13	Object
    //   81	61	5	localz	z
    //   147	12	5	localException3	Exception
    //   257	1	5	localException4	Exception
    //   264	1	5	localException5	Exception
    //   44	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   87	91	107	java/io/IOException
    //   87	91	115	java/lang/Exception
    //   98	102	115	java/lang/Exception
    //   108	112	115	java/lang/Exception
    //   137	141	115	java/lang/Exception
    //   98	102	136	java/io/IOException
    //   51	60	147	java/lang/Exception
    //   167	171	184	java/io/IOException
    //   175	179	192	java/io/IOException
    //   51	60	202	finally
    //   213	218	228	java/io/IOException
    //   222	226	236	java/io/IOException
    //   60	69	244	finally
    //   74	83	251	finally
    //   158	163	251	finally
    //   60	69	257	java/lang/Exception
    //   74	83	264	java/lang/Exception
    //   0	38	276	java/lang/Exception
    //   40	46	276	java/lang/Exception
    //   167	171	276	java/lang/Exception
    //   175	179	276	java/lang/Exception
    //   185	189	276	java/lang/Exception
    //   193	197	276	java/lang/Exception
    //   213	218	276	java/lang/Exception
    //   222	226	276	java/lang/Exception
    //   226	228	276	java/lang/Exception
    //   229	233	276	java/lang/Exception
    //   237	241	276	java/lang/Exception
  }
  
  public void f()
  {
    b.deleteFile(k());
    b.deleteFile(l());
    cn.a(b).d(new p(this));
  }
  
  public boolean g()
  {
    return this.d.a();
  }
  
  public a h()
  {
    return this.d;
  }
  
  public static class a
  {
    private final int a = 10;
    private File b;
    private FilenameFilter c = new t(this);
    
    public a(Context paramContext)
    {
      this(paramContext, ".um");
    }
    
    public a(Context paramContext, String paramString)
    {
      this.b = new File(paramContext.getFilesDir(), paramString);
      if ((!this.b.exists()) || (!this.b.isDirectory())) {
        this.b.mkdir();
      }
    }
    
    /* Error */
    public void a(o.b paramb)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aload_0
      //   4: getfield 45	com/f/a/o$a:b	Ljava/io/File;
      //   7: aload_0
      //   8: getfield 32	com/f/a/o$a:c	Ljava/io/FilenameFilter;
      //   11: invokevirtual 62	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
      //   14: astore_2
      //   15: aload_2
      //   16: ifnull +61 -> 77
      //   19: aload_2
      //   20: arraylength
      //   21: bipush 10
      //   23: if_icmplt +54 -> 77
      //   26: aload_2
      //   27: invokestatic 68	java/util/Arrays:sort	([Ljava/lang/Object;)V
      //   30: aload_2
      //   31: arraylength
      //   32: bipush 10
      //   34: isub
      //   35: istore 6
      //   37: new 70	com/f/a/s
      //   40: dup
      //   41: aload_0
      //   42: iload 6
      //   44: invokespecial 73	com/f/a/s:<init>	(Lcom/f/a/o$a;I)V
      //   47: invokestatic 78	com/f/a/m:b	(Ljava/lang/Runnable;)V
      //   50: iconst_0
      //   51: istore 4
      //   53: iload 4
      //   55: iload 6
      //   57: if_icmpge +20 -> 77
      //   60: aload_2
      //   61: iload 4
      //   63: aaload
      //   64: invokevirtual 81	java/io/File:delete	()Z
      //   67: pop
      //   68: iload 4
      //   70: iconst_1
      //   71: iadd
      //   72: istore 4
      //   74: goto -21 -> 53
      //   77: aload_2
      //   78: ifnull +92 -> 170
      //   81: aload_2
      //   82: arraylength
      //   83: ifle +87 -> 170
      //   86: aload_1
      //   87: aload_0
      //   88: getfield 45	com/f/a/o$a:b	Ljava/io/File;
      //   91: invokeinterface 86 2 0
      //   96: aload_2
      //   97: arraylength
      //   98: istore 6
      //   100: iload 5
      //   102: istore 4
      //   104: iload 4
      //   106: iload 6
      //   108: if_icmpge +52 -> 160
      //   111: aload_1
      //   112: aload_2
      //   113: iload 4
      //   115: aaload
      //   116: invokeinterface 89 2 0
      //   121: istore 7
      //   123: iload 7
      //   125: ifeq +11 -> 136
      //   128: aload_2
      //   129: iload 4
      //   131: aaload
      //   132: invokevirtual 81	java/io/File:delete	()Z
      //   135: pop
      //   136: iload 4
      //   138: iconst_1
      //   139: iadd
      //   140: istore 4
      //   142: goto -38 -> 104
      //   145: astore_3
      //   146: aload_2
      //   147: iload 4
      //   149: aaload
      //   150: invokevirtual 81	java/io/File:delete	()Z
      //   153: pop
      //   154: goto -18 -> 136
      //   157: astore_1
      //   158: aload_1
      //   159: athrow
      //   160: aload_1
      //   161: aload_0
      //   162: getfield 45	com/f/a/o$a:b	Ljava/io/File;
      //   165: invokeinterface 91 2 0
      //   170: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	171	0	this	a
      //   0	171	1	paramb	o.b
      //   14	133	2	arrayOfFile	File[]
      //   145	1	3	localThrowable	Throwable
      //   51	97	4	i	int
      //   1	100	5	j	int
      //   35	74	6	k	int
      //   121	3	7	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   111	123	145	java/lang/Throwable
      //   111	123	157	finally
    }
    
    public void a(byte[] paramArrayOfByte)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
        return;
      }
      Object localObject = String.format(Locale.US, "um_cache_%d.env", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      localObject = new File(this.b, (String)localObject);
      try
      {
        aw.a((File)localObject, paramArrayOfByte);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    
    public boolean a()
    {
      File[] arrayOfFile = this.b.listFiles();
      return (arrayOfFile != null) && (arrayOfFile.length > 0);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(File paramFile);
    
    public abstract boolean b(File paramFile);
    
    public abstract void c(File paramFile);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */