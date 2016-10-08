package com.xiaoenai.app.model.Forum;

import java.io.Serializable;
import org.json.JSONObject;

public class b
  extends a
  implements Serializable
{
  private static final long serialVersionUID = 8112346480543029031L;
  public int h;
  public int i;
  public String j;
  public boolean k;
  public String l;
  public int m = 1;
  public int n = 0;
  
  public b() {}
  
  public b(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.h = paramJSONObject.optInt("product_id");
    this.i = paramJSONObject.optInt("topic_id");
    this.j = paramJSONObject.optString("title");
    this.k = paramJSONObject.optBoolean("favored");
    this.l = paramJSONObject.optString("reply_to");
    this.m = paramJSONObject.optInt("topic_type");
    this.n = paramJSONObject.optInt("post_id");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\Forum\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */