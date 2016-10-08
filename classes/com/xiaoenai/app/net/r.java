package com.xiaoenai.app.net;

import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

public class r
  extends l
{
  public r(m paramm)
  {
    super(paramm);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", paramString1);
      localJSONObject.put("password", paramString2);
      localJSONObject.put("verify_code", paramString3);
      a("v2/regist_phone", localJSONObject);
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
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", paramString1);
      localJSONObject.put("password", paramString2);
      localJSONObject.put("verify_code", paramString3);
      a("v2/recover_phone_password", localJSONObject);
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
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    return new JSONObject(a.a(super.c(paramJSONObject).toString()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */