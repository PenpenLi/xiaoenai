package com.xiaoenai.app.service;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.messagelist.message.model.c;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.common.c.g;
import com.xiaoenai.app.classes.common.q;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.home.mode.ModeSleepActivity;
import com.xiaoenai.app.classes.home.mode.ModeWakeActivity;
import com.xiaoenai.app.classes.startup.LauncherActivity;
import com.xiaoenai.app.common.internal.di.a.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.net.s;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.utils.aa;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.p;
import com.xiaoenai.app.utils.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageService
  extends Service
{
  public static int a = 0;
  Comparator<com.xiaoenai.app.classes.chat.messagelist.message.a.a> b = new d(this);
  private j c = new j(this);
  private MessageReceiver d = new MessageReceiver();
  
  private void a(int paramInt)
  {
    Activity localActivity = com.xiaoenai.app.classes.common.a.a().b(HomeActivity.class);
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      ((HomeActivity)localActivity).d(paramInt);
    }
    UserConfig.setInt("receive_new_msg_count", paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    if ((AppModel.getInstance().isLogined()) && (AppModel.getInstance().getToken() != null))
    {
      localIntent.setAction("notification_to_home");
      localIntent.setClass(this, HomeActivity.class);
    }
    for (;;)
    {
      localIntent.putExtra("from", "notification");
      w.a(this, paramString, 0, paramInt, localIntent);
      return;
      localIntent.setClass(this, LauncherActivity.class);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, Class paramClass)
  {
    Intent localIntent = new Intent();
    if ((AppModel.getInstance().isLogined()) && (AppModel.getInstance().getToken() != null)) {
      localIntent.setClass(this, paramClass);
    }
    for (;;)
    {
      localIntent.putExtra("from", "notification");
      localIntent.putExtra("notifyId", paramInt2);
      w.a(this, paramString, paramInt1, paramInt2, localIntent);
      return;
      localIntent.setClass(this, LauncherActivity.class);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    new com.xiaoenai.app.net.socket.a().a();
  }
  
  private void a(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2;
    ArrayList localArrayList;
    if (paramJSONObject.has("new"))
    {
      localJSONArray2 = paramJSONObject.getJSONArray("new");
      localArrayList = new ArrayList();
      paramInt = 0;
    }
    for (;;)
    {
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala;
      if (paramInt < localJSONArray2.length()) {
        try
        {
          JSONObject localJSONObject = localJSONArray2.getJSONObject(paramInt);
          localJSONArray1.put(localJSONObject.getLong("id") + ":" + localJSONObject.getInt("ts"));
          locala = com.xiaoenai.app.classes.chat.messagelist.a.a().a(localJSONObject.getLong("id"));
          String str = localJSONObject.getString("content");
          Object localObject = locala;
          if (locala == null)
          {
            localObject = localJSONObject.getString("types");
            locala = com.xiaoenai.app.classes.chat.messagelist.message.b.k.a((String)localObject, com.xiaoenai.app.classes.chat.messagelist.message.b.k.a((String)localObject, str), c.a((String)localObject, str));
            localObject = locala;
            if (locala != null)
            {
              localArrayList.add(locala);
              localObject = locala;
            }
          }
          if (localObject != null)
          {
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).b(localJSONObject.getLong("id"));
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).b(str);
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).a(Integer.valueOf(localJSONObject.getInt("sender_id")));
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).a(localJSONObject.getInt("ts"));
            ((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject).a(false);
          }
          else
          {
            com.xiaoenai.app.utils.f.a.a("解析消息出错", new Object[0]);
            com.xiaoenai.app.utils.f.a.c("json data:{}", new Object[] { localJSONObject.toString() });
          }
        }
        catch (JSONException localJSONException)
        {
          com.xiaoenai.app.utils.f.a.a("解析消息出错", new Object[0]);
          localJSONException.printStackTrace();
        }
      }
      Collections.sort(localArrayList, this.b);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        locala = (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localIterator.next();
        locala.k();
        com.xiaoenai.app.classes.chat.messagelist.a.a().a(locala);
      }
      if (localArrayList.size() > 0)
      {
        if ((localArrayList.size() != 1) || (!a((com.xiaoenai.app.classes.chat.messagelist.message.a.a)localArrayList.get(0)))) {
          break label522;
        }
        if (!as.g())
        {
          paramInt = a + 1;
          a = paramInt;
          a(paramInt);
        }
      }
      label423:
      long l1;
      if (paramJSONObject.has("read"))
      {
        paramString1 = paramJSONObject.getJSONArray("read");
        paramInt = 0;
        if (paramInt < paramString1.length())
        {
          paramString2 = paramString1.getString(paramInt);
          l1 = 0L;
          long l2;
          if (paramString2.contains(":"))
          {
            paramString2 = paramString1.getString(paramInt).split(":");
            l2 = Long.valueOf(paramString2[0]).longValue();
            l1 = Long.valueOf(paramString2[1]).longValue();
            com.xiaoenai.app.net.socket.a.a(l1);
            label487:
            if (l2 > 0L)
            {
              paramString2 = com.xiaoenai.app.classes.chat.messagelist.a.a().a(l2);
              if (paramString2 != null) {
                break label657;
              }
              com.xiaoenai.app.classes.chat.messagelist.message.a.a.a(l2, 1, l1);
            }
          }
          for (;;)
          {
            paramInt += 1;
            break label423;
            label522:
            if ((paramString2 != null) && (paramString2.equals("default"))) {
              com.xiaoenai.app.utils.h.a.a().c(2);
            }
            if ((!as.d()) && (as.g())) {
              break;
            }
            a += localArrayList.size();
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = as.a(2131100026);
            }
            if (a == 1) {}
            for (;;)
            {
              a(paramString2, a, 1000, ChatActivity.class);
              a(a);
              break;
              paramString2 = paramString2 + "(" + a + ")";
            }
            l2 = paramString1.getLong(paramInt);
            break label487;
            label657:
            paramString2.b(Integer.valueOf(1));
            paramString2.c(l1);
            paramString2.k();
          }
        }
      }
      if (paramJSONObject.has("update"))
      {
        paramString1 = paramJSONObject.getJSONArray("update");
        paramInt = 0;
        while (paramInt < paramString1.length())
        {
          paramJSONObject = paramString1.optJSONObject(paramInt);
          paramString2 = new JSONObject(paramJSONObject.optString("content"));
          l1 = paramJSONObject.optLong("id");
          localJSONArray1.put(l1 + ":" + paramJSONObject.optInt("ts"));
          paramJSONObject = com.xiaoenai.app.classes.chat.messagelist.a.a().a(l1);
          if (paramJSONObject != null)
          {
            ((com.xiaoenai.app.classes.chat.messagelist.message.model.d)paramJSONObject).c(paramString2.optDouble("distance"));
            paramJSONObject.b(paramString2.toString());
            paramJSONObject.b(Integer.valueOf(1));
            paramJSONObject.k();
          }
          paramInt += 1;
        }
      }
      com.xiaoenai.app.classes.chat.messagelist.a.l();
      if (localJSONArray1.length() > 0)
      {
        paramString1 = new com.xiaoenai.app.net.socket.f();
        paramString1.a("message");
        paramString1.b("confirmMessageReceive");
        paramString1.a(new JSONObject().put("ids", localJSONArray1));
        s.a().a(paramString1);
      }
      return;
      paramInt += 1;
    }
  }
  
  private boolean a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    return ((parama instanceof com.xiaoenai.app.classes.chat.messagelist.message.model.k)) && ((((com.xiaoenai.app.classes.chat.messagelist.message.model.k)parama).w().equals("008")) || (((com.xiaoenai.app.classes.chat.messagelist.message.model.k)parama).w().equals("009")));
  }
  
  private int b(String paramString, int paramInt)
  {
    int i = aa.b(paramString);
    if (i > 0) {
      paramInt = Integer.parseInt(getString(i));
    }
    return paramInt;
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    g localg = new com.xiaoenai.app.classes.common.c.f().a(paramString2, "push");
    com.xiaoenai.app.classes.common.c.a.d locald = new com.xiaoenai.app.classes.common.c.a.e(localg).a();
    paramString2 = new Intent();
    if ((AppModel.getInstance().isLogined()) && (AppModel.getInstance().getToken() != null))
    {
      paramString2 = p.b(this, locald, localg);
      paramInt = b(localg.a(), paramInt);
    }
    for (;;)
    {
      w.a(this, paramString1, 0, paramInt, paramString2);
      return;
      paramString2.setClass(this, LauncherActivity.class);
    }
  }
  
  private void c()
  {
    SocketManager.a().c();
  }
  
  private void d()
  {
    Activity localActivity = com.xiaoenai.app.classes.common.a.a().b(HomeActivity.class);
    UserConfig.remove("key_notify_last_get_time");
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      ((HomeActivity)localActivity).c();
    }
  }
  
  private void e()
  {
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    Object localObject = new Intent("com.xiaoenai.intent.action.RESTART_SERVICE");
    ((Intent)localObject).setClass(this, MessageService.class);
    localObject = PendingIntent.getBroadcast(this, 0, (Intent)localObject, 134217728);
    localAlarmManager.set(0, Calendar.getInstance().getTimeInMillis() + 120000L, (PendingIntent)localObject);
  }
  
  private void f()
  {
    new l(new e(this, this)).n();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, ProtectService.class);
    paramContext.startService(localIntent);
  }
  
  public void b()
  {
    com.xiaoenai.app.classes.chat.messagelist.message.model.d locald = new com.xiaoenai.app.classes.chat.messagelist.message.model.d();
    locald.b(1);
    locald.j();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.c;
  }
  
  public void onCreate()
  {
    super.onCreate();
    startForeground(0, null);
    com.xiaoenai.app.utils.f.a.c("Message service Create!", new Object[0]);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(SocketManager.b);
    localIntentFilter.addAction(SocketManager.a);
    localIntentFilter.addAction(SocketManager.c);
    localIntentFilter.addAction(SocketManager.d);
    localIntentFilter.addAction("action_new_message_data");
    localIntentFilter.addAction("unbindAction");
    localIntentFilter.addAction("background_or_lock_screen");
    localIntentFilter.addAction("background_to_foreground");
    localIntentFilter.addAction("send_location_action");
    localIntentFilter.addAction("com.xiaoenai.mall.service.TIME_UPDATE");
    registerReceiver(this.d, localIntentFilter, getString(2131101650), null);
    if (AppModel.getInstance().isLogined()) {
      c();
    }
  }
  
  public void onDestroy()
  {
    com.xiaoenai.app.utils.f.a.c("Message service Destory!", new Object[0]);
    a();
    unregisterReceiver(this.d);
    if (!Xiaoenai.F)
    {
      e();
      a(this);
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 1;
    if (!Xiaoenai.F)
    {
      if ((AppModel.getInstance().isLogined()) && (SocketManager.a().f() != 2)) {
        c();
      }
      paramInt1 = i;
      if (paramIntent != null)
      {
        com.xiaoenai.app.utils.f.a.c("action={}", new Object[] { paramIntent.getAction() });
        com.xiaoenai.app.utils.f.a.c("from={}", new Object[] { paramIntent.getStringExtra("from") });
        com.xiaoenai.app.utils.f.a.c("time={}", new Object[] { com.xiaoenai.app.utils.d.d.a(Calendar.getInstance()) });
      }
    }
    for (paramInt1 = i;; paramInt1 = 2) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
  }
  
  public class MessageReceiver
    extends BroadcastReceiver
  {
    public MessageReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction() == null) {}
      String str1;
      String str2;
      int i;
      label600:
      label686:
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      str1 = paramIntent.getStringExtra("pushSound");
                      str2 = paramIntent.getStringExtra("pushMsg");
                      i = paramIntent.getIntExtra("pushBadge", 0);
                      int j = paramIntent.getIntExtra("notifyId", 0);
                      if ((str2 == null) || (str2.equals("")) || (j == 0) || (j == 1000)) {}
                      for (;;)
                      {
                        if (!paramIntent.getAction().equals(SocketManager.b)) {
                          break label600;
                        }
                        paramIntent = paramIntent.getStringExtra("Command");
                        if (!paramIntent.equals("getNewMessages")) {
                          break;
                        }
                        MessageService.b(MessageService.this, str2, i, str1);
                        return;
                        if (j == 1001)
                        {
                          MessageService.a(MessageService.this, str2, 0, j, ChatActivity.class);
                          if (as.d(HomeActivity.class.getName())) {
                            com.xiaoenai.app.utils.h.a.a().c(2);
                          }
                        }
                        else if (j == 1002)
                        {
                          MessageService.a(MessageService.this, str2, 0, j, ModeWakeActivity.class);
                        }
                        else if (j == 1004)
                        {
                          if ((str1 != null) && (str1.equals("default"))) {
                            com.xiaoenai.app.utils.h.a.a().c(2);
                          }
                          MessageService.a(MessageService.this, str2, 0, j, HomeActivity.class);
                        }
                        else if (j == 1005)
                        {
                          if ((str1 != null) && (str1.equals("default"))) {
                            com.xiaoenai.app.utils.h.a.a().c(2);
                          }
                          MessageService.a(MessageService.this, str2, 0, j, HomeActivity.class);
                        }
                        else if (j == 1007)
                        {
                          if ((str1 != null) && (str1.equals("default"))) {
                            com.xiaoenai.app.utils.h.a.a().c(2);
                          }
                          MessageService.a(MessageService.this, str2, 1007);
                        }
                        else if (j == 1008)
                        {
                          String str3 = paramIntent.getStringExtra("moduleId");
                          MessageService.a(MessageService.this);
                          MessageService.a(MessageService.this, str2, 1008, str3);
                        }
                        else if (j == 1003)
                        {
                          if ((str1 != null) && (str1.equals("default"))) {
                            com.xiaoenai.app.utils.h.a.a().c(2);
                          }
                          MessageService.a(MessageService.this, str2, 0, j, HomeActivity.class);
                        }
                      }
                      if (!paramIntent.equals("newInvite")) {
                        break;
                      }
                    } while (User.getInstance().getLoverId() > 0);
                    UserConfig.setBoolean("home_has_invite", Boolean.valueOf(true));
                    paramContext = com.xiaoenai.app.classes.common.a.a().c();
                  } while ((paramContext == null) || (paramContext.isFinishing()) || (!as.d(paramContext.getClass().getName())) || ((paramContext instanceof LauncherActivity)) || ((paramContext instanceof NewVersionIntroActivity)));
                  new q(paramContext).a();
                  return;
                  if (paramIntent.equals("getProfile"))
                  {
                    paramIntent = com.xiaoenai.app.classes.common.a.a().c();
                    if (paramIntent == null) {}
                    for (;;)
                    {
                      new q(paramContext).c();
                      return;
                      paramContext = paramIntent;
                    }
                  }
                  if (!paramIntent.equals("Alarm")) {
                    break;
                  }
                  paramContext = HomeModeSettings.getMessage("home_mode.msg");
                } while ((paramContext == null) || (!(paramContext instanceof com.xiaoenai.app.classes.chat.messagelist.message.model.k)) || (!((com.xiaoenai.app.classes.chat.messagelist.message.model.k)paramContext).w().equals("008")));
                com.xiaoenai.app.classes.common.a.a().a(ModeSleepActivity.class);
                Xiaoenai.j().a(new f(this, str1), 500L);
                return;
              } while (!paramIntent.equals("updateStatus"));
              HomeModeSettings.getHomeMode(paramContext);
              return;
            } while (paramIntent.getAction().equals(SocketManager.a));
            if (paramIntent.getAction().equals(SocketManager.c))
            {
              paramContext = Xiaoenai.j().z().c().a();
              if ((paramContext != null) && (!paramContext.isFinishing()))
              {
                if (!(paramContext instanceof BaseActivity)) {
                  break label686;
                }
                ((BaseActivity)paramContext).e(MessageService.this.getString(2131099964));
              }
              for (;;)
              {
                AppModel.logout();
                MessageService.this.a();
                return;
                Xiaoenai.j().z().g().a(MessageService.this.getString(2131099964));
              }
            }
          } while (paramIntent.getAction().equals("unbindAction"));
          if (!paramIntent.getAction().equals("action_new_message_data")) {
            break;
          }
          paramContext = paramIntent.getStringExtra("data");
        } while (paramContext == null);
        try
        {
          paramContext = new JSONObject(paramContext);
          MessageService.a(MessageService.this, null, 0, "default", paramContext);
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        if (paramIntent.getAction().equals("background_or_lock_screen"))
        {
          SocketManager.a().h();
          return;
        }
        if (!paramIntent.getAction().equals("background_to_foreground")) {
          break;
        }
        SocketManager.a().g();
      } while (SocketManager.a().f() != 0);
      SocketManager.a().a(1);
      return;
      if (paramIntent.getAction().equals("send_location_action"))
      {
        MessageService.this.b();
        return;
      }
      if (paramIntent.getAction().equals(SocketManager.d))
      {
        paramIntent = paramIntent.getStringExtra("data");
        if (str2 != null) {
          break label933;
        }
        paramContext = "default";
        i = 0;
      }
      for (;;)
      {
        try
        {
          MessageService.a(MessageService.this, str2, i, paramContext, new JSONObject(paramIntent));
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        if (!paramIntent.getAction().equals("com.xiaoenai.mall.service.TIME_UPDATE")) {
          break;
        }
        MessageService.b(MessageService.this);
        return;
        label933:
        paramContext = str1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\MessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */