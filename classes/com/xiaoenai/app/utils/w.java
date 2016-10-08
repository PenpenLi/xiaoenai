package com.xiaoenai.app.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.classes.startup.LauncherActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public class w
{
  public static NotificationCompat.Builder a(Context paramContext)
  {
    return new NotificationCompat.Builder(paramContext).setWhen(System.currentTimeMillis()).setAutoCancel(true).setDefaults(0).setLights(-16711936, 1, 0);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, NotificationCompat.Builder paramBuilder)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramBuilder.build());
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Intent paramIntent)
  {
    paramIntent = PendingIntent.getActivity(paramContext, paramInt3, paramIntent, 134217728);
    paramString = a(paramContext).setContentIntent(paramIntent).setContentTitle(as.a(2131099955)).setContentText(paramString).setSmallIcon(paramInt1);
    if (paramInt2 > 0) {
      paramString.setNumber(paramInt2);
    }
    a(paramContext, paramString, paramInt3);
  }
  
  public static void a(Context paramContext, Notification paramNotification, int paramInt)
  {
    if (paramNotification != null) {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramNotification);
    }
  }
  
  public static void a(Context paramContext, NotificationCompat.Builder paramBuilder, int paramInt)
  {
    if (paramBuilder != null) {
      a(paramContext, paramBuilder.build(), paramInt);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    if ((AppModel.getInstance().isLogined()) && (AppModel.getInstance().getToken() != null))
    {
      localIntent.setAction("notification_to_home");
      localIntent.setClass(paramContext, HomeActivity.class);
    }
    for (;;)
    {
      localIntent.putExtra("from", "notification");
      a(paramContext, paramString, 0, paramInt, localIntent);
      return;
      localIntent.setClass(paramContext, LauncherActivity.class);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(paramContext, 2130838588, paramString, paramInt1, paramInt2, paramIntent);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramContext, paramString, 0, paramInt, paramIntent);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("product_id", paramInt1);
      localJSONObject.put("rush_id", paramInt2);
      a(as.a(2131100674), paramString, localJSONObject.toString(), "xiaoenai.street.detail", String.valueOf(paramInt1));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(as.a(2131099918), paramString2, null, "xiaoenai.anniversary", paramString1);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    DynamicNotification localDynamicNotification = new DynamicNotification();
    localDynamicNotification.setCount(1);
    localDynamicNotification.setReadStatus(0);
    localDynamicNotification.setContent(paramString2);
    localDynamicNotification.setTitle(paramString1);
    localDynamicNotification.setModule(paramString4);
    localDynamicNotification.setGroup(paramString5);
    localDynamicNotification.setUpdated_at(ak.b());
    if (!ae.a(paramString3)) {
      localDynamicNotification.setParams(paramString3);
    }
    c.a().a(localDynamicNotification);
  }
  
  public static void b(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
    com.xiaoenai.app.service.MessageService.a = 0;
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("notification_to_home");
    localIntent.setClass(paramContext, HomeActivity.class);
    localIntent.putExtra("from", "notification");
    a(paramContext, paramString, 0, paramInt, localIntent);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(as.a(2131100874), paramString2, null, "xiaoenai.mens", paramString1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */