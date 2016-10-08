package com.adhoc;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q
{
  private static q a = null;
  private Context b;
  private HashMap<String, p> c = new HashMap();
  private HashMap<String, p> d = new HashMap();
  
  public static q a()
  {
    if (a == null) {
      a = new q();
    }
    return a;
  }
  
  private p b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    p localp;
    for (;;)
    {
      return null;
      fl.a(paramJSONObject.toString());
      try
      {
        localJSONArray = paramJSONObject.getJSONArray("flags");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          localp = new p();
          localObject2 = paramJSONObject.optString("id");
          str = paramJSONObject.optString("name");
          localp.c((String)localObject2);
          localp.a(str);
          this.d.put(localObject2, localp);
          i = 0;
          if (i >= j) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            JSONArray localJSONArray;
            int i;
            Object localObject2 = localJSONArray.getJSONObject(i);
            String str = (String)((JSONObject)localObject2).keys().next();
            boolean bool = ((JSONObject)localObject2).optBoolean(str, false);
            this.c.put(str, localp);
            localp.a(str, bool);
            i += 1;
          }
          localJSONException1 = localJSONException1;
          fl.a(localJSONException1);
          Object localObject1 = null;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            fl.a(localJSONException2);
          }
        }
        localp.b(paramJSONObject.optBoolean("allcalled", false));
        fl.a("load experiment from local : " + localp.f());
      }
    }
    return localp;
  }
  
  private p c(JSONObject paramJSONObject)
  {
    int i = 0;
    fl.a("add Experiment form network" + paramJSONObject.toString());
    if (paramJSONObject == null) {}
    p localp;
    for (;;)
    {
      return null;
      fl.a(paramJSONObject.toString());
      try
      {
        localJSONArray = paramJSONObject.getJSONArray("flags");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          localp = new p();
          str = paramJSONObject.optString("id");
          paramJSONObject = paramJSONObject.optString("name");
          localp.c(str);
          localp.a(paramJSONObject);
          this.d.put(str, localp);
          if (i >= j) {}
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          for (;;)
          {
            JSONArray localJSONArray;
            paramJSONObject = localJSONArray.getJSONObject(i);
            String str = (String)paramJSONObject.keys().next();
            boolean bool = paramJSONObject.optBoolean(str, false);
            this.c.put(str, localp);
            localp.a(str, bool);
            i += 1;
          }
          localJSONException = localJSONException;
          fl.a(localJSONException);
          Object localObject = null;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            fl.a(paramJSONObject);
          }
        }
        localp.b(localp.d());
      }
    }
    try
    {
      fl.a("add element net work : " + localp.f());
      b();
      fl.a("add element net work : " + localp.f());
      return localp;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        fl.a(paramJSONObject);
      }
    }
  }
  
  private boolean c(String paramString)
  {
    p localp = (p)this.c.get(paramString);
    if (localp == null) {
      return false;
    }
    return localp.d(paramString);
  }
  
  public Double a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1 + "&&&" + paramString2;
      paramContext = fm.a(fm.c(paramContext), paramString1);
      if (paramContext.equals("")) {
        return Double.valueOf(0.0D);
      }
      double d1 = Double.parseDouble(paramContext);
      return Double.valueOf(d1);
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
    return Double.valueOf(0.0D);
  }
  
  public Double a(Context paramContext, String paramString1, String paramString2, Object paramObject, Double paramDouble)
  {
    try
    {
      paramString1 = paramString1 + "&&&" + paramString2;
      if (paramObject == null) {
        return Double.valueOf(0.0D);
      }
      double d1 = Double.parseDouble(paramObject.toString());
      paramString2 = Double.valueOf(paramDouble.doubleValue() + Double.valueOf(d1).doubleValue());
      fm.a(fm.c(paramContext), paramString1, paramString2.toString());
      return paramString2;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
    return paramDouble;
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: new 106	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   12: ldc -72
    //   14: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 27	com/adhoc/q:d	Ljava/util/HashMap;
    //   21: invokevirtual 187	java/util/HashMap:size	()I
    //   24: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 43	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_1
    //   36: ifnonnull +6 -> 42
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_1
    //   43: ldc -64
    //   45: invokevirtual 49	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -11 -> 39
    //   53: aload_1
    //   54: invokevirtual 55	org/json/JSONArray:length	()I
    //   57: ifeq -18 -> 39
    //   60: ldc -62
    //   62: invokestatic 43	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 55	org/json/JSONArray:length	()I
    //   69: istore 5
    //   71: iload 4
    //   73: iload 5
    //   75: if_icmpge +113 -> 188
    //   78: aload_1
    //   79: iload 4
    //   81: invokevirtual 77	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   84: astore_2
    //   85: aload_2
    //   86: ldc 60
    //   88: ldc -105
    //   90: invokevirtual 197	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_0
    //   95: getfield 27	com/adhoc/q:d	Ljava/util/HashMap;
    //   98: aload_3
    //   99: invokevirtual 200	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   102: ifne +49 -> 151
    //   105: aload_0
    //   106: aload_2
    //   107: invokespecial 202	com/adhoc/q:c	(Lorg/json/JSONObject;)Lcom/adhoc/p;
    //   110: iconst_1
    //   111: invokevirtual 204	com/adhoc/p:a	(Z)V
    //   114: ldc -50
    //   116: invokestatic 43	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   119: iload 4
    //   121: iconst_1
    //   122: iadd
    //   123: istore 4
    //   125: goto -60 -> 65
    //   128: astore_1
    //   129: aload_1
    //   130: invokestatic 99	com/adhoc/fl:a	(Ljava/lang/Exception;)V
    //   133: aload_2
    //   134: astore_1
    //   135: goto -86 -> 49
    //   138: astore_1
    //   139: aload_1
    //   140: invokestatic 168	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   143: goto -104 -> 39
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: aload_0
    //   152: getfield 27	com/adhoc/q:d	Ljava/util/HashMap;
    //   155: aload_3
    //   156: invokevirtual 134	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   159: checkcast 57	com/adhoc/p
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +8 -> 172
    //   167: aload_2
    //   168: iconst_1
    //   169: invokevirtual 204	com/adhoc/p:a	(Z)V
    //   172: ldc -48
    //   174: invokestatic 43	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   177: goto -58 -> 119
    //   180: astore_2
    //   181: aload_2
    //   182: invokestatic 99	com/adhoc/fl:a	(Ljava/lang/Exception;)V
    //   185: goto -66 -> 119
    //   188: aload_0
    //   189: getfield 27	com/adhoc/q:d	Ljava/util/HashMap;
    //   192: invokevirtual 212	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   195: invokeinterface 217 1 0
    //   200: astore_1
    //   201: aload_1
    //   202: invokeinterface 220 1 0
    //   207: ifeq +79 -> 286
    //   210: aload_1
    //   211: invokeinterface 87 1 0
    //   216: checkcast 222	java/util/Map$Entry
    //   219: invokeinterface 225 1 0
    //   224: checkcast 57	com/adhoc/p
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull -28 -> 201
    //   232: aload_2
    //   233: invokevirtual 228	com/adhoc/p:e	()Z
    //   236: ifne -35 -> 201
    //   239: aload_1
    //   240: invokeinterface 231 1 0
    //   245: aload_0
    //   246: invokevirtual 129	com/adhoc/q:b	()V
    //   249: new 106	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   256: ldc -23
    //   258: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 235	com/adhoc/p:c	()Ljava/lang/String;
    //   265: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 43	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   274: goto -73 -> 201
    //   277: astore_3
    //   278: ldc -19
    //   280: invokestatic 239	com/adhoc/fl:b	(Ljava/lang/String;)V
    //   283: goto -34 -> 249
    //   286: aload_0
    //   287: getfield 27	com/adhoc/q:d	Ljava/util/HashMap;
    //   290: invokevirtual 212	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   293: invokeinterface 217 1 0
    //   298: astore_1
    //   299: aload_1
    //   300: invokeinterface 220 1 0
    //   305: ifeq -266 -> 39
    //   308: aload_1
    //   309: invokeinterface 87 1 0
    //   314: checkcast 222	java/util/Map$Entry
    //   317: invokeinterface 225 1 0
    //   322: checkcast 57	com/adhoc/p
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull -28 -> 299
    //   330: aload_2
    //   331: iconst_0
    //   332: invokevirtual 204	com/adhoc/p:a	(Z)V
    //   335: goto -36 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	q
    //   0	338	1	paramJSONObject	JSONObject
    //   34	134	2	localObject	Object
    //   180	2	2	localJSONException1	JSONException
    //   227	104	2	localp	p
    //   93	63	3	str	String
    //   277	1	3	localJSONException2	JSONException
    //   1	123	4	i	int
    //   69	7	5	j	int
    // Exception table:
    //   from	to	target	type
    //   42	49	128	org/json/JSONException
    //   5	33	138	java/lang/Throwable
    //   42	49	138	java/lang/Throwable
    //   53	65	138	java/lang/Throwable
    //   65	71	138	java/lang/Throwable
    //   78	119	138	java/lang/Throwable
    //   129	133	138	java/lang/Throwable
    //   151	163	138	java/lang/Throwable
    //   167	172	138	java/lang/Throwable
    //   172	177	138	java/lang/Throwable
    //   181	185	138	java/lang/Throwable
    //   188	201	138	java/lang/Throwable
    //   201	228	138	java/lang/Throwable
    //   232	245	138	java/lang/Throwable
    //   245	249	138	java/lang/Throwable
    //   249	274	138	java/lang/Throwable
    //   278	283	138	java/lang/Throwable
    //   286	299	138	java/lang/Throwable
    //   299	326	138	java/lang/Throwable
    //   330	335	138	java/lang/Throwable
    //   5	33	146	finally
    //   42	49	146	finally
    //   53	65	146	finally
    //   65	71	146	finally
    //   78	119	146	finally
    //   129	133	146	finally
    //   139	143	146	finally
    //   151	163	146	finally
    //   167	172	146	finally
    //   172	177	146	finally
    //   181	185	146	finally
    //   188	201	146	finally
    //   201	228	146	finally
    //   232	245	146	finally
    //   245	249	146	finally
    //   249	274	146	finally
    //   278	283	146	finally
    //   286	299	146	finally
    //   299	326	146	finally
    //   330	335	146	finally
    //   78	119	180	org/json/JSONException
    //   151	163	180	org/json/JSONException
    //   167	172	180	org/json/JSONException
    //   172	177	180	org/json/JSONException
    //   245	249	277	org/json/JSONException
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      if (!fm.a(this.b)) {
        return;
      }
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("flags");
        if ((paramJSONObject != null) && (paramJSONObject.has(paramString)))
        {
          fl.a("used flag " + paramString);
          if ((paramString != null) && (this.c.containsKey(paramString)) && (!a().a(paramString)))
          {
            boolean bool = a().c(paramString);
            fl.a("flag : " + paramString + " is called " + bool);
            if (!bool)
            {
              fl.a("flag is set true");
              a().b(paramString);
              return;
            }
          }
        }
      }
    }
    catch (Throwable paramJSONObject)
    {
      fl.a(paramJSONObject);
    }
  }
  
  public boolean a(String paramString)
  {
    return ((p)this.c.get(paramString)).f();
  }
  
  protected void b()
  {
    if (this.b == null) {
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      JSONObject localJSONObject1 = new JSONObject();
      String str1 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (p)((Map.Entry)localObject1).getValue();
      String str2 = ((p)localObject1).a();
      Object localObject2 = ((p)localObject1).b();
      JSONArray localJSONArray2 = new JSONArray();
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
        localJSONArray2.put(localJSONObject2);
      }
      localJSONObject1.put("flags", localJSONArray2);
      localJSONObject1.put("allcalled", ((p)localObject1).f());
      localJSONObject1.put("id", str1);
      localJSONObject1.put("name", str2);
      localJSONArray1.put(localJSONObject1);
    }
    fm.a(fm.c(this.b), "experiments", localJSONArray1.toString());
    fl.a("save str :" + localJSONArray1.toString());
  }
  
  public void b(String paramString)
  {
    try
    {
      p localp = (p)this.c.get(paramString);
      if (localp == null) {
        return;
      }
      localp.b(paramString);
      if (localp.d()) {
        localp.b(true);
      }
      try
      {
        fl.a("触发保存used flag " + paramString);
        b();
        return;
      }
      catch (JSONException paramString)
      {
        fl.a(paramString);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
  }
  
  public void c()
  {
    Object localObject1 = fm.a(fm.c(this.b), "experiments");
    if ((localObject1 == null) || (((String)localObject1).equals(""))) {}
    for (;;)
    {
      return;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0)) {
          continue;
        }
        fl.a("load experiments from loacal");
        if (!this.c.isEmpty()) {
          continue;
        }
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          continue;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            int i;
            b(((JSONArray)localObject1).getJSONObject(i));
            i += 1;
          }
          localJSONException1 = localJSONException1;
          fl.a(localJSONException1);
          Object localObject2 = null;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            fl.a(localJSONException2);
          }
        }
      }
    }
  }
  
  public JSONArray d()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)((Map.Entry)localIterator.next()).getValue();
      if ((localp.f()) || ("CONTROL".equals(localp.c()))) {
        localJSONArray.put(localp.c());
      }
    }
    if (localJSONArray.length() == 0) {
      localJSONArray.put("CONTROL");
    }
    return localJSONArray;
  }
  
  public JSONArray e()
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject = this.d.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localp = (p)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localp.f()) || ("CONTROL".equals(localp.c())))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", localp.a());
          localJSONObject.put("id", localp.c());
          localJSONArray.put(localJSONObject);
        }
        catch (Throwable localThrowable2)
        {
          fl.a(localThrowable2);
        }
      }
    }
    if (localJSONArray.length() == 0) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("name", "CONTROL");
      ((JSONObject)localObject).put("id", "CONTROL");
      localJSONArray.put(localObject);
      return localJSONArray;
    }
    catch (Throwable localThrowable1)
    {
      fl.a(localThrowable1);
    }
    return localJSONArray;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */