package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.extentions.anniversary.ad;
import com.xiaoenai.app.classes.extentions.menses.ac;
import com.xiaoenai.app.classes.extentions.todo.TodoDetailActivity;
import com.xiaoenai.app.classes.extentions.todo.ao;
import com.xiaoenai.app.classes.newLogin.LoginActivity;
import com.xiaoenai.app.classes.settings.bj;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.ShareSDKSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.album.PhotoImageList;
import com.xiaoenai.app.model.status.StatusList;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.service.c;
import org.cocos2dx.cpp.k;
import org.json.JSONObject;

public class n
{
  private static n a = null;
  
  public static n a()
  {
    if (a == null) {
      a = new n();
    }
    return a;
  }
  
  private void c(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    Xiaoenai.j().a(new o(this, paramActivity), 500L);
  }
  
  public void a(Activity paramActivity)
  {
    Xiaoenai.j().z().g().e();
    try
    {
      bj.a().a(paramActivity, null);
      Intent localIntent = new Intent("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
      localIntent.putExtra("Command", "logout");
      com.xiaoenai.app.utils.f.a.c("发送了退出游戏的权限", new Object[0]);
      paramActivity.sendBroadcast(localIntent, paramActivity.getString(2131101650));
      paramActivity.sendBroadcast(new Intent("unbindAction"), paramActivity.getString(2131101650));
      Xiaoenai.j().f();
      c.b(paramActivity);
      ad.b(paramActivity);
      com.xiaoenai.app.utils.e.d.a();
      com.xiaoenai.app.utils.e.b.a();
    }
    catch (Exception localException1)
    {
      try
      {
        ShareSDKSettings.saveShareSDK(paramActivity);
        com.xiaoenai.app.classes.chat.input.faces.r.a = 2;
        User.release();
        StatusList.release();
        PhotoImageList.release();
        com.xiaoenai.app.classes.chat.messagelist.a.a().h();
        com.xiaoenai.app.classes.chat.messagelist.a.m();
        com.xiaoenai.app.classes.extentions.anniversary.ai.c();
        ao.g();
        TodoDetailActivity.d();
        ac.j();
        com.xiaoenai.app.classes.home.a.a.b();
        com.xiaoenai.app.widget.remindButton.a.b();
        SocketManager.b();
        ai.s();
        AppModel.logout();
        com.xiaoenai.app.classes.common.a.a().a(paramActivity);
        System.gc();
        com.f.a.b.b(paramActivity, "LoginOut");
        c(paramActivity);
        k.a();
        w.b(paramActivity);
        ai.s();
        com.xiaoenai.app.utils.a.d.c();
        as.p();
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, Context paramContext, String paramString2)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("user_info");
    if (paramJSONObject.has("im_history_ts")) {
      UserConfig.setInt("im_history_ts", paramJSONObject.optInt("im_history_ts"));
    }
    AppModel.getInstance().loadFromJson(paramJSONObject);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      AppModel.getInstance().setLastLoginAccount(paramString1);
    }
    AppModel.getInstance().save();
    new User(localJSONObject).save();
    User.release();
    com.xiaoenai.app.classes.chat.messagelist.a.m();
    com.xiaoenai.app.classes.chat.messagelist.a.a();
    if (paramJSONObject.has("onekey_status")) {
      StatusList.getInstance().getStatusFromJson(paramJSONObject);
    }
    if (paramJSONObject.has("fun_status")) {}
    try
    {
      ShareSDKSettings.loadShareSDK(paramContext);
      HomeModeSettings.handleFunStatus(paramJSONObject.optJSONObject("fun_status"));
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        com.f.a.b.b(paramContext, paramString2);
      }
      Xiaoenai.j().e();
      new l(paramContext).a(true);
      AppSettings.removeOldSettings();
      as.a(as.k());
      if (!User.isSingle()) {
        com.xiaoenai.app.classes.extentions.menses.a.a(paramContext);
      }
      as.p();
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void b(Activity paramActivity)
  {
    Intent localIntent = new Intent("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
    localIntent.putExtra("Command", "logout");
    paramActivity.sendBroadcast(localIntent, paramActivity.getString(2131101650));
    paramActivity.sendBroadcast(new Intent("unbindAction"), paramActivity.getString(2131101650));
    c.b(paramActivity);
    ad.b(paramActivity);
    com.xiaoenai.app.utils.e.d.a();
    com.xiaoenai.app.utils.e.b.a();
    com.xiaoenai.app.utils.e.b.b();
    try
    {
      ShareSDKSettings.saveShareSDK(paramActivity);
      User.release();
      StatusList.release();
      PhotoImageList.release();
      com.xiaoenai.app.classes.chat.messagelist.a.a().h();
      com.xiaoenai.app.classes.chat.messagelist.a.m();
      com.xiaoenai.app.classes.extentions.anniversary.ai.c();
      TodoDetailActivity.d();
      ao.g();
      ac.j();
      com.xiaoenai.app.classes.home.a.a.b();
      com.xiaoenai.app.widget.remindButton.a.b();
      SocketManager.b();
      ai.s();
      AppModel.logout();
      com.xiaoenai.app.classes.common.a.a().a(paramActivity);
      as.p();
      System.gc();
      ai.s();
      com.xiaoenai.app.utils.a.d.b();
      e.b();
      Xiaoenai.F = true;
      com.f.a.b.b(paramActivity, "UserExitApp");
      Xiaoenai.j().h();
      Xiaoenai.j().f();
      Xiaoenai.j().g();
      Xiaoenai.j().i();
      com.xiaoenai.app.classes.common.a.a().a(paramActivity);
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */