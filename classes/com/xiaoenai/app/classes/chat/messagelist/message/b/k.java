package com.xiaoenai.app.classes.chat.messagelist.message.b;

import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.message.model.c;
import com.xiaoenai.app.classes.chat.messagelist.message.model.d;
import com.xiaoenai.app.classes.chat.messagelist.message.model.m;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  public static com.xiaoenai.app.classes.chat.messagelist.message.a.a a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString.equals("text")) {
      return new m();
    }
    if (paramString.equals("image")) {
      return new PhotoMessage();
    }
    if (paramString.equals("status"))
    {
      if (paramBoolean1) {
        return new d();
      }
      if (paramBoolean2) {
        return new c();
      }
      return new com.xiaoenai.app.classes.chat.messagelist.message.model.k();
    }
    if (paramString.equals("voice")) {
      return new o();
    }
    if (paramString.equals("emotion")) {
      return new com.xiaoenai.app.classes.chat.messagelist.message.model.a();
    }
    return null;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals("status"))) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = new JSONObject(paramString2).has("distance");
        if (bool) {
          return true;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */