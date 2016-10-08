package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.Xiaoenai;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends k
{
  private int d = 0;
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals("status"))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new JSONObject(paramString2);
        if (paramString1.has("type"))
        {
          paramString1 = paramString1.getString("type");
          if (!"012".equals(paramString1))
          {
            boolean bool = "013".equals(paramString1);
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("text_type")) {
        this.d = paramString.getInt("text_type");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String c()
  {
    for (;;)
    {
      try
      {
        if (super.c() == null) {
          localJSONObject = new JSONObject();
        }
      }
      catch (JSONException localJSONException1)
      {
        label51:
        JSONObject localJSONObject = null;
        localJSONException1.printStackTrace();
        continue;
      }
      for (;;)
      {
        try
        {
          if (this.c != null) {
            localJSONObject.put("type", this.c);
          }
          if (this.b == null) {
            continue;
          }
          localJSONObject.put("content", this.b);
        }
        catch (JSONException localJSONException2)
        {
          break label93;
          break label51;
        }
        try
        {
          localJSONObject.put("text_type", this.d);
          b(localJSONObject.toString());
          return localJSONObject.toString();
        }
        catch (JSONException localJSONException3)
        {
          break label93;
        }
      }
      localJSONObject = new JSONObject(super.c());
    }
  }
  
  public String r()
  {
    if (1 == g()) {
      return super.r();
    }
    if (this.d == 1) {
      return Xiaoenai.j().getString(2131100671) + super.r();
    }
    return super.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */