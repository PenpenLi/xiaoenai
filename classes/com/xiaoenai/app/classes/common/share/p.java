package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.webkit.WebView;
import cn.sharesdk.framework.PlatformActionListener;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.a.c;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.stat.j;

public class p
{
  private boolean a = true;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder;
    if (paramString1.contains(paramString2))
    {
      paramString2 = " (来自@小恩爱 情侣应用)";
      localStringBuilder = new StringBuilder();
      if (135 - (paramString2.length() - paramString3.length()) <= paramString1.length()) {
        break label102;
      }
    }
    label102:
    for (int i = paramString1.length();; i = 135 - paramString2.length() - paramString3.length())
    {
      localStringBuilder.append(paramString3);
      localStringBuilder.append(paramString1.substring(0, i));
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
      paramString2 = "  " + paramString2 + " (来自@小恩爱 情侣应用)";
      break;
    }
  }
  
  public static void a(Context paramContext, ShareInfo paramShareInfo)
  {
    b(paramContext, paramShareInfo, null, null);
  }
  
  private static void b(Context paramContext, ShareInfo paramShareInfo, WebView paramWebView, String paramString)
  {
    l locall = new l();
    Object localObject2 = null;
    Object localObject1 = null;
    com.xiaoenai.app.ui.a.h localh = com.xiaoenai.app.ui.a.h.a(paramContext);
    com.xiaoenai.app.utils.f.a.c("=============== getListen_type {}", new Object[] { Integer.valueOf(paramShareInfo.i()) });
    com.xiaoenai.app.utils.f.a.c("=============== getTask_id {}", new Object[] { Integer.valueOf(paramShareInfo.k()) });
    if (paramShareInfo.i() == 1) {
      if (paramShareInfo.k() != -1)
      {
        paramWebView = new ac(paramShareInfo.k(), 1, paramContext, paramWebView, paramString, localh);
        paramString = new ad(paramShareInfo.k(), 1, paramContext, (e)paramWebView, localh);
        ((e)paramWebView).a(false);
        if (paramShareInfo.l() != 0) {
          break label224;
        }
        locall.a(paramShareInfo, paramContext, paramString);
      }
    }
    for (;;)
    {
      if (!localh.isShowing()) {
        localh.show();
      }
      label224:
      do
      {
        return;
        paramWebView = new ae(paramWebView, paramString, localh);
        paramString = new af((e)paramWebView, localh);
        ((e)paramWebView).a(false);
        break;
        paramWebView = (WebView)localObject2;
        paramString = (String)localObject1;
        if (paramShareInfo.i() != 2) {
          break;
        }
        paramWebView = new ag(localh);
        paramString = new ah(localh);
        break;
      } while (paramShareInfo.l() != 3);
      paramShareInfo.b(a(paramShareInfo.b(), paramShareInfo.f(), ""));
      locall.c(paramShareInfo, paramContext, paramWebView);
    }
  }
  
  public void a(ShareInfo paramShareInfo, String paramString, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    com.xiaoenai.app.classes.common.dialog.a.a locala = new com.xiaoenai.app.classes.common.dialog.a.a(paramContext, paramShareInfo.h());
    l locall = new l();
    if (paramString == null) {
      locala.a(8);
    }
    for (;;)
    {
      locala.a(new q(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.b(new ab(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_moment_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.c(new ai(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_sinaweibo_share", paramContext, paramShareInfo, locala));
      locala.e(new aj(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qzone_share", paramShareInfo, paramContext, locala));
      locala.d(new ak(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qq_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.a();
      return;
      locala.a(paramString);
    }
  }
  
  public void a(ShareInfo paramShareInfo, String paramString1, Context paramContext, PlatformActionListener paramPlatformActionListener, WebView paramWebView, String paramString2)
  {
    com.xiaoenai.app.classes.common.dialog.a.a locala = new com.xiaoenai.app.classes.common.dialog.a.a(paramContext, paramShareInfo.h());
    l locall = new l();
    if (paramString1 == null) {
      locala.a(8);
    }
    for (;;)
    {
      locala.a(new al(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.b(new am(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_moment_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.c(new an(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_sinaweibo_share", paramContext, paramShareInfo, paramWebView, paramString2, locala));
      locala.e(new ao(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qzone_share", paramShareInfo, paramContext, paramWebView, paramString2, locala));
      locala.d(new r(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qq_share", paramShareInfo, locall, paramContext, paramPlatformActionListener, locala));
      locala.a();
      return;
      locala.a(paramString1);
    }
  }
  
  public void a(ShareInfo paramShareInfo, String paramString1, Context paramContext, PlatformActionListener paramPlatformActionListener, WebView paramWebView, String paramString2, c paramc)
  {
    paramString1 = new l();
    if (paramShareInfo.h()[0] != null)
    {
      if (!paramShareInfo.h()[0].equals("wxs")) {
        break label78;
      }
      paramWebView = new StatEntry();
      j.a().a(paramWebView, paramContext, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_share");
      com.xiaoenai.app.stat.h.a().a(paramWebView);
      paramString1.a(paramShareInfo, paramContext, paramPlatformActionListener);
    }
    label78:
    do
    {
      return;
      if (paramShareInfo.h()[0].equals("wxt"))
      {
        paramWebView = new StatEntry();
        j.a().a(paramWebView, paramContext, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_moment_share");
        com.xiaoenai.app.stat.h.a().a(paramWebView);
        paramString1.b(paramShareInfo, paramContext, paramPlatformActionListener);
        return;
      }
      if (paramShareInfo.h()[0].equals("sinawb"))
      {
        if (paramWebView != null) {
          Xiaoenai.j().a(new s(this));
        }
        paramPlatformActionListener = new StatEntry();
        j.a().a(paramPlatformActionListener, paramContext, ((Activity)paramContext).getComponentName().getClassName(), "stat_sinaweibo_share");
        com.xiaoenai.app.stat.h.a().a(paramPlatformActionListener);
        paramString1.a(paramShareInfo, paramContext, paramc);
        return;
      }
      if (paramShareInfo.h()[0].equals("qq"))
      {
        paramWebView = new StatEntry();
        j.a().a(paramWebView, paramContext, ((Activity)paramContext).getComponentName().getClassName(), "stat_qq_share");
        com.xiaoenai.app.stat.h.a().a(paramWebView);
        paramString1.d(paramShareInfo, paramContext, paramPlatformActionListener);
        return;
      }
    } while (!paramShareInfo.h()[0].equals("qzone"));
    paramWebView = new StatEntry();
    j.a().a(paramWebView, paramContext, ((Activity)paramContext).getComponentName().getClassName(), "stat_qzone_share");
    com.xiaoenai.app.stat.h.a().a(paramWebView);
    paramString1.c(paramShareInfo, paramContext, paramPlatformActionListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(ShareInfo paramShareInfo, String paramString, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    com.xiaoenai.app.classes.common.dialog.a.a locala = new com.xiaoenai.app.classes.common.dialog.a.a(paramContext, paramShareInfo.h());
    l locall = new l();
    if (paramString == null) {
      locala.a(8);
    }
    for (;;)
    {
      locala.a(new t(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_share", locall, paramShareInfo, paramContext, paramPlatformActionListener, locala));
      locala.b(new u(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_moment_share", locall, paramShareInfo, paramContext, paramPlatformActionListener, locala));
      locala.c(new v(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_sinaweibo_share", paramShareInfo, paramContext, locala));
      locala.e(new w(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qzone_share", paramContext, paramShareInfo, locala));
      locala.d(new x(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qq_share", locall, paramShareInfo, paramContext, paramPlatformActionListener, locala));
      locala.a();
      return;
      locala.a(paramString);
    }
  }
  
  public void c(ShareInfo paramShareInfo, String paramString, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    com.xiaoenai.app.classes.common.dialog.a.a locala = new com.xiaoenai.app.classes.common.dialog.a.a(paramContext, paramShareInfo.h());
    l locall = new l();
    if (paramString == null) {
      locala.a(8);
    }
    for (;;)
    {
      locala.b(new y(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_wechat_moment_share", locall, paramShareInfo, paramContext, paramPlatformActionListener, locala));
      locala.c(new z(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_sinaweibo_share", paramShareInfo, paramContext, locala));
      locala.e(new aa(this, ((Activity)paramContext).getComponentName().getClassName(), "stat_qzone_share", paramContext, paramShareInfo, locala));
      locala.a();
      return;
      locala.a(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */