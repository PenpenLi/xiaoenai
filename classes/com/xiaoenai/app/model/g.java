package com.xiaoenai.app.model;

import com.xiaoenai.app.model.Forum.a;
import com.xiaoenai.app.model.Forum.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends a
{
  public int h = 0;
  public String i = "";
  public b j;
  public long k = 0L;
  public String l;
  public long m = 0L;
  public long n = 0L;
  
  public g()
  {
    this.j = new b();
  }
  
  public g(b paramb)
  {
    this.j = paramb;
  }
  
  public g(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.j = new b(paramJSONObject);
    this.h = paramJSONObject.optInt("event_status");
    this.i = paramJSONObject.optString("event_url");
    this.k = paramJSONObject.optLong("author_uid");
    this.m = paramJSONObject.optLong("reply_to_id");
    this.l = paramJSONObject.optString("reply_to_post_excerpt");
    this.n = paramJSONObject.optLong("topic_author_id");
  }
  
  public static ArrayList<g> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    if (paramJSONObject.has("notifications")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("notifications");
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          localArrayList.add(new g(paramJSONObject.getJSONObject(i1)));
          i1 += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */