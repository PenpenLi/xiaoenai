package com.xiaoenai.app.model.Forum;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  implements Serializable
{
  private static final long serialVersionUID = -2145603160037264957L;
  public int a = 0;
  public String b = "";
  public String c = null;
  public boolean d = false;
  public int e = 0;
  public int f = 0;
  public int g = -1;
  private final int h = 18000000;
  private int i = 0;
  
  public f() {}
  
  public f(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("id")) {
        this.a = paramJSONObject.getInt("id");
      }
      if (paramJSONObject.has("gender")) {
        this.e = paramJSONObject.getInt("gender");
      }
      if (paramJSONObject.has("is_admin")) {
        this.d = paramJSONObject.getBoolean("is_admin");
      }
      if (paramJSONObject.has("posts_count")) {
        this.f = paramJSONObject.getInt("posts_count");
      }
      if ((paramJSONObject.has("avatar_url")) && (!paramJSONObject.isNull("avatar_url"))) {
        this.c = paramJSONObject.getString("avatar_url");
      }
      if (paramJSONObject.has("online_time")) {
        this.i = paramJSONObject.getInt("online_time");
      }
      if ((paramJSONObject.has("nickname")) && (!paramJSONObject.isNull("nickname"))) {
        this.b = paramJSONObject.getString("nickname");
      }
      if ((paramJSONObject.has("lover_id")) && (!paramJSONObject.isNull("lover_id"))) {
        this.g = paramJSONObject.getInt("lover_id");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static List<f> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    if (paramJSONObject.has("users")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("users");
        int j = 0;
        while (j < paramJSONObject.length())
        {
          localArrayList.add(new f(paramJSONObject.getJSONObject(j)));
          j += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static void a(f paramf)
  {
    try
    {
      com.xiaoenai.app.utils.d.f.b(paramf.e(), com.xiaoenai.app.utils.d.f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "forum_user.dat"));
      return;
    }
    catch (Exception paramf)
    {
      paramf.printStackTrace();
    }
  }
  
  public static void b(JSONObject paramJSONObject)
  {
    try
    {
      com.xiaoenai.app.utils.d.f.b(paramJSONObject, com.xiaoenai.app.utils.d.f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "forum_user.dat"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static f d()
  {
    try
    {
      f localf = new f(com.xiaoenai.app.utils.d.f.b(com.xiaoenai.app.utils.d.f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), "forum_user.dat")));
      return localf;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private JSONObject e()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", this.a);
    localJSONObject.put("gender", this.e);
    localJSONObject.put("is_admin", this.d);
    localJSONObject.put("posts_count", this.f);
    localJSONObject.put("avatar_url", this.c);
    localJSONObject.put("online_time", this.i);
    localJSONObject.put("nickname", this.b);
    localJSONObject.put("lover_id", this.g);
    return localJSONObject;
  }
  
  public boolean a()
  {
    int j = 18000000;
    int k = UserConfig.getInt("forum_publish_limit", Integer.valueOf(18000000)).intValue();
    if (k < 0) {}
    for (;;)
    {
      this.i = User.getInstance().getOnlineTime();
      return this.i >= j;
      j = k;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    int k = UserConfig.getInt("forum_reply_limit", Integer.valueOf(-1)).intValue();
    int j = k;
    if (k < 0) {
      j = 0;
    }
    this.i = User.getInstance().getOnlineTime();
    if (this.i >= j) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return (this.b != null) && (!this.b.equalsIgnoreCase(""));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\Forum\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */