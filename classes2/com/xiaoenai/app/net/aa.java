package com.xiaoenai.app.net;

import com.f.a.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

class aa
  implements Runnable
{
  aa(y paramy, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      a.a(localJSONException.getMessage(), new Object[0]);
      b.b(Xiaoenai.j(), "ParseSocketResponseErr");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */