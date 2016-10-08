package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.l;
import org.json.JSONObject;

public class q
  extends l
{
  public q(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.b + paramString;
    }
    return str;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v3/discover/list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */