package com.xiaoenai.app.classes.street.pay.a;

import org.json.JSONException;
import org.json.JSONObject;

class j
  implements i.a
{
  j(i parami, f paramf) {}
  
  public void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("channel", i.a(this.b));
      if (paramString.equals("success"))
      {
        this.a.a(true, localJSONObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      this.a.a(false, localJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */