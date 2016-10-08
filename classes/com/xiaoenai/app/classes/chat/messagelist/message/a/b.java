package com.xiaoenai.app.classes.chat.messagelist.message.a;

import com.xiaoenai.app.net.y;
import org.json.JSONObject;

class b
  extends y
{
  b(a parama) {}
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("success"))
    {
      this.a.b(Integer.valueOf(1));
      this.a.k();
    }
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */