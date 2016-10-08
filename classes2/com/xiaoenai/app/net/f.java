package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.a;
import org.json.JSONObject;

public class f
  extends a
{
  public f(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.n + paramString;
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "Android");
      localJSONObject.put("keys", paramString);
      b("client/config", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "Android");
      localJSONObject.put("md5", paramString);
      b("client/changed", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */