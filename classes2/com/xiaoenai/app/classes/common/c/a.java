package com.xiaoenai.app.classes.common.c;

import java.net.URLDecoder;
import org.json.JSONObject;

public class a
  extends f
{
  public g a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", URLDecoder.decode(paramString, "UTF-8"));
      return new g.a().a("xiaoenai.event.browser").c(localJSONObject.toString()).a();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */