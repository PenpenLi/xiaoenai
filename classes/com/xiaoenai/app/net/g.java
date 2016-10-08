package com.xiaoenai.app.net;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.a;
import com.xiaoenai.app.utils.d.o;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends a
{
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public g(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.e + paramString;
    }
    return str;
  }
  
  public void a()
  {
    try
    {
      b("v2/users/get_profile", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInt);
      b("v2/events/get_event", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("post_id", paramInt2);
      localJSONObject.put("topic_id", paramInt1);
      b("v2/events/get_noti_event", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("event_id", paramInt1);
      localJSONObject.put("limit", paramInt3);
      localJSONObject.put("offset", paramInt2);
      if (paramInt4 != -1) {
        localJSONObject.put("last_post_id", paramInt4);
      }
      b("v2/events/posts", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt1);
      localJSONObject.put("lover_id", paramInt2);
      localJSONObject.put("reply_to_id", paramInt3);
      localJSONObject.put("content", paramString);
      a("v2/topics/reply", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("event_id", paramInt1);
      if (paramString != null) {
        localJSONObject.put("content", paramString);
      }
      if (paramInt2 != -1) {
        localJSONObject.put("lover_id", paramInt2);
      }
      a("v2/events/reply", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("category_id", paramInt1);
      if (-1L != paramLong) {
        localJSONObject.put("last_updated_at", paramLong);
      }
      if (-1 != paramInt2) {
        localJSONObject.put("limit", paramInt2);
      }
      localJSONObject.put("request_offset", paramInt3);
      b("v3/topics/topics", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("forum_ts", paramLong);
      b("v2/discover/discover_forum_info", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nickname", paramString);
      localJSONObject.put("gender", paramInt);
      a("v2/regist", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("content", paramString2);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("ext_info", paramJSONObject);
      }
      if (paramInt != -1) {
        localJSONObject.put("lover_id", paramInt);
      }
      a("v3/topics/add_topic", localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/notifications/list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt);
      b("v3/topics/get_topic", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt1 != -1) {}
    try
    {
      localJSONObject.put("limit", paramInt1);
      if (paramInt2 != -1) {
        localJSONObject.put("offset", paramInt2);
      }
      b("v3/users/favors", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt1);
      localJSONObject.put("last_post_id", paramInt2);
      localJSONObject.put("limit", paramInt3);
      localJSONObject.put("request_offset", paramInt4);
      b("v2/topics/posts", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("event_id", paramInt1);
      if (paramInt2 != -1) {
        localJSONObject.put("post_id", paramInt2);
      }
      localJSONObject.put("content", paramString);
      a("v2/events/report", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramString != null) {
        localJSONObject.put("nickname", paramString);
      }
      if (paramInt != -1) {
        localJSONObject.put("gender", paramInt);
      }
      a("v2/users/update_profile", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (o.b(this.b)) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject.put("wifi", i);
      localJSONObject.put("os", "android");
      return super.c(localJSONObject);
    }
  }
  
  public void c()
  {
    try
    {
      b("v3/notification/get_count", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt);
      a("v2/topics/toggle_follow", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt1 != -1) {}
    try
    {
      localJSONObject.put("limit", paramInt1);
      if (paramInt2 != -1) {
        localJSONObject.put("offset", paramInt2);
      }
      b("v3/users/topics", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt1);
      if (paramInt2 != -1) {
        localJSONObject.put("post_id", paramInt2);
      }
      localJSONObject.put("content", paramString);
      a("v2/topics/report", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void d(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt);
      a("v2/topics/delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("topic_id", paramInt1);
      localJSONObject.put("target_category_id", paramInt2);
      a("v2/topics/move", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void e(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("post_id", paramInt);
      a("v2/topics/post_delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt1);
      localJSONObject.put("post_id", paramInt2);
      b("v3/topics/get_noti_topic", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("gender", paramInt);
      b("v2/users/ranking", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("limit", paramInt2);
      localJSONObject.put("offset", paramInt1);
      b("v3/events/get_events", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void g(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("topic_id", paramInt);
      a("v2/topics/filter", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void h(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("post_id", paramInt);
      a("v2/events/post_delete", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */