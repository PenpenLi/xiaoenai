package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.l;
import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

public class ah
  extends l
{
  public ah(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.j + paramString;
    }
    return str;
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", paramString);
      if (Integer.MIN_VALUE != paramInt) {
        localJSONObject.put("verify_type", paramInt);
      }
      a("v3/sms/get_verify_code", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mobile", paramString1);
      localJSONObject.put("verify_code", paramString2);
      localJSONObject.put("verify_type", paramInt);
      a("v3/sms/client_verify_code", localJSONObject);
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
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(String paramString)
  {
    a(paramString, Integer.MIN_VALUE);
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    return new JSONObject(a.a(super.c(paramJSONObject).toString()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */