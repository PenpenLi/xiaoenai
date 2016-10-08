package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.a;
import org.json.JSONObject;

public class b
  extends a
{
  public b(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.b + paramString;
    }
    return str;
  }
  
  public void a()
  {
    try
    {
      a("v2/reminder/get", new JSONObject());
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramInt);
      b("v2/sdk/games/game_info", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("last_menstruation_ts", paramLong);
      localJSONObject.put("internal_day", paramInt1);
      localJSONObject.put("cycle_day", paramInt2);
      b("v2/mens/update_mens_info", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("remind_ts", paramLong);
      localJSONObject.put("content", paramString);
      localJSONObject.put("calendar_type", paramInt1);
      localJSONObject.put("repeat_type", paramInt2);
      a("v2/reminder/add", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(Integer paramInteger)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInteger);
      a("v2/reminder/del", localJSONObject);
      return;
    }
    catch (Exception paramInteger)
    {
      paramInteger.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("start", paramInteger1);
      localJSONObject.put("count", paramInteger2);
      a("v2/photos/get", localJSONObject);
      return;
    }
    catch (Exception paramInteger1)
    {
      paramInteger1.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(Integer paramInteger1, Integer paramInteger2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("start", paramInteger1);
      localJSONObject.put("count", paramInteger2);
      if (paramInt == 0) {
        localJSONObject.put("group", "all");
      }
      a("v2/notes/get", localJSONObject);
      return;
    }
    catch (Exception paramInteger1)
    {
      paramInteger1.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(Integer paramInteger, String paramString, Long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInteger);
      if (paramString != null) {
        localJSONObject.put("content", paramString);
      }
      if (paramLong != null) {
        localJSONObject.put("remind_ts", paramLong);
      }
      localJSONObject.put("calendar_type", paramInt1);
      localJSONObject.put("repeat_type", paramInt2);
      a("v2/reminder/update", localJSONObject);
      return;
    }
    catch (Exception paramInteger)
    {
      paramInteger.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInteger);
      if (paramString1 != null) {
        localJSONObject.put("content", paramString1);
      }
      if ((paramString2 != null) && (!paramString2.equals(""))) {
        localJSONObject.put("finished", paramString2);
      }
      a("v2/notes/update", localJSONObject);
      return;
    }
    catch (Exception paramInteger)
    {
      paramInteger.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      localJSONObject.put("is_original", paramInt3);
      a("v2/photos/add", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", "android");
      b("v2/sdk/games/game_list", localJSONObject);
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
      localJSONObject.put("is_open", paramInt);
      b("v2/mens/update_open", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(Integer paramInteger)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInteger);
      a("v2/notes/del", localJSONObject);
      return;
    }
    catch (Exception paramInteger)
    {
      paramInteger.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content", paramString);
      a("v2/notes/add", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/mens/get_mens_info", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ids", paramString);
      a("v2/photos/del", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void d(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("push_type", paramString);
      b("v2/mens/send_notification", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */