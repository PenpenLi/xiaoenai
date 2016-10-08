package com.xiaoenai.app.model.Forum;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.xiaoenai.app.classes.common.ads.a
  implements Serializable
{
  public int b;
  public String c;
  public String d;
  public int e;
  public long f;
  public f g;
  
  public a() {}
  
  public a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("id")) {
        this.b = paramJSONObject.getInt("id");
      }
      if (paramJSONObject.has("post_number")) {
        this.e = paramJSONObject.getInt("post_number");
      }
      if (paramJSONObject.has("excerpt")) {
        this.d = paramJSONObject.getString("excerpt");
      }
      if (paramJSONObject.has("content")) {
        this.c = paramJSONObject.getString("content");
      }
      if (paramJSONObject.has("created_at")) {
        this.f = paramJSONObject.getLong("created_at");
      }
      this.g = new f(paramJSONObject.optJSONObject("author"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\Forum\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */