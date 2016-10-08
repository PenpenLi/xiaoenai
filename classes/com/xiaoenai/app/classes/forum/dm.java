package com.xiaoenai.app.classes.forum;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.home.d;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.stat.j;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;

public class dm
{
  public static int a = 110;
  private static f b;
  private static int c = 0;
  
  public static void a()
  {
    new com.xiaoenai.app.net.g(new dn(Xiaoenai.j())).a();
  }
  
  public static void a(Context paramContext)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(paramContext);
    localg.a(String.format(paramContext.getResources().getString(2131100374), new Object[] { Integer.valueOf(UserConfig.getInt("forum_publish_limit", Integer.valueOf(0)).intValue() / 3600) }));
    localg.a(2131100898, new dp());
    localg.show();
  }
  
  public static void a(Context paramContext, PullToRefreshListView paramPullToRefreshListView)
  {
    paramPullToRefreshListView = (ListView)paramPullToRefreshListView.getRefreshableView();
    if (Build.VERSION.SDK_INT >= 21) {
      paramPullToRefreshListView.setDivider(paramContext.getResources().getDrawable(d.a(paramContext, 2130772024), paramContext.getTheme()));
    }
    for (;;)
    {
      paramPullToRefreshListView.setDividerHeight(1);
      paramPullToRefreshListView.setFooterDividersEnabled(true);
      return;
      paramPullToRefreshListView.setDivider(paramContext.getResources().getDrawable(d.a(paramContext, 2130772024)));
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    StatEntry localStatEntry = new StatEntry();
    if (User.isSingle())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_single");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      as.a();
      return false;
    }
    f localf = b();
    if (localf == null)
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_single");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      com.xiaoenai.app.ui.a.h.c(paramActivity, paramActivity.getString(2131100887), 2000L);
      return false;
    }
    if (!localf.a())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_time_limit");
      localStatEntry.setExpand(String.valueOf(User.getInstance().getOnlineTime()));
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      a(paramActivity);
      return false;
    }
    if (!localf.c())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_not_register");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      c(paramActivity);
      return false;
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity, int paramInt)
  {
    StatEntry localStatEntry = new StatEntry();
    if (User.isSingle())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_single");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      as.a();
      return false;
    }
    f localf = b();
    if (localf == null)
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_single");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      com.xiaoenai.app.ui.a.h.c(paramActivity, paramActivity.getString(2131100887), 2000L);
      return false;
    }
    if (!localf.b())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_time_limit");
      localStatEntry.setExpand(String.valueOf(User.getInstance().getOnlineTime()));
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      if (paramInt == 2)
      {
        c(paramActivity);
        return false;
      }
      b(paramActivity);
      return false;
    }
    if (!localf.c())
    {
      j.a().a(localStatEntry, paramActivity, paramActivity.getComponentName().getClassName(), "stat_forum_not_register");
      com.xiaoenai.app.stat.h.a().a(localStatEntry);
      c(paramActivity);
      return false;
    }
    return true;
  }
  
  public static f b()
  {
    b = f.d();
    if (b == null) {
      a();
    }
    return b;
  }
  
  public static void b(Context paramContext)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(paramContext);
    localg.a(String.format(paramContext.getResources().getString(2131100375), new Object[] { Integer.valueOf(UserConfig.getInt("forum_reply_limit", Integer.valueOf(0)).intValue() / 3600) }));
    localg.a(2131100898, new dq());
    localg.show();
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (User.isSingle())
    {
      as.a();
      return false;
    }
    if (!b().c())
    {
      c(paramActivity);
      return false;
    }
    return true;
  }
  
  private static void c(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ForumRegisterActivity.class);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(Context paramContext)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(paramContext);
    localg.a(String.format(paramContext.getResources().getString(2131100373), new Object[] { Integer.valueOf(UserConfig.getInt("forum_reply_limit", Integer.valueOf(0)).intValue() / 3600) }));
    localg.a(2131100898, new dr());
    localg.show();
  }
  
  public static boolean c()
  {
    int i;
    long l1;
    int j;
    long l2;
    if (UserConfig.getBoolean("forum_has_moment", Boolean.valueOf(false)).booleanValue())
    {
      i = UserConfig.getInt("forum_moment_id", Integer.valueOf(-1)).intValue();
      l1 = UserConfig.getLong("forum_moment_end_time", 0L);
      j = UserConfig.getInt("forum_current_moment_id", Integer.valueOf(-1)).intValue();
      l2 = UserConfig.getLong("forum_current_moment_end_time", 0L);
      long l3 = ak.b();
      a.c("momentId:{} momentEndTime:{} curmomentEndTime:{} curMomentId:{}", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(j) });
      if (l1 - l3 >= 0L) {
        break label115;
      }
    }
    label115:
    do
    {
      return false;
      if (i > j) {
        return true;
      }
    } while ((i != j) || (l1 <= l2));
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */