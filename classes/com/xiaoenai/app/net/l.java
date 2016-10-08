package com.xiaoenai.app.net;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.net.c.a.a;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.h;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends a
{
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public l(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.a + paramString;
    }
    return str;
  }
  
  public void a()
  {
    try
    {
      b("v2/relation/get_invite", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sticker_id", paramInt);
      a("v2/sticker_store/fetch_sticker", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("task_id", paramInt1);
      localJSONObject.put("task_done", paramInt2);
      a("v2/task/do", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        localJSONObject.put("username", paramString2);
      }
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localJSONObject.put("nickname", paramString1);
      }
      if (paramLong > 0L) {
        localJSONObject.put("love_time", paramLong);
      }
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        localJSONObject.put("email", paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        localJSONObject.put("phone", paramString4);
      }
      if (paramString5 != null) {
        localJSONObject.put("couple_photo", paramString5);
      }
      a("v2/config/update", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_access_token", paramString2);
      localJSONObject.put("wx_open_id", paramString1);
      localJSONObject.put("ver", as.l());
      a("v2/login_wx2", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void a(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = Xiaoenai.j();
      localJSONObject.put("uuid", ((Xiaoenai)localObject).x);
      localJSONObject.put("os", "android");
      localJSONObject.put("device", ((Xiaoenai)localObject).y);
      localJSONObject.put("device_ver", ((Xiaoenai)localObject).z);
      localJSONObject.put("app_ver", ((Xiaoenai)localObject).B);
      localJSONObject.put("jb", as.h());
      localJSONObject.put("channel", ((Xiaoenai)localObject).D);
      localObject = localJSONObject.toString();
      if ((!AppSettings.getString("device_info", "").equals(localObject)) || (paramBoolean))
      {
        a("v2/config/update_device_info", localJSONObject);
        AppSettings.setString("device_info", (String)localObject);
        return;
      }
      if (this.a != null)
      {
        this.a.a(0);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.a != null) {
        this.a.a(0);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean1) {
        localJSONObject.put("email", paramBoolean1);
      }
      if (paramBoolean2) {
        localJSONObject.put("phone", paramBoolean2);
      }
      if (paramBoolean3) {
        localJSONObject.put("qq", paramBoolean3);
      }
      if (paramBoolean4) {
        localJSONObject.put("sina", paramBoolean4);
      }
      if (paramBoolean5) {
        localJSONObject.put("wx", paramBoolean5);
      }
      a("v2/config/unbind", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void b()
  {
    try
    {
      b("v2/logout", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void b(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sticker_id", paramInt);
      b("v2/sticker_store/download", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      do
      {
        localJSONException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
      return;
    }
    catch (Exception localException)
    {
      if (this.a != null) {
        this.a.a(0);
      }
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramString);
      a("v2/relation/search", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("qq_access_token", paramString2);
      localJSONObject.put("qq_open_id", paramString1);
      localJSONObject.put("ver", as.l());
      a("v2/login_qq2", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = AppModel.getInstance().getImageKey();
      if ((str != null) && (!str.equals("")))
      {
        str = h.c(str);
        if (str.length() > 4) {
          localJSONObject.put("img_key_ver", str.substring(0, 4));
        }
      }
      str = AppModel.getInstance().getAudioKey();
      if ((str != null) && (!str.equals("")))
      {
        str = h.c(str);
        if (str.length() > 4) {
          localJSONObject.put("aud_key_ver", str.substring(0, 4));
        }
      }
      b("v2/config/get", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (this.a == null) {}
      this.a.a(0);
    }
  }
  
  public void c(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("task_id", paramInt);
      b("v2/task/gain", localJSONObject);
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
      localJSONObject.put("username", paramString);
      a("v2/relation/invite", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sina_access_token", paramString2);
      localJSONObject.put("sina_uid", paramString1);
      localJSONObject.put("ver", as.l());
      a("v2/login_sina2", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void d()
  {
    try
    {
      a("v2/config/verify_info", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lover_uid", paramString);
      b("v2/relation/accept", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("email", paramString1);
      localJSONObject.put("password", paramString2);
      localJSONObject.put("ver", as.l());
      a("v2/regist2", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void e()
  {
    try
    {
      a("v2/config/send_email_verify", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("password", paramString);
      b("v2/relation/release", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      while (this.a == null) {}
      this.a.a(0);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("old_password", paramString1);
      localJSONObject.put("password", paramString2);
      a("v2/config/edit_pwd", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void f()
  {
    try
    {
      b("v2/fun/status", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramString);
      a("v2/sync_onekey_status", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("tag", paramString2);
      }
      a("v2/feedback/submit", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void g()
  {
    try
    {
      b("v2/fun/sleep", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void g(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("email", paramString);
      a("v2/recover_password", localJSONObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void g(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("verify_code", paramString1);
      localJSONObject.put("mobile", paramString2);
      a("v2/config/bind_phone", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void h()
  {
    try
    {
      b("v2/fun/alarm", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void h(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wx_access_token", paramString2);
      localJSONObject.put("wx_open_id", paramString1);
      a("v2/config/bind_wx", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void i()
  {
    try
    {
      b("v2/fun/wake", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("qq_access_token", paramString2);
      localJSONObject.put("qq_open_id", paramString1);
      a("v2/config/bind_qq", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void j()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ver", Xiaoenai.j().B);
      localJSONObject.put("os", "android");
      a("v2/upgrade", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void j(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sina_uid", paramString1);
      localJSONObject.put("sina_access_token", paramString2);
      a("v2/config/bind_sina", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void k()
  {
    try
    {
      a("v2/sticker_store/list", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void k(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramString1 != null) {
        localJSONObject.put("data1", paramString1);
      }
      if (paramString2 != null) {
        localJSONObject.put("data2", paramString2);
      }
      a("v2/config/up", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramString1.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void l()
  {
    try
    {
      a("v2/share/single_info", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void l(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sex", paramString1);
      localJSONObject.put("is_modify", paramString2);
      a("v2/config/edit_sex", localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void m()
  {
    try
    {
      a("v2/share/app_info", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void n()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("timestamp", System.currentTimeMillis() / 1000L);
      a("v2/ts_sync", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void o()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/feedback/get", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void p()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/chat/background_list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void q()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/relation/release_note", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void r()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/task/list", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void s()
  {
    try
    {
      b("v2/task/has_new", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void t()
  {
    try
    {
      b("v2/share/first_open", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void u()
  {
    try
    {
      b("v2/share/invite_text", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void v()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Xiaoenai localXiaoenai = Xiaoenai.j();
      localJSONObject.put("uuid", localXiaoenai.x);
      localJSONObject.put("os", "android");
      localJSONObject.put("device", localXiaoenai.y);
      localJSONObject.put("os_ver", localXiaoenai.z);
      localJSONObject.put("app_ver", localXiaoenai.B);
      localJSONObject.put("market", Xiaoenai.j().D);
      b("v2/config2/stat", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (this.a == null);
      this.a.a(0);
    }
  }
  
  public void w()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      b("v2/config/get_sex", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */