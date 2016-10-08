package com.xiaoenai.app.model;

import android.app.Activity;
import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.utils.d.f;
import java.io.File;
import org.json.JSONObject;

public class HomeModeSettings
{
  public static final String HOME_LOVER_MODE = "home_lover_mode.msg";
  public static final String HOME_MODE = "home_mode.msg";
  public static boolean isAlreadyOpened = false;
  private static volatile boolean isGettingMode = false;
  
  public static void getHomeMode(Context paramContext)
  {
    if (isGettingMode) {
      return;
    }
    new l(new d(paramContext)).f();
  }
  
  public static com.xiaoenai.app.classes.chat.messagelist.message.a.a getMessage(String paramString)
  {
    try
    {
      paramString = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), paramString);
      if (paramString.exists())
      {
        k localk = new k();
        localk.a(f.b(paramString));
        return localk;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void handleFunStatus(JSONObject paramJSONObject)
  {
    Object localObject3 = null;
    int j = 0;
    if ((paramJSONObject.has("user_status")) && (!paramJSONObject.isNull("user_status"))) {}
    for (Object localObject1 = paramJSONObject.getString("user_status");; localObject1 = null)
    {
      if (paramJSONObject.has("user_start_ts")) {}
      for (int i = paramJSONObject.getInt("user_start_ts");; i = 0)
      {
        Object localObject2 = localObject3;
        if (paramJSONObject.has("lover_status"))
        {
          localObject2 = localObject3;
          if (!paramJSONObject.isNull("lover_status")) {
            localObject2 = paramJSONObject.getString("lover_status");
          }
        }
        if (paramJSONObject.has("lover_start_ts")) {
          j = paramJSONObject.getInt("lover_start_ts");
        }
        if (localObject1 == null)
        {
          removeMessage("home_mode.msg");
          if (localObject2 != null) {
            break label173;
          }
          removeMessage("home_lover_mode.msg");
          UserConfig.remove("last_send_alarm_time");
        }
        for (;;)
        {
          updateHomeModeUI();
          return;
          paramJSONObject = getMessage("home_mode.msg");
          if ((paramJSONObject != null) || (!((String)localObject1).equals("sleep"))) {
            break;
          }
          localObject1 = k.x();
          int k = i;
          if (i <= 0) {
            k = paramJSONObject.d();
          }
          ((k)localObject1).a(k);
          saveMessage("home_mode.msg", (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject1);
          break;
          label173:
          if (((String)localObject2).equals("sleep"))
          {
            paramJSONObject = k.x();
            paramJSONObject.a(j);
            paramJSONObject.b(2);
            saveMessage("home_lover_mode.msg", paramJSONObject);
          }
        }
      }
    }
  }
  
  public static void removeMessage(String paramString)
  {
    paramString = f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  public static void saveMessage(String paramString, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    try
    {
      f.b(parama.o(), f.a(Xiaoenai.j(), AppModel.getInstance().getUserId(), paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void updateHomeModeUI()
  {
    Activity localActivity = com.xiaoenai.app.classes.common.a.a().b(HomeActivity.class);
    if (localActivity != null) {
      ((HomeActivity)localActivity).b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\HomeModeSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */