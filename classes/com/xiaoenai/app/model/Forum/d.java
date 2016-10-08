package com.xiaoenai.app.model.Forum;

import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends a
{
  public boolean h = false;
  public d i;
  
  public d() {}
  
  public d(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    try
    {
      if (paramJSONObject.has("deleted")) {
        this.h = paramJSONObject.getBoolean("deleted");
      }
      if (paramJSONObject.has("reply_to_post")) {
        this.i = new d(paramJSONObject.getJSONObject("reply_to_post"));
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\Forum\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */