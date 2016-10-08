package com.xiaoenai.app.classes.auth;

import android.os.Bundle;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.al;
import org.json.JSONObject;

public class a
{
  private String a(String paramString)
  {
    if (paramString != null) {
      return paramString.substring(paramString.indexOf("?") + 1);
    }
    return null;
  }
  
  public void a(String paramString, e parame)
  {
    parame.b(-1, null);
  }
  
  public void a(String paramString1, String paramString2, m paramm)
  {
    new com.xiaoenai.app.net.e(paramm).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, m paramm, e parame)
  {
    paramString1 = al.a(a(paramString1));
    com.xiaoenai.app.utils.f.a.c("params={}", new Object[] { paramString1.toString() });
    String str = paramString1.getString("request_token");
    if (str != null)
    {
      a(str, paramString2, paramm);
      return;
    }
    paramString2 = new JSONObject();
    for (;;)
    {
      try
      {
        int i = Integer.valueOf(paramString1.getString("code")).intValue();
        paramString1.printStackTrace();
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString2.put("server_msg", paramString1.getString("message"));
          com.xiaoenai.app.utils.f.a.c("code={} object{}", new Object[] { Integer.valueOf(i), paramString2.toString() });
          parame.a(i, paramString2);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;) {}
        }
        paramString1 = paramString1;
        i = -5;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */