package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.l;
import org.json.JSONObject;

public class j
  extends l
{
  public j(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.s + paramString;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("loverpet/v3/setting/push/time", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("wishtree/v1/setting/push/time", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */