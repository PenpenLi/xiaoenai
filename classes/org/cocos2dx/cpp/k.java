package org.cocos2dx.cpp;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.game.GamePushInfo;
import com.xiaoenai.app.net.j;
import com.xiaoenai.app.service.RemindReceiver;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.w;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  private static Intent a(Context paramContext, GamePushInfo paramGamePushInfo)
  {
    Intent localIntent = new Intent("com.xiaoenai.app.GAME_ON_LOVEPET_PUSH");
    localIntent.setClass(paramContext, RemindReceiver.class);
    localIntent.putExtra("param", paramGamePushInfo.toJson().toString());
    return localIntent;
  }
  
  public static void a()
  {
    b("xiaoenai.lovepet.index");
    b("xiaoenai.wishtree.index");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Object localObject = new Intent("com.xiaoenai.app.GAME_ON_LOVEPET_PUSH");
    ((Intent)localObject).setClass(paramContext, RemindReceiver.class);
    localObject = PendingIntent.getBroadcast(paramContext, paramInt, (Intent)localObject, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel((PendingIntent)localObject);
  }
  
  private static void a(Context paramContext, int paramInt, Intent paramIntent, long paramLong)
  {
    a(paramContext, paramInt);
    Calendar localCalendar = Calendar.getInstance();
    paramLong = 1000L * paramLong;
    localCalendar.setTimeInMillis(paramLong);
    a.c("game push time==========={} {}", new Object[] { d.a(localCalendar), Long.valueOf(paramLong) });
    if (paramLong <= System.currentTimeMillis()) {
      return;
    }
    ((AlarmManager)paramContext.getSystemService("alarm")).set(0, paramLong, PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728));
  }
  
  public static void a(Context paramContext, int paramInt, GamePushInfo paramGamePushInfo, long paramLong)
  {
    a(paramContext, paramInt, a(paramContext, paramGamePushInfo), paramLong);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("param");
    a.c("showRemind {}", new Object[] { paramIntent });
    if (!ae.a(paramIntent)) {}
    try
    {
      a.c("showRemind {}", new Object[] { paramIntent });
      GamePushInfo localGamePushInfo = new GamePushInfo(new JSONObject(paramIntent));
      Intent localIntent = new Intent();
      localIntent.putExtra("param", paramIntent);
      localIntent.setClass(paramContext, AppActivity.class);
      w.a(paramContext, localGamePushInfo.getMessage(), 0, localGamePushInfo.getNotifyId(), localIntent);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      a.a("showRemind {}", new Object[] { paramContext.getMessage() });
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = new j(new l(paramContext, paramString));
    if ("xiaoenai.wishtree.index".equals(paramString)) {
      paramContext.b();
    }
    while (!"xiaoenai.lovepet.index".equals(paramString)) {
      return;
    }
    paramContext.a();
  }
  
  public static void a(String paramString)
  {
    a.c("initAlarm {}", new Object[] { paramString });
    paramString = i.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      GamePushInfo localGamePushInfo = (GamePushInfo)paramString.next();
      a.c("isPast {}", new Object[] { localGamePushInfo.isPast() });
      if (localGamePushInfo.isPast().booleanValue())
      {
        a(Xiaoenai.j(), localGamePushInfo.getNotifyId(), localGamePushInfo, localGamePushInfo.getPushTime());
        a.c("info.getNotifyId() {} {}", new Object[] { Integer.valueOf(localGamePushInfo.getNotifyId()), Long.valueOf(localGamePushInfo.getPushTime()) });
      }
    }
  }
  
  public static void b(String paramString)
  {
    NotificationManager localNotificationManager = (NotificationManager)Xiaoenai.j().getSystemService("notification");
    paramString = i.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      GamePushInfo localGamePushInfo = (GamePushInfo)paramString.next();
      localNotificationManager.cancel(localGamePushInfo.getNotifyId());
      a(Xiaoenai.j(), localGamePushInfo.getNotifyId());
    }
    i.a().b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\cpp\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */