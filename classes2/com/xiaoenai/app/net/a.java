package com.xiaoenai.app.net;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import org.json.JSONObject;

public class a
  extends com.xiaoenai.app.net.c.a.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public a(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.m + paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ad_zone_id", paramString);
      localJSONObject.put("begin", paramInt1);
      localJSONObject.put("need", paramInt2);
      localJSONObject.put("os", "android");
      b("show", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ad_zone_id", paramString1);
      localJSONObject.put("token", paramString2);
      localJSONObject.put("text", paramString3);
      localJSONObject.put("report_type", paramString4);
      b("click", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */