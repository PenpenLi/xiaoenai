package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.as;
import org.json.JSONObject;

public class ac
  extends com.xiaoenai.app.net.c.a.a
{
  public ac(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.r + paramString;
  }
  
  public void a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("encrypted", paramInt);
      localJSONObject.put("batch_data", paramString);
      localJSONObject.put("encrypted_version", as.l());
      a("stat/v1/upload", localJSONObject);
      com.xiaoenai.app.utils.f.a.c("uploadStat = {}", new Object[] { localJSONObject });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */