package com.xiaoenai.app.classes.common.share;

import android.app.Activity;
import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qq.QQ.ShareParams;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.tencent.qzone.QZone.ShareParams;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.friends.Wechat.ShareParams;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.wechat.moments.WechatMoments.ShareParams;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.a.c;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e.b;

public class l
{
  public void a(ShareInfo paramShareInfo, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    if (!as.a(paramContext, "com.tencent.mm"))
    {
      as.b(2131101256);
      return;
    }
    Wechat.ShareParams localShareParams = new Wechat.ShareParams();
    localShareParams.title = paramShareInfo.a();
    localShareParams.text = paramShareInfo.b();
    localShareParams.shareType = paramShareInfo.j();
    localShareParams.url = paramShareInfo.f();
    if (paramShareInfo.c() != null)
    {
      if (!paramShareInfo.c().startsWith("http")) {
        break label163;
      }
      localShareParams.imageUrl = paramShareInfo.c();
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("title = {} {} {} {} {} {}", new Object[] { paramShareInfo.a(), paramShareInfo.d(), paramShareInfo.b(), Integer.valueOf(paramShareInfo.j()), paramShareInfo.f(), paramShareInfo.c() });
      paramShareInfo = ShareSDK.getPlatform(paramContext, Wechat.NAME);
      paramShareInfo.share(localShareParams);
      paramShareInfo.setPlatformActionListener(paramPlatformActionListener);
      return;
      label163:
      localShareParams.imagePath = paramShareInfo.c();
    }
  }
  
  public void a(ShareInfo paramShareInfo, Context paramContext, c paramc)
  {
    WeiboMultiMessage localWeiboMultiMessage = new WeiboMultiMessage();
    localWeiboMultiMessage.textObject = new TextObject();
    localWeiboMultiMessage.textObject.text = paramShareInfo.b();
    com.xiaoenai.app.utils.f.a.c("sinaWeibo ========= {}", new Object[] { paramShareInfo.c() });
    if (paramShareInfo.c().startsWith("http"))
    {
      b.a(paramShareInfo.c(), new m(this, paramContext, localWeiboMultiMessage, paramShareInfo, paramc));
      return;
    }
    localWeiboMultiMessage.imageObject = new ImageObject();
    localWeiboMultiMessage.imageObject.imagePath = paramShareInfo.c();
    a(paramShareInfo, localWeiboMultiMessage, paramContext, paramc);
  }
  
  public void a(ShareInfo paramShareInfo, WeiboMultiMessage paramWeiboMultiMessage, Context paramContext, c paramc)
  {
    SendMultiMessageToWeiboRequest localSendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
    localSendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
    localSendMultiMessageToWeiboRequest.multiMessage = paramWeiboMultiMessage;
    localSendMultiMessageToWeiboRequest.packageName = "com.xiaoenai.app";
    com.xiaoenai.app.classes.common.a.a.a().a(Long.valueOf(localSendMultiMessageToWeiboRequest.transaction).longValue(), paramc);
    paramWeiboMultiMessage = new AuthInfo(paramContext, "1683793224", paramShareInfo.g(), "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write");
    paramc = a.a();
    paramShareInfo = "";
    if (paramc != null) {
      paramShareInfo = paramc.getToken();
    }
    if (Xiaoenai.j().l() != null) {
      Xiaoenai.j().l().sendRequest((Activity)paramContext, localSendMultiMessageToWeiboRequest, paramWeiboMultiMessage, paramShareInfo, new n(this));
    }
  }
  
  public void b(ShareInfo paramShareInfo, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    if (!as.a(paramContext, "com.tencent.mm"))
    {
      as.b(2131101256);
      return;
    }
    paramContext = ShareSDK.getPlatform(paramContext, WechatMoments.NAME);
    WechatMoments.ShareParams localShareParams = new WechatMoments.ShareParams();
    localShareParams.title = paramShareInfo.a();
    localShareParams.text = paramShareInfo.b();
    localShareParams.shareType = paramShareInfo.j();
    localShareParams.url = paramShareInfo.f();
    if (paramShareInfo.c() != null)
    {
      if (!paramShareInfo.c().startsWith("http")) {
        break label108;
      }
      localShareParams.imageUrl = paramShareInfo.c();
    }
    for (;;)
    {
      paramContext.share(localShareParams);
      paramContext.setPlatformActionListener(paramPlatformActionListener);
      return;
      label108:
      localShareParams.imagePath = paramShareInfo.c();
    }
  }
  
  public void c(ShareInfo paramShareInfo, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    paramContext = ShareSDK.getPlatform(paramContext, QZone.NAME);
    QZone.ShareParams localShareParams = new QZone.ShareParams();
    com.xiaoenai.app.utils.f.a.c("=============== {}", new Object[] { paramShareInfo.a() });
    com.xiaoenai.app.utils.f.a.c("=============== {}", new Object[] { paramShareInfo.f() });
    com.xiaoenai.app.utils.f.a.c("=============== {}", new Object[] { paramShareInfo.b() });
    com.xiaoenai.app.utils.f.a.c("=============== {}", new Object[] { paramShareInfo.c() });
    localShareParams.setTitle(paramShareInfo.a());
    localShareParams.setTitleUrl(paramShareInfo.f());
    localShareParams.setText(paramShareInfo.b());
    localShareParams.setSite("小恩爱");
    localShareParams.setSiteUrl(paramShareInfo.f());
    if (paramShareInfo.c() != null)
    {
      if (!paramShareInfo.c().startsWith("http")) {
        break label165;
      }
      localShareParams.setImageUrl(paramShareInfo.c());
    }
    for (;;)
    {
      paramContext.share(localShareParams);
      paramContext.setPlatformActionListener(paramPlatformActionListener);
      return;
      label165:
      localShareParams.setImagePath(paramShareInfo.c());
    }
  }
  
  public void d(ShareInfo paramShareInfo, Context paramContext, PlatformActionListener paramPlatformActionListener)
  {
    paramContext = ShareSDK.getPlatform(paramContext, QQ.NAME);
    QQ.ShareParams localShareParams = new QQ.ShareParams();
    localShareParams.title = paramShareInfo.a();
    localShareParams.text = paramShareInfo.b();
    localShareParams.titleUrl = paramShareInfo.f();
    if (paramShareInfo.c() != null)
    {
      if (!paramShareInfo.c().startsWith("http")) {
        break label84;
      }
      localShareParams.imageUrl = paramShareInfo.c();
    }
    for (;;)
    {
      paramContext.share(localShareParams);
      paramContext.setPlatformActionListener(paramPlatformActionListener);
      return;
      label84:
      localShareParams.imagePath = paramShareInfo.c();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */