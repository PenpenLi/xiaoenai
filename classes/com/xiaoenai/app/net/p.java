package com.xiaoenai.app.net;

import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

public class p
  extends l
{
  public p(m paramm)
  {
    super(paramm);
  }
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    return new JSONObject(a.a(super.c(paramJSONObject).toString()));
  }
  
  public void m(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramString1);
      localJSONObject.put("password", paramString2);
      a("v2/login2", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */