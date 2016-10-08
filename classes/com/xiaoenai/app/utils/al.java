package com.xiaoenai.app.utils;

import android.os.Bundle;
import com.xiaoenai.app.utils.f.a;
import java.net.URLDecoder;
import org.json.JSONObject;

public class al
{
  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null) {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            String[] arrayOfString = paramString[i].split("=");
            int k = arrayOfString.length;
            if (k > 1) {}
            try
            {
              localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                a.a(localException.getMessage(), new Object[0]);
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    tmp103_100[0] = localBundle;
    a.c("=======params======= {}", tmp103_100);
    return localBundle;
  }
  
  public static Bundle b(String paramString)
  {
    return a(paramString.substring(paramString.indexOf("?") + 1, paramString.length()));
  }
  
  public static JSONObject c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject = paramString.substring(paramString.indexOf("?") + 1, paramString.length());
      if (localObject == null) {
        break label90;
      }
      localObject = ((String)localObject).split("&");
      j = localObject.length;
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        int j;
        int i;
        String[] arrayOfString;
        label90:
        label166:
        a.a(paramString.getMessage(), new Object[0]);
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      arrayOfString = localObject[i].split("=");
      if (arrayOfString.length > 1) {
        localJSONObject.put(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
      }
    }
    else
    {
      if ((paramString.contains("url=http")) && (paramString.indexOf("?") != paramString.lastIndexOf("?")))
      {
        if (!paramString.contains("click_url")) {
          break label166;
        }
        localJSONObject.put("click_url", URLDecoder.decode(paramString.substring(paramString.indexOf("url=") + "url=".length()), "UTF-8"));
      }
      for (;;)
      {
        a.c("=======params======= {}", new Object[] { localJSONObject });
        return localJSONObject;
        localJSONObject.put("url", URLDecoder.decode(paramString.substring(paramString.indexOf("url=") + "url=".length()), "UTF-8"));
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */