package com.xiaoenai.app.utils.d;

import com.xiaoenai.app.utils.f.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public final class ac
{
  private static String a = "UTF-8";
  private static final Map<String, String> b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("*", "%2A");
    localHashMap.put("+", "%20");
    localHashMap.put("%7E", "~");
    b = Collections.unmodifiableMap(localHashMap);
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = "";
      try
      {
        paramString = URLEncoder.encode(paramString, a);
        Iterator localIterator = b.entrySet().iterator();
        for (;;)
        {
          localObject = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (Map.Entry)localIterator.next();
          paramString = a(paramString, (String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          a.c("Charset not found while encoding string: {} {}", new Object[] { a, paramString.getMessage() });
          paramString = (String)localObject;
        }
      }
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceAll(Pattern.quote(paramString2), paramString3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */