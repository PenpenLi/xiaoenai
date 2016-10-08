package com.alibaba.nb.android.trade.service.config.impl;

import android.content.Context;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.a.b;
import com.alibaba.nb.android.trade.service.config.a.c;
import com.alibaba.nb.android.trade.service.config.a.d;
import com.alibaba.nb.android.trade.service.config.b.a.a;
import com.alibaba.nb.android.trade.utils.h;
import org.json.JSONException;
import org.json.JSONObject;

public class AliTradeConfigServiceImpl
  implements com.alibaba.nb.android.trade.service.config.a
{
  private static String a = "albbTradeConfig";
  public static String channel;
  private static volatile com.alibaba.nb.android.trade.service.config.a f;
  public boolean asyncTaokeTrace = true;
  private String b;
  private b c = new b();
  private com.alibaba.nb.android.trade.service.config.b.a d;
  private Context e = AliTradeContext.context;
  public long expiredTimeStamp = System.currentTimeMillis() + 3600000L;
  private c g = new c();
  private final long h = 21600000L;
  private final long i = 3600000L;
  public String isvVersion = "1.0.0";
  public String taobaoNativeSource;
  public AliTradeTaokeParams taokeParams;
  
  AliTradeConfigServiceImpl()
  {
    com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "config设置默认值开始");
    if (this.g.a() != null)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "configspwrapper有值");
      this.c.a(this.g.a());
    }
    for (;;)
    {
      this.d = new com.alibaba.nb.android.trade.service.config.b.a(this.e, new a());
      this.d.a();
      return;
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "读取本地配置文件");
      try
      {
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "本地配置文件的值为" + "{\n  \"group0\": {\n    \"dataId\": \"com.alibaba.baichuan.nbcp.meta.default\",\n    \"group\": \"1.0.0\",\n    \"lastUpdate\": \"Jun 14, 2016 2:12:22 PM\",\n    \"sign\": \"\"\n  },\n  \"albbTradeConfig\": {\n    \"isSyncForTaoke\": \"YES\",\n    \"isForceH5\": \"NO\",\n    \"isNeedAlipay\": \"YES\",\n    \"loginDegarade\": \"NO\"\n  },\n  \"group2\": {\n    \"abc1\": \"agc1\",\n    \"abc2\": \"agc2\",\n    \"abc3\": \"agc3\",\n    \"11111\":\"11111\"\n  }\n}");
        JSONObject localJSONObject = new JSONObject("{\n  \"group0\": {\n    \"dataId\": \"com.alibaba.baichuan.nbcp.meta.default\",\n    \"group\": \"1.0.0\",\n    \"lastUpdate\": \"Jun 14, 2016 2:12:22 PM\",\n    \"sign\": \"\"\n  },\n  \"albbTradeConfig\": {\n    \"isSyncForTaoke\": \"YES\",\n    \"isForceH5\": \"NO\",\n    \"isNeedAlipay\": \"YES\",\n    \"loginDegarade\": \"NO\"\n  },\n  \"group2\": {\n    \"abc1\": \"agc1\",\n    \"abc2\": \"agc2\",\n    \"abc3\": \"agc3\",\n    \"11111\":\"11111\"\n  }\n}");
        d locald = new d();
        locald.a(localJSONObject);
        this.c.a(locald);
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "读取本地配置文件成功");
      }
      catch (JSONException localJSONException)
      {
        com.alibaba.nb.android.trade.utils.d.a.d("AliTradeConfigServiceImpl", "本地默认配置文件解析错误" + localJSONException.getMessage());
      }
    }
  }
  
  private void a()
  {
    try
    {
      if (System.currentTimeMillis() > this.expiredTimeStamp)
      {
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "当前的时间大于过期时间，过期时间为" + this.expiredTimeStamp);
        this.expiredTimeStamp = (System.currentTimeMillis() + 3600000L);
        this.d.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramString.length()) {
        break label72;
      }
      int k = paramString.charAt(j);
      if (((k < 48) || (k > 57)) && ((k < 97) || (k > 122)) && ((k < 65) || (k > 90))) {
        break;
      }
      j += 1;
    }
    label72:
    return true;
  }
  
  public static AliTradeConfigServiceImpl getInstance()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new AliTradeConfigServiceImpl();
      }
      return (AliTradeConfigServiceImpl)f;
    }
    finally {}
  }
  
  public String getAppKey()
  {
    return this.b;
  }
  
  public String getChannel()
  {
    try
    {
      String str1 = (String)getGlobalConfig("channelName");
      if ((str1 != null) && (str1.length() > 0))
      {
        String str2 = (String)getGlobalConfig("channelType");
        if ((str2 != null) && (str2.length() > 0)) {
          return str2 + str1;
        }
        str1 = "0" + str1;
        return str1;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("AliTradeConfigServiceImpl", "getChannel error: " + localRuntimeException.getMessage(), localRuntimeException);
      return null;
    }
    if (!a(channel))
    {
      com.alibaba.nb.android.trade.utils.d.a.d("initChannel", "Channel chars must in [0-9][a-z][A-Z], now : " + channel);
      channel = "0";
    }
    return channel;
  }
  
  /* Error */
  public String getFromAssets(String paramString)
  {
    // Byte code:
    //   0: new 211	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: getfield 73	com/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl:e	Landroid/content/Context;
    //   8: invokevirtual 217	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: invokevirtual 223	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   14: aload_1
    //   15: invokevirtual 229	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: invokespecial 232	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: astore_2
    //   22: new 234	java/io/BufferedReader
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 237	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_3
    //   31: ldc -17
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 242	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +26 -> 68
    //   45: new 116	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   52: aload_1
    //   53: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 4
    //   58: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_1
    //   65: goto -31 -> 34
    //   68: aload_2
    //   69: invokevirtual 245	java/io/InputStreamReader:close	()V
    //   72: aload_1
    //   73: areturn
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   79: aload_1
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_1
    //   84: ldc 85
    //   86: ldc -6
    //   88: invokestatic 149	com/alibaba/nb/android/trade/utils/d/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 245	java/io/InputStreamReader:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 245	java/io/InputStreamReader:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   127: goto -7 -> 120
    //   130: astore_1
    //   131: goto -19 -> 112
    //   134: astore_3
    //   135: aload_1
    //   136: astore_2
    //   137: aload_3
    //   138: astore_1
    //   139: goto -27 -> 112
    //   142: astore_1
    //   143: aload_2
    //   144: astore_1
    //   145: goto -61 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	AliTradeConfigServiceImpl
    //   0	148	1	paramString	String
    //   21	48	2	localInputStreamReader	java.io.InputStreamReader
    //   74	2	2	localIOException1	java.io.IOException
    //   111	6	2	localObject1	Object
    //   122	2	2	localIOException2	java.io.IOException
    //   136	8	2	str1	String
    //   30	5	3	localBufferedReader	java.io.BufferedReader
    //   134	4	3	localObject2	Object
    //   38	19	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/io/IOException
    //   0	22	81	java/lang/Exception
    //   95	99	101	java/io/IOException
    //   0	22	109	finally
    //   116	120	122	java/io/IOException
    //   22	31	130	finally
    //   34	40	130	finally
    //   45	65	130	finally
    //   84	91	134	finally
    //   22	31	142	java/lang/Exception
    //   34	40	142	java/lang/Exception
    //   45	65	142	java/lang/Exception
  }
  
  public Object getGlobalConfig(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    a();
    return this.c.b(a, paramString, null);
  }
  
  public Object getGlobalConfig(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return null;
    }
    a();
    return this.c.b(a, paramString, paramObject);
  }
  
  public Object getGroupConfig(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    a();
    return this.c.b(paramString1, paramString2, null);
  }
  
  public Object getGroupConfig(String paramString1, String paramString2, Object paramObject)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    a();
    return this.c.b(paramString1, paramString2, paramObject);
  }
  
  public boolean getIsNeedAlipay(boolean paramBoolean)
  {
    return h.a(getGlobalConfig("isNeedAlipay", Boolean.valueOf(paramBoolean)));
  }
  
  public boolean getIsSyncForTaoke()
  {
    return "YES".equals(getGlobalConfig("isSyncForTaoke"));
  }
  
  public String getIsvCode()
  {
    if (AliTradeContext.isvCode != null) {
      return AliTradeContext.isvCode;
    }
    if (getGlobalConfig("isvCode") != null) {
      return (String)getGlobalConfig("isvCode");
    }
    return null;
  }
  
  public String getIsvVersion()
  {
    if (getGlobalConfig("isvVersion") != null) {
      return (String)getGlobalConfig("isvVersion");
    }
    return this.isvVersion;
  }
  
  public boolean getLoginDegarade(boolean paramBoolean)
  {
    return h.a(getGlobalConfig("loginDegarade", Boolean.valueOf(paramBoolean)));
  }
  
  public AliTradeTaokeParams getNBTTradeTaokeParams()
  {
    return this.taokeParams;
  }
  
  public AliTradeTaokeParams getTaokeParams()
  {
    return this.taokeParams;
  }
  
  public String getWebTTID()
  {
    return String.format("2014_%s_%s@baichuan_android_%s", new Object[] { getChannel(), getAppKey(), AliTradeContext.sdkVersion });
  }
  
  public void initConfigure(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean isForceH5()
  {
    return "YES".equals(getGlobalConfig("isForceH5"));
  }
  
  public boolean needTaoke()
  {
    return "YES".equals(getGlobalConfig("isTaokeUT"));
  }
  
  public void setChangeSlickUrl(boolean paramBoolean)
  {
    setGlobalConfig("IS_TAOKE_SCLICK", Boolean.valueOf(paramBoolean));
  }
  
  public void setChannel(String paramString1, String paramString2)
  {
    setGlobalConfig("channelType", paramString1);
    setGlobalConfig("channelName", paramString2);
  }
  
  public boolean setGlobalConfig(String paramString, Object paramObject)
  {
    return setGroupConfig(a, paramString, paramObject);
  }
  
  public boolean setGroupConfig(String paramString1, String paramString2, Object paramObject)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramObject == null)) {
      return false;
    }
    this.c.a(paramString1, paramString2, paramObject);
    return true;
  }
  
  public boolean setIsForceH5(boolean paramBoolean)
  {
    this.c.a("isForceH5");
    if (paramBoolean) {}
    for (String str = "YES";; str = "NO") {
      return setGlobalConfig("isForceH5", str);
    }
  }
  
  public boolean setIsSyncForTaoke(boolean paramBoolean)
  {
    this.c.a("isSyncForTaoke");
    if (paramBoolean) {}
    for (String str = "YES";; str = "NO") {
      return setGlobalConfig("isSyncForTaoke", str);
    }
  }
  
  public boolean setIsvCode(String paramString)
  {
    this.c.a("isvCode");
    return setGlobalConfig("isvCode", paramString);
  }
  
  public boolean setIsvVersion(String paramString)
  {
    this.c.a("isvVersion");
    return setGlobalConfig("isvVersion", paramString);
  }
  
  public void setTaokeParams(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    if (paramAliTradeTaokeParams == null) {
      return;
    }
    setGlobalConfig("pid", paramAliTradeTaokeParams.pid);
    setGlobalConfig("subPid", paramAliTradeTaokeParams.subPid);
    setGlobalConfig("unionId", paramAliTradeTaokeParams.unionId);
    this.taokeParams = paramAliTradeTaokeParams;
  }
  
  final class a
    implements a.a
  {
    a() {}
    
    public final void a(d paramd)
    {
      AliTradeConfigServiceImpl.a(AliTradeConfigServiceImpl.this).a(paramd);
      AliTradeConfigServiceImpl.b(AliTradeConfigServiceImpl.this).a(paramd);
      try
      {
        AliTradeConfigServiceImpl.this.expiredTimeStamp = (System.currentTimeMillis() + 21600000L);
        com.alibaba.nb.android.trade.utils.d.a.b("AliTradeConfigServiceImpl", "当前的时间为过期时间戳为" + AliTradeConfigServiceImpl.this.expiredTimeStamp);
        return;
      }
      finally
      {
        paramd = finally;
        throw paramd;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\impl\AliTradeConfigServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */