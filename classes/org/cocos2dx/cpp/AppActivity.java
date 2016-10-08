package org.cocos2dx.cpp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.share.ShareInfo;
import com.xiaoenai.app.classes.common.share.p;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.as;
import org.json.JSONException;
import org.json.JSONObject;
import org.mzd.game.GameCallback;
import org.mzd.game.GameJni;

public class AppActivity
  extends GameBaseActivity
{
  private GameCallback c = null;
  private String d = "";
  private a e = new a(null);
  private boolean f = true;
  private String g = "xiaoenai.lovepet.index";
  
  private void a(ShareInfo paramShareInfo)
  {
    p localp = new p();
    if ((paramShareInfo != null) && (paramShareInfo.h() != null)) {
      localp.b(paramShareInfo, getString(2131099955), this, new com.xiaoenai.app.classes.common.share.e());
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = al.b(paramString);
    paramString = ((Bundle)localObject3).getString("params");
    if (!ae.a(paramString)) {}
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject(paramString);
        str6 = ((JSONObject)localObject3).optString("title");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          str5 = ((JSONObject)localObject3).optString("content");
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            String str6;
            paramString = null;
            str1 = null;
            str2 = null;
            str3 = null;
            str4 = null;
            String str5 = null;
          }
        }
        try
        {
          str4 = ((JSONObject)localObject3).optString("image_url");
        }
        catch (JSONException localJSONException3)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          str4 = null;
          break label242;
        }
        try
        {
          str3 = ((JSONObject)localObject3).optString("short_content");
        }
        catch (JSONException localJSONException4)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          str3 = null;
          break label242;
        }
        try
        {
          str2 = ((JSONObject)localObject3).optString("thumb_image_url");
        }
        catch (JSONException localJSONException5)
        {
          paramString = null;
          str1 = null;
          str2 = null;
          break label242;
        }
        try
        {
          str1 = ((JSONObject)localObject3).optString("share_url");
        }
        catch (JSONException localJSONException6)
        {
          paramString = null;
          str1 = null;
          break label242;
        }
        try
        {
          paramString = ((JSONObject)localObject3).optString("redirect_url");
          localObject2 = localObject1;
        }
        catch (JSONException localJSONException7)
        {
          paramString = null;
          break label242;
        }
        try
        {
          localObject1 = ((JSONObject)localObject3).optString("show");
          localObject2 = localObject1;
          ((JSONObject)localObject3).optString("share_id");
          localObject2 = localObject1;
          if ((str6 != null) && (str5 != null) && (str4 != null))
          {
            localObject1 = new ShareInfo();
            ((ShareInfo)localObject1).a(str6);
            ((ShareInfo)localObject1).b(str5);
            ((ShareInfo)localObject1).c(str4);
            ((ShareInfo)localObject1).d(str3);
            ((ShareInfo)localObject1).e(str2);
            ((ShareInfo)localObject1).f(str1);
            ((ShareInfo)localObject1).g(paramString);
            ((ShareInfo)localObject1).b(4);
            if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
              ((ShareInfo)localObject1).a(((String)localObject2).split(","));
            }
            a((ShareInfo)localObject1);
          }
          return;
        }
        catch (JSONException localJSONException8)
        {
          break label242;
        }
        localJSONException1 = localJSONException1;
        paramString = null;
        str1 = null;
        str2 = null;
        str3 = null;
        str4 = null;
        str5 = null;
        str6 = null;
      }
      label242:
      continue;
      str6 = ((Bundle)localObject3).getString("title");
      str5 = ((Bundle)localObject3).getString("content");
      str4 = ((Bundle)localObject3).getString("image_url");
      str3 = ((Bundle)localObject3).getString("short_content");
      str2 = ((Bundle)localObject3).getString("thumb_image_url");
      str1 = ((Bundle)localObject3).getString("share_url");
      paramString = ((Bundle)localObject3).getString("redirect_url");
      localObject2 = ((Bundle)localObject3).getString("show");
      ((Bundle)localObject3).getString("share_id");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    runOnGLThread(new e(this, paramString1, paramString2));
  }
  
  private void b(String paramString)
  {
    if ((this.g != null) && (this.g.length() > 0))
    {
      paramString = new Intent(paramString);
      paramString.putExtra("module_id", this.g);
      if (!this.g.equals("xiaoenai.lovepet.index")) {
        break label55;
      }
      sendBroadcast(paramString);
    }
    label55:
    while (!this.g.equals("xiaoenai.wishtree.index")) {
      return;
    }
    sendBroadcast(paramString);
  }
  
  private void c(String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("{}", new Object[] { paramString });
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      com.xiaoenai.app.utils.f.a.c("length = {}", new Object[] { Integer.valueOf(paramString.length()) });
      localIntent = new Intent("com.xiaoenai.app.GAME_REPORT_ERROR");
      localIntent.putExtra("module_id", this.g);
      if (paramString.length() >= 1048576) {
        break label83;
      }
      localIntent.putExtra("message", paramString);
    }
    for (;;)
    {
      sendBroadcast(localIntent);
      return;
      label83:
      localIntent.putExtra("message", paramString.substring(0, 1048575));
    }
  }
  
  private void d(String paramString)
  {
    runOnGLThread(new f(this, paramString));
  }
  
  protected void a()
  {
    this.c = new a(this);
    GameJni.setServerAddress(Xiaoenai.s);
    GameJni.setUserData(AppModel.getInstance().getToken(), AppModel.getInstance().getSigKey(), AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue(), this.c);
    if ((this.g != null) && (this.g.length() > 0))
    {
      if (this.g.equals("xiaoenai.lovepet.index"))
      {
        GameJni.launchGame("xiaoenai.lovepet.index");
        return;
      }
      GameJni.launchGame("xiaoenai.wishtree.index");
      return;
    }
    GameJni.launchGame("xiaoenai.lovepet.index");
  }
  
  public void a(Context paramContext, String paramString)
  {
    com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramString });
    this.f = true;
    Intent localIntent = new Intent();
    String str = paramContext.getPackageName();
    localIntent.setComponent(new ComponentName(str, str + ".wxapi.WXPayEntryActivity"));
    localIntent.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", paramString);
    ((Activity)paramContext).startActivityForResult(localIntent, 1);
  }
  
  public void finish()
  {
    b("com.xiaoenai.app.GAME_GET_SCHEDULE");
    super.finish();
    overridePendingTransition(2130968606, 2130968607);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      str = paramIntent.getExtras().getString("pay_result");
      com.xiaoenai.app.utils.f.a.c("pay finish result = {}", new Object[] { str });
      if ((str != null) && (!str.equals("invalid"))) {}
    }
    else
    {
      do
      {
        try
        {
          paramIntent = new JSONObject(this.d).optString("channel");
          if ((paramIntent == null) || (paramIntent.length() <= 0)) {
            break;
          }
          if (paramIntent.equalsIgnoreCase("upacp")) {
            if ((this.f) && (as.e(this, "com.unionpay.uppay")))
            {
              this.f = false;
              a(this, this.d);
              return;
            }
          }
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
            paramIntent = "";
          }
          a(this.d, str);
          return;
        }
      } while (!paramIntent.equalsIgnoreCase("wx"));
      h.c(this, 2131100761, 1500L);
      return;
      a(this.d, str);
      return;
    }
    a(this.d, str);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent().getStringExtra("param");
    if (!ae.a((String)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("module_id")) {
        this.g = ((JSONObject)localObject).optString("module_id");
      }
      for (;;)
      {
        super.onCreate(paramBundle);
        CrashReport.initCrashReport(this, "900011556", false, (CrashReport.UserStrategy)new CrashReport.UserStrategy(this).setAppChannel("百度"));
        paramBundle = new IntentFilter();
        paramBundle.addAction(SocketManager.b);
        paramBundle.addAction(SocketManager.c);
        paramBundle.addAction("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
        registerReceiver(this.e, paramBundle, getString(2131101650), null);
        b("com.xiaoenai.app.GAME_CLEAR_NOTIFICATION");
        paramBundle = "uid = " + AppModel.getInstance().getUserId() + " userName = " + User.getInstance().getUserName() + " nickName = " + User.getInstance().getNickName();
        BuglyLog.i("LovePet", paramBundle);
        CrashReport.setUserId(paramBundle);
        return;
        if (((JSONObject)localObject).has("module")) {
          this.g = ((JSONObject)localObject).optString("module");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.e);
    com.xiaoenai.app.utils.f.a.c("onDestroy", new Object[0]);
    System.exit(0);
  }
  
  protected void onLoadNativeLibraries()
  {
    super.onLoadNativeLibraries();
    a();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  private class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction() == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramContext = paramIntent.getStringExtra("Command");
                com.xiaoenai.app.utils.f.a.c("Command = {}", new Object[] { paramContext });
                if (!paramIntent.getAction().equals(SocketManager.b)) {
                  break;
                }
                if (paramContext.equals("petUpdateIndexData"))
                {
                  AppActivity.d(AppActivity.this, "{\"pushNotification\":\"" + paramContext + "\"}");
                  return;
                }
              } while (!paramContext.equals("petDataUpdate"));
              paramContext = paramIntent.getStringExtra("pushMsg");
            } while ((paramContext == null) || (paramContext.length() <= 0));
            AppActivity.d(AppActivity.this, paramContext);
            return;
            if (!paramIntent.getAction().equals("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED")) {
              break;
            }
            com.xiaoenai.app.utils.f.a.c("收到了退出了的消息", new Object[0]);
          } while (paramContext == null);
          if (paramContext.equals("logout"))
          {
            AppActivity.this.finish();
            return;
          }
          if (paramContext.equals("exit"))
          {
            System.exit(0);
            return;
          }
          if (paramContext.equals("sync_ts"))
          {
            int i = paramIntent.getIntExtra("adjust", 0);
            AppActivity.this.runOnGLThread(new g(this, i));
            return;
          }
        } while (!paramContext.equals("single"));
        AppActivity.d(AppActivity.this, "{\"pushNotification\":\" + getProfile + \"}");
        AppActivity.this.finish();
        return;
      } while (!paramIntent.getAction().equals(SocketManager.c));
      AppActivity.this.finish();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\AppActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */