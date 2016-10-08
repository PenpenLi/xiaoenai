package com.inmobi.commons.core.utilities.uid;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class d
{
  private Map<String, Boolean> a;
  
  public d(Map<String, Boolean> paramMap)
  {
    this.a = paramMap;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
      byte[] arrayOfByte = new byte[paramString1.length];
      paramString2 = paramString2.getBytes("UTF-8");
      int i = 0;
      while (i < paramString1.length)
      {
        arrayOfByte[i] = ((byte)(paramString1[i] ^ paramString2[(i % paramString2.length)]));
        i += 1;
      }
      paramString1 = new String(Base64.encode(arrayOfByte, 2), "UTF-8");
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  private String c()
  {
    return new JSONObject(a(null, false)).toString();
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("u-id-map", c());
    return localHashMap;
  }
  
  public Map<String, String> a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    Object localObject;
    if ((((Boolean)this.a.get("O1")).booleanValue()) && (!c.a().l()))
    {
      str = c.a().a(c.a().i());
      localObject = str;
      if (paramBoolean) {
        localObject = a(str, paramString);
      }
      localHashMap.put("O1", localObject);
    }
    if ((((Boolean)this.a.get("UM5")).booleanValue()) && (!c.a().l()))
    {
      str = c.a().b(c.a().i());
      localObject = str;
      if (paramBoolean) {
        localObject = a(str, paramString);
      }
      localHashMap.put("UM5", localObject);
    }
    if (((Boolean)this.a.get("LID")).booleanValue())
    {
      str = c.a().g();
      if ((str != null) && (str.trim().length() > 0))
      {
        localObject = str;
        if (paramBoolean) {
          localObject = a(str, paramString);
        }
        localHashMap.put("LID", localObject);
      }
    }
    if (((Boolean)this.a.get("SID")).booleanValue())
    {
      str = c.a().h();
      if ((str != null) && (str.trim().length() > 0))
      {
        localObject = str;
        if (paramBoolean) {
          localObject = a(str, paramString);
        }
        localHashMap.put("SID", localObject);
      }
    }
    if (((Boolean)this.a.get("GPID")).booleanValue())
    {
      localObject = c.a().j();
      if (localObject != null)
      {
        str = ((a)localObject).b();
        if (str != null)
        {
          localObject = str;
          if (paramBoolean) {
            localObject = a(str, paramString);
          }
          localHashMap.put("GPID", localObject);
        }
      }
    }
    if (((Boolean)this.a.get("IMID")).booleanValue())
    {
      str = c.a().a(com.inmobi.commons.a.a.b());
      if (str != null)
      {
        localObject = str;
        if (paramBoolean) {
          localObject = a(str, paramString);
        }
        localHashMap.put("IMID", localObject);
      }
    }
    if (((Boolean)this.a.get("AIDL")).booleanValue())
    {
      str = c.a().b(com.inmobi.commons.a.a.b());
      if (str != null)
      {
        localObject = str;
        if (paramBoolean) {
          localObject = a(str, paramString);
        }
        localHashMap.put("AIDL", localObject);
      }
    }
    return localHashMap;
  }
  
  public Map<String, String> b()
  {
    String str1 = Integer.toString(new Random().nextInt());
    String str2 = com.inmobi.commons.core.utilities.a.c.a(new JSONObject(a(str1, true)).toString());
    HashMap localHashMap = new HashMap();
    localHashMap.put("u-id-map", str2);
    localHashMap.put("u-id-key", str1);
    localHashMap.put("u-key-ver", c.a().f());
    return localHashMap;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\uid\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */