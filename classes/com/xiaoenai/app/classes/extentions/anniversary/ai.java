package com.xiaoenai.app.classes.extentions.anniversary;

import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ai
{
  private static ai b = null;
  private ArrayList<ah> a = null;
  private Comparator<ah> c = new aj(this);
  
  private ai()
  {
    String str = UserConfig.getString("extention_anniversary", null);
    if (str != null) {}
    try
    {
      b(new JSONObject(str));
      f();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static ai a()
  {
    if (b == null) {}
    try
    {
      b = new ai();
      return b;
    }
    finally {}
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("reminders");
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        ah localah = ah.a(paramJSONObject.getJSONObject(i));
        this.a.add(localah);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void c()
  {
    b = null;
  }
  
  private void f()
  {
    ah localah = new ah();
    localah.a(Integer.valueOf(0));
    localah.a(3);
    localah.b(localah.c);
    localah.a(ah.b);
    long l = User.getInstance().getLovedTime();
    if (l > 0L) {
      localah.a(l);
    }
    for (;;)
    {
      this.a.add(0, localah);
      return;
      localah.a(System.currentTimeMillis() / 1000L + 86400L);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.clear();
    b(paramJSONObject);
    f();
  }
  
  public ArrayList<ah> b()
  {
    if (this.a.size() > 0) {
      this.a.remove(0);
    }
    Collections.sort(this.a, this.c);
    f();
    return this.a;
  }
  
  public void d()
  {
    UserConfig.remove("extention_anniversary");
    this.a.clear();
    f();
  }
  
  public void e()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put(((ah)localIterator.next()).n());
        continue;
        UserConfig.setString("extention_anniversary", localJSONObject.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      return;
      localJSONObject.put("reminders", localJSONException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */