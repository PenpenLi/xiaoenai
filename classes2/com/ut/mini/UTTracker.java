package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.e.p;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UTTracker
{
  private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n])+");
  private String am = null;
  private Map<String, String> z = new HashMap();
  
  private static String b(String paramString)
  {
    return d(paramString);
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!"".equals(paramString)) {
        str = a.matcher(paramString).replaceAll("");
      }
    }
    return str;
  }
  
  private static void f(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str;
      if (paramMap.containsKey("_field_os"))
      {
        str = (String)paramMap.get("_field_os");
        paramMap.remove("_field_os");
        paramMap.put(LogField.OS.toString(), str);
      }
      if (paramMap.containsKey("_field_os_version"))
      {
        str = (String)paramMap.get("_field_os_version");
        paramMap.remove("_field_os_version");
        paramMap.put(LogField.OSVERSION.toString(), str);
      }
    }
  }
  
  private Map<String, String> g(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null) {
            localHashMap.put(str, b((String)paramMap.get(str)));
          }
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  private static void h(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.containsKey(LogField.IMEI.toString())) {
        paramMap.remove(LogField.IMEI.toString());
      }
      if (paramMap.containsKey(LogField.IMSI.toString())) {
        paramMap.remove(LogField.IMSI.toString());
      }
      if (paramMap.containsKey(LogField.CARRIER.toString())) {
        paramMap.remove(LogField.CARRIER.toString());
      }
      if (paramMap.containsKey(LogField.ACCESS.toString())) {
        paramMap.remove(LogField.ACCESS.toString());
      }
      if (paramMap.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
        paramMap.remove(LogField.ACCESS_SUBTYPE.toString());
      }
      if (paramMap.containsKey(LogField.CHANNEL.toString())) {
        paramMap.remove(LogField.CHANNEL.toString());
      }
      if (paramMap.containsKey(LogField.LL_USERNICK.toString())) {
        paramMap.remove(LogField.LL_USERNICK.toString());
      }
      if (paramMap.containsKey(LogField.USERNICK.toString())) {
        paramMap.remove(LogField.USERNICK.toString());
      }
      if (paramMap.containsKey(LogField.LL_USERID.toString())) {
        paramMap.remove(LogField.LL_USERID.toString());
      }
      if (paramMap.containsKey(LogField.USERID.toString())) {
        paramMap.remove(LogField.USERID.toString());
      }
      if (paramMap.containsKey(LogField.SDKVERSION.toString())) {
        paramMap.remove(LogField.SDKVERSION.toString());
      }
      if (paramMap.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
        paramMap.remove(LogField.START_SESSION_TIMESTAMP.toString());
      }
      if (paramMap.containsKey(LogField.UTDID.toString())) {
        paramMap.remove(LogField.UTDID.toString());
      }
      if (paramMap.containsKey(LogField.SDKTYPE.toString())) {
        paramMap.remove(LogField.SDKTYPE.toString());
      }
      if (paramMap.containsKey(LogField.RESERVE2.toString())) {
        paramMap.remove(LogField.RESERVE2.toString());
      }
      if (paramMap.containsKey(LogField.RESERVE3.toString())) {
        paramMap.remove(LogField.RESERVE3.toString());
      }
      if (paramMap.containsKey(LogField.RESERVE4.toString())) {
        paramMap.remove(LogField.RESERVE4.toString());
      }
      if (paramMap.containsKey(LogField.RESERVE5.toString())) {
        paramMap.remove(LogField.RESERVE5.toString());
      }
      if (paramMap.containsKey(LogField.RESERVES.toString())) {
        paramMap.remove(LogField.RESERVES.toString());
      }
      if (paramMap.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
        paramMap.remove(LogField.RECORD_TIMESTAMP.toString());
      }
    }
  }
  
  private static void i(Map<String, String> paramMap)
  {
    paramMap.put(LogField.SDKTYPE.toString(), "mini");
  }
  
  private static void j(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap.containsKey("_track_id"))
    {
      String str = (String)paramMap.get("_track_id");
      paramMap.remove("_track_id");
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("_tkid", str);
      }
    }
    if (localHashMap.size() > 0) {
      paramMap.put(LogField.RESERVES.toString(), p.c(localHashMap));
    }
    if (!paramMap.containsKey(LogField.PAGE.toString())) {
      paramMap.put(LogField.PAGE.toString(), "UT");
    }
  }
  
  public String getGlobalProperty(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramString = (String)this.z.get(paramString);
        return paramString;
      }
      finally {}
      paramString = null;
    }
  }
  
  public void pageAppear(Object paramObject)
  {
    UTPageHitHelper.getInstance().pageAppear(paramObject);
  }
  
  public void pageAppear(Object paramObject, String paramString)
  {
    UTPageHitHelper.getInstance().pageAppear(paramObject, paramString);
  }
  
  public void pageAppearDonotSkip(Object paramObject)
  {
    UTPageHitHelper.getInstance().a(paramObject, null, true);
  }
  
  public void pageAppearDonotSkip(Object paramObject, String paramString)
  {
    UTPageHitHelper.getInstance().a(paramObject, paramString, true);
  }
  
  public void pageDisAppear(Object paramObject)
  {
    UTPageHitHelper.getInstance().pageDisAppear(paramObject);
  }
  
  public void removeGlobalProperty(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (this.z.containsKey(paramString)) {
        this.z.remove(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  void s(String paramString)
  {
    this.am = paramString;
  }
  
  public void send(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.z);
      localHashMap.putAll(paramMap);
      paramMap = g(localHashMap);
      if (!TextUtils.isEmpty(this.am)) {
        paramMap.put("_track_id", this.am);
      }
      if (UTMIVariables.getInstance().isAliyunOSPlatform()) {}
      h(paramMap);
      f(paramMap);
      i(paramMap);
      j(paramMap);
      a.a((String)paramMap.remove(LogField.PAGE.toString()), (String)paramMap.remove(LogField.EVENTID.toString()), (String)paramMap.remove(LogField.ARG1.toString()), (String)paramMap.remove(LogField.ARG2.toString()), (String)paramMap.remove(LogField.ARG3.toString()), paramMap);
    }
  }
  
  /* Error */
  public void setGlobalProperty(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +22 -> 28
    //   9: aload_2
    //   10: ifnull +18 -> 28
    //   13: aload_0
    //   14: getfield 34	com/ut/mini/UTTracker:z	Ljava/util/Map;
    //   17: aload_1
    //   18: aload_2
    //   19: invokeinterface 86 3 0
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: ldc_w 274
    //   31: ldc_w 276
    //   34: invokestatic 281	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   37: goto -12 -> 25
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	UTTracker
    //   0	45	1	paramString1	String
    //   0	45	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	9	40	finally
    //   13	25	40	finally
    //   28	37	40	finally
  }
  
  public void skipPage(Object paramObject)
  {
    UTPageHitHelper.getInstance().skipPage(paramObject);
  }
  
  public void updateNextPageProperties(Map<String, String> paramMap)
  {
    UTPageHitHelper.getInstance().updateNextPageProperties(paramMap);
  }
  
  public void updatePageName(Object paramObject, String paramString)
  {
    UTPageHitHelper.getInstance().updatePageName(paramObject, paramString);
  }
  
  public void updatePageProperties(Object paramObject, Map<String, String> paramMap)
  {
    UTPageHitHelper.getInstance().updatePageProperties(paramObject, paramMap);
  }
  
  public void updatePageStatus(Object paramObject, UTPageStatus paramUTPageStatus)
  {
    UTPageHitHelper.getInstance().updatePageStatus(paramObject, paramUTPageStatus);
  }
  
  public void updatePageUrl(Object paramObject, Uri paramUri)
  {
    UTPageHitHelper.getInstance().updatePageUrl(paramObject, paramUri);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\UTTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */