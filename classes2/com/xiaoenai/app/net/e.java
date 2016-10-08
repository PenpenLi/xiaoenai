package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import org.json.JSONObject;

public class e
  extends com.xiaoenai.app.net.c.a.a
{
  public e(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.h + paramString;
    }
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("request_token", paramString1);
      localJSONObject.put("appkey", paramString2);
      localJSONObject.put("user_id", AppModel.getInstance().getUserId());
      com.xiaoenai.app.utils.f.a.a(localJSONObject.toString());
      a("v1/sdk/oauth1/access_token", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */