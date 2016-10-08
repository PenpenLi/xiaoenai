package com.xiaoenai.app.net.http.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class d
  implements c
{
  public Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new LinkedHashMap();
    }
    ((Map)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
    ((Map)localObject).put("os", "android");
    return (Map<String, String>)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */