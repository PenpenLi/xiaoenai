package com.xiaoenai.app.classes.extentions.menses;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.service.RemindReceiver;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.w;
import java.util.Calendar;

public class t
{
  public static void a()
  {
    ((NotificationManager)Xiaoenai.j().getSystemService("notification")).cancel(12001);
  }
  
  public static void a(Context paramContext)
  {
    if ((AppModel.getInstance().isLogined()) && (!User.isSingle()))
    {
      c(paramContext);
      return;
    }
    d(paramContext);
    e(paramContext);
  }
  
  private static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    long l = 1000L * paramLong1;
    paramLong1 = l;
    if (l <= System.currentTimeMillis()) {
      paramLong1 = l + 86400000L * paramLong2;
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong1);
    ((Calendar)localObject).set(11, 9);
    ((Calendar)localObject).set(12, 0);
    l = ((Calendar)localObject).getTimeInMillis();
    paramLong1 = l;
    if (l <= System.currentTimeMillis()) {
      paramLong1 = l + 86400000L * paramLong2;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    Intent localIntent = new Intent(paramContext, RemindReceiver.class);
    localIntent.putExtra("from", "AlarmManager");
    localIntent.setAction("com.xiaoenai.app.REMIND_MENSES");
    ((AlarmManager)localObject).setRepeating(0, paramLong1, 86400000L * paramLong2, PendingIntent.getBroadcast(paramContext, 227, localIntent, 134217728));
  }
  
  private static void a(String paramString)
  {
    w.b("xiaoenai.mens.come", paramString);
  }
  
  public static void b(Context paramContext)
  {
    e(paramContext);
    d(paramContext);
    a();
    int i = UserConfig.getInt("menses_interval", Integer.valueOf(0)).intValue();
    long l1 = ak.b();
    long l2 = ac.k() - 259200L;
    if (l2 > l1)
    {
      a(paramContext, l2, i);
      return;
    }
    a(paramContext, 86400L * ac.e() + l2, i);
  }
  
  private static void c(Context paramContext)
  {
    String str = as.a(2131100856);
    if (ac.l() == 1) {
      str = as.a(2131100857) + as.a(2131100856);
    }
    switch (u.a[ac.n().ordinal()])
    {
    }
    do
    {
      return;
    } while ((ac.o() == ac.k()) || (ac.c()));
    w.a(paramContext, str, 12001);
    a(str);
    ac.b(ac.k());
  }
  
  private static void d(Context paramContext)
  {
    Object localObject = new Intent(paramContext, RemindReceiver.class);
    ((Intent)localObject).setAction("com.xiaoenai.app.REMIND_MENSES");
    localObject = PendingIntent.getBroadcast(paramContext, 226, (Intent)localObject, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel((PendingIntent)localObject);
  }
  
  private static void e(Context paramContext)
  {
    Object localObject = new Intent(paramContext, RemindReceiver.class);
    ((Intent)localObject).setAction("com.xiaoenai.app.REMIND_MENSES");
    localObject = PendingIntent.getBroadcast(paramContext, 227, (Intent)localObject, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel((PendingIntent)localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */